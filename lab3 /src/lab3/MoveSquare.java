package lab3;

import java.awt.Color;

import se.lth.cs.ptdc.square.*;
import se.lth.cs.window.SimpleWindow;

public class MoveSquare {
	public static void main(String[] args) {
		
		SimpleWindow w = new SimpleWindow(600, 600, "MoveSquare");
		Square sq = new Square(50, 50, 50);
		sq.draw(w);
		
		int oldX = 50;
		int oldY = 50;

		while (true) {
			w.waitForMouseClick();
			if (w.getKey() == 'r') {
				w.setLineColor(Color.red);
			} else {
				w.setLineColor(Color.black);
			}
			
			int newX = w.getMouseX();
			int newY = w.getMouseY();
			w.clear();
			sq.move(newX - oldX, newY - oldY);
			sq.draw(w);
			oldX = newX;
			oldY = newY;
		}
	}
}
