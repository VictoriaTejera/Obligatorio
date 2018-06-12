package Obligatorio;

public class PaisAux {

	private Pais pais;
	private int cantProd;
	
	
	
	public PaisAux(Pais pais) {
		super();
		this.pais = pais;
		this.cantProd = 0;
	}
	
	public void agregarCant() {
		this.cantProd++;
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
