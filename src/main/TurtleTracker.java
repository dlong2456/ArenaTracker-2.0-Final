package main;

import java.io.IOException;

import javax.swing.JOptionPane;

import model.ArenaTracker;
import exceptions.USB4ReadException;
import exceptions.USB4ResetException;
import exceptions.USB4SetUpException;

public class TurtleTracker implements TurtleTrackerInterface {
	// Native functions make calls to .c files using JNI -> data from USB4
	// device

	// Native files are NOT thread safe. Each instance of TurtleTracker is
	// accessing the SAME instance of the .c file, so native methods must be
	// synchronized to work properly.
	private static synchronized native int read(int trackerNum);

	private static synchronized native int reset(int trackerNum);

	private static synchronized native int setUpTracker(int trackerNum);

	private int trackerNum;
	private int demo;

	static {
	    try {
	        System.loadLibrary("TurtleTracker"); // used for tests. This library in classpath only
	    } catch (UnsatisfiedLinkError e) {
	        try {
	            NativeUtils.loadLibraryFromJar("/TurtleTracker.dll"); // during runtime. .DLL within .JAR
	        } catch (IOException e1) {
	            throw new RuntimeException(e1);
	        }
	    }
	}

	public TurtleTracker(int newTrackerNum, int isDemo) {
		demo = isDemo;
		trackerNum = newTrackerNum;
	}

	// public wrapper functions

	public int read(ArenaTracker tracker) {
		try {
			int angle = read(trackerNum);
			// error handling, see ENUM in native file
			if (angle == 400) {
				throw new USB4ReadException();
			}
			return angle;
		} catch (USB4ReadException e) {
			if (tracker.getTimer().getCalibrator().getRunning()) {
				tracker.getTimer().getCalibrator().pauseCalibration();
				JOptionPane.showMessageDialog(null,
						"Failed to read USB4 Counter. Tracker "
								+ (trackerNum + 1)
								+ " calibration has been stopped.",
						"Failed to read USB4 Counter.",
						JOptionPane.ERROR_MESSAGE);

			} else {
				tracker.abort();
				JOptionPane
						.showMessageDialog(null,
								"Failed to read USB4 Counter. Tracker "
										+ (trackerNum + 1)
										+ " trial has been aborted.",
								"Failed to read USB4 Counter.",
								JOptionPane.ERROR_MESSAGE);
			}
			return 0;
		}
	}

	public void setUpTracker(ArenaTracker tracker) {
		try {
			int result = setUpTracker(trackerNum);
			// error handling, see ENUM in native file
			if (result == 1 || result == 2 || result == 3 || result == 4
					|| result == 7 || result == 400) {
				throw new USB4SetUpException();
			}
		} catch (USB4SetUpException e) {
			demo = 1;
			JOptionPane
					.showMessageDialog(null, "Failed to set up USB4 Tracker "
							+ (trackerNum + 1) + ". Proceeding in Demo mode.",
							"Failed to set up USB4 Tracker.",
							JOptionPane.ERROR_MESSAGE);
		}
	}

	public void reset(ArenaTracker tracker) {
		try {
			int result = reset(trackerNum);
			if (result == 8) {
				throw new USB4ResetException();
			}
		} catch (USB4ResetException e) {
			tracker.getTimer().getCalibrator().pauseCalibration();
			JOptionPane.showMessageDialog(null,
					"Failed to reset USB4 Counter to 0. Tracker "
							+ (trackerNum + 1)
							+ " calibration has been stopped.",
					"Failed to reset USB4 Counter to 0.",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public boolean isDemo() {
		if (demo == 1) {
			return true;
		} else {
			return false;
		}

	}

}
