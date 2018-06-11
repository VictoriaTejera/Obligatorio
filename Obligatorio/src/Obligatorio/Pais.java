package Obligatorio;

import uy.edu.um.prog2.adt.Lista.LinkedList;
import uy.edu.um.prog2.adt.Lista.List;
import uy.edu.um.prog2.adt.Lista.PosInvalida;

public class Pais {

	private String nombre;

	private List<Producto> prodHabilitados;

	public Pais(String nombre) {
		this.nombre = nombre;

		prodHabilitados = new LinkedList();

	}	
	
	public void addProducto(Producto producto) {
		prodHabilitados.add(producto);
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public boolean equals(Pais p) {
		boolean equal = false;
		if (this.nombre.equals(p.getNombre()) == true) {
			equal = true;
		}
		return equal;
	}

	

	public List<Producto> getProdHablitados() {
		return prodHabilitados;
	}

	public void setProdHablitados(List<Producto> prodHablitados) {
		this.prodHabilitados = prodHabilitados;
	}

	/*
	 * public boolean buscarMarcaPorPais(Marca m) { boolean b = false; for (int i=0;
	 * i < marcasPais.size(); i++) { try { if (this.marcasPais.get(i).getNombre() ==
	 * m.getNombre()) { b=true; } } catch (PosInvalida e) {
	 * 
	 * e.printStackTrace(); } } return b; }
	 */

	// public List<Marca> getMarcasPais() {
	// return marcasPais;
	// }

	// public void setMarcasPais(List<Marca> marcasPais) {
	// this.marcasPais = marcasPais;
	// }
}
