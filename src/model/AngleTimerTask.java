package model;

import java.io.File;

public interface AngleTimerTask {

	public void run();

	public File newFile();

	public int getAngle();

	public void setAngle(int newAngle);

	public int[] getAngles();

	public int[] getTimes();

	public int retrieveAngleDemo();

	public int retrieveAngle();

	public int getCounter();

}
