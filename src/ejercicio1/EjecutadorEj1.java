package ejercicio1;

import java.util.Scanner;

public class EjecutadorEj1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Gestor g= new Gestor();
		System.out.println("Introduzca la ruta del fichero que desee crear para escribir los archivos");
		String ruta=sc.nextLine();
		g.crearAlumno(ruta);
		
	}

}
