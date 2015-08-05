package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeListener;

public interface ArenaTrackerPanel extends ActionListener, KeyListener {

	public String getArenaName();

	public void setArenaName(String arenaName);

	public String getLight1OffTimeDisp();

	public void setLight1OffTimeDisp(String light1OffTimeDisp);

	public String getLight1OnTimeDisp();

	public void setLight1OnTimeDisp(String light1OnTimeDisp);

	public String getLengthOfTrialDisp();

	public void setLengthOfTrialDisp(String lengthOfTrialDisp);

	public String getSampleEveryDisp();

	public void setSampleEveryDisp(String sampleEveryDisp);

	public String getStartAnalysisDisp();

	public void setStartAnalysisDisp(String startAnalysisDisp);

	public String getEndAnalysisDisp();

	public void setEndAnalysisDisp(String endAnalysisDisp);

	public String getLastDataRecordedToFileDisp();

	public void setLastDataRecordedToFileDisp(String lastDataRecordedToFileDisp);

	public String getRDisp();

	public void setRDisp(String rDisp);

	public String getAngleDisp();

	public void setAngleDisp(String angleDisp);

	public String getCompletedDisp();

	public void setCompletedDisp(String completedDisp);

	public String getMeanAngleDisp();

	public void setMeanAngleDisp(String meanAngleDisp);

	public String getRemainingDisp();

	public void setRemainingDisp(String remainingDisp);

	public String getLight2OnTimeDisp();

	public void setLight2OnTimeDisp(String light2OnTimeDisp);

	public String getLight2OffTimeDisp();

	public void setLight2OffTimeDisp(String light2OffTimeDisp);

	public ALine getLine();

	// other methods

	public void resetEnabled(boolean val);

	public void disableTextFields(boolean val);

	// event handling

	public void addPropertyChangeListener(PropertyChangeListener l);

	public void removePropertyChangeListener(PropertyChangeListener l);

	@Override
	public void actionPerformed(ActionEvent evt);

	@Override
	public void keyTyped(KeyEvent evt);

	@Override
	public void keyPressed(KeyEvent e);

	@Override
	public void keyReleased(KeyEvent evt);

}
