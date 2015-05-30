package lab5;
import java.awt.Color;
import se.lth.cs.window.SimpleWindow;
import java.util.Random;
import lab4.Turtle;



public class RandomWalkTwoTurtles {
	public static void main(String[] args) {
		
		SimpleWindow w = new SimpleWindow(600, 600, "RandomWalkTwoTurtles");
		ColorTurtle turtle1 = new ColorTurtle (w, 250, 250, Color.BLUE);
		ColorTurtle turtle2 = new ColorTurtle (w, 350, 350, Color.RED);
		turtle1.penDown();
		turtle2.penDown();
		
		Random rand = new Random();

		while ((Math.hypot(turtle1.getX() - turtle2.getX(), turtle1.getY() - turtle2.getY())) >= 50) {
			turtle1.forward(rand.nextInt(9) + 1);
			turtle1.left(rand.nextInt(360));
			turtle2.forward(rand.nextInt(9) + 1);
			turtle2.left(rand.nextInt(360));
			w.delay(20);

		}

		System.out.println("Turtle1 och Turtle2 är mindre än 50 pixlar ifrån varandra!");

	}
}
