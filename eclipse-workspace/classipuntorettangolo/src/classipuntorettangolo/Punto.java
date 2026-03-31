package classipuntorettangolo;

public class Punto {
	private int x;
	private int y; //stato
	
	public void setX(int posX) {
		x = posX;
	}
	
	public void setY(int posY) {
		y = posY;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void trasla(int dx, int dy) {
		x = x + dx;
		y = y + dy;
	}
	public Punto() {
		this.x = 0;
		this.y = 0;
	}
	public Punto(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
