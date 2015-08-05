package model;

import java.util.TimerTask;

public class ALight1TimerTask extends TimerTask implements Light1TimerTask {
	private int light1OffTime;
	private int counter;
	private ArenaTracker model;

	ALight1TimerTask(ArenaTracker newModel, int newCounter, int newLight1OffTime) {
		model = newModel;
		counter = newCounter;
		light1OffTime = newLight1OffTime;
	}

	@Override
	public void run() {
		if (!model.getTimer().getPaused()) {
			// Call to USB4 Device to turn on light 1 should go here.
			counter = counter + 1;
		}
		if (counter == light1OffTime) {
			cancel();
		}
	}

}
