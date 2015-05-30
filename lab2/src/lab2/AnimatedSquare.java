package lab2;

import java.util.Scanner;

import se.lth.cs.ptdc.square.Square;
import se.lth.cs.window.SimpleWindow;

public class AnimatedSquare {

	public static void main(String[] args) {
		System.out.println("Skriv förminskning och rotation: ");
		Scanner scan = new Scanner(System.in);
		int dim = scan.nextInt();
		int rot = scan.nextInt();
		scan.close();

		SimpleWindow w = new SimpleWindow(600, 600, "DrawManySquares");
		Square sq = new Square(300, 300, 300);

		while (true) {

			while (sq.getSide() > 0) {
				sq.draw(w);
				sq.setSide(sq.getSide() - dim);
				sq.rotate(rot);
				w.delay(25);
				w.clear();

			}

			while (sq.getSide() < 600) {
				sq.draw(w);
				sq.setSide(sq.getSide() + dim);
				sq.rotate(rot);
				w.delay(25);
				w.clear();

			}
		}
	}

}
