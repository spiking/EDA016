import se.lth.cs.window.SimpleWindow;

import lab4.Turtle;


public class RaceTrack {
	
	private int yStart;
	private int yFinish;

	public RaceTrack(int yStart, int yFinish) {
		this.yStart = yStart;
		this.yFinish = yFinish;

	}

	public void draw(SimpleWindow w) {
		w.moveTo(80, yStart);
		w.lineTo(w.getWidth() - 80, yStart);
		w.moveTo(80, yFinish);
		w.lineTo(w.getWidth() - 80, yFinish);
	}

	public int getYStart() {
		return yStart;
	}

	public boolean finish(Turtle t) {
		return t.getY() > yFinish;
	}

}


	


