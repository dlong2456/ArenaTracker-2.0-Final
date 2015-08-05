package model;

import java.beans.PropertyChangeListener;

import main.TurtleTrackerInterface;

public interface ArenaTracker extends PropertyChangeListener {

	// getters

	public String getArenaName();

	public int getAngle();

	public int getAngleCalibration();

	public int getCompleted();

	public TurtleTrackerInterface getTurtleTracker();

	public int getEndAnalysis();

	public String getLastDataRecordedToFile();

	public int getLight1OffTime();

	public int getLight2OffTime();

	public double getMeanAngle();

	public String getName();

	public String getPath();

	public boolean getPaused();

	public PostTrialAnalysis getPostTrialAnalysis();

	public double getR();

	public int getRemaining();

	public TurtleTimer getTimer();

	// setters

	public void setArenaName(String newArenaName);

	public void setAngle(int newAngle);

	public void setAngleCalibration(int newAngle);

	public void setCompleted(int val);

	public void setEditable(boolean val);

	public void setEndAnalysis(int newEndAnalysis);

	public void setLastDataRecordedToFile(String newLastDataRecordedToFile);

	public void setLight1OffTime(int newLight1OffTime);

	public void setLight2OffTime(int newLight2OffTime);

	public void setLight1OnTime(int val);

	public void setLight2OnTime(int val);

	public void setMeanAngle(int[] newAngleArray);

	public void setPath(String newPath);

	public void setR(int[] newAngleArray);

	public void setR(double meanX, double meanY);

	public void setRemaining(int val);

	public void setSampleEvery(int val);

	public void setStartAnalysis(int val);

	// other

	public void abort();

	public void addPropertyChangeListener(PropertyChangeListener l);

	public void removePropertyChangeListener(PropertyChangeListener l);

}
