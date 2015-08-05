package view;

import javax.swing.JPanel;
import main.TurtleTrackerInterface;

public class AHeaderPanel extends JPanel {

	private static final long serialVersionUID = -6296366491884147121L;
	private javax.swing.JLabel tracker;

	public AHeaderPanel(String string, TurtleTrackerInterface turtleTracker) {
		tracker = new javax.swing.JLabel();
		tracker.setFont(new java.awt.Font("Lucida Grande", 1, 18));
		tracker.setForeground(new java.awt.Color(255, 255, 255));
		String demo;
		if (turtleTracker.isDemo()) {
			demo = " DEMO";
		} else {
			demo = "";
		}
		tracker.setText("TRACKER " + string + demo);

		this.setBackground(new java.awt.Color(159, 214, 250));
		java.awt.GridBagConstraints gridBagConstraints;
		this.setLayout(new java.awt.GridBagLayout());
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		this.add(tracker, gridBagConstraints);
	}
}
