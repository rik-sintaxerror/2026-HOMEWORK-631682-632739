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
	
	public Punto getVertice () {
		return vertice;
	}
	
	void scala(int fattore) {
		base = base * fattore;
		altezza = altezza * fattore;
	}
	
	void scala(int fattoreBase, int fattoreAltezza) {
		base =  base * fattoreBase;
		altezza = altezza * fattoreAltezza;
	}
	
	public Rettangolo() {
		this(new Punto(0,0), 0, 0);
	}
	public Rettangolo(int base, int altezza) {
		this(new Punto(0,0), base, altezza);
	}
	public Rettangolo(Punto vertice, int base, int altezza) {
		this.vertice = vertice;
		this.base = base;
		this.altezza = altezza;
	}
} 
