package xmlDom;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class GestorDom {
private Document doc;
	
	public GestorDom() {
		DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = factoria.newDocumentBuilder();
			doc = builder.newDocument();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		
	}
	
	public void crearDocumento() {
		
		Element datos = doc.createElement("datos");
		doc.appendChild(datos);
		
		Element ventas = doc.createElement("ventas");
		datos.appendChild(ventas);
		
		Element productos = doc.createElement("productos");
		ventas.appendChild(productos);
		
		Element producto = doc.createElement("producto");
		productos.appendChild(producto);

		producto.setAttribute("codigo", "1");
		producto.setAttribute("tipo", "A");
		
		Element nombre = doc.createElement("nombre");
		producto.appendChild(nombre);
		nombre.appendChild(doc.createTextNode("Atun"));
		

		Element descripccion = doc.createElement("descripccion");
		producto.appendChild(descripccion);
		descripccion.appendChild(doc.createTextNode("Lomos de atun en aceite"));
		
		Element precio = doc.createElement("precio");
		producto.appendChild(precio);
		precio.appendChild(doc.createTextNode("12.58"));
		
	}
	
	public void anadirProductos() {
		
		Scanner teclado = new Scanner(System.in);
		
		Element datos = doc.createElement("datos");
		doc.appendChild(datos);
		
		Element ventas = doc.createElement("ventas");
		datos.appendChild(ventas);
		
		Element productos = doc.createElement("productos");
		ventas.appendChild(productos);

		Element producto = doc.createElement("producto");
		productos.appendChild(producto);
		
		producto.setAttribute("codigo", "1");
		producto.setAttribute("tipo", "A");
		
		System.out.print("Nombre: ");
		Element nombre = doc.createElement("nombre");
		producto.appendChild(nombre);
		nombre.appendChild(doc.createTextNode(teclado.nextLine()));
		System.out.println();
		System.out.println();
		
		System.out.print("Descripccion: ");
		Element descripccion = doc.createElement("descripccion");
		producto.appendChild(descripccion);
		descripccion.appendChild(doc.createTextNode(teclado.nextLine()));
		System.out.println();
		System.out.println();
		
		System.out.print("Precio: ");
		Element precio = doc.createElement("precio");
		producto.appendChild(precio);
		precio.appendChild(doc.createTextNode(teclado.nextLine()));
		System.out.println();
		System.out.println();
	}
	
	public void crearArchivoXML() {
		TransformerFactory factoria = TransformerFactory.newInstance();
		Transformer transformer;
		try {
			transformer = factoria.newTransformer();
			Source source = new DOMSource(doc);
			File f = new File("fichero.xml");
			FileWriter fw = new FileWriter(f);
			PrintWriter pw = new PrintWriter(fw);
			Result result = new StreamResult(pw);
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			transformer.transform(source, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
