package com.uniovi.pageobjects;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.*;

import com.uniovi.utils.SeleniumUtils;

public class PO_NavView extends PO_View {

	/**
	 * * CLicka una de las opciones principales (a href) y comprueba que se vaya a
	 * la vista con el elemento de tipo type con el texto Destino * @param driver:
	 * apuntando al navegador abierto actualmente. * @param textOption: Texto de la
	 * opción principal. * @param criterio: "id" or "class" or "text" or
	 * "@attribute" or "free". Si el valor de criterio es free es una expresion
	 * xpath completa. * @param textoDestino: texto correspondiente a la búsqueda de
	 * la página destino.
	 */

	public static void clickOption(WebDriver driver, String textOption, String criterio, String textoDestino) {
		// CLickamos en la opción de registro y esperamos a que se cargue el enlace de
		// Registro.
		List<WebElement> elementos = SeleniumUtils.EsperaCargaPagina(driver, "@href", textOption, getTimeout());
		// Tiene que haber un sólo elemento.
		assertTrue(elementos.size() == 1);
		// Ahora lo clickamos
		elementos.get(0).click();
		// Esperamos a que sea visible un elemento concreto
		elementos = SeleniumUtils.EsperaCargaPagina(driver, criterio, textoDestino, getTimeout());
		// Tiene que haber un sólo elemento.
		assertTrue(elementos.size() == 1);
	}

	/**
	 * * Selecciona el enlace de idioma correspondiente al texto textLanguage
	 * * @param driver: apuntando al navegador abierto actualmente. * @param
	 * textLanguage: el texto que aparece en el enlace de idioma ("English" o
	 * "Spanish")
	 */
	public static void changeIdiom(WebDriver driver, String textLanguage) {   
		//clickamos la opción Idioma.   
		List<WebElement> elementos = SeleniumUtils.EsperaCargaPagina(driver, "id", "btnLanguage", getTimeout());     
		elementos.get(0).click();   
		//Esperamos a que aparezca el menú de opciones.   
		elementos = SeleniumUtils.EsperaCargaPagina(driver, "id", "languageDropdownMenuButton", getTimeout());   
		//SeleniumUtils.esperarSegundos(driver, 2);   
		//CLickamos la opción Inglés partiendo de la opción Español   
		elementos = SeleniumUtils.EsperaCargaPagina(driver, "id", textLanguage, getTimeout());   
		elementos.get(0).click(); 
	 } 
	
	/**
	 * * Selecciona la opción de Gestion de Usuarios y posteriormente
	 * el botón de Ver Usuarios.
	 * * @param driver: apuntando al navegador abierto actualmente.
	 */
	public static void accessSeeker(WebDriver driver) {
		//clicamos la opcion de gestion de usuarios
		List<WebElement> elementos = SeleniumUtils.EsperaCargaPagina(driver, "id", "users-menu", getTimeout());
		elementos.get(0).click();   
		//Esperamos a que aparezca el menú de opciones.   
		elementos = SeleniumUtils.EsperaCargaPagina(driver, "id", "languageDropdownMenuButton", getTimeout());   
		//Clickamos la opcion Ver Usuarios
		elementos = SeleniumUtils.EsperaCargaPagina(driver, "id", "btnSeeUsers", getTimeout());
		elementos.get(0).click(); 
	}
	
	public static void writeOnSeeker(WebDriver driver, String texto) {
		//Escribimos lo pasado como parametro dentor del buscador de usuarios
		WebElement userSeeker = driver.findElement(By.id("userSeeker"));
		userSeeker.click();
		userSeeker.clear();
		userSeeker.sendKeys(texto);
		//Pulsamos el boton de buscar
		By boton = By.id("btnSeek");
		driver.findElement(boton).click();
	}

}