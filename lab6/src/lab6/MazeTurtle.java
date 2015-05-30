package lab6;

import se.lth.cs.ptdc.maze.*;
import se.lth.cs.window.SimpleWindow;
import lab4.Turtle;

public class MazeTurtle extends Turtle {

	public MazeTurtle(SimpleWindow w, int x, int y) {
		super(w, x, y);
	}

	public void walk(Maze maze) {
		penDown();

		while (!maze.atExit(getX(), getY())) {
			
			if (!maze.wallAtLeft(getDirection(), getX(), getY())) {
				left(90);
			} else if (maze.wallInFront(getDirection(), getX(), getY())
					&& (maze.wallAtLeft(getDirection(), getX(), getY()))) {
				left(-90);
			}

			forward(1);
			SimpleWindow.delay(10);

		}

	}

}
