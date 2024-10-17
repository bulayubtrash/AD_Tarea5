package ejercicio1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Gestor {

	public void escribirFichero(Alumno alumno) {

		ObjectOutputStream oos;

		try {
			oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\usuario\\Desktop\\alum2.dat", true));
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

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ruta))) {
			Alumno a1 = (Alumno) ois.readObject();
			System.out.println(a1);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
