package view;

import java.beans.PropertyChangeListener;

public interface View extends PropertyChangeListener {

	public void addPropertyChangeListener(PropertyChangeListener l);

	public void removePropertyChangeListener(PropertyChangeListener l);

	public ArenaTrackerPanel getArenaTrackerPanel1();

	public ArenaTrackerPanel getArenaTrackerPanel2();

	public ArenaTrackerPanel getArenaTrackerPanel3();

	public ArenaTrackerPanel getArenaTrackerPanel4();

}
