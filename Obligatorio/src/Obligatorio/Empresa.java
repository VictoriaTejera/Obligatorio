package Obligatorio;

import uy.edu.um.prog2.adt.Lista.LinkedList;
import uy.edu.um.prog2.adt.Lista.List;

public class Empresa {

	private String nombre;
	private String ruc;
	private List<Producto> pHabilitados;

	public Empresa(String nombre, String ruc) {
		this.nombre = nombre;
		this.ruc = ruc;
		pHabilitados = new LinkedList();
	}
	
	public boolean equals(Empresa e) {
		boolean equal=false; 
		if(this.nombre.equals(e.getNombre())==true) {
			equal=true;
		}
		return equal;
	}
	
	public void addProducto(Producto nombre) {
		pHabilitados.add(nombre);
	}

	public List<Producto> getpHabilitados() {
		return pHabilitados;
	}

	public void setpHabilitados(List<Producto> pHabilitados) {
		this.pHabilitados = pHabilitados;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getNombre() {
		return nombre;
	}

	public String getRuc() {
		return ruc;
	}

}
