package Obligatorio;

public class Empresa {

	private String nombre;
	private String ruc;
	
	public Empresa(String nombre, String ruc) {
		this.nombre = nombre;
		this.ruc = ruc;
	}
	public String getNombre() {
		return nombre;
	}
	public String getRuc() {
		return ruc;
	}
	
	public boolean equals(Empresa e) {
		boolean equal=false;
		if(this.ruc.equals(e.getRuc())==true) {
			equal=true;
		}
		return equal;
	}
	
}
