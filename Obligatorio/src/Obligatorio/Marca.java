package Obligatorio;

import uy.edu.um.prog2.adt.Hash.ElementoYaExistenteException;
import uy.edu.um.prog2.adt.Hash.HashCerrado;
import uy.edu.um.prog2.adt.Hash.HashTable;
import uy.edu.um.prog2.adt.Lista.LinkedList;
import uy.edu.um.prog2.adt.Lista.List;

public class Marca {

	private String nombre;
	private List<Producto> pHabilitados;
	HashTable<Pais, PaisAux> cantPais;

	public Marca(String nombre) {
		this.nombre = nombre;
		pHabilitados = new LinkedList();
		cantPais = new HashCerrado(500, true);

	}

	public void addProducto(Producto nombre) {
		pHabilitados.add(nombre);
	}

	

	public PaisAux buscarPaisAux(Pais pais) {

		PaisAux oPaisAux;
		if (cantPais.pertenece(pais) == true) {

			oPaisAux = cantPais.obtener(pais);

		} else {
			oPaisAux = new PaisAux(pais);
			try {
				cantPais.insertar(pais, oPaisAux);
			} catch (ElementoYaExistenteException e) {

			}
		}

		return oPaisAux;
	}
	
	
	public boolean equals(Marca m) {
		boolean equal=false; 
		if(this.nombre.equals(m.getNombre())==true) {
			equal=true;
		}
		return equal;
	}
	public List<Producto> getpHabilitados() {
		return pHabilitados;
	}

	public void setpHabilitados(List<Producto> pHabilitados) {
		this.pHabilitados = pHabilitados;
	}

	public HashTable<Pais, PaisAux> getCantPais() {
		return cantPais;
	}

	public void setCantPais(HashTable<Pais, PaisAux> cantPais) {
		this.cantPais = cantPais;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
