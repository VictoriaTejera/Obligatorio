package Obligatorio;

import uy.edu.um.prog2.adt.Lista.List;

public class Pais {

	private String nombre;
	private List<Marca> marcasMasPhabilitados;
	
	public void agregarAMarcas(Marca nombre) {
		marcasMasPhabilitados.add(nombre);
		
	} 
	

	public List<Marca> getMarcasMasPhabilitados() {
		return marcasMasPhabilitados;
	}

	public void setMarcasMasPhabilitados(List<Marca> marcasMasPhabilitados) {
		this.marcasMasPhabilitados = marcasMasPhabilitados;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Pais(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
}
