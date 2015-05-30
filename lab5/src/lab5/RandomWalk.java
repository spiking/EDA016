package lab5;
import se.lth.cs.window.SimpleWindow;

import java.util.Random;
import lab4.Turtle;

public class RandomWalk {
	public static void main(String[] args) {
		
		SimpleWindow w = new SimpleWindow(600, 600, "RandomWalk");
		Random rand = new Random();
		Turtle turtle = new Turtle(w, 300, 300);
		
		turtle.penDown();
		
		for(int i = 0; i < 1000; i++) {
			turtle.forward(rand.nextInt(10) + 1);
			turtle.left(rand.nextInt(360));
			w.delay(20);
		}
	}

}
