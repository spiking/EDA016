package lab8_9;

import java.awt.Color;

import se.lth.cs.ptdc.images.ImageFilter;

/** IdentityFilter beskriver en identitetstransformation */
public class ContrastFilter extends ImageFilter {
	public ContrastFilter(String name) {
		super(name);
	}

	public Color[][] apply(Color[][] inPixels, double paramValue) {
		int height = inPixels.length;
		int width = inPixels[0].length;
		Color[][] outPixels = new Color[height][width];

		short[][] intensity = computeIntensity(inPixels);
		Color[] grayLevels = new Color[256];
		int[] histogram = new int[256];

		for (int x = 0; x < grayLevels.length; x++) {
			grayLevels[x] = new Color(x, x, x);
		}

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				int index = intensity[i][j];
				histogram[index]++;
			}
		}

		int pixels = height * width;
		double cutOff = paramValue / 100;
		int sum = 0;
		int counter = 0;

		while (sum < pixels * cutOff) {
			sum += histogram[counter];
			counter++;
		}

		int lowCut = counter; // intensitet < lowCut sätts till 0

		sum = 0;
		counter = 0;

		/* börjar från andra hållet av intensitetshistogrammet */

		while (sum < pixels * cutOff) {
			sum += histogram[255 - counter];
			counter++;
		}

		int highCut = 255 - counter; // intensitet > highCut sätts till 255

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (intensity[i][j] < lowCut) {
					intensity[i][j] = 0;
				} else if (intensity[i][j] > highCut) {
					intensity[i][j] = 255;
				} else {
					intensity[i][j] = (short) (255 * (intensity[i][j] - lowCut) / (highCut - lowCut));
				}
				outPixels[i][j] = grayLevels[intensity[i][j]];
			}
		}

		return outPixels;
	}
}
