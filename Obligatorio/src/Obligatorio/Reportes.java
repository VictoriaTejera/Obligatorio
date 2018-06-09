package Obligatorio;

import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

import uy.edu.um.prog2.adt.Hash.ElementoYaExistenteException;
import uy.edu.um.prog2.adt.Hash.HashTable;
import uy.edu.um.prog2.adt.Queue.EmptyQueueException;
import uy.edu.um.prog2.adt.Queue.MyPriotityQueue;
import uy.edu.um.prog2.adt.Queue.PriorityQueue;

public class Reportes {	
	
	
	Scanner sc= new Scanner(System.in);
	
	CargaDeDatos cargaDeDatos;
	public Reportes() {
		
		System.out.println("Inserte el archivo de datos");
		cargaDeDatos= new CargaDeDatos();
		try {
			cargaDeDatos.cargar(sc.next());
		} catch (ElementoYaExistenteException e) {
			
			
		} catch (IOException e) {
			
		}
		
	}
	

	public void reporte1() {
		
		MyPriotityQueue<Empresa> priorityQueue=new PriorityQueue<>();
		
		HashTable<String, Empresa> empresas=cargaDeDatos.getEmpresas();
		
		
		Iterator<Empresa> iteratorEmpresa=empresas.iterator();
		int clave=0;
		
		while(iteratorEmpresa.hasNext()==true) {
			Empresa oEmpresa=  iteratorEmpresa.next();
		
			
		clave=oEmpresa.getpHabilitados().size();
		
		
		priorityQueue.insert(oEmpresa,clave);
		}
		
		for(int i=0; i<20; i++) {
		try {
			System.out.println(priorityQueue.getFirst().getNombre() + " " + priorityQueue.getFirst().getpHabilitados().size());
			
			priorityQueue.dequeue();
			
		} catch (EmptyQueueException e) {
			
		}
		
		
			
		}
			
		
		
	}
	
	
	
}
