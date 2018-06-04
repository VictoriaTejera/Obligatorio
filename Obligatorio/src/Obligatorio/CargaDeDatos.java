package Obligatorio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import uy.edu.um.prog2.adt.Hash.HashCerrado;
import uy.edu.um.prog2.adt.Hash.HashTable;
import uy.edu.um.prog2.adt.Lista.LinkedList;




//Agregar atributo idProd a producto

/*public class CargaDeDatos {
	
	HashTable <Integer,Producto> productos;
	HashTable<String,Pais> paises;
	HashTable<String,Clase> clases ;
	HashTable<String,Empresa> empresas;
	
	public CargaDeDatos() {
		productos= new HashCerrado(42901, true); 
		paises= new HashCerrado(100, true);
		clases= new HashCerrado(100, true);
		empresas= new HashCerrado(100,true);
		
		
	}
	
	public void CargaDeDatos() {
		File f = new File("tabla_datos.csv");

		BufferedReader b;
		try {
			b = new BufferedReader(new FileReader(f));
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		String readLine = "";

		try {
			readLine = b.readLine();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			while ((readLine = b.readLine()) != null) {
				String[] fields = readLine.split(";");
				String nombre = String.valueOf(fields[0]);
				String nombreFantasia = String.valueOf(fields[1]);
				Integer idProd = Integer.valueOf(fields[2]);
				String rubro = String.valueOf(fields[3]);
				String empresa = String.valueOf(fields[5]);
				String clase = String.valueOf(fields[10]);
				String marca = String.valueOf(fields[12]);
				String pais = String.valueOf(fields[13]);
				String estado = String.valueOf(fields[20]);
				String ruc = String.valueOf(fields[23]);

				Empresa oEmpresa = new Empresa(empresa, ruc);
				Marca oMarca = new Marca(marca);
				Pais oPais = new Pais(pais);
			//	LinkedList<Rubro> oRubro = getRubro(rubro);
				Clase oClase = new Clase(clase);
			//	Producto producto = new Producto(nombre, nombreFantasia, estado, oClase, oPais, oMarca, oEmpresa, oRubro);
//		productos.insertar(idProd, producto);
				
			}
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//b.close();
	}
	
	
	*/


