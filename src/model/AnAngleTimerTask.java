package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

public class AnAngleTimerTask extends TimerTask implements AngleTimerTask {
	private int angle;
	private int counter;
	private File file;
	private int i = 0;
	private int[] angles;
	private int[] times;
	private ArenaTracker model;
	private int endAnalysis;
	private int sampleEvery;

	public AnAngleTimerTask(ArenaTracker newModel, int newCounter,
			int newEndAnalysis, int newSampleEvery) {
		model = newModel;
		counter = newCounter;
		endAnalysis = newEndAnalysis;
		sampleEvery = newSampleEvery;
		angles = new int[(int) Math
				.floor((endAnalysis - counter) / sampleEvery)];
		times = new int[(int) Math.floor((endAnalysis - counter) / sampleEvery)];
		file = newFile();
	}

	@Override
	public void run() {
		PrintWriter out;
		// get angle and write to file
		if (!model.getTimer().getPaused()) {
			int usbAngle;
			if (model.getTurtleTracker().isDemo()) {
				usbAngle = retrieveAngleDemo();
			} else {
				usbAngle = retrieveAngle();
			}
			times[i] = counter;
			angles[i] = usbAngle;
			try {
				out = new PrintWriter(new BufferedWriter((new FileWriter(file,
						true))));
				out.printf("%-10d %-10d%n", counter, usbAngle);
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			model.setAngle(usbAngle);
			i++;
			counter = counter + sampleEvery;
		}
		if (counter == endAnalysis) {
			model.setMeanAngle(angles);
			model.setR(angles);
			cancel();
		}
	}

	public File newFile() {
		String nameString;
		Date myDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		String myDateString = sdf.format(myDate);
		if (model.getArenaName() == null) {
			nameString = "Arena" + model.getName() + "Tracker";
		} else {
			nameString = model.getArenaName();
		}
		File file = new File(model.getPath() + "/" + nameString + "_"
				+ model.getName() + "_" + myDateString + ".txt");
		model.setLastDataRecordedToFile(file.getAbsolutePath());
		return file;
	}

	public int getAngle() {
		return angle;
	}

	public void setAngle(int newAngle) {
		angle = newAngle;
	}

	public int[] getAngles() {
		return angles;
	}

	public int[] getTimes() {
		return times;
	}

	// dummy function to mimic USB4 input
	public int retrieveAngleDemo() {
		return (int) (Math.random() * 360);
	}

	public int retrieveAngle() {
		int angle = model.getTurtleTracker().read(model);
		return angle;
	}

	public int getCounter() {
		return counter;
	}

}
