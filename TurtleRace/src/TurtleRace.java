import se.lth.cs.window.SimpleWindow;

import lab4.Turtle;

public class TurtleRace {
	public static void main(String[] args) {

		SimpleWindow w = new SimpleWindow(600, 600, "Turtle Race");
		RaceTrack track = new RaceTrack(w.getHeight() - 100,
				w.getHeight() - 500);
		track.draw(w);
		Turtle t1 = new Turtle(w, w.getWidth() / 3, track.getYStart());
		Turtle t2 = new Turtle(w, w.getWidth() / 3 * 2, track.getYStart());
		RacingEvent event = new RacingEvent(track, t1, t2);
		w.waitForMouseClick();
		event.start();

	}
}
