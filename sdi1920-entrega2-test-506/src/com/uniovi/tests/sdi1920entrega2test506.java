package com.uniovi.tests;

//Paquetes Java
import java.util.List;
//Paquetes JUnit 
import org.junit.*;
import org.junit.runners.MethodSorters;
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
//	@Test
//	public void PR05() {
//		driver.navigate().to("http://localhost:8081/cliente.html");
//		PO_LoginView.fillForm(driver, "prueba99@prueba99.com", "prueba99");
//		SeleniumUtils.esperarSegundos(driver, 3);
//		PO_View.checkElement(driver, "text", "Amigos");
//	}
//	//Inicio de sesión con datos inválidos (usuario estándar, campo email y contraseña vacíos)
	@Test
	public void PR06() {
		driver.navigate().to("http://localhost:8081/cliente.html");
		PO_LoginView.fillForm(driver, "", "");
		SeleniumUtils.esperarSegundos(driver, 3);
		SeleniumUtils.textoPresentePagina(driver, "Usuario no encontrado");
	}
//
//	// PR07. Sin hacer /
//	@Test
//	public void PR07() {
//		assertTrue("PR07 sin hacer", false);
//	}
//
//	// PR08. Sin hacer /
//	@Test
//	public void PR08() {
//		assertTrue("PR08 sin hacer", false);
//	}
//
//	// PR09. Sin hacer /
//	@Test
//	public void PR09() {
//		assertTrue("PR09 sin hacer", false);
//	}
//
//	// PR10. Sin hacer /
//	@Test
//	public void PR10() {
//		assertTrue("PR10 sin hacer", false);
//	}
//
//	// PR11. Sin hacer /
//	@Test
//	public void PR11() {
//		assertTrue("PR11 sin hacer", false);
//	}
//
//	// PR12. Sin hacer /
//	@Test
//	public void PR12() {
//		assertTrue("PR12 sin hacer", false);
//	}
//
//	// PR13. Sin hacer /
//	@Test
//	public void PR13() {
//		assertTrue("PR13 sin hacer", false);
//	}
//
//	// PR14. Sin hacer /
//	@Test
//	public void PR14() {
//		assertTrue("PR14 sin hacer", false);
//	}
//
//	// PR15. Sin hacer /
//	@Test
//	public void PR15() {
//		assertTrue("PR15 sin hacer", false);
//	}
//
//	// PR16. Sin hacer /
//	@Test
//	public void PR16() {
//		assertTrue("PR16 sin hacer", false);
//	}
//
//	// PR017. Sin hacer /
//	@Test
//	public void PR17() {
//		assertTrue("PR17 sin hacer", false);
//	}
//
//	// PR18. Sin hacer /
//	@Test
//	public void PR18() {
//		assertTrue("PR18 sin hacer", false);
//	}
//
//	// PR19. Sin hacer /
//	@Test
//	public void PR19() {
//		assertTrue("PR19 sin hacer", false);
//	}
//
//	// P20. Sin hacer /
//	@Test
//	public void PR20() {
//		assertTrue("PR20 sin hacer", false);
//	}
//
//	// PR21. Sin hacer /
//	@Test
//	public void PR21() {
//		assertTrue("PR21 sin hacer", false);
//	}
//
//	// PR22. Sin hacer /
//	@Test
//	public void PR22() {
//		assertTrue("PR22 sin hacer", false);
//	}
//
//	// PR23. Sin hacer /
//	@Test
//	public void PR23() {
//		assertTrue("PR23 sin hacer", false);
//	}
//
//	// PR24. Sin hacer /
//	@Test
//	public void PR24() {
//		assertTrue("PR24 sin hacer", false);
//	}
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
