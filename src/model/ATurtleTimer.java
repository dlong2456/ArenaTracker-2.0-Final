package model;

import java.util.Timer;
import java.util.TimerTask;

public class ATurtleTimer implements TurtleTimer {
	private int light1OnTime;
	private int lengthOfTrial;
	private int sampleEvery;
	private int light1OffTime;
	private int light2OffTime;
	private int startAnalysis;
	private int endAnalysis;
	private int light2OnTime;
	private ArenaTracker model;
	private boolean paused = false;
	private boolean started = false;
	private AngleTimerTask angleTimerTask;
	private Light1TimerTask light1TimerTask;
	private Light2TimerTask light2TimerTask;
	private Calibrator calibrator;
	private Thread calibratorThread;
	private Timer timer;
	private boolean light1 = false;
	private boolean light2 = false;
	private int remaining;
	private int completed;
	private int i = 0;
	private int tempLengthOfTrial;

	public ATurtleTimer(ArenaTracker newModel) {
		model = newModel;
		if (!model.getTurtleTracker().isDemo()) {
			calibrator = new ACalibrator(model);
			calibratorThread = new Thread(calibrator);
		}
	}

	public void start() {
		if (getPaused()) {
			setPaused(false);
			model.setEditable(false);
			if (!model.getTurtleTracker().isDemo()) {
				calibrator.pauseCalibration();
			}
		} else if (!started) {
			if (!model.getTurtleTracker().isDemo()) {
				calibrator.pauseCalibration();
			}
			tempLengthOfTrial = lengthOfTrial;
			model.setEditable(false);
			started = true;
			setCompleted(0);
			setRemaining(lengthOfTrial);
			i = 0;
			timer = new Timer(true);
			// initializing tasks (not starting)
			if (light1) {
				light1TimerTask = new ALight1TimerTask(model, light1OnTime,
						light1OffTime);
			}
			if (light2) {
				light2TimerTask = new ALight2TimerTask(model, light2OnTime,
						light2OffTime);
			}
			angleTimerTask = new AnAngleTimerTask(model, startAnalysis,
					endAnalysis, sampleEvery);
			// starting timer tasks
			timer.scheduleAtFixedRate((TimerTask) angleTimerTask,
					startAnalysis * 1000, sampleEvery * 1000);
			if (light1) {
				timer.scheduleAtFixedRate((TimerTask) light1TimerTask,
						light1OnTime * 1000, 1000);
			}
			if (light2) {
				timer.scheduleAtFixedRate((TimerTask) light2TimerTask,
						light2OnTime * 1000, 1000);
			}
			timer.scheduleAtFixedRate(new TimerTask() {
				public void run() {
					if (!getPaused()) {
						model.setCompleted(i);
						model.setRemaining(tempLengthOfTrial);
						tempLengthOfTrial--;
						i++;
					}
					if (tempLengthOfTrial < 0) {
						if (light1) {
							((TimerTask) light1TimerTask).cancel();
						}
						if (light2) {
							((TimerTask) light2TimerTask).cancel();
						}
						((TimerTask) angleTimerTask).cancel();
						started = false;
						model.setEditable(true);
						timer.cancel();
						timer.purge();
					}
				}
			}, 0, 1000);
		}
	}

	public void pause() {
		if (started) {
			model.setEditable(true);
			setPaused(true);
			if (!model.getTurtleTracker().isDemo()) {
				calibrator.resumeCalibration();
				calibratorThread = new Thread(calibrator);
				calibratorThread.start();
			}
		}
	}

	public void abort() {
		if (started) {
			model.setEditable(true);
			timer.cancel();
			timer.purge();
			started = false;
			if (!model.getTurtleTracker().isDemo()) {
				calibrator.resumeCalibration();
				calibratorThread = new Thread(calibrator);
				calibratorThread.start();
			}
		}
	}

	public void setCompleted(int val) {
		completed = val;
	}

	public int getCompleted() {
		return completed;
	}

	public void setRemaining(int val) {
		remaining = val;
	}

	public int getRemaining() {
		return remaining;
	}

	public int getLight1OnTime() {
		return light1OnTime;
	}

	public void setLight1OnTime(int newLight1OnTime) {
		light1OnTime = newLight1OnTime;
	}

	public int getLengthOfTrial() {
		return lengthOfTrial;
	}

	public void setLengthOfTrial(int newLengthOfTrial) {
		lengthOfTrial = newLengthOfTrial;
	}

	public int getStartAnalysis() {
		return startAnalysis;
	}

	public void setStartAnalysis(int newStartAnalysis) {
		startAnalysis = newStartAnalysis;
	}

	public int getLight2OnTime() {
		return light2OnTime;
	}

	public void setLight2OnTime(int newLight2OnTime) {
		light2OnTime = newLight2OnTime;
	}

	public int getSampleEvery() {
		return sampleEvery;
	}

	public void setSampleEvery(int newSampleEvery) {
		sampleEvery = newSampleEvery;
	}

	public AngleTimerTask getAngleTimerTask() {
		return angleTimerTask;
	}

	public Light1TimerTask getLight1TimerTask() {
		return light1TimerTask;
	}

	public Light2TimerTask getLight2TimerTask() {
		return light2TimerTask;
	}

	public void startCalibration() {
		calibratorThread.start();
	}

	public void setAngle(int newAngle) {
		angleTimerTask.setAngle(newAngle);
	}

	public int getEndAnalysis() {
		return endAnalysis;
	}

	public void setEndAnalysis(int newEndAnalysis) {
		endAnalysis = newEndAnalysis;
	}

	public int getAngle() {
		return angleTimerTask.getAngle();
	}

	public boolean getLight1() {
		return light1;
	}

	public boolean getLight2() {
		return light2;
	}

	public void setLight1(boolean val) {
		light1 = val;
	}

	public void setLight2(boolean val) {
		light2 = val;
	}

	public int getLight1OffTime() {
		return light1OffTime;
	}

	public void setLight1OffTime(int newLight1OffTime) {
		light1OffTime = newLight1OffTime;
	}

	public int getLight2OffTime() {
		return light2OffTime;
	}

	public void setLight2OffTime(int newLight2OffTime) {
		light2OffTime = newLight2OffTime;
	}

	public boolean getPaused() {
		return paused;
	}

	public void setPaused(boolean val) {
		paused = val;
	}

	public Calibrator getCalibrator() {
		return calibrator;
	}

}
