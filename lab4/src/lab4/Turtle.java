package lab4;

import se.lth.cs.window.SimpleWindow;

public class Turtle {
	protected SimpleWindow w; // Fönster w skapas där draw sker
	private double x; // Position x-led
	private double y; // Position y-led
	private boolean draw = false; // Draw true/false
	private double dir = Math.PI / 2; // Riktning i radianer

	/**
	 * Skapar en sköldpadda som ritar i ritfönstret w. Från början befinner sig
	 * sköldpaddan i punkten x,y med pennan lyft och huvudet pekande rakt uppåt
	 * i fönstret (i negativ y-riktning)
	 */
	public Turtle(SimpleWindow w, int x, int y) {
		this.w = w;
		this.x = x;
		this.y = y;
	}

	/** Sänker pennan */
	public void penDown() {
		draw = true;
	}

	/** Lyfter pennan */
	public void penUp() {
		draw = false;
	}

	/** Går rakt framåt n pixlar i den riktning som huvudet pekar */
	public void forward(int n) {
		w.moveTo ( (int) Math.round(x), (int) Math.round(y) );
		x = x + n * Math.cos(dir);
		y = y - n * Math.sin(dir);
		if (draw) {
			w.lineTo((int) Math.round(x), (int) Math.round(y));
		} 
		
	}

	/** Vrider beta grader åt vänster runt pennan */
	public void left(int beta) {
		dir = dir + Math.toRadians(beta);
	}

	/**
	 * Går till punkten newX,newY utan att rita. Pennans läge (sänkt eller lyft)
	 * och huvudets riktning påverkas inte
	 */
	public void jumpTo(int newX, int newY) {
		x = newX;
		y = newY;
		w.moveTo(newX, newY);
	}

	/** Återställer huvudriktningen till den ursprungliga */
	public void turnNorth() {
		dir = Math.PI / 2;
	}

	/** Tar reda på x-koordinaten för sköldpaddans aktuella position */
	public int getX() {
		return (int) x;
	}

	/** Tar reda på y-koordinaten för sköldpaddans aktuella position */
	public int getY() {
		return (int) y;
	}

	/** Tar reda på sköldpaddans riktning, i grader från positiv x-led */
	public int getDirection() {
		return ((int) Math.toDegrees(dir)) % 360;
	}
}
