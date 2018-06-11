package Obligatorio;

import uy.edu.um.prog2.adt.Lista.LinkedList;
import uy.edu.um.prog2.adt.Lista.List;
import uy.edu.um.prog2.adt.Lista.PosInvalida;

public class Pais {
	private List<Marca> marcasPhabilitados;
	private String nombre;
	private List<Marca> marcasPais;
	
	
	public Pais(String nombre) {
		this.nombre=nombre;
		marcasPhabilitados = new LinkedList();
		marcasPais= new LinkedList();
	} 
	
	
	public void agregarMarcaP(Marca nombre) {
		marcasPhabilitados.add(nombre);
}
	public void agregarAMarcas(Marca nombre) {
		marcasPais.add(nombre);
		
	} 
	

	public List<Marca> getmarcasPais() {
		return marcasPais;
	}

	public void setmarcasPais(List<Marca> marcasPais) {
		this.marcasPais = marcasPais;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getNombre() {
		return nombre;
	}
	public boolean equals(Pais p) {
		boolean equal=false;
		if(this.nombre.equals(p.getNombre())==true) {
			equal=true;
		}
		return equal;
	}


	public List<Marca> getMarcasPhabilitados() {
		return marcasPhabilitados;
	}


	public void setMarcasPhabilitados(List<Marca> marcasPhabilitados) {
		this.marcasPhabilitados = marcasPhabilitados;
	}
	
	/*public boolean buscarMarcaPorPais(Marca m) {
		boolean b = false;
		for (int i=0; i < marcasPais.size(); i++) {
			try {
				if (this.marcasPais.get(i).getNombre() == m.getNombre()) {
					b=true;
				}
			} catch (PosInvalida e) {
			
				e.printStackTrace();
			}
	}
		return b;
	}*/


	//public List<Marca> getMarcasPais() {
		//return marcasPais;
	//}


	//public void setMarcasPais(List<Marca> marcasPais) {
		//this.marcasPais = marcasPais;
	//}
}
