package com.uniovi.tests;

//Paquetes Java
import java.util.List;
//Paquetes JUnit 
import org.junit.*;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
//Paquetes Selenium 
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
//Paquetes Utilidades de Testing Propias
import com.uniovi.tests.util.SeleniumUtils;
//Paquetes con los Page Object
import com.uniovi.tests.pageobjects.*;

//Ordenamos las pruebas por el nombre 
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class sdi1920entrega2test506 {
	static String PathFirefox65 = "D:\\ProgramasInstalados\\Firefox\\firefox.exe";
	static String Geckdriver024 = "C:\\Users\\alejandro\\Downloads\\PL-SDI-Sesión5-material\\geckodriver024win64.exe";

	static WebDriver driver = getDriver(PathFirefox65, Geckdriver024);
	static String URL = "http://localhost:8081";

	public static WebDriver getDriver(String PathFirefox, String Geckdriver) {
		System.setProperty("webdriver.firefox.bin", PathFirefox);
		System.setProperty("webdriver.gecko.driver", Geckdriver);
		WebDriver driver = new FirefoxDriver();
		return driver;
	}

	@Before
	public void setUp() {
		driver.navigate().to(URL);
	}

	@After
	public void tearDown() {
		driver.manage().deleteAllCookies();
	}

	@BeforeClass
	static public void begin() {
		PO_View.setTimeout(3);
	}

	@AfterClass
	static public void end() {
		driver.quit();
	}

//	///Registro de Usuario con datos válidos
//	@Test
//	public void PR01() {	
//		List<WebElement> elementos = PO_View.checkElement(driver, "free", "//li/a[contains(@id, 'botonSignup')]");
//		elementos.get(0).click();
//		SeleniumUtils.esperarSegundos(driver, 2);	
//		PO_RegisterView.fillForm(driver, "Pepito", "prueba99@prueba99.com", "prueba99", "prueba99");
//		SeleniumUtils.textoPresentePagina(driver, "Nuevo usuario registrado");
//	}
//	// Registro de Usuario con datos inválidos (email vacío, nombre vacío, apellidos vacíos).
//	@Test
//	public void PR02() {
//		List<WebElement> elementos = PO_View.checkElement(driver, "free", "//li/a[contains(@id, 'botonSignup')]");
//		elementos.get(0).click();
//		SeleniumUtils.esperarSegundos(driver, 2);	
//		PO_RegisterView.fillForm(driver, "", "", "", "");
//		SeleniumUtils.textoPresentePagina(driver, "Registrar usuario");
//	}
// Registro de Usuario con datos inválidos (repetición de contraseña inválida).
//	@Test
//	public void PR03() {
//		List<WebElement> elementos = PO_View.checkElement(driver, "free", "//li/a[contains(@id, 'botonSignup')]");
//		elementos.get(0).click();
//		SeleniumUtils.esperarSegundos(driver, 2);	
//		PO_RegisterView.fillForm(driver, "PepitoGrillo", "prueba999@prueba99.com", "prueba99", "prueba98");
//		SeleniumUtils.textoPresentePagina(driver, "Registrar usuario");
//	}

//	// Registro de Usuario con datos inválidos (email existente).
//	@Test
//	public void PR04() {
//		List<WebElement> elementos = PO_View.checkElement(driver, "free", "//li/a[contains(@id, 'botonSignup')]");
//		elementos.get(0).click();
//		SeleniumUtils.esperarSegundos(driver, 2);
//		PO_RegisterView.fillForm(driver, "Alex", "prueba99@prueba99.com", "prueba99", "prueba99");
//		SeleniumUtils.textoPresentePagina(driver, "Registrar usuario");
//	}
//	//Inicio de sesión con datos válidos (usuario estándar).
	//REVISAS
//	@Test
//	public void PR05() {
//		driver.navigate().to("http://localhost:8081/cliente.html");
//		PO_LoginView.fillForm(driver, "prueba99@prueba99.com", "prueba99");
//		SeleniumUtils.esperarSegundos(driver, 3);
//		PO_View.checkElement(driver, "text", "Amigos");
//	}
//	//Inicio de sesión con datos inválidos (usuario estándar, campo email y contraseña vacíos)
//	@Test
//	public void PR06() {
//		driver.navigate().to("http://localhost:8081/cliente.html");
//		PO_LoginView.fillForm(driver, "", "");
//		SeleniumUtils.esperarSegundos(driver, 3);
//		SeleniumUtils.textoPresentePagina(driver, "Usuario no encontrado");
//	}
//
//	// Inicio de sesión con datos inválidos (usuario estándar, email existente, pero contraseña incorrecta).
//	@Test
//	public void PR07() {
//		driver.navigate().to("http://localhost:8081/cliente.html");
//		PO_LoginView.fillForm(driver, "prueba99@prueba99.com", "pedo");
//		SeleniumUtils.esperarSegundos(driver, 3);
//		SeleniumUtils.textoPresentePagina(driver, "Usuario no encontrado");
//	}
//
//	// Inicio de sesión con datos inválidos (usuario estándar, email no existente y contraseña no vacía)
//	@Test
//	public void PR08() {
//		driver.navigate().to("http://localhost:8081/cliente.html");
//		PO_LoginView.fillForm(driver, "pruebaFalsa@prueba99.com", "pedo");
//		SeleniumUtils.esperarSegundos(driver, 3);
//		SeleniumUtils.textoPresentePagina(driver, "Usuario no encontrado");
//	}
//
//	// Hacer click en la opción de salir de sesión y comprobar que se redirige a la página de inicio de sesión (Login).
//	@Test
//	public void PR09() {
//		driver.navigate().to("http://localhost:8081/cliente.html");
//		PO_LoginView.fillForm(driver, "prueba99@prueba99.com", "prueba99");
//		SeleniumUtils.esperarSegundos(driver, 3);
//		PO_View.checkElement(driver, "text", "Amigos");
//		driver.navigate().to("http://localhost:8081/logout");
//		SeleniumUtils.textoPresentePagina(driver, "Bienvenido a la mejor red social del mundo");
//	}
//
//	// Comprobar que el botón cerrar sesión no está visible si el usuario no está autenticado.
//	@Test
//	public void PR10() {
//		driver.navigate().to("http://localhost:8081");
//		try {
//			List<WebElement> elementos = PO_View.checkElement(driver, "free", "//li/a[contains(@id, 'botonLogout')]");
//		} catch (NoSuchElementException nse) {
//			assertTrue("No esta el boton", true);
//		}
//	}
//
//	// PR11. Mostrar el listado de usuarios y comprobar que se muestran todos los que existen en el sistema. 
//	@Test
//	public void PR11() {
//		List<WebElement> elementos = PO_View.checkElement(driver, "free", "//li/a[contains(@id, 'botonLogin')]");
//		elementos.get(0).click();
//		SeleniumUtils.esperarSegundos(driver, 2);
//		PO_LoginView.fillForm(driver, "prueba99@prueba99.com", "prueba99");
//		SeleniumUtils.textoPresentePagina(driver, "Usuarios");
//	}
//
//	// Hacer una búsqueda con el campo vacío y comprobar que se muestra la página que
//	//corresponde con el listado usuarios existentes en el sistema
//	@Test
//	public void PR12() {
//
//		List<WebElement> elementos = PO_View.checkElement(driver, "free", "//li/a[contains(@id, 'botonLogin')]");
//		elementos.get(0).click();
//		SeleniumUtils.esperarSegundos(driver, 2);
//		PO_LoginView.fillForm(driver, "prueba99@prueba99.com", "prueba99");
//		SeleniumUtils.textoPresentePagina(driver, "Usuarios");
//		PO_ListUsers.fillSearchText(driver, "");
//		PO_View.checkElement(driver, "text", "prueba2");
//	}
//
//	// Hacer una búsqueda escribiendo en el campo un texto que no exista y comprobar que se
////muestra la página que corresponde, con la lista de usuarios vacía.
//	@Test
//	public void PR13() {
//		List<WebElement> elementos = PO_View.checkElement(driver, "free", "//li/a[contains(@id, 'botonLogin')]");
//		elementos.get(0).click();
//		SeleniumUtils.esperarSegundos(driver, 2);
//		PO_LoginView.fillForm(driver, "prueba99@prueba99.com", "prueba99");
//		SeleniumUtils.textoPresentePagina(driver, "Usuarios");
//		PO_ListUsers.fillSearchText(driver, "pedo");
//		elementos = PO_View.checkElement(driver, "text", "Request");
//		assertTrue(elementos.size() == 0);
//	}
//
//	Hacer una búsqueda con un texto específico y comprobar que se muestra la página que
//	corresponde, con la lista de usuarios en los que el texto especificados sea parte de su nombre, apellidos o
//	de su email.
//	@Test
//	public void PR14() {
//		List<WebElement> elementos = PO_View.checkElement(driver, "free", "//li/a[contains(@id, 'botonLogin')]");
//		elementos.get(0).click();
//		SeleniumUtils.esperarSegundos(driver, 2);
//		PO_LoginView.fillForm(driver, "prueba99@prueba99.com", "prueba99");
//		SeleniumUtils.textoPresentePagina(driver, "Usuarios");
//		PO_ListUsers.fillSearchText(driver, "ba2");
//		PO_View.checkElement(driver, "text", "prueba2@prueba2.com");
//	}
//
//	// Desde el listado de usuarios de la aplicación, enviar una invitación de amistad a un usuario.
//	Comprobar que la solicitud de amistad aparece en el listado de invitaciones (punto siguiente). 
//	@Test
//	public void PR15() {
//		List<WebElement> elementos = PO_View.checkElement(driver, "free", "//li/a[contains(@id, 'botonLogin')]");
//		elementos.get(0).click();
//		SeleniumUtils.esperarSegundos(driver, 2);
//		PO_LoginView.fillForm(driver, "prueba2@prueba2.com", "prueba2");
//		SeleniumUtils.textoPresentePagina(driver, "Usuarios");
//		By enlace = By.xpath("//td[contains(text(), 'RegVal')]/following-sibling::*[2]");
//		SeleniumUtils.esperarSegundos(driver, 1);
//		driver.findElement(enlace).click();
//		SeleniumUtils.esperarSegundos(driver, 2);
//		SeleniumUtils.textoPresentePagina(driver, "Petición de amistad enviada correctamente.");
//	}
//
//	// Desde el listado de usuarios de la aplicación, enviar una invitación de amistad a un usuario al
//	que ya le habíamos enviado la invitación previamente. No debería dejarnos enviar la invitación, se podría
//	ocultar el botón de enviar invitación o notificar que ya había sido enviada previamente.
//	@Test
//	public void PR16() {
//		List<WebElement> elementos = PO_View.checkElement(driver, "free", "//li/a[contains(@id, 'botonLogin')]");
//		elementos.get(0).click();
//		SeleniumUtils.esperarSegundos(driver, 2);
//		PO_LoginView.fillForm(driver, "prueba2@prueba2.com", "prueba2");
//		SeleniumUtils.textoPresentePagina(driver, "Usuarios");
//		By enlace = By.xpath("//td[contains(text(), 'RegVal')]/following-sibling::*[2]");
//		SeleniumUtils.esperarSegundos(driver, 1);
//		driver.findElement(enlace).click();
//		SeleniumUtils.esperarSegundos(driver, 2);
//		SeleniumUtils.textoPresentePagina(driver, "Error al enviar petición, ya existe una petición enviada.");
//	}
//
//	// PR017. Sin hacer /
//	@Test
//	public void PR17() {
//		List<WebElement> elementos = PO_View.checkElement(driver, "free", "//li/a[contains(@id, 'botonLogin')]");
//		elementos.get(0).click();
//		SeleniumUtils.esperarSegundos(driver, 2);
//		PO_LoginView.fillForm(driver, "prueba2@prueba2.com", "prueba2");
//		SeleniumUtils.textoPresentePagina(driver, "Usuarios");
//		elementos = PO_View.checkElement(driver, "free", "//a[contains(@href,'/requests')]");
//		elementos.get(0).click();
//		elementos = PO_View.checkElement(driver, "free", "//td/following-sibling::*[1]");
//		assertTrue(elementos.size() == 1);
//	}
//
	// Sobre el listado de invitaciones recibidas. Hacer click en el botón/enlace de
	// una de ellas y
	// comprobar que dicha solicitud desaparece del listado de invitaciones.
//	@Test
//	public void PR18() {
//		List<WebElement> elementos = PO_View.checkElement(driver, "free", "//li/a[contains(@id, 'botonLogin')]");
//		elementos.get(0).click();
//		SeleniumUtils.esperarSegundos(driver, 2);
//		PO_LoginView.fillForm(driver, "prueba2@prueba2.com", "prueba2");
//		SeleniumUtils.textoPresentePagina(driver, "Usuarios");
//		elementos = PO_View.checkElement(driver, "free", "//a[contains(@href,'/requests')]");
//		elementos.get(0).click();
//		SeleniumUtils.esperarSegundos(driver, 2);
//		elementos = PO_View.checkElement(driver, "free", "//td/following-sibling::*[1]");
//		assertTrue(elementos.size() == 1);
//		elementos.get(0).click();
//		try {
//			elementos = PO_View.checkElement(driver, "free", "//td/following-sibling::*[1]");
//		} catch (TimeoutException e) {
//			// No encuentra el objeto porque ya no esta
//		}
//	}
//
//	// Mostrar el listado de amigos de un usuario. Comprobar que el listado contiene los amigos que deben ser.
//	@Test
//	public void PR19() {
//		List<WebElement> elementos = PO_View.checkElement(driver, "free", "//li/a[contains(@id, 'botonLogin')]");
//		elementos.get(0).click();
//		SeleniumUtils.esperarSegundos(driver, 2);
//		PO_LoginView.fillForm(driver, "prueba2@prueba2.com", "prueba2");
//		SeleniumUtils.textoPresentePagina(driver, "Usuarios");
//		elementos = PO_View.checkElement(driver, "free", "//a[contains(@href,'/friends')]");
//		elementos.get(0).click();
//		SeleniumUtils.esperarSegundos(driver, 2);
//		SeleniumUtils.textoPresentePagina(driver, "prueba1");// Su unico amigo
//	}
//
//	//Intentar acceder sin estar autenticado a la opción de listado de usuarios. Se deberá volver al
//// formulario de login
//	@Test
//	public void PR20() {
//		driver.navigate().to("http://localhost:8081/user/list");
//		SeleniumUtils.textoPresentePagina(driver, "Intento de acceso a una zona privada sin autorizacion");
//	}
//
//	// Intentar acceder sin estar autenticado a la opción de listado de invitaciones de amistad recibida
	//// de un usuario estándar. Se deberá volver al formulario de login.
//	@Test
//	public void PR21() {
//		driver.navigate().to("http://localhost:8081/requests");
//		SeleniumUtils.textoPresentePagina(driver, "Intento de acceso a una zona privada sin autorizacion");
//	}
//
//	// Intentar acceder estando autenticado como usuario standard a la lista de amigos de otro
// //usuario. Se deberá mostrar un mensaje de acción indebida.
//	@Test
//	public void PR22() {
//		assertTrue("Que resulta que este lo teneis mal, gracias por avisar -.-", false);
//	}
//
//	//Inicio de sesión con datos válidos.
//	@Test
//	public void PR23() {
//		driver.navigate().to("http://localhost:8081/cliente.html");
//		PO_LoginView.fillForm(driver, "prueba99@prueba99.com", "prueba99");
//		SeleniumUtils.esperarSegundos(driver, 3);
//		PO_View.checkElement(driver, "text", "Amigos");
//	}
//
//	// Inicio de sesión con datos inválidos (usuario no existente en la aplicación)Usuario no encontrado
	@Test
	public void PR24() {
		driver.navigate().to("http://localhost:8081/cliente.html");
		PO_LoginView.fillForm(driver, "pedo@prueba99.com", "Fake");
		SeleniumUtils.esperarSegundos(driver, 3);
		SeleniumUtils.textoPresentePagina(driver, "Usuario no encontrado");
	}
//
//	// PR25. Sin hacer /
//	@Test
//	public void PR25() {
//		assertTrue("PR25 sin hacer", false);
//	}
//
//	// PR26. Sin hacer /
//	@Test
//	public void PR26() {
//		assertTrue("PR26 sin hacer", false);
//	}
//
//	// PR27. Sin hacer /
//	@Test
//	public void PR27() {
//		assertTrue("PR27 sin hacer", false);
//	}
//
//	// PR029. Sin hacer /
//	@Test
//	public void PR29() {
//		assertTrue("PR29 sin hacer", false);
//	}
//
//	// PR030. Sin hacer /
//	@Test
//	public void PR30() {
//		assertTrue("PR30 sin hacer", false);
//	}
//
//	// PR031. Sin hacer /
//	@Test
//	public void PR31() {
//		assertTrue("PR31 sin hacer", false);
//	}

}
