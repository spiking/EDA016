package lab3;

import se.lth.cs.ptdc.square.*;
import se.lth.cs.window.SimpleWindow;

import java.awt.Color;
import java.awt.color.*;

public class MoveFollowingSquares {
	public static void main(String[] args) {
		
		SimpleWindow w = new SimpleWindow(600, 600, "MoveSquare");
	    w.waitForMouseClick();
		Square sq = new Square(w.getMouseX(), w.getMouseY(), 50);
		sq.draw(w);
		int oldX = w.getMouseX();
		int oldY = w.getMouseY();
		

		while (true) {
			w.waitForEvent();
			if (w.getKey() == 'r') {
				w.setLineColor(Color.red);
			} else {
				w.setLineColor(Color.black);
			}
			
			int moveX = (w.getMouseX() - oldX) / 10;
			int moveY = (w.getMouseY() - oldY) / 10;
			
			
			for (int i = 1; i <= 10; i++) {
				sq = new Square (oldX + i * moveX, oldY + i * moveY, 50);
				sq.draw(w);
			}
			oldX = w.getMouseX();
			oldY = w.getMouseY();
			

		}
	}
}
