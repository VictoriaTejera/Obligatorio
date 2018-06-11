package Obligatorio;

import uy.edu.um.prog2.adt.Lista.LinkedList;
import uy.edu.um.prog2.adt.Lista.List;

public class Marca {

	private String nombre;
	private List<Producto> pHabilitados;
	private Pais paisMarca;
	
	
	public void addProducto(Producto nombre) {
		pHabilitados.add(nombre);
	}
	
	public List<Producto> getpHabilitados() {
		return pHabilitados;
	}
	
	public void setpHabilitados(List<Producto> pHabilitados) {
		this.pHabilitados = pHabilitados;
	}
	
	public Marca(String nombre) {
		this.nombre = nombre;
		pHabilitados = new LinkedList();
		
	}

	public String getNombre() {
		return nombre;
	}
	
	public boolean equals(Marca e) {
		boolean equal=false;
		if(this.nombre.equals(e.getNombre())==true) {
			equal=true;
		}
		return equal;
	}

	public Pais getPaisMarca() {
		return paisMarca;
	}

	public void setPaisMarca(Pais paisMarca) {
		this.paisMarca = paisMarca;
	}

}
