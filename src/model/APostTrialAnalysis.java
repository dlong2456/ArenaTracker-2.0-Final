package model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class APostTrialAnalysis implements PostTrialAnalysis {
	private double meanAngle;
	private double r;

	public double getR() {
		BigDecimal bd = new BigDecimal(r);
		bd = bd.setScale(3, RoundingMode.HALF_UP);
		r = bd.doubleValue();
		return r;
	}

	public double getMeanAngle() {
		BigDecimal bd = new BigDecimal(meanAngle);
		bd = bd.setScale(1, RoundingMode.HALF_UP);
		meanAngle = bd.doubleValue();
		return meanAngle;
	}

	public void setMeanAngle(int[] newAngleArray) {
		double sumX = 0;
		double sumY = 0;
		double meanVectorX;
		double meanVectorY;
		double localR;
		for (int i = 0; i < newAngleArray.length; i++) {
			int currEl = newAngleArray[i];
			sumX = sumX + Math.cos(Math.toRadians(currEl));
			sumY = sumY + Math.sin(Math.toRadians(currEl));
		}
		meanVectorX = sumX / newAngleArray.length;
		meanVectorY = sumY / newAngleArray.length;
		localR = findR(meanVectorX, meanVectorY);
		// Quadrant I
		if ((meanVectorX / localR) > 0 && (meanVectorY / localR) >= 0) {
			meanAngle = Math.toDegrees(Math.acos(meanVectorX / localR));
			// Quadrant II
		} else if ((meanVectorX / localR) <= 0 && (meanVectorY / localR) > 0) {
			meanAngle = Math.toDegrees(Math.acos(meanVectorX / localR));
			// Quadrant III
		} else if ((meanVectorX / localR) < 0 && (meanVectorY / localR) <= 0) {
			meanAngle = 360 - Math.toDegrees(Math.acos(meanVectorX / localR));
			// Quadrant IV
		} else if ((meanVectorX / localR) >= 0 && (meanVectorY / localR) < 0) {
			meanAngle = 360 - Math.toDegrees(Math.acos(meanVectorX / localR));
		}
	}

	private double findR(double meanX, double meanY) {
		r = Math.sqrt(Math.pow(meanX, 2) + Math.pow(meanY, 2));
		return r;
	}

	public void setR(double meanX, double meanY) {
		r = findR(meanX, meanY);
	}

	public void setR(int[] newAngleArray) {
		double sumX = 0;
		double sumY = 0;
		double meanVectorX;
		double meanVectorY;
		for (int i = 0; i < newAngleArray.length; i++) {
			int currEl = newAngleArray[i];
			sumX = sumX + Math.cos(Math.toRadians(currEl));
			sumY = sumY + Math.sin(Math.toRadians(currEl));
		}
		meanVectorX = sumX / newAngleArray.length;
		meanVectorY = sumY / newAngleArray.length;
		r = findR(meanVectorX, meanVectorY);
	}

}
