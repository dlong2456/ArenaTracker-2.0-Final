package main;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import model.AModel;
import model.Model;
import view.AView;
import view.View;
import controller.AController;
import controller.Controller;
import exceptions.USB4BoardException;
import exceptions.USB4InitializeException;

public class Driver {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		// set all trackers to non-demo mode
		int[] isDemo = new int[] { 0, 0, 0, 0 };

		// initialize USB4
		USB4DeviceInterface usb4Device = new USB4Device();
		int result = 0;

		try {
			result = usb4Device.initialize();
			if (result == 5) {
				throw new USB4InitializeException();
			} else if (result == 6) {
				throw new USB4BoardException();
			}
		} catch (USB4InitializeException e) {
			for (int i = 0; i < isDemo.length; i++) {
				isDemo[i] = 1;
			}
			JOptionPane.showMessageDialog(null,
					"USB4 failed to initialize. Proceeding in Demo mode.",
					"USB4 failed to initialize.", JOptionPane.ERROR_MESSAGE);
			result = 0;
		} catch (USB4BoardException e) {
			for (int i = 0; i < isDemo.length; i++) {
				isDemo[i] = 1;
			}
			JOptionPane.showMessageDialog(null,
					"No USB4 boards found. Proceeding in Demo mode.",
					"No USB4 boards found.", JOptionPane.ERROR_MESSAGE);
			result = 0;
		}

		TurtleTrackerInterface[] turtleTrackers = new TurtleTracker[4];
		for (int i = 0; i < turtleTrackers.length; i++) {
			turtleTrackers[i] = new TurtleTracker(i, isDemo[i]);
		}

		View v = new AView(turtleTrackers);
		Model m = new AModel(turtleTrackers);
		Controller c = new AController(m, v);
		m.startCalibration();

	}
}
