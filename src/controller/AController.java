package controller;

import java.beans.PropertyChangeEvent;

import model.Model;
import view.View;

public class AController implements Controller {
	Model model;
	View view;

	public AController(Model m, View v) {
		model = m;
		view = v;
		model.addPropertyChangeListener(this);
		view.addPropertyChangeListener(this);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		String propertyName = evt.getPropertyName();
		String newValue = evt.getNewValue().toString();
		// TRACKER 1
		if (evt.getSource() == view.getArenaTrackerPanel1()) {
			if (propertyName.equalsIgnoreCase("light1OnTimeDisp")) {
				model.getArenaTracker1().getTimer()
						.setLight1OnTime(Integer.valueOf(newValue));
			} else if (propertyName.equalsIgnoreCase("light1OffTimeDisp")) {
				model.getArenaTracker1().getTimer()
						.setLight1OffTime(Integer.valueOf(newValue) * 60);
			} else if (propertyName.equalsIgnoreCase("arenaName")) {
				model.getArenaTracker1().setArenaName(newValue);
			} else if (propertyName.equalsIgnoreCase("lengthOfTrialDisp")) {
				model.getArenaTracker1().getTimer()
						.setLengthOfTrial(Integer.valueOf(newValue) * 60);
			} else if (propertyName.equalsIgnoreCase("sampleEveryDisp")) {
				model.getArenaTracker1().getTimer()
						.setSampleEvery(Integer.valueOf(newValue));
			} else if (propertyName.equalsIgnoreCase("startAnalysisDisp")) {
				model.getArenaTracker1().getTimer()
						.setStartAnalysis(Integer.valueOf(newValue) * 60);
			} else if (propertyName.equalsIgnoreCase("endAnalysisDisp")) {
				model.getArenaTracker1().getTimer()
						.setEndAnalysis(Integer.valueOf(newValue) * 60);
			} else if (propertyName.equalsIgnoreCase("light2OnTimeDisp")) {
				model.getArenaTracker1().getTimer()
						.setLight2OnTime(Integer.valueOf(newValue) * 60);
			} else if (propertyName.equalsIgnoreCase("light2OffTimeDisp")) {
				model.getArenaTracker1().getTimer()
						.setLight2OffTime(Integer.valueOf(newValue) * 60);
			} else if (propertyName.equalsIgnoreCase("reset")) {
				if (!model.getArenaTracker1().getTurtleTracker().isDemo()) {
					model.getArenaTracker1().getTimer().getCalibrator().reset();
				}
			} else if (propertyName.equalsIgnoreCase("start")) {
				model.getArenaTracker1().getTimer().start();
			} else if (propertyName.equalsIgnoreCase("abort")) {
				model.getArenaTracker1().getTimer().abort();
			} else if (propertyName.equalsIgnoreCase("pause")) {
				model.getArenaTracker1().getTimer().pause();
			} else if (propertyName.equalsIgnoreCase("light1")) {
				evt.getNewValue();
				model.getArenaTracker1().getTimer()
						.setLight1((boolean) evt.getNewValue());
			} else if (propertyName.equalsIgnoreCase("light2")) {
				evt.getNewValue();
				model.getArenaTracker1().getTimer()
						.setLight2((boolean) evt.getNewValue());
			} else if (propertyName.equalsIgnoreCase("directory")) {
				model.getArenaTracker1().setPath(evt.getNewValue().toString());
			}

		} else if (evt.getSource() == model.getArenaTracker1()) {
			if (propertyName.equalsIgnoreCase("angle")) {
				int newAngle = model.getArenaTracker1().getAngle();
				view.getArenaTrackerPanel1().setAngleDisp(
						Integer.toString(newAngle));
				view.getArenaTrackerPanel1().getLine().setAngle(newAngle);
			} else if (propertyName.equalsIgnoreCase("initialReadAngle")) {
				int newAngle = model.getArenaTracker1().getAngleCalibration();
				view.getArenaTrackerPanel1().setAngleDisp(
						Integer.toString(newAngle));
				view.getArenaTrackerPanel1().getLine().setAngle(newAngle);
			} else if (propertyName.equalsIgnoreCase("completedDisp")) {
				view.getArenaTrackerPanel1().setCompletedDisp(
						Integer.toString(model.getArenaTracker1().getTimer()
								.getCompleted()));
			} else if (propertyName.equalsIgnoreCase("remainingDisp")) {
				view.getArenaTrackerPanel1().setRemainingDisp(
						Integer.toString(model.getArenaTracker1().getTimer()
								.getRemaining()));
			} else if (propertyName.equalsIgnoreCase("meanAngle")) {
				view.getArenaTrackerPanel1().setMeanAngleDisp(
						Double.toString(model.getArenaTracker1()
								.getPostTrialAnalysis().getMeanAngle()));
			} else if (propertyName.equalsIgnoreCase("r")) {
				view.getArenaTrackerPanel1().setRDisp(
						Double.toString(model.getArenaTracker1()
								.getPostTrialAnalysis().getR()));
			} else if (propertyName.equalsIgnoreCase("lastDataRecordedToFile")) {
				view.getArenaTrackerPanel1().setLastDataRecordedToFileDisp(
						model.getArenaTracker1().getLastDataRecordedToFile());
			} else if (propertyName.equalsIgnoreCase("startAnalysis")) {
				view.getArenaTrackerPanel1().setStartAnalysisDisp(
						Integer.toString(model.getArenaTracker1().getTimer()
								.getStartAnalysis() / 60));
				;
			} else if (propertyName.equalsIgnoreCase("light2OnTime")) {
				view.getArenaTrackerPanel1().setLight2OnTimeDisp(
						Integer.toString(model.getArenaTracker1().getTimer()
								.getLight2OnTime() / 60));
			} else if (propertyName.equalsIgnoreCase("light1OnTime")) {
				view.getArenaTrackerPanel1().setLight1OnTimeDisp(
						Integer.toString(model.getArenaTracker1().getTimer()
								.getLight1OnTime() / 60));
			} else if (propertyName.equalsIgnoreCase("sampleEvery")) {
				view.getArenaTrackerPanel1().setSampleEveryDisp(
						Integer.toString(model.getArenaTracker1().getTimer()
								.getSampleEvery()));
			} else if (propertyName.equalsIgnoreCase("started")) {
				view.getArenaTrackerPanel1().resetEnabled(
						(boolean) evt.getNewValue());
				view.getArenaTrackerPanel1().disableTextFields(
						(boolean) evt.getNewValue());
			}
		}

		// TRACKER 2
		if (evt.getSource() == view.getArenaTrackerPanel2()) {
			if (propertyName.equalsIgnoreCase("light1OnTimeDisp")) {
				model.getArenaTracker2().getTimer()
						.setLight1OnTime(Integer.valueOf(newValue));
			} else if (propertyName.equalsIgnoreCase("light1OffTimeDisp")) {
				model.getArenaTracker2().getTimer()
						.setLight1OffTime(Integer.valueOf(newValue) * 60);
			} else if (propertyName.equalsIgnoreCase("arenaName")) {
				model.getArenaTracker2().setArenaName(newValue);
			} else if (propertyName.equalsIgnoreCase("lengthOfTrialDisp")) {
				model.getArenaTracker2().getTimer()
						.setLengthOfTrial(Integer.valueOf(newValue) * 60);
			} else if (propertyName.equalsIgnoreCase("sampleEveryDisp")) {
				model.getArenaTracker2().getTimer()
						.setSampleEvery(Integer.valueOf(newValue));
			} else if (propertyName.equalsIgnoreCase("startAnalysisDisp")) {
				model.getArenaTracker2().getTimer()
						.setStartAnalysis(Integer.valueOf(newValue) * 60);
			} else if (propertyName.equalsIgnoreCase("endAnalysisDisp")) {
				model.getArenaTracker2().getTimer()
						.setEndAnalysis(Integer.valueOf(newValue) * 60);
			} else if (propertyName.equalsIgnoreCase("light2OnTimeDisp")) {
				model.getArenaTracker2().getTimer()
						.setLight2OnTime(Integer.valueOf(newValue) * 60);
			} else if (propertyName.equalsIgnoreCase("light2OffTimeDisp")) {
				model.getArenaTracker2().getTimer()
						.setLight2OffTime(Integer.valueOf(newValue) * 60);
			} else if (propertyName.equalsIgnoreCase("reset")) {
				if (!model.getArenaTracker2().getTurtleTracker().isDemo()) {
					model.getArenaTracker2().getTimer().getCalibrator().reset();
				}
			} else if (propertyName.equalsIgnoreCase("start")) {
				model.getArenaTracker2().getTimer().start();
			} else if (propertyName.equalsIgnoreCase("abort")) {
				model.getArenaTracker2().getTimer().abort();
			} else if (propertyName.equalsIgnoreCase("pause")) {
				model.getArenaTracker2().getTimer().pause();
			} else if (propertyName.equalsIgnoreCase("light1")) {
				evt.getNewValue();
				model.getArenaTracker2().getTimer()
						.setLight1((boolean) evt.getNewValue());
			} else if (propertyName.equalsIgnoreCase("light2")) {
				evt.getNewValue();
				model.getArenaTracker2().getTimer()
						.setLight2((boolean) evt.getNewValue());
			} else if (propertyName.equalsIgnoreCase("directory")) {
				model.getArenaTracker2().setPath(evt.getNewValue().toString());
			}

		} else if (evt.getSource() == model.getArenaTracker2()) {
			if (propertyName.equalsIgnoreCase("angle")) {
				int newAngle = model.getArenaTracker2().getAngle();
				view.getArenaTrackerPanel2().setAngleDisp(
						Integer.toString(newAngle));
				view.getArenaTrackerPanel2().getLine().setAngle(newAngle);
			} else if (propertyName.equalsIgnoreCase("completedDisp")) {
				view.getArenaTrackerPanel2().setCompletedDisp(
						Integer.toString(model.getArenaTracker2().getTimer()
								.getCompleted()));
			} else if (propertyName.equalsIgnoreCase("remainingDisp")) {
				view.getArenaTrackerPanel2().setRemainingDisp(
						Integer.toString(model.getArenaTracker2().getTimer()
								.getRemaining()));
			} else if (propertyName.equalsIgnoreCase("meanAngle")) {
				view.getArenaTrackerPanel2().setMeanAngleDisp(
						Double.toString(model.getArenaTracker2()
								.getPostTrialAnalysis().getMeanAngle()));
			} else if (propertyName.equalsIgnoreCase("r")) {
				view.getArenaTrackerPanel2().setRDisp(
						Double.toString(model.getArenaTracker2()
								.getPostTrialAnalysis().getR()));
			} else if (propertyName.equalsIgnoreCase("lastDataRecordedToFile")) {
				view.getArenaTrackerPanel2().setLastDataRecordedToFileDisp(
						model.getArenaTracker2().getLastDataRecordedToFile());
			} else if (propertyName.equalsIgnoreCase("startAnalysis")) {
				view.getArenaTrackerPanel2().setStartAnalysisDisp(
						Integer.toString(model.getArenaTracker2().getTimer()
								.getStartAnalysis() / 60));
				;
			} else if (propertyName.equalsIgnoreCase("light2OnTime")) {
				view.getArenaTrackerPanel2().setLight2OnTimeDisp(
						Integer.toString(model.getArenaTracker2().getTimer()
								.getLight2OnTime() / 60));
			} else if (propertyName.equalsIgnoreCase("light1OnTime")) {
				view.getArenaTrackerPanel2().setLight1OnTimeDisp(
						Integer.toString(model.getArenaTracker2().getTimer()
								.getLight1OnTime() / 60));
			} else if (propertyName.equalsIgnoreCase("sampleEvery")) {
				view.getArenaTrackerPanel2().setSampleEveryDisp(
						Integer.toString(model.getArenaTracker2().getTimer()
								.getSampleEvery()));
			} else if (propertyName.equalsIgnoreCase("started")) {
				view.getArenaTrackerPanel2().resetEnabled(
						(boolean) evt.getNewValue());
				view.getArenaTrackerPanel2().disableTextFields(
						(boolean) evt.getNewValue());
			}
		}

		// TRACKER 3
		if (evt.getSource() == view.getArenaTrackerPanel3()) {
			if (propertyName.equalsIgnoreCase("light1OnTimeDisp")) {
				model.getArenaTracker3().getTimer()
						.setLight1OnTime(Integer.valueOf(newValue));
			} else if (propertyName.equalsIgnoreCase("light1OffTimeDisp")) {
				model.getArenaTracker3().getTimer()
						.setLight1OffTime(Integer.valueOf(newValue) * 60);
			} else if (propertyName.equalsIgnoreCase("arenaName")) {
				model.getArenaTracker3().setArenaName(newValue);
			} else if (propertyName.equalsIgnoreCase("lengthOfTrialDisp")) {
				model.getArenaTracker3().getTimer()
						.setLengthOfTrial(Integer.valueOf(newValue) * 60);
			} else if (propertyName.equalsIgnoreCase("sampleEveryDisp")) {
				model.getArenaTracker3().getTimer()
						.setSampleEvery(Integer.valueOf(newValue));
			} else if (propertyName.equalsIgnoreCase("startAnalysisDisp")) {
				model.getArenaTracker3().getTimer()
						.setStartAnalysis(Integer.valueOf(newValue) * 60);
			} else if (propertyName.equalsIgnoreCase("endAnalysisDisp")) {
				model.getArenaTracker3().getTimer()
						.setEndAnalysis(Integer.valueOf(newValue) * 60);
			} else if (propertyName.equalsIgnoreCase("light2OnTimeDisp")) {
				model.getArenaTracker3().getTimer()
						.setLight2OnTime(Integer.valueOf(newValue) * 60);
			} else if (propertyName.equalsIgnoreCase("light2OffTimeDisp")) {
				model.getArenaTracker3().getTimer()
						.setLight2OffTime(Integer.valueOf(newValue) * 60);
			} else if (propertyName.equalsIgnoreCase("reset")) {
				if (!model.getArenaTracker3().getTurtleTracker().isDemo()) {
					model.getArenaTracker3().getTimer().getCalibrator().reset();
				}
			} else if (propertyName.equalsIgnoreCase("start")) {
				model.getArenaTracker3().getTimer().start();
			} else if (propertyName.equalsIgnoreCase("abort")) {
				model.getArenaTracker3().getTimer().abort();
			} else if (propertyName.equalsIgnoreCase("pause")) {
				model.getArenaTracker3().getTimer().pause();
			} else if (propertyName.equalsIgnoreCase("light1")) {
				evt.getNewValue();
				model.getArenaTracker3().getTimer()
						.setLight1((boolean) evt.getNewValue());
			} else if (propertyName.equalsIgnoreCase("light2")) {
				evt.getNewValue();
				model.getArenaTracker3().getTimer()
						.setLight2((boolean) evt.getNewValue());
			} else if (propertyName.equalsIgnoreCase("directory")) {
				model.getArenaTracker3().setPath(evt.getNewValue().toString());
			}

		} else if (evt.getSource() == model.getArenaTracker3()) {
			if (propertyName.equalsIgnoreCase("angle")) {
				int newAngle = model.getArenaTracker3().getAngle();
				view.getArenaTrackerPanel3().setAngleDisp(
						Integer.toString(newAngle));
				view.getArenaTrackerPanel3().getLine().setAngle(newAngle);
			} else if (propertyName.equalsIgnoreCase("completedDisp")) {
				view.getArenaTrackerPanel3().setCompletedDisp(
						Integer.toString(model.getArenaTracker3().getTimer()
								.getCompleted()));
			} else if (propertyName.equalsIgnoreCase("remainingDisp")) {
				view.getArenaTrackerPanel3().setRemainingDisp(
						Integer.toString(model.getArenaTracker3().getTimer()
								.getRemaining()));
			} else if (propertyName.equalsIgnoreCase("meanAngle")) {
				view.getArenaTrackerPanel3().setMeanAngleDisp(
						Double.toString(model.getArenaTracker3()
								.getPostTrialAnalysis().getMeanAngle()));
			} else if (propertyName.equalsIgnoreCase("r")) {
				view.getArenaTrackerPanel3().setRDisp(
						Double.toString(model.getArenaTracker3()
								.getPostTrialAnalysis().getR()));
			} else if (propertyName.equalsIgnoreCase("lastDataRecordedToFile")) {
				view.getArenaTrackerPanel3().setLastDataRecordedToFileDisp(
						model.getArenaTracker3().getLastDataRecordedToFile());
			} else if (propertyName.equalsIgnoreCase("startAnalysis")) {
				view.getArenaTrackerPanel3().setStartAnalysisDisp(
						Integer.toString(model.getArenaTracker3().getTimer()
								.getStartAnalysis() / 60));
				;
			} else if (propertyName.equalsIgnoreCase("light2OnTime")) {
				view.getArenaTrackerPanel3().setLight2OnTimeDisp(
						Integer.toString(model.getArenaTracker3().getTimer()
								.getLight2OnTime() / 60));
			} else if (propertyName.equalsIgnoreCase("light1OnTime")) {
				view.getArenaTrackerPanel3().setLight1OnTimeDisp(
						Integer.toString(model.getArenaTracker3().getTimer()
								.getLight1OnTime() / 60));
			} else if (propertyName.equalsIgnoreCase("sampleEvery")) {
				view.getArenaTrackerPanel3().setSampleEveryDisp(
						Integer.toString(model.getArenaTracker3().getTimer()
								.getSampleEvery()));
			} else if (propertyName.equalsIgnoreCase("started")) {
				view.getArenaTrackerPanel3().resetEnabled(
						(boolean) evt.getNewValue());
				view.getArenaTrackerPanel3().disableTextFields(
						(boolean) evt.getNewValue());
			}
		}

		// TRACKER 4
		if (evt.getSource() == view.getArenaTrackerPanel4()) {
			if (propertyName.equalsIgnoreCase("light1OnTimeDisp")) {
				model.getArenaTracker4().getTimer()
						.setLight1OnTime(Integer.valueOf(newValue));
			} else if (propertyName.equalsIgnoreCase("light1OffTimeDisp")) {
				model.getArenaTracker4().getTimer()
						.setLight1OffTime(Integer.valueOf(newValue) * 60);
			} else if (propertyName.equalsIgnoreCase("arenaName")) {
				model.getArenaTracker4().setArenaName(newValue);
			} else if (propertyName.equalsIgnoreCase("lengthOfTrialDisp")) {
				model.getArenaTracker4().getTimer()
						.setLengthOfTrial(Integer.valueOf(newValue) * 60);
			} else if (propertyName.equalsIgnoreCase("sampleEveryDisp")) {
				model.getArenaTracker4().getTimer()
						.setSampleEvery(Integer.valueOf(newValue));
			} else if (propertyName.equalsIgnoreCase("startAnalysisDisp")) {
				model.getArenaTracker4().getTimer()
						.setStartAnalysis(Integer.valueOf(newValue) * 60);
			} else if (propertyName.equalsIgnoreCase("endAnalysisDisp")) {
				model.getArenaTracker4().getTimer()
						.setEndAnalysis(Integer.valueOf(newValue) * 60);
			} else if (propertyName.equalsIgnoreCase("light2OnTimeDisp")) {
				model.getArenaTracker4().getTimer()
						.setLight2OnTime(Integer.valueOf(newValue) * 60);
			} else if (propertyName.equalsIgnoreCase("light2OffTimeDisp")) {
				model.getArenaTracker4().getTimer()
						.setLight2OffTime(Integer.valueOf(newValue) * 60);
			} else if (propertyName.equalsIgnoreCase("reset")) {
				if (!model.getArenaTracker4().getTurtleTracker().isDemo()) {
					model.getArenaTracker4().getTimer().getCalibrator().reset();
				}
			} else if (propertyName.equalsIgnoreCase("start")) {
				model.getArenaTracker4().getTimer().start();
			} else if (propertyName.equalsIgnoreCase("abort")) {
				model.getArenaTracker4().getTimer().abort();
			} else if (propertyName.equalsIgnoreCase("pause")) {
				model.getArenaTracker4().getTimer().pause();
			} else if (propertyName.equalsIgnoreCase("light1")) {
				evt.getNewValue();
				model.getArenaTracker4().getTimer()
						.setLight1((boolean) evt.getNewValue());
			} else if (propertyName.equalsIgnoreCase("light2")) {
				evt.getNewValue();
				model.getArenaTracker4().getTimer()
						.setLight2((boolean) evt.getNewValue());
			} else if (propertyName.equalsIgnoreCase("directory")) {
				model.getArenaTracker4().setPath(evt.getNewValue().toString());
			}

		} else if (evt.getSource() == model.getArenaTracker4()) {
			if (propertyName.equalsIgnoreCase("angle")) {
				int newAngle = model.getArenaTracker4().getAngle();
				view.getArenaTrackerPanel4().setAngleDisp(
						Integer.toString(newAngle));
				view.getArenaTrackerPanel4().getLine().setAngle(newAngle);
			} else if (propertyName.equalsIgnoreCase("completedDisp")) {
				view.getArenaTrackerPanel4().setCompletedDisp(
						Integer.toString(model.getArenaTracker4().getTimer()
								.getCompleted()));
			} else if (propertyName.equalsIgnoreCase("remainingDisp")) {
				view.getArenaTrackerPanel4().setRemainingDisp(
						Integer.toString(model.getArenaTracker4().getTimer()
								.getRemaining()));
			} else if (propertyName.equalsIgnoreCase("meanAngle")) {
				view.getArenaTrackerPanel4().setMeanAngleDisp(
						Double.toString(model.getArenaTracker4()
								.getPostTrialAnalysis().getMeanAngle()));
			} else if (propertyName.equalsIgnoreCase("r")) {
				view.getArenaTrackerPanel4().setRDisp(
						Double.toString(model.getArenaTracker4()
								.getPostTrialAnalysis().getR()));
			} else if (propertyName.equalsIgnoreCase("lastDataRecordedToFile")) {
				view.getArenaTrackerPanel4().setLastDataRecordedToFileDisp(
						model.getArenaTracker4().getLastDataRecordedToFile());
			} else if (propertyName.equalsIgnoreCase("startAnalysis")) {
				view.getArenaTrackerPanel4().setStartAnalysisDisp(
						Integer.toString(model.getArenaTracker4().getTimer()
								.getStartAnalysis() / 60));
				;
			} else if (propertyName.equalsIgnoreCase("light2OnTime")) {
				view.getArenaTrackerPanel4().setLight2OnTimeDisp(
						Integer.toString(model.getArenaTracker4().getTimer()
								.getLight2OnTime() / 60));
			} else if (propertyName.equalsIgnoreCase("light1OnTime")) {
				view.getArenaTrackerPanel4().setLight1OnTimeDisp(
						Integer.toString(model.getArenaTracker4().getTimer()
								.getLight1OnTime() / 60));
			} else if (propertyName.equalsIgnoreCase("sampleEvery")) {
				view.getArenaTrackerPanel4().setSampleEveryDisp(
						Integer.toString(model.getArenaTracker4().getTimer()
								.getSampleEvery()));
			} else if (propertyName.equalsIgnoreCase("started")) {
				view.getArenaTrackerPanel4().resetEnabled(
						(boolean) evt.getNewValue());
				view.getArenaTrackerPanel4().disableTextFields(
						(boolean) evt.getNewValue());
			}
		}
	}
}