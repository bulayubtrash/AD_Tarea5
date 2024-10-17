package ejercicio1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Gestor {
	Alumno a1 = new Alumno();
	Scanner sc = new Scanner(System.in);

	public void crearAlumno(String ruta) {
		for (int i = 0; i < 2; i++) {

			a1 = new Alumno();
			System.out.println("Introduzca los siguientes datos:");

			System.out.println("Intoduzca el NIA");
			a1.setNia(sc.nextInt());

			sc.nextLine();

			System.out.println("Intoduzca el Nombre");
			a1.setNombre(sc.nextLine());

			System.out.println("Intoduzca el Apellidos");
			a1.setApellidos(sc.nextLine());

			System.out.println("Intoduzca el Genero");

			String genero = sc.nextLine();

			a1.setGenero(genero.charAt(0));

			System.out.println("Intoduzca el Fecha de nacimiento dd/mm/yyyy");

			String fecha = sc.nextLine();

			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

			try {
				a1.setFechaNac(formato.parse(fecha));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("Intoduzca el Ciclo");
			a1.setCiclo(sc.nextLine());

			System.out.println("Intoduzca el Curso");
			a1.setCurso(sc.nextLine());

			System.out.println("Intoduzca el Grupo");
			a1.setGrupo(sc.nextLine());

			escribirFichero(a1, ruta);
		}

	}

	public void escribirFichero(Alumno alumno, String ruta) {

		ObjectOutputStream oos;

		try {
			oos = new ObjectOutputStream(new FileOutputStream(ruta, true));
			oos.writeObject(alumno);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void leerFichero(String ruta) {
//		String ruta="C:\\Users\\usuario\\Desktop\\alum2.dat";
		ObjectInputStream ois=null;
		FileInputStream fis;

		try {
			fis = new FileInputStream(ruta);
			ois = new ObjectInputStream(fis);
			while (fis.available() > 0) {
				Alumno a1 = (Alumno) ois.readObject();
				System.out.println(a1);
			}

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
