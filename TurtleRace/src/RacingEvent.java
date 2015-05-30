import java.util.Random;

import lab4.Turtle;


import se.lth.cs.window.SimpleWindow;

public class RacingEvent {
	private RaceTrack track;
	private Turtle t1;
	private Turtle t2;

	public RacingEvent(RaceTrack track, Turtle t1, Turtle t2) {
		this.track = track;
		this.t1 = t1;
		this.t2 = t2;
	}

	public void start() {
		Random rand = new Random();
		t1.penDown();
		t2.penDown();

		while (track.finish(t1) && track.finish(t2)) {
			t1.forward(rand.nextInt(3));
			t2.forward(rand.nextInt(3));
			SimpleWindow.delay(10);

		}
	
	}

}
