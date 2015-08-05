package main;

import model.ArenaTracker;

public interface TurtleTrackerInterface {
	public int read(ArenaTracker model);

	public void setUpTracker(ArenaTracker model);

	public void reset(ArenaTracker model);

	public boolean isDemo();

}
