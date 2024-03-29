//Modulos
let express = require('express');
let app = express();

let rest = require('request');
app.set('rest', rest);

app.use(function (req, res, next) {
    res.header("Access-Control-Allow-Origin", "*");
    res.header("Access-Control-Allow-Credentials", "true");
    res.header("Access-Control-Allow-Methods", "POST, GET, DELETE, UPDATE, PUT");
    res.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, token");
    // Debemos especificar todas las headers que se aceptan. Content-Type , token
    next();
});
log4js = require('log4js');
log4js.configure({
    appenders: {sdi2: {type: 'file', filename: 'log/social-network.log'}},
    categories: {default: {appenders: ['sdi2'], level: 'trace'}}
});
var logger = log4js.getLogger('sdi2');

var jwt = require('jsonwebtoken');
app.set('jwt', jwt);

var expressSession = require('express-session');
app.use(expressSession({
    secret: 'abcdefg',
    resave: true,
    saveUninitialized: true
}));
var crypto = require('crypto');
var mongo = require('mongodb');
var swig = require('swig');
var bodyParser = require('body-parser');
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended: true}));

var gestorBD = require("./modules/gestorBD.js");
gestorBD.init(app, mongo);

// routerUsuarioToken
var routerUsuarioToken = express.Router();
routerUsuarioToken.use(function (req, res, next) {
    // obtener el token, puede ser un parámetro GET , POST o HEADER
    var token = req.body.token || req.query.token || req.headers['token'];
    if (token != null) {
        // verificar el token
        jwt.verify(token, 'secreto', function (err, infoToken) {
            if (err || (Date.now() / 1000 - infoToken.tiempo) > 24000) {
                res.status(403); // Forbidden
                res.json({
                    acceso: false,
                    error: 'Token invalido o caducado'
                });
                // También podríamos comprobar que intoToken.usuario existe


            } else {
                // dejamos correr la petición
                res.usuario = infoToken.usuario;
                next();
            }
        });

    } else {
        res.status(403); // Forbidden
        res.json({
            acceso: false,
            mensaje: 'No hay Token'
        });
    }
});
// Aplicar routerUsuarioToken
app.use('/api/users', routerUsuarioToken);
app.use('/api/message', routerUsuarioToken);
app.use('/api/message/:id', routerUsuarioToken);
app.use('/cliente.html?w=friends', routerUsuarioToken);
app.use('/cliente.html?w=chat', routerUsuarioToken);


// routerUsuarioSession
var routerUsuarioSession = express.Router();
routerUsuarioSession.use(function (req, res, next) {
    console.log("routerUsuarioSession");
    if (req.session.usuario) {
        // dejamos correr la petición
        next();
    } else {
        console.log("va a : " + req.session.destino);
        res.redirect("/signin?mensaje=Intento de acceso a una zona privada sin autorizacion"
            + "&tipoMensaje=alert-danger");
    }
});
// Aplicar routerUsuarioSession
app.use("/user/list", routerUsuarioSession);
app.use("/friends", routerUsuarioSession);
app.use("/requests", routerUsuarioSession);
app.use("/requests/accept/:id", routerUsuarioSession);
app.use("/friendrequest/:id", routerUsuarioSession);

app.use(express.static('public'));

//Variables
// Variables
app.set('port', 8081);
app.set('db', 'mongodb://admin:admin@tiendamusica-shard-00-00-en3ox.mongodb.net:27017,tiendamusica-shard-00-01-en3ox.mongodb.net:27017,tiendamusica-shard-00-02-en3ox.mongodb.net:27017/test?ssl=true&replicaSet=tiendamusica-shard-0&authSource=admin&retryWrites=true&w=majority');
app.set('clave', 'abcdefg');
app.set('crypto', crypto);
app.set('logger', logger);

//Routers/controllers
require("./routes/rusers.js")(app, swig, gestorBD);
require("./routes/rrequests.js")(app, swig, gestorBD);
require("./routes/rapiusers.js")(app, gestorBD);
require("./routes/rapimessages.js")(app, gestorBD);

// routerUserSession
var routerUserSession = express.Router();
routerUserSession.use(function (req, res, next) {
    console.log("routerUsuarioSession");
    if (req.session.usuario) {
        // dejamos correr la petición
        next();
    } else {
        console.log("va a : " + req.session.destino);
        res.redirect("/signin");
    }
});


app.get('/', function (req, res) {
    var respuesta = swig.renderFile('views/index.html', {
        usuario: req.session.usuario
    });
    res.send(respuesta);
});

//Server launcher
app.listen(app.get('port'), function () {
    console.log("Servidor activo");
});