package Obligatorio;

import uy.edu.um.prog2.adt.Lista.LinkedList;
import uy.edu.um.prog2.adt.Lista.List;

public class Clase {

	private String nombre;
	private String idClase;
	private Pais paisClase;
	List<Producto> pHabilitadosClase;

	public List<Producto> getpHabilitadosClase() {
		return pHabilitadosClase;
	}

	public void setpHabilitadosClase(List<Producto> pHabilitadosClase) {
		this.pHabilitadosClase = pHabilitadosClase;
	}

	public void addProducto(Producto nombre) {
		pHabilitadosClase.add(nombre);
	}
	
	public Clase(String idClase, String clase) {
		this.nombre = clase;
		this.idClase = idClase;
		pHabilitadosClase = new LinkedList();
	}

	public String getNombre() {
		return nombre;
	}

	public Pais getPaisClase() {
		return paisClase;
	}

	public void setPaisClase(Pais paisClase) {
		this.paisClase = paisClase;
	}
}
