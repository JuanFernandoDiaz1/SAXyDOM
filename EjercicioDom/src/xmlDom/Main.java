package xmlDom;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GestorDom gDom = new GestorDom();
		
		File f = new File("fichero.xml");
		
		if(f.exists()) {
			gDom.anadirProductos();
		}else {
			gDom.crearArchivoXML();
		}
	}

}
