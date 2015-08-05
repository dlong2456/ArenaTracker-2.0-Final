package model;

import java.beans.PropertyChangeListener;

public interface Model extends PropertyChangeListener {

	public ArenaTracker getArenaTracker1();

	public ArenaTracker getArenaTracker2();

	public ArenaTracker getArenaTracker3();

	public ArenaTracker getArenaTracker4();

	public void startCalibration();

	public void addPropertyChangeListener(PropertyChangeListener l);

	public void removePropertyChangeListener(PropertyChangeListener l);
}
