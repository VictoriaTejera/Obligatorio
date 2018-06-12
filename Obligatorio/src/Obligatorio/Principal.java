package Obligatorio;

import java.io.IOException;
import java.util.Scanner;

import uy.edu.um.prog2.adt.Hash.ElementoYaExistenteException;

public class Principal {

	public static void main(String[] args) {
		Reportes reporte= new Reportes();
		Scanner sc = new Scanner (System.in);
		String opcion = null;
		do { 
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");	
		System.out.println("Elija la opcion: ");
		System.out.println("");
		System.out.println("1. Listar 20 empresas con mayor cantidad de productos habilitados.");
		System.out.println("2. Listar 10 marcas con mayor cantidad de productos habilitados.");
		System.out.println("3. Listar 10 paises con mayor cantidad de productos habilitados.");
		System.out.println("4. Listar 20 clases con mayor cantidad de productos habilitados.");
		System.out.println("5. Salir.");
		opcion = sc.nextLine(); 
		switch(opcion) {
			case "1": 
				reporte.reporte1();
				break;
			case "2":
				reporte.reporte2();
				break;
			case "3":
				reporte.reporte3();
				break;
			case "4":
				reporte.reporte4();
				break;
			case "5":
				System.exit(0);
				break;
		default:
			if (!opcion.equals("1") && !opcion.equals("2")&& !opcion.equals("3") && !opcion.equals("4") && !opcion.equals("5")) {
				System.out.println("Opcion incorrecta, vuelva a intentarlo.");  
				System.out.println(""); 
				}
		
		}		
	}
		while(opcion!="5");
		
	}
}







