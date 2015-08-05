package model;

public interface PostTrialAnalysis {

	public double getMeanAngle();

	public void setMeanAngle(int[] newAngleArray);

	public double getR();

	public void setR(int[] newAngleArray);

	public void setR(double meanX, double meanY);

}
