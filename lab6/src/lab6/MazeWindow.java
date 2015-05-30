package lab6;
import java.util.Scanner;

import se.lth.cs.ptdc.maze.Maze;
import se.lth.cs.window.SimpleWindow;

public class MazeWindow {

	public static void main(String[] args) {
		
		Scanner scan  = new Scanner(System.in);
		Maze maze = new Maze(scan.nextInt());
		SimpleWindow w = new SimpleWindow(600, 600, "Maze");
		MazeTurtle turtle = new MazeTurtle(w, maze.getXEntry(), maze.getYEntry());
		
		maze.draw(w);
		turtle.walk(maze);
		scan.close();
	}

}
