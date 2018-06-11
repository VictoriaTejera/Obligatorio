package Obligatorio;

import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

import uy.edu.um.prog2.adt.Hash.ElementoYaExistenteException;
import uy.edu.um.prog2.adt.Hash.HashTable;
import uy.edu.um.prog2.adt.Heap.HeapImpl;
import uy.edu.um.prog2.adt.Heap.HeapVacio;
import uy.edu.um.prog2.adt.Heap.MyHeap;
import uy.edu.um.prog2.adt.Lista.List;
import uy.edu.um.prog2.adt.Lista.PosInvalida;
import uy.edu.um.prog2.adt.Queue.EmptyQueueException;
import uy.edu.um.prog2.adt.Queue.MyPriotityQueue;
import uy.edu.um.prog2.adt.Queue.NodoWPrioridad;
import uy.edu.um.prog2.adt.Queue.PriorityQueue;

public class Reportes {

	Scanner sc = new Scanner(System.in);

	CargaDeDatos cargaDeDatos;

	public Reportes() {

		System.out.println("Inserte el archivo de datos");
		cargaDeDatos = new CargaDeDatos();
		try {
			cargaDeDatos.cargar(sc.next());
		} catch (ElementoYaExistenteException e) {

		} catch (IOException e) {

		}

	}

	public void reporte1() {

		MyPriotityQueue<Empresa> priorityQueue = new PriorityQueue<>();

		HashTable<String, Empresa> empresas = cargaDeDatos.getEmpresas();

		Iterator<Empresa> iteratorEmpresa = empresas.iterator();
		int clave = 0;

		while (iteratorEmpresa.hasNext() == true) {

			Empresa oEmpresa = iteratorEmpresa.next();

			clave = oEmpresa.getpHabilitados().size();

			priorityQueue.insert(oEmpresa, clave);

		}

		for (int i = 0; i < 20; i++) {
			try {
				System.out.println(
						priorityQueue.getFirst().getNombre() + " " + priorityQueue.getFirst().getpHabilitados().size());

				priorityQueue.dequeue();

			} catch (EmptyQueueException e) {

			}
		}

	}

	// public void marcasPorPais(Pais oPais) {
	//
	// MyPriotityQueue<Marca> priorityQueue=new PriorityQueue<>();
	//
	// HashTable<String, Marca> marcas = cargaDeDatos.getMarcas();
	//
	// Iterator<Marca> iteratorMarca = marcas.iterator();
	//
	// int clave=0;
	//
	// while(iteratorMarca.hasNext()==true) {
	//
	// Marca oMarca = iteratorMarca.next();
	//
	// clave = oMarca.getpHabilitados().size();
	//
	// priorityQueue.insert(oMarca,clave);
	//
	// }
	//
	// for(int i=0; i<10; i++) {
	//
	// try {
	// oPais.agregarMarcaP(priorityQueue.getFirst());
	// priorityQueue.dequeue();
	// } catch (EmptyQueueException e) {
	//
	// e.printStackTrace();
	// }
	// }
	// }
	//
	// public void reporte2() {
	//
	// MyPriotityQueue<Marca> priorityQueue=new PriorityQueue<>();
	//
	// HashTable<String, Pais> paises = cargaDeDatos.getPaises();
	//
	// Iterator<Pais> iteratorPais = paises.iterator();
	// int clave=0;
	// while(iteratorPais.hasNext()==true) {
	// Pais oPais = iteratorPais.next();
	// System.out.println("PAIS: " + oPais.getNombre());
	// marcasPorPais(oPais);
	// for(int i=0; i<10; i++) {
	// try {
	// System.out.println(oPais.getmarcasPais().get(i).getNombre() + " " +
	// oPais.getmarcasPais().get(i).getpHabilitados().size());
	// } catch (PosInvalida e) {
	// System.out.println("Exception: " + e.getMessage());
	// }
	// }
	// }
	//
	//
	// }
	//

	/*
	 * public void reporte2() { MyPriotityQueue<Marca> priorityQueue=new
	 * PriorityQueue<>();
	 * 
	 * HashTable<String, Pais> paises = cargaDeDatos.getPaises();
	 * 
	 * Iterator<Pais> iteratorPais = paises.iterator(); int clave=0;
	 * while(iteratorPais.hasNext()==true) { Pais oPais = iteratorPais.next();
	 * System.out.println("PAIS:  " + oPais.getNombre());
	 * 
	 * try { for (int i=0; i<oPais.getmarcasPais().size();i++) { //for (int j=0;
	 * j<oPais.getmarcasPais().get(i).getpHabilitados().size(); j++) { clave =
	 * oPais.getmarcasPais().get(i).getpHabilitados().size();
	 * priorityQueue.insert(oPais.getmarcasPais().get(i), clave); //} } } catch
	 * (PosInvalida e) {
	 * 
	 * } for (int i=0; i<10; i ++) { try {
	 * System.out.println(priorityQueue.getFirst().getNombre() + " - " +
	 * priorityQueue.getFirst().getpHabilitados().size());
	 * 
	 * priorityQueue.dequeue(); } catch (EmptyQueueException e) {
	 * 
	 * }
	 * 
	 * } } }
	 */

	// public void marcasPorPais(Pais oPais) {
	//
	// MyPriotityQueue<Marca> priorityQueue = new PriorityQueue<>();
	//
	// int clave = 0;
	//
	// int tamano = oPais.getmarcasPais().size();
	//
	// for (int i = 0; i < oPais.getmarcasPais().size(); i++) {
	//
	// try {
	//
	// clave = oPais.getmarcasPais().get(i).getpHabilitados().size();
	// priorityQueue.insert(oPais.getmarcasPais().get(i), clave);
	// } catch (PosInvalida e) {
	//
	// }
	//
	// }
	//
	// for (int i = 0; i < 10; i++) {
	// try {
	//
	// oPais.agregarMarcaP(priorityQueue.getFirst());
	// priorityQueue.dequeue();
	//
	// } catch (EmptyQueueException e) {
	//
	// }
	// }
	//
	// }

	// public void reporte2() {
	//
	//// MyPriotityQueue<Marca> priorityQueue=new PriorityQueue<>();
	//
	// HashTable<String, Pais> paises = cargaDeDatos.getPaises();
	//
	// Iterator<Pais> iteratorPais = paises.iterator();
	// int clave=0;
	// while(iteratorPais.hasNext()==true) {
	// Pais oPais = iteratorPais.next();
	// System.out.println("PAIS: " + oPais.getNombre());
	// marcasPorPais(oPais);
	// for(int i=0; i<10; i++) {
	// try {
	// System.out.println(oPais.getMarcasPhabilitados().get(i).getNombre() + " " +
	// oPais.getMarcasPhabilitados().get(i).getpHabilitados().size());
	// } catch (PosInvalida e) {
	// System.out.println("Exception: " + e.getMessage());
	// }
	// }
	// }
	// }

	public void reporte2() {
		MyPriotityQueue<Marca> priorityQueueMarca = new PriorityQueue<>();
		MyPriotityQueue<Reporte2> priorityQueueReporte2 = new PriorityQueue<>();

		HashTable<String, Marca> marcas = cargaDeDatos.getMarcas();

		Iterator<Marca> iteratorMarca = marcas.iterator();

		while (iteratorMarca.hasNext() == true) {
			Marca oMarca = iteratorMarca.next();
			HashTable<Pais, Reporte2> cantPais = oMarca.getCantPais();
			Iterator<Reporte2> iteratorReporte2 = cantPais.iterator();
			while (iteratorReporte2.hasNext()==true) {
				Reporte2 oReporte2 = iteratorReporte2.next();
				priorityQueueMarca.insert(oMarca,oReporte2.getCantProd());
				priorityQueueReporte2.insert(oReporte2,oReporte2.getCantProd());
			}
		}
		for (int i = 0; i < 10; i++) {
			Marca marca;
			Pais pais;
			try {
				System.out.println("Pais:  " + priorityQueueReporte2.getFirst().getPais().getNombre() + "  Marca:  "
						+ priorityQueueMarca.getFirst().getNombre() + "  " + "Cant productos: "
						+ priorityQueueReporte2.getFirst().getCantProd());
				priorityQueueMarca.dequeue();
				priorityQueueReporte2.dequeue();

			} catch (EmptyQueueException e) {

			}

		}
	}

	public void reporte4() {

		HashTable<String, Clase> clases = cargaDeDatos.getClases();

		Iterator<Clase> iteratorClase = clases.iterator();

		MyHeap<Integer, Clase> heapClase = new HeapImpl<>(clases.size(), 1);

		while (iteratorClase.hasNext() == true) {
			Clase oClase = iteratorClase.next();

			int clave = oClase.getpHabilitadosClase().size();

			heapClase.insert(clave, oClase);
		}

		for (int i = 0; i < 10; i++) {
			Clase clase;
			try {
				clase = heapClase.findAndDelete();
				System.out.println("Clase:  " + clase.getNombre() + "  " + "Pais:  " + clase.getPaisClase().getNombre()
						+ "   " + "Cant productos: " + clase.getpHabilitadosClase().size());
			} catch (HeapVacio e) {

			}

		}
	}

}
