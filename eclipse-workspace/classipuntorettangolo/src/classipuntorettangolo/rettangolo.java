package classipuntorettangolo;

public class Rettangolo {
	private int base;
	private int altezza;
	private Punto vertice;
	
	
 	public void setBase(int b) {
		base = b;
	}
	
	public void setAltezza(int h) {
		altezza = h;
	}
	
	public void setVertice(Punto v) {
		vertice = v;
	}
	
	public int getBase() {
		return  base;
	}
	
	public int getAltezza () {
		return altezza;
	}
	
	public int getVertice () {
		return vertice;
	}
} 
