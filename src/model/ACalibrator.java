package model;

public class ACalibrator implements Calibrator {

	private ArenaTracker tracker;
	private int angle;
	private boolean running = true;

	public ACalibrator(ArenaTracker newTracker) {
		tracker = newTracker;
	}

	@Override
	public void run() {
		while (running) {
			angle = tracker.getTurtleTracker().read(tracker);
			tracker.setAngleCalibration(angle);
			if (!running) {
				return;
			}
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void reset() {
		if (running) {
			tracker.getTurtleTracker().reset(tracker);
		}
	}

	public void pauseCalibration() {
		running = false;
	}

	public void resumeCalibration() {
		running = true;
	}

	public boolean getRunning() {
		return running;
	}

}
