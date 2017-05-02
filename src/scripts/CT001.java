package scripts;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import components.BlankPage;
import components.BolPage;
import components.CaixaEntradaBol;
import coreFrame.Config;
import data.Json;
import library.LibSelenium;

public class CT001 {
	Json json;
	Config config = Config.getInstance();

	@Before
	public void preConditions() {
		config.setCurrentCaseName(this.getClass().getSimpleName());
		json = new Json(config.getCurrentCaseName());
	}

	@Test
	public void mainTest() {
		try {

			BlankPage blank = new BlankPage();
			blank.navegarAteBol("https://www.bol.uol.com.br/");

			BolPage bolPage = new BolPage();
			bolPage.digitaCampoEmailESenha(json.getEmail(), json.getSenha());

			CaixaEntradaBol caixaEntrada = bolPage.clicarEntrar();
			caixaEntrada.clicaBotaoEscrever();
			caixaEntrada.insereEmailDestinatario(json.getEmailDestinatario());
			caixaEntrada.insereAssunto(json.getTextoAssunto());
			caixaEntrada.insereTextoCorpoEmail(json.getTextoCorpoEmail());
			caixaEntrada.clicaBotaoEnviar();
			caixaEntrada.validaEnvioEmail();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@After
	public void finalTest() {
		LibSelenium.getInstance().driverClose();
	}
}