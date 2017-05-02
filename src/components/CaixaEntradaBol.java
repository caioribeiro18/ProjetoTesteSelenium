package components;

import static org.junit.Assert.assertTrue;

import library.LibSelenium;

public class CaixaEntradaBol {

	LibSelenium lib = LibSelenium.getInstance();
	
	public void clicaBotaoEscrever() {
		lib.click("/html/body/div[3]/div/section[1]/div/div[1]/div[3]/menu[1]");	
	}
	
	public void insereEmailDestinatario(String emailDestinatario){
		lib.sendKeys("//*[@id=\"fake_input__field-to\"]", emailDestinatario);
	}
	
	public void insereAssunto(String textoAssunto){
		lib.sendKeys("//*[@id=\"field-subject\"]", textoAssunto);
	}
	
	public void insereTextoCorpoEmail(String textoCorpoEmail){
		lib.waitElement("//*[@id=\"cke_1_contents\"]/iframe");
		lib.click("//*[@id=\"cke_1_contents\"]/iframe");		
		lib.sendKeys("//*[@id=\"cke_1_contents\"]/iframe", textoCorpoEmail);
	}
	
	public void clicaBotaoEnviar(){
		lib.click("/html/body/div[3]/div/div[1]/form/div[2]/div[1]/menu[1]");
	}
	
	public void validaEnvioEmail(){
		lib.waitElement("/html/body/div[3]/div/section[2]/div/div[2]/div/div[2]/section[1]/div/div[1]");
		assertTrue(lib.exists("/html/body/div[3]/div/section[2]/div/div[2]/div/div[2]/section[1]/div/div[1]"));
	}
}
