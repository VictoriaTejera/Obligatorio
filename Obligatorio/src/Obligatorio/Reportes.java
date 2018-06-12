package Obligatorio;

import java.io.IOException;
import java.text.DecimalFormat;
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

	private CargaDeDatos cargaDeDatos;

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

		long totalTime = 0;
		long startTime = System.currentTimeMillis();
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
						"EMPRESA:  " + priorityQueue.getFirst().getNombre() + " - #PHABILITADOS: " + priorityQueue.getFirst().getpHabilitados().size());

				priorityQueue.dequeue();

			} catch (EmptyQueueException e) {

			}
		}
		totalTime += (System.currentTimeMillis() - startTime);
		System.out.println("Tiempo del reporte 1: " + totalTime + "ms");
	}

	public void reporte2() {
		long totalTime = 0;
		long startTime = System.currentTimeMillis();

		MyPriotityQueue<Marca> priorityQueueMarca = new PriorityQueue<>();
		MyPriotityQueue<PaisAux> priorityQueuePaisAux = new PriorityQueue<>();

		HashTable<String, Marca> marcas = cargaDeDatos.getMarcas();

		Iterator<Marca> iteratorMarca = marcas.iterator();

		while (iteratorMarca.hasNext() == true) {
			Marca oMarca = iteratorMarca.next();

			HashTable<Pais, PaisAux> cantPais = oMarca.getCantPais();
			Iterator<PaisAux> iteratorPaisAux = cantPais.iterator();
			while (iteratorPaisAux.hasNext() == true) {
				PaisAux oPaisAux = iteratorPaisAux.next();
				priorityQueueMarca.insert(oMarca, oPaisAux.getCantProd());
				priorityQueuePaisAux.insert(oPaisAux, oPaisAux.getCantProd());
			}
		}
		for (int i = 0; i < 10; i++) {
			Marca marca;
			Pais pais;
			try {
				System.out.println("PAIS:  " + priorityQueuePaisAux.getFirst().getPais().getNombre() + " - MARCA:  "
						+ priorityQueueMarca.getFirst().getNombre() + " - #PHABILITADOS: "
						+ priorityQueuePaisAux.getFirst().getCantProd());
				priorityQueueMarca.dequeue();
				priorityQueuePaisAux.dequeue();

			} catch (EmptyQueueException e) {
				System.out.println("FILA VACIA");
			}

		}
		totalTime += (System.currentTimeMillis() - startTime);
		System.out.println("Tiempo del reporte 2: " + totalTime + "ms");
	}

	public void reporte3() {

		long totalTime = 0;
		long startTime = System.currentTimeMillis();

		MyPriotityQueue<Pais> priorityQueue = new PriorityQueue<>();

		HashTable<String, Pais> paises = cargaDeDatos.getPaises();

		Iterator<Pais> iteratorPais = paises.iterator();
		int clave = 0;
		double pHabTotal = 0;
		double porcentaje = 0;

		while (iteratorPais.hasNext() == true) {

			Pais oPais = iteratorPais.next();
			clave = oPais.getProdHablitados().size();
			pHabTotal = pHabTotal + clave;
			priorityQueue.insert(oPais, clave);

		}

		for (int i = 0; i < 10; i++) {
			try {
				clave = priorityQueue.getFirst().getProdHablitados().size();

				porcentaje = ((clave * 100) / (pHabTotal));
				DecimalFormat df = new DecimalFormat("0,00%");
				String porcStr = df.format(porcentaje);
				System.out.println("PAIS:  " + priorityQueue.getFirst().getNombre() + " - #PHABILITADOS:  "
						+ priorityQueue.getFirst().getProdHablitados().size() + " - PORCENTAJE: " + porcStr + " ");

				priorityQueue.dequeue();

			} catch (EmptyQueueException e) {

			}
		}
		totalTime += (System.currentTimeMillis() - startTime);
		System.out.println("Tiempo del reporte 3: " + totalTime + "ms");

	}

	public void reporte4() {

		long totalTime = 0;
		long startTime = System.currentTimeMillis();

		MyPriotityQueue<Clase> priorityQueueClase = new PriorityQueue<>();
		MyPriotityQueue<PaisAux> priorityQueuePaisAux = new PriorityQueue<>();

		HashTable<String, Clase> clases = cargaDeDatos.getClases();

		Iterator<Clase> iteratorClase = clases.iterator();

		while (iteratorClase.hasNext() == true) {
			Clase oClase = iteratorClase.next();

			HashTable<Pais, PaisAux> cantPaisC = oClase.getCantPaisC();
			Iterator<PaisAux> iteratorPaisAux = cantPaisC.iterator();
			while (iteratorPaisAux.hasNext() == true) {
				PaisAux oPaisAux = iteratorPaisAux.next();
				priorityQueueClase.insert(oClase, oPaisAux.getCantProd());
				priorityQueuePaisAux.insert(oPaisAux, oPaisAux.getCantProd());
			}
		}
		for (int i = 0; i < 20; i++) {
			Clase clase;
			Pais pais;
			try {
				System.out.println("PAIS:  " + priorityQueuePaisAux.getFirst().getPais().getNombre() + " - CLASE:  "
						+ priorityQueueClase.getFirst().getNombre() + " - CANTIDAD: "
						+ priorityQueuePaisAux.getFirst().getCantProd());
				priorityQueueClase.dequeue();
				priorityQueuePaisAux.dequeue();

			} catch (EmptyQueueException e) {
				System.out.println("FILA VACIA");
			}

		}
		totalTime += (System.currentTimeMillis() - startTime);
		System.out.println("Tiempo del reporte 4: " + totalTime + "ms");

	}

}