package controlador;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import modelo.Alumno;
import modelo.Direccion;


public class ManejaAlumnos extends DefaultHandler {
	private ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
	private Alumno alumno;
	private Direccion direccion;
	private StringBuilder buffer = new StringBuilder();

	@Override
	public void characters(char[] arg0, int arg1, int arg2) throws SAXException {
		// TODO Auto-generated method stub
		// super.characters(arg0, arg1, arg2);
		buffer.append(arg0, arg1, arg2);
	}

	@Override
	public void endElement(String arg0, String arg1, String arg2) throws SAXException {
		switch (arg2) {
		case "alumnos":
			
		case "alumno":
			break;
		case "nombre":
			alumno.setNombre(buffer.toString());
			break;
		case "edad":
			alumno.setEdad(Integer.parseInt(buffer.toString()));
			break;
		case "direccion":
			break;
		case "calle":
			direccion.setCalle(buffer.toString());
			break;
		case "provincia":
			direccion.setProvinvia(buffer.toString());
		}
	}

	@Override
	public void startElement(String arg0, String arg1, String arg2, Attributes arg3) throws SAXException {
		switch (arg2) {
		case "alumnos":
			break;
		case "alumno":
			alumno = new Alumno();
			direccion = new Direccion();
			alumno.setDireccion(direccion);
			alumnos.add(alumno);
			alumno.setCodigo(Integer.parseInt(arg3.getValue("codigo")));
			break;
		case "nombre":
			buffer.delete(0, buffer.length());
			// break;
		case "edad":
			buffer.delete(0, buffer.length());
			// break;
		case "direccion":
			buffer.delete(0, buffer.length());
		case "calle":
			buffer.delete(0, buffer.length());
		case "provincia":
			buffer.delete(0, buffer.length());
		}
	}

	public ArrayList<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(ArrayList<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
	
}
