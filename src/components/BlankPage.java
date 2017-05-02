package components;

import library.LibSelenium;

public class BlankPage {
	LibSelenium lib = LibSelenium.getInstance();

	public void navegarAteBol(String URL) {
		lib.navigate(URL);
	}
}