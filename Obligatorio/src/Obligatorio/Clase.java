package Obligatorio;

import uy.edu.um.prog2.adt.Hash.ElementoYaExistenteException;
import uy.edu.um.prog2.adt.Hash.HashCerrado;
import uy.edu.um.prog2.adt.Hash.HashTable;
import uy.edu.um.prog2.adt.Lista.LinkedList;
import uy.edu.um.prog2.adt.Lista.List;

public class Clase {

	private String nombre;
	private String idClase;
	private Pais paisClase;
	HashTable<Pais, PaisAux> cantPaisC;
	private List<Producto> pHabilitadosC;

	public Clase(String clase) {
		this.nombre = clase;
		this.idClase = ""; // idClase;
		cantPaisC = new HashCerrado(500, true);
		pHabilitadosC= new LinkedList();

	}

	public PaisAux buscarPaisAuxC(Pais pais) {

		PaisAux oPaisAuxC;
		if (cantPaisC.pertenece(pais)) {

			oPaisAuxC = cantPaisC.obtener(pais); 

		} else {
			oPaisAuxC = new PaisAux(pais);
			try {
				cantPaisC.insertar(pais, oPaisAuxC); 
			} catch (ElementoYaExistenteException e) {

			}
		}

		return oPaisAuxC;
	}
	
	public void addProductoC(Producto nombre) {
		pHabilitadosC.add(nombre);
	}

	public String getIdClase() {
		return idClase;
	}

	public void setIdClase(String idClase) {
		this.idClase = idClase;
	}

	public HashTable<Pais, PaisAux> getCantPaisC() {
		return cantPaisC;
	}

	public void setCantPaisC(HashTable<Pais, PaisAux> cantPaisC) {
		this.cantPaisC = cantPaisC;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
