package Mandelbrot;

import se.lth.cs.ptdc.fractal.MandelbrotGUI;

public class Mandelbrot {
	public static void main(String[] args) {
		MandelbrotGUI gui = new MandelbrotGUI();
		Generator gen = new Generator();
		boolean drawn = false; 
		/*
		 * Hanterar kommandon från användargränssnittet, alltså från
		 * MandelbrotGUI klassen
		 */
		while (true) {
			switch (gui.getCommand()) {
			case MandelbrotGUI.RENDER:
				gen.render(gui);
				drawn = true;
				break;
			case MandelbrotGUI.ZOOM:
				if (drawn)
					gen.render(gui);
				break;
			case MandelbrotGUI.RESET:
				gui.resetPlane();
				gui.clearPlane();
				drawn = false;
				break;

			case MandelbrotGUI.QUIT:
				System.exit(0);
				break;
			}
		}
	}
}
