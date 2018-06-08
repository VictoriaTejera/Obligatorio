package Obligatorio;

import java.io.IOException;
import java.util.Scanner;

import uy.edu.um.prog2.adt.Hash.ElementoYaExistenteException;

public class Principal {

	public static void main(String[] args) {
		
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Ingresar el archivo de datos");
		
		CargaDeDatos cargaDeDatos= new CargaDeDatos();
		
		try {
			cargaDeDatos.cargar(sc.next());
		} catch (ElementoYaExistenteException e) {
			
		} catch (IOException e) {
			

		
		
	}

}
}
