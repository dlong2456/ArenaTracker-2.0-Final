package model;

public interface TurtleTimer {

	public void start();

	public void pause();

	public void abort();

	public void setCompleted(int val);

	public int getCompleted();

	public void setRemaining(int val);

	public int getRemaining();

	public int getLight1OnTime();

	public void setLight1OnTime(int newLight1OnTime);

	public int getLengthOfTrial();

	public void setLengthOfTrial(int newLengthOfTrial);

	public int getStartAnalysis();

	public void setStartAnalysis(int newStartAnalysis);

	public int getLight2OnTime();

	public void setLight2OnTime(int newLight2OnTime);

	public int getSampleEvery();

	public void setSampleEvery(int newSampleEvery);

	public AngleTimerTask getAngleTimerTask();

	public Light1TimerTask getLight1TimerTask();

	public Light2TimerTask getLight2TimerTask();

	public void startCalibration();

	public void setAngle(int newAngle);

	public int getEndAnalysis();

	public void setEndAnalysis(int newEndAnalysis);

	public int getAngle();

	public boolean getLight1();

	public boolean getLight2();

	public void setLight1(boolean val);

	public void setLight2(boolean val);

	public int getLight1OffTime();

	public void setLight1OffTime(int newLight1OffTime);

	public int getLight2OffTime();

	public void setLight2OffTime(int newLight2OffTime);

	public boolean getPaused();

	public void setPaused(boolean val);

	public Calibrator getCalibrator();
}
