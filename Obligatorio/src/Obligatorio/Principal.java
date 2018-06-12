package Obligatorio;

import java.io.IOException;
import java.util.Scanner;

import uy.edu.um.prog2.adt.Hash.ElementoYaExistenteException;

public class Principal {

	public static void main(String[] args) {
		
		Reportes reporte= new Reportes();
		
		//System.out.println("20 empresas con mayor cantidad de productos habilitados (empresa, cantidad):");
		//System.out.println("");
		reporte.reporte1();
		System.out.println("-----------------------------------------------------------------------------------");
		reporte.reporte2();
		System.out.println("-----------------------------------------------------------------------------------");
		reporte.reporte3();
		System.out.println("-----------------------------------------------------------------------------------");
		reporte.reporte4();
		
		
	
		
}
}
