package Obligatorio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.InputStreamReader;
import java.io.FileInputStream;

import uy.edu.um.prog2.adt.Hash.ElementoYaExistenteException;
import uy.edu.um.prog2.adt.Hash.HashCerrado;
import uy.edu.um.prog2.adt.Hash.HashTable;
import uy.edu.um.prog2.adt.Heap.HeapImpl;
import uy.edu.um.prog2.adt.Heap.MyHeap;
import uy.edu.um.prog2.adt.Lista.LinkedList;
import uy.edu.um.prog2.adt.Lista.List;
import uy.edu.um.prog2.adt.SearchTree.BinaryTree;
import uy.edu.um.prog2.adt.SearchTree.MyBinarySearchTree;

public class CargaDeDatos {

	private HashTable<String, Producto> productos;
	private HashTable<String, Pais> paises;
	private HashTable<String, Clase> clases;
	private HashTable<String, Empresa> empresas;
	private HashTable<String, Marca> marcas;

	public CargaDeDatos() {
		productos = new HashCerrado(60000, true);
		paises = new HashCerrado(100, true);
		clases = new HashCerrado(800, true);
		empresas = new HashCerrado(1400, true);
		marcas = new HashCerrado(140000, true);

	}

	public void cargar(String archivo) throws ElementoYaExistenteException, IOException {

		long totalTime = 0;
		long startTime = System.currentTimeMillis();

		BufferedReader b = new BufferedReader(new InputStreamReader(new FileInputStream(archivo + ".csv"), "UTF-8"));

		String readLine = "";

		String[] fields;
		String nombre;
		String idProd = null;
		String rubro;
		String empresa;
		String clase;
		String idClase;
		String marca;
		String pais;
		String estado = null;
		String ruc;
		String nroHabilitacion = null;
		String clave;

		Empresa oEmpresa;
		Marca oMarca = null;
		Pais oPais;
		LinkedList<Rubro> oRubro;
		Clase oClase;
		Producto producto = null;
		b.readLine();

		while ((readLine = b.readLine()) != null) {
			readLine = readLine.substring(1, readLine.length() - 1);
			fields = readLine.split("\";\"");
			nombre = String.valueOf(fields[0]);
			idProd = String.valueOf(fields[2]);
			rubro = String.valueOf(fields[3]);
			nroHabilitacion = String.valueOf(fields[3]);
			empresa = String.valueOf(fields[5]);
			idClase = String.valueOf(fields[9]);
			clase = String.valueOf(fields[10]);
			marca = String.valueOf(fields[12]);
				if (marca.contains("  ")) {
					marca=marca.replace("  ", " ");
				}
			pais = String.valueOf(fields[13]);
			estado = String.valueOf(fields[20]);
			ruc = String.valueOf(fields[23]);

			oEmpresa = buscarEmpresa(empresa, ruc);
			oPais = buscarPais(pais);
			oMarca = buscarMarca(marca);
			oClase = buscarClase(clase);
			oRubro = (LinkedList<Rubro>) getRubro(rubro);

			clave = idProd + nroHabilitacion + nombre;
			producto = new Producto(nombre, estado, oClase, oPais, oMarca, oEmpresa, oRubro, idProd);

			productos.insertar(clave, producto);

			agregarALaLista(oEmpresa);
			agregarALaLista(oMarca);
			agregarALaLista(oPais);
			agregarALaLista(oRubro);
			agregarALaLista(oClase);

			if (estado.equals("HABILITADO")) {
				oEmpresa.addProducto(producto);
				oMarca.addProducto(producto);
				oClase.addProductoC(producto);
				oPais.addProducto(producto);
				oMarca.buscarPaisAux(oPais).agregarCant();
				oClase.buscarPaisAuxC(oPais).agregarCant();
			}
		}

		b.close();
		
		totalTime += (System.currentTimeMillis() - startTime);
		System.out.println("Tiempo del carga de datos: " + totalTime + "ms");
	}

	private Empresa buscarEmpresa(String empresa, String ruc) {
		Empresa oEmpresa;
		if (empresas.pertenece(ruc) == true) {
			oEmpresa = empresas.obtener(ruc);
		} else {
			oEmpresa = new Empresa(empresa, ruc);
		}
		return oEmpresa;
	}

	private Marca buscarMarca(String marca) {
		Marca oMarca;
		if (marcas.pertenece(marca) == true) {
			oMarca = marcas.obtener(marca);
		} else {
			oMarca = new Marca(marca);
		}
		return oMarca;
	}

	private Pais buscarPais(String pais) {
		Pais oPais;
		if (paises.pertenece(pais) == true) {
			oPais = paises.obtener(pais);
		} else {
			oPais = new Pais(pais);
		}
		return oPais;
	}

	private Clase buscarClase(String clase) {
		Clase oClase;
		if (clases.pertenece(clase) == true) {
			oClase = clases.obtener(clase);
		} else {
			oClase = new Clase(clase);
		}
		return oClase;
	}

	private void agregarALaLista(Object objeto) throws ElementoYaExistenteException {

		if (objeto instanceof Empresa) {
			String objClave = ((Empresa) objeto).getRuc();

			if (!empresas.pertenece(objClave)) {
				empresas.insertar(objClave, (Empresa) objeto);
			}
		}
		if (objeto instanceof Clase) {
			String nombreClave = ((Clase) objeto).getIdClase() + ((Clase) objeto).getNombre();
			if (clases != null) {
				if (clases.pertenece(nombreClave) == false) {
					clases.insertar(nombreClave, (Clase) objeto);
				}
			}
		}
		if (objeto instanceof Pais) {
			String nombreClave = ((Pais) objeto).getNombre();
			if (paises != null) {
				if (paises.pertenece(nombreClave) == false) {
					paises.insertar(nombreClave, (Pais) objeto);
				}
			}
		}
		if (objeto instanceof Marca) {
			String nombreClave = ((Marca) objeto).getNombre();
			if (marcas != null) {
				if (marcas.pertenece(nombreClave) == false) {
					marcas.insertar(nombreClave, (Marca) objeto);
				}
			}
		}
	}

	private List<Rubro> getRubro(String rubro) {

		List<Rubro> lista = new LinkedList<>();
		String readLine = "";
		String[] fields = readLine.split("\";\"");
		for (int i = 0; i < fields.length; i++) {
			lista.add(new Rubro(String.valueOf(fields[i])));
		}
		return (LinkedList<Rubro>) lista;
	}

	public HashTable<String, Producto> getProductos() {
		return productos;
	}

	public void setProductos(HashTable<String, Producto> productos) {
		this.productos = productos;
	}

	public HashTable<String, Pais> getPaises() {
		return paises;
	}

	public void setPaises(HashTable<String, Pais> paises) {
		this.paises = paises;
	}

	public HashTable<String, Clase> getClases() {
		return clases;
	}

	public void setClases(HashTable<String, Clase> clases) {
		this.clases = clases;
	}

	public HashTable<String, Empresa> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(HashTable<String, Empresa> empresas) {
		this.empresas = empresas;
	}

	public HashTable<String, Marca> getMarcas() {
		return marcas;
	}
}