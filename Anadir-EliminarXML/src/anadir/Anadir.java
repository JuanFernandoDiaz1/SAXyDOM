package anadir;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class Anadir {
	private Document doc1;
	
	public Anadir() {
		try {
			DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factoria.newDocumentBuilder();
			doc1 = builder.parse("alumnos.xml");	

		} catch (Exception pc) {
			pc.printStackTrace();
		}
	}

	public void insertar() {
		Element alumnos = doc1.getDocumentElement();

		Element alumno = doc1.createElement("alumno");
		alumnos.appendChild(alumno);
		alumno.setAttribute("codigo", "58");

		Element nombre = doc1.createElement("nombre");
		alumno.appendChild(nombre);
		nombre.appendChild(doc1.createTextNode("Braulio"));

		Element edad = doc1.createElement("edad");
		alumno.appendChild(edad);
		edad.setTextContent("21");

		Element direccion = doc1.createElement("direccion");
		alumno.appendChild(direccion);

		Element calle = doc1.createElement("calle");
		direccion.appendChild(calle);
		calle.appendChild(doc1.createTextNode("estrecha"));

		Element provincia = doc1.createElement("provincia");
		direccion.appendChild(provincia);
		provincia.appendChild(doc1.createTextNode("casona"));
		
		/*
		Node raiz = doc1.getDocumentElement();
		NodeList alumnosNode = raiz.getChildNodes();
		raiz.insertBefore(alumno, alumnosNode.item(0));*/
	}
	
	public void eliminar() {
		String nombre = "Braulio";
		
		Node raiz = doc1.getDocumentElement();
		NodeList alumnos = raiz.getChildNodes();
		for(int x = 0; x<alumnos.getLength();x++) {
			Node alumno = alumnos.item(x);
			NodeList datos = alumno.getChildNodes();
			for(int y = 0; y<datos.getLength();y++) {
				Node dato = datos.item(y);
				if(dato.getNodeName().equals("nombre") && dato.getTextContent().equals(nombre)) {
					dato.getParentNode();
					while(alumno.hasChildNodes()) {
						alumno.removeChild(alumno.getFirstChild());
					}
				}
			}
		}
	}
}
