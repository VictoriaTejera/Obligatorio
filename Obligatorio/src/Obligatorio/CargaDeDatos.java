package Obligatorio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import uy.edu.um.prog2.adt.Hash.ElementoYaExistenteException;
import uy.edu.um.prog2.adt.Hash.HashCerrado;
import uy.edu.um.prog2.adt.Hash.HashTable;
import uy.edu.um.prog2.adt.Lista.LinkedList;
import uy.edu.um.prog2.adt.Lista.List;
import uy.edu.um.prog2.adt.SearchTree.BinaryTree;
import uy.edu.um.prog2.adt.SearchTree.MyBinarySearchTree;

public class CargaDeDatos {

	HashTable<Integer, Producto> productos;
	HashTable<String, Pais> paises;
	HashTable<String, Clase> clases;
	HashTable<String, Empresa> empresas;

	public CargaDeDatos() {
		productos = new HashCerrado(42901, true);
		paises = new HashCerrado(100, true);
		clases = new HashCerrado(100, true);
		empresas = new HashCerrado(100, true);

	}

	public void CargaDeDatos() throws ElementoYaExistenteException, IOException {
		File f = new File("tabla_datos.csv");

		BufferedReader b = new BufferedReader(new FileReader(f));

		String readLine = "";

		readLine = b.readLine();

		String[] fields;
		String nombre;
		String nombreFantasia;
		Integer idProd;
		String rubro;
		String empresa;
		String clase;
		String marca;
		String pais;
		String estado = null;
		String ruc;

		Empresa oEmpresa;
		Marca oMarca;
		Pais oPais;
		LinkedList<Rubro> oRubro;
		Clase oClase;
		Producto producto = null;

		while ((readLine = b.readLine()) != null) {
			fields = readLine.split(";");
			nombre = String.valueOf(fields[0]);
			nombreFantasia = String.valueOf(fields[1]);
			idProd = Integer.valueOf(fields[2]);
			rubro = String.valueOf(fields[3]);
			empresa = String.valueOf(fields[5]);
			clase = String.valueOf(fields[10]);
			marca = String.valueOf(fields[12]);
			pais = String.valueOf(fields[13]);
			estado = String.valueOf(fields[20]);
			ruc = String.valueOf(fields[23]);

			oEmpresa = new Empresa(empresa, ruc);
			oMarca = new Marca(marca);
			oPais = new Pais(pais);
			oRubro = (LinkedList<Rubro>) getRubro(rubro);
			oClase = new Clase(clase);
			producto = new Producto(nombre, nombreFantasia, estado, oClase, oPais, oMarca, oEmpresa, oRubro);
			productos.insertar(idProd, producto);

			agregarALaLista(oEmpresa);
			agregarALaLista(oMarca);
			agregarALaLista(oPais);
			agregarALaLista(oRubro);
			agregarALaLista(oClase);

		}

		b.close();

		if (estado == "HABILITADO") {
			Empresa.getpHabilitados().add(producto);

		}

	}

	private List<Rubro> getRubro(String rubro) {

		List<Rubro> lista = new LinkedList<>();
		String readLine = "";
		String[] fields = readLine.split("-");
		for (int i = 0; i < fields.length; i++) {
			lista.add(new Rubro(String.valueOf(fields[i])));
		}
		return (LinkedList<Rubro>) lista;
	}

	private void agregarALaLista(Object objeto) throws ElementoYaExistenteException {
		if (objeto instanceof Empresa) {
			String objClave = ((Empresa) objeto).getRuc();
			if (empresas != null) {
				if (empresas.pertenece(objClave) == false) {
					empresas.insertar(objClave, (Empresa) objeto);

				}
			}
		}
		if (objeto instanceof Clase) {
			String nombreClave= ((Clase) objeto).getNombre();
			if (clases != null) {
				if(clases.pertenece(nombreClave)==false) {
					clases.insertar(nombreClave, (Clase) objeto);
					
				}

			}
		}
		if(objeto instanceof Pais) {
			String nombreClave= ((Pais) objeto).getNombre();
			if(paises!=null) {
				if(paises.pertenece(nombreClave)==false) {
					paises.insertar(nombreClave, (Pais)objeto);
					
				}
			}
		}
	
	

	
	}

	for(int i = 0;i<=100;i++){

		}

}