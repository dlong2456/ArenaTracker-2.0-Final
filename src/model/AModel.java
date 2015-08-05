package model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import main.TurtleTrackerInterface;

public class AModel implements Model {
	private PropertyChangeSupport changes;
	private ArenaTracker[] arenaTrackers;

	public AModel(TurtleTrackerInterface[] turtles) {
		this.changes = new PropertyChangeSupport(this);
		this.arenaTrackers = new AnArenaTracker[4];
		for (int i = 0; i < arenaTrackers.length; i++) {
			arenaTrackers[i] = new AnArenaTracker("" + (i + 1), turtles[i]);
			arenaTrackers[i].addPropertyChangeListener(this);
		}
	}

	public void addPropertyChangeListener(PropertyChangeListener l) {
		changes.addPropertyChangeListener(l);
	}

	public void removePropertyChangeListener(PropertyChangeListener l) {
		changes.removePropertyChangeListener(l);
	}

	public ArenaTracker getArenaTracker1() {
		return arenaTrackers[0];
	}

	public ArenaTracker getArenaTracker2() {
		return arenaTrackers[1];
	}

	public ArenaTracker getArenaTracker3() {
		return arenaTrackers[2];
	}

	public ArenaTracker getArenaTracker4() {
		return arenaTrackers[3];
	}

	public void startCalibration() {
		for (int i = 0; i < arenaTrackers.length; i++) {
			if (!arenaTrackers[i].getTurtleTracker().isDemo()) {
				arenaTrackers[i].getTimer().startCalibration();
			}
		}
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		changes.firePropertyChange(evt);

	}

}
