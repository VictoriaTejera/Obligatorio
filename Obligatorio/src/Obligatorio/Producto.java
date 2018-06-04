package Obligatorio;

import TADs.LinkedList;

public class Producto {

	//private String nombre;
	//private String nombreFantasia;
	private String estado;
	private Clase clase;
	private Pais pais;
	private Marca marca;
	private Empresa empresa;
	//private LinkedList<Rubro> rubro;
	
	


	public Producto(//String nombre,String nombreFantasia,
			String estado, Clase clase, Pais pais, Marca marca, Empresa empresa 
			//LinkedList<Rubro> rubro
	)
			{
		super();
		//this.nombre = nombre;
		//this.nombreFantasia = nombreFantasia;
		this.estado = estado;
		this.clase = clase;
		this.pais = pais;
		this.marca = marca;
		this.empresa = empresa;
		//this.rubro = rubro;
		
		
	}
	
	//public String getNombre() {
		//return nombre;
	//}

	//public void setNombre(String nombre) {
		//this.nombre = nombre;
	//}

	//public String getNombreFantasia() {
		//return nombreFantasia;
	//}

	//public void setNombreFantasia(String nombreFantasia) {
		//this.nombreFantasia = nombreFantasia;
	//}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Clase getClase() {
		return clase;
	}

	public void setClase(Clase clase) {
		this.clase = clase;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	//public LinkedList<Rubro> getRubro() {
		//return rubro;
	//}

	//public void setRubro(LinkedList<Rubro> rubro) {
		//this.rubro = rubro;
	//}
	
	
	
	
	
}
