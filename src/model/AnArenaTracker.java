package model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import main.TurtleTrackerInterface;

public class AnArenaTracker implements ArenaTracker {
	private PropertyChangeSupport changes;
	private String arenaName;
	private TurtleTimer turtleTimer;
	private PostTrialAnalysis postTrialAnalysis;
	private String path;
	private String name;
	private String lastDataRecordedToFile;
	private TurtleTrackerInterface turtleTracker;
	private int angle;

	public AnArenaTracker(String string, TurtleTrackerInterface turtle) {
		turtleTracker = turtle;
		name = string;
		changes = new PropertyChangeSupport(this);
		turtleTimer = new ATurtleTimer(this);
		postTrialAnalysis = new APostTrialAnalysis();
		if (!turtleTracker.isDemo()) {
			turtleTracker.setUpTracker(this);
		}
	}

	public String getName() {
		return name;
	}

	public TurtleTrackerInterface getTurtleTracker() {
		return turtleTracker;
	}

	public boolean getPaused() {
		return turtleTimer.getPaused();
	}

	public String getArenaName() {
		return arenaName;
	}

	public void setArenaName(String newArenaName) {
		arenaName = newArenaName;
	}

	public TurtleTimer getTimer() {
		return turtleTimer;
	}

	public PostTrialAnalysis getPostTrialAnalysis() {
		return postTrialAnalysis;
	}

	public void addPropertyChangeListener(PropertyChangeListener l) {
		changes.addPropertyChangeListener(l);
	}

	public void removePropertyChangeListener(PropertyChangeListener l) {
		changes.removePropertyChangeListener(l);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		changes.firePropertyChange(evt);
	}

	public void abort() {
		turtleTimer.abort();
		changes.firePropertyChange("timerDone", false, true);
	}

	public void setMeanAngle(int[] newAngleArray) {
		double oldMeanAngle = getMeanAngle();
		postTrialAnalysis.setMeanAngle(newAngleArray);
		changes.firePropertyChange("meanAngle", oldMeanAngle, getMeanAngle());
	}

	public void setR(int[] newAngleArray) {
		postTrialAnalysis.setR(newAngleArray);
		changes.firePropertyChange("r", 1, getR());
	}

	public void setR(double meanX, double meanY) {
		double oldR = getR();
		postTrialAnalysis.setR(meanX, meanY);
		changes.firePropertyChange("r", oldR, getR());
	}

	public void setAngle(int newAngle) {
		int oldAngle = getAngle();
		turtleTimer.setAngle(newAngle);
		changes.firePropertyChange("angle", oldAngle, getAngle());
	}

	public int getEndAnalysis() {
		return turtleTimer.getEndAnalysis();
	}

	public void setEndAnalysis(int newEndAnalysis) {
		int oldEndAnalysis = getEndAnalysis();
		turtleTimer.setEndAnalysis(newEndAnalysis);
		changes.firePropertyChange("endAnalysis", oldEndAnalysis,
				getEndAnalysis());
	}

	public int getAngle() {
		return turtleTimer.getAngle();
	}

	public double getMeanAngle() {
		return postTrialAnalysis.getMeanAngle();
	}

	public double getR() {
		return postTrialAnalysis.getR();
	}

	public int getLight2OffTime() {
		return turtleTimer.getLight2OffTime();
	}

	public void setLight2OffTime(int newLight2OffTime) {
		int oldLight2OffTime = getLight2OffTime();
		turtleTimer.setLight2OffTime(newLight2OffTime);
		changes.firePropertyChange("light2OffTime", oldLight2OffTime,
				getLight2OffTime());
	}

	public int getLight1OffTime() {
		return turtleTimer.getLight1OffTime();
	}

	public void setLight1OffTime(int newLight1OffTime) {
		int oldLight1OffTime = getLight1OffTime();
		turtleTimer.setLight1OffTime(newLight1OffTime);
		changes.firePropertyChange("light1OffTime", oldLight1OffTime,
				getLight1OffTime());
	}

	public String getLastDataRecordedToFile() {
		return lastDataRecordedToFile;
	}

	public void setLastDataRecordedToFile(String newLastDataRecordedToFile) {
		String oldLastDataRecordedToFile = getLastDataRecordedToFile();
		lastDataRecordedToFile = newLastDataRecordedToFile;
		changes.firePropertyChange("lastDataRecordedToFile",
				oldLastDataRecordedToFile, getLastDataRecordedToFile());
	}

	public void setPath(String newPath) {
		path = newPath;
	}

	public String getPath() {
		return path;
	}

	public void setCompleted(int val) {
		turtleTimer.setCompleted(val);
		changes.firePropertyChange("completedDisp", 1, getCompleted());
	}

	public int getCompleted() {
		return turtleTimer.getCompleted();
	}

	public void setRemaining(int val) {
		turtleTimer.setRemaining(val);
		changes.firePropertyChange("remainingDisp", 1, getRemaining());
	}

	public int getRemaining() {
		return turtleTimer.getRemaining();
	}

	public void setStartAnalysis(int val) {
		turtleTimer.setStartAnalysis(val);
		changes.firePropertyChange("startAnalysis", 1,
				turtleTimer.getStartAnalysis());
	}

	public void setSampleEvery(int val) {
		turtleTimer.setSampleEvery(val);
		changes.firePropertyChange("sampleEvery", 1,
				turtleTimer.getSampleEvery());
	}

	public void setLight1OnTime(int val) {
		turtleTimer.setLight1OnTime(val);
		changes.firePropertyChange("light1OnTime", 1,
				turtleTimer.getLight1OnTime());
	}

	public void setLight2OnTime(int val) {
		turtleTimer.setLight2OnTime(val);
		changes.firePropertyChange("light2OnTime", 1,
				turtleTimer.getLight2OnTime());
	}

	public void setEditable(boolean val) {
		changes.firePropertyChange("started", 1, val);
	}

	public void setAngleCalibration(int newAngle) {
		int oldAngle = getAngleCalibration();
		angle = newAngle;
		changes.firePropertyChange("initialReadAngle", oldAngle,
				getAngleCalibration());
	}

	public int getAngleCalibration() {
		return angle;
	}

}
