package model;

import java.util.TimerTask;

public class ALight2TimerTask extends TimerTask implements Light2TimerTask {
	private int counter;
	private int light2OffTime;
	private ArenaTracker model;

	ALight2TimerTask(ArenaTracker newModel, int newCounter, int newLight2OffTime) {
		model = newModel;
		counter = newCounter;
		light2OffTime = newLight2OffTime;
	}

	@Override
	public void run() {
		if (!model.getTimer().getPaused()) {
			//Call to USB4 Device to turn on Light 2 should go here. 
			counter++;
		}
		if (counter == light2OffTime) {
			cancel();
		}
	}
}
