package model;

public interface Calibrator extends Runnable {
	public void pauseCalibration();

	public void resumeCalibration();

	public void reset();
	
	public boolean getRunning();
}
