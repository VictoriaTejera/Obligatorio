package Obligatorio;

public class Reporte2 {

	private Pais pais;
	private int cantProd;
	
	
	
	public Reporte2(Pais pais) {
		super();
		this.pais = pais;
		cantProd = 0;
	}
	
	public void agregarCant() {
		cantProd++;
	}
	
	public int getCantProd() {
		return cantProd;
	}
	public void setCantProd(int cantProd) {
		this.cantProd = cantProd;
	}
	public Pais getPais() {
		return pais;
	}
	public void setPais(Pais pais) {
		this.pais = pais;
	}
	
	
	
}
