package controlador;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import modelo.Alumno;

public class GestorSax {

	public ArrayList<Alumno> leerXML() {
		ArrayList<Alumno> alumnos= new ArrayList<Alumno>();
		File f = new File("alumnos.xml");
		SAXParserFactory factoria = SAXParserFactory.newInstance();
		try {
			SAXParser saxParser = factoria.newSAXParser();
			ManejaAlumnos manejador = new ManejaAlumnos();
			saxParser.parse(f, manejador);
			alumnos = manejador.getAlumnos();

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return alumnos;
	}

	public void escribir() {
		ArrayList<Alumno> alumnos= new ArrayList<Alumno>();
		alumnos=leerXML();
		try {
			File fichero = new File("fichero.txt");
			FileOutputStream fileout = new FileOutputStream(fichero);
			ObjectOutputStream datOS = new ObjectOutputStream(fileout);
			for(Alumno alumno : alumnos) {
				datOS.writeObject(alumno);
			}
			datOS.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void leerObjeto() {
		Alumno alumno;
		ObjectInputStream datIN=null;
		try {
			File fichero = new File("fichero.txt");
			FileInputStream  filein = new FileInputStream(fichero);
			datIN = new ObjectInputStream(filein);
			while(datIN!=null) {
				alumno = (Alumno) datIN.readObject();
				System.out.println(alumno.getCodigo());
				System.out.println(alumno.getNombre());
				System.out.println(alumno.getEdad());
				System.out.println(alumno.getDireccion().getCalle());
				System.out.println(alumno.getDireccion().getProvinvia());
				System.out.println("");
			}
			
		} catch (EOFException e) {
		}  catch(IOException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
		} finally {
			try {
				datIN.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
