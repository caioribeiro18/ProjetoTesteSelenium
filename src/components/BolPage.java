package components;

import library.LibSelenium;

public class BolPage {

	LibSelenium lib = LibSelenium.getInstance();

	public void digitaCampoEmailESenha(String email , String senha ) {
		lib.sendKeys("/html/body/div[1]/div[3]/div/div/div[3]/form/input[1]",  email);
		lib.sendKeys("/html/body/div[1]/div[3]/div/div/div[3]/form/input[2]",  senha);
	}
	
	public CaixaEntradaBol clicarEntrar() {
		lib.click("/html/body/div[1]/div[3]/div/div/div[3]/form/button");
		lib.waitElement("/html/body/div[3]/div/section[2]/div/div[2]/div/div[2]/section[1]/div/div[1]");		
		return new CaixaEntradaBol();
	}

}
