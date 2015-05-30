package Mandelbrot;

import se.lth.cs.ptdc.fractal.MandelbrotGUI;
import java.awt.Color;

public class Generator {
	private final int MAX_ITER = 200;
	Color[] colorLevels;
	int colorIndex = 0;

	/*
	 * I konstruktorn skapar vi ett färgintervall som täcker antal iterationer
	 * och skapar färgobjekten(optimering)
	 */
	public Generator() {
		colorLevels = new Color[MAX_ITER];
		for (float i = 0; i < MAX_ITER; i++)
			colorLevels[(int) i] = Color.getHSBColor(i / MAX_ITER, 1f, 1f);
	}

	public void render(MandelbrotGUI gui) {
		gui.disableInput();
		int resDiff = 1;
		boolean color = false;
		/*
		 * Hanterar kommandon angående upplösning från användargränssnittet
		 */
		switch (gui.getResolution()) {
		case MandelbrotGUI.RESOLUTION_VERY_HIGH:
			resDiff = 1;
			break;
		case MandelbrotGUI.RESOLUTION_HIGH:
			resDiff = 3;
			break;
		case MandelbrotGUI.RESOLUTION_MEDIUM:
			resDiff = 5;
			break;
		case MandelbrotGUI.RESOLUTION_LOW:
			resDiff = 7;
			break;
		case MandelbrotGUI.RESOLUTION_VERY_LOW:
			resDiff = 9;
			break;
		}
		/* Hanterar kommandot som hanterar färgläget */
		switch (gui.getMode()) {
		case MandelbrotGUI.MODE_COLOR:
			color = true;
			break;
		case MandelbrotGUI.MODE_BW:
			color = false;
			break;
		}
		/* Det komplexa talsystemet i relation till rutans storlek */
		Complex[][] complex = mesh(gui.getMinimumReal(), gui.getMaximumReal(),
				gui.getMinimumImag(), gui.getMaximumImag(), gui.getWidth(),
				gui.getHeight());
		/*
		 * Förbereder rutans pixelplan för grafiken, vi delar med resDiff för
		 * att vi ej kommer att ha lika många färgobjekt för att beskriva vår
		 * yta.
		 */
		Color[][] picture = new Color[gui.getHeight() / resDiff + 1][gui
				.getWidth() / resDiff + 1];

		/*
		 * Här loopar vi igenom talplanet för att se om det komplexa talet
		 * tillhör mängden eller ej för att sedan färglägga enligt tidigare
		 * färger och användarens val
		 */
		for (int i = resDiff / 2; i < gui.getHeight(); i += resDiff) {
			for (int j = resDiff / 2; j < gui.getWidth(); j += resDiff) {
				Complex c = complex[i][j];
				Complex z = new Complex(0, 0);
				int k = 0;
				/* Mängdcheck */
				while (k < MAX_ITER && z.getAbs2() <= 4) {
					z.mul(z);
					z.add(c);
					k++;
				}

				/*
				 * Färgläggning, delar med resDiff för att inte gå out of bounds
				 */
				if (color == true) {
					picture[i / resDiff][j / resDiff] = colorLevels[k - 1];
					if (z.getAbs2() <= 4)
						picture[i / resDiff][j / resDiff] = Color.BLACK;
				} else {
					picture[i / resDiff][j / resDiff] = Color.WHITE;
					if (z.getAbs2() <= 4)
						picture[i / resDiff][j / resDiff] = Color.BLACK;
				}
			}
		}
		gui.putData(picture, resDiff, resDiff);
		gui.enableInput();

	}

	/*
	 * Här skapar vi det komplexa talsystemet i relation till rutans upplösning
	 */
	private Complex[][] mesh(double minRe, double maxRe, double minIm,
			double maxIm, int width, int height) {
		Complex[][] complex = new Complex[height][width];
		double resRe = (maxRe - minRe) / width;
		double resIm = (maxIm - minIm) / height;
		for (int i = 0; i < height; i++)
			for (int j = 0; j < width; j++)
				complex[i][j] = new Complex(minRe + j * resRe, maxIm - i
						* resIm);
		return complex;
	}
}
