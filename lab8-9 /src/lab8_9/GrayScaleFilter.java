package lab8_9;

import java.awt.Color;
import se.lth.cs.ptdc.images.ImageFilter;

/** IdentityFilter beskriver en identitetstransformation */
public class GrayScaleFilter extends ImageFilter {
	public GrayScaleFilter(String name) {
		super(name);
	}

	public Color[][] apply(Color[][] inPixels, double paramValue) {
		int height = inPixels.length;
		int width = inPixels[0].length;
		Color[][] outPixels = new Color[height][width];

		short[][] intensity = computeIntensity(inPixels);
		Color[] grayLevels = new Color[256];
		for (int x = 0; x < grayLevels.length; x++) {
			grayLevels[x] = new Color(x, x, x);
		}

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				outPixels[i][j] = grayLevels[intensity[i][j]];
			

			}
		}
		return outPixels;

	}
}
