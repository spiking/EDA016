package lab2;

import se.lth.cs.ptdc.square.Square;
import se.lth.cs.window.SimpleWindow;

public class DrawSquare {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600, 600, "DrawSquare");
		Square sq = new Square(200, 200, 200);
		sq.draw(w);
		

	}
}
