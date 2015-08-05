package view;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import exceptions.DirectoryException;
import exceptions.InvalidInputException;
import main.TurtleTrackerInterface;

public class AnArenaTrackerPanel extends JPanel implements ArenaTrackerPanel {

	private static final long serialVersionUID = -2883345791994840371L;

	private PropertyChangeSupport changes;
	private ALine line;
	private JFileChooser fileChooser;
	private String path = null;
	private JButton chooseDirectory;
	private JTextField directoryDisp;
	private javax.swing.JButton abortButton;
	private javax.swing.JTextField angleDisp;
	private javax.swing.JTextField arenaName;
	private javax.swing.JLabel completed;
	private javax.swing.JTextField completedDisp;
	private javax.swing.JLabel endAnalysis;
	private javax.swing.JTextField endAnalysisDisp;
	private javax.swing.JLabel endAnalysisMin;
	private javax.swing.JLabel lastDataRecordedToFile;
	private javax.swing.JTextField lastDataRecordedToFileDisp;
	private javax.swing.JLabel lengthOfTrial;
	private javax.swing.JTextField lengthOfTrialDisp;
	private javax.swing.JLabel lengthOfTrialMin;
	private javax.swing.JCheckBox light1;
	private javax.swing.JLabel light1Off;
	private javax.swing.JTextField light1OffTimeDisp;
	private javax.swing.JLabel light1On;
	private javax.swing.JTextField light1OnTimeDisp;
	private javax.swing.JCheckBox light2;
	private javax.swing.JLabel light2Off;
	private javax.swing.JTextField light2OffTimeDisp;
	private javax.swing.JLabel light2On;
	private javax.swing.JTextField light2OnTimeDisp;
	private javax.swing.JLabel meanAngle;
	private javax.swing.JTextField meanAngleDisp;
	private javax.swing.JButton pauseButton;
	private javax.swing.JLabel r;
	private javax.swing.JTextField rDisp;
	private javax.swing.JLabel remaining;
	private javax.swing.JTextField remainingDisp;
	private javax.swing.JButton reset;
	private javax.swing.JLabel sampleEvery;
	private javax.swing.JTextField sampleEveryDisp;
	private javax.swing.JLabel sampleEverySec;
	private javax.swing.JLabel startAnalysis;
	private javax.swing.JTextField startAnalysisDisp;
	private javax.swing.JLabel startAnalysisMin;
	private javax.swing.JButton startButton;
	private javax.swing.JPanel headerPanel;
	private TurtleTrackerInterface turtleTracker;

	public AnArenaTrackerPanel(String string,
			TurtleTrackerInterface newTurtleTracker) {
		super();
		changes = new PropertyChangeSupport(this);
		turtleTracker = newTurtleTracker;

		// initializing components and adding action listeners, in visual order
		// from top to bottom, left to right
		headerPanel = new AHeaderPanel(string, turtleTracker);
		arenaName = new javax.swing.JTextField();
		arenaName.setFocusable(true);
		arenaName.addKeyListener(this);
		line = new ALine();
		angleDisp = new javax.swing.JTextField();
		reset = new javax.swing.JButton();
		reset.addActionListener(this);
		completed = new javax.swing.JLabel();
		completedDisp = new javax.swing.JTextField();
		remaining = new javax.swing.JLabel();
		remainingDisp = new javax.swing.JTextField();
		light1 = new javax.swing.JCheckBox();
		light1.addActionListener(this);
		light2 = new javax.swing.JCheckBox();
		light2.addActionListener(this);
		light1On = new javax.swing.JLabel();
		light1OnTimeDisp = new javax.swing.JTextField();
		light1OnTimeDisp.setFocusable(true);
		light1OnTimeDisp.addKeyListener(this);
		light2On = new javax.swing.JLabel();
		light2OnTimeDisp = new javax.swing.JTextField();
		light2OnTimeDisp.setFocusable(true);
		light2OnTimeDisp.addKeyListener(this);
		light1Off = new javax.swing.JLabel();
		light1OffTimeDisp = new javax.swing.JTextField();
		light1OffTimeDisp.setFocusable(true);
		light1OffTimeDisp.addKeyListener(this);
		light2Off = new javax.swing.JLabel();
		light2OffTimeDisp = new javax.swing.JTextField();
		light2OffTimeDisp.setFocusable(true);
		light2OffTimeDisp.addKeyListener(this);
		lengthOfTrial = new javax.swing.JLabel();
		lengthOfTrialDisp = new javax.swing.JTextField();
		lengthOfTrialDisp.setFocusable(true);
		lengthOfTrialDisp.addKeyListener(this);
		lengthOfTrialMin = new javax.swing.JLabel();
		sampleEvery = new javax.swing.JLabel();
		sampleEveryDisp = new javax.swing.JTextField();
		sampleEveryDisp.setFocusable(true);
		sampleEveryDisp.addKeyListener(this);
		sampleEverySec = new javax.swing.JLabel();
		startAnalysis = new javax.swing.JLabel();
		startAnalysisDisp = new javax.swing.JTextField();
		startAnalysisDisp.setFocusable(true);
		startAnalysisDisp.addKeyListener(this);
		startAnalysisMin = new javax.swing.JLabel();
		endAnalysis = new javax.swing.JLabel();
		endAnalysisDisp = new javax.swing.JTextField();
		endAnalysisDisp.setFocusable(true);
		endAnalysisDisp.addKeyListener(this);
		endAnalysisMin = new javax.swing.JLabel();
		startButton = new javax.swing.JButton();
		startButton.addActionListener(this);
		pauseButton = new javax.swing.JButton();
		pauseButton.addActionListener(this);
		abortButton = new javax.swing.JButton();
		abortButton.addActionListener(this);
		lastDataRecordedToFile = new javax.swing.JLabel();
		lastDataRecordedToFileDisp = new javax.swing.JTextField();
		meanAngle = new javax.swing.JLabel();
		meanAngleDisp = new javax.swing.JTextField();
		r = new javax.swing.JLabel();
		rDisp = new javax.swing.JTextField();
		rDisp.setFocusable(true);
		fileChooser = new JFileChooser();
		chooseDirectory = new JButton();
		chooseDirectory.addActionListener(this);
		directoryDisp = new JTextField();

		// JPanel formatting

		java.awt.GridBagConstraints gridBagConstraints;
		this.setBackground(new java.awt.Color(255, 255, 255));
		this.setLayout(new java.awt.GridBagLayout());

		// formatting components, in visual order from top to bottom, left to
		// right

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.ipady = 15;
		this.add(headerPanel, gridBagConstraints);

		arenaName.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
		arenaName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		arenaName.setText("Arena " + string + " Name");
		arenaName
				.setToolTipText("Give your turtle a name. Your file will save as TurtleName_"
						+ string + "_YYYY-MM-DD/TIME.txt");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.ipadx = 140;
		gridBagConstraints.insets = new java.awt.Insets(6, 20, 0, 20);
		this.add(arenaName, gridBagConstraints);

		angleDisp.setEditable(false);
		angleDisp.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
		angleDisp.setText("0.0");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.ipadx = 20;
		gridBagConstraints.insets = new java.awt.Insets(0, 160, 30, 0);
		this.add(angleDisp, gridBagConstraints);

		reset.setBackground(new java.awt.Color(255, 255, 255));
		reset.setText("Reset");
		reset.setToolTipText("Reset angle to zero.");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.insets = new java.awt.Insets(30, 150, 0, 0);
		this.add(reset, gridBagConstraints);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.insets = new java.awt.Insets(16, -135, 0, 0);
		this.add(line, gridBagConstraints);

		completed.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
		completed.setText("Completed");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.insets = new java.awt.Insets(6, -130, 0, 0);
		this.add(completed, gridBagConstraints);

		remaining.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
		remaining.setText("Remaining");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.insets = new java.awt.Insets(6, 130, 0, 0);
		this.add(remaining, gridBagConstraints);

		completedDisp.setEditable(false);
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 4;
		gridBagConstraints.ipadx = 81;
		gridBagConstraints.insets = new java.awt.Insets(6, -130, 0, 0);
		this.add(completedDisp, gridBagConstraints);

		remainingDisp.setEditable(false);
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 4;
		gridBagConstraints.ipadx = 81;
		gridBagConstraints.insets = new java.awt.Insets(8, 130, 0, 0);
		this.add(remainingDisp, gridBagConstraints);

		light1.setFont(new java.awt.Font("Lucida Grande", 1, 10)); // NOI18N
		light1.setText("Light 1");
		light1.setToolTipText("Turn on light 1.");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 5;
		gridBagConstraints.insets = new java.awt.Insets(6, -150, 0, 0);
		this.add(light1, gridBagConstraints);

		light2.setFont(new java.awt.Font("Lucida Grande", 1, 10)); // NOI18N
		light2.setText("Light 2");
		light2.setToolTipText("Turn on light 2.");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 5;
		gridBagConstraints.insets = new java.awt.Insets(6, 110, 0, 0);
		this.add(light2, gridBagConstraints);

		light1On.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
		light1On.setText("On");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 6;
		gridBagConstraints.insets = new java.awt.Insets(12, -200, 0, 0);
		this.add(light1On, gridBagConstraints);

		light1OnTimeDisp.setToolTipText("Light 1 on at _ min");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 6;
		gridBagConstraints.ipadx = 35;
		gridBagConstraints.insets = new java.awt.Insets(6, -120, 0, 0);
		this.add(light1OnTimeDisp, gridBagConstraints);

		light1Off.setFont(new java.awt.Font("Lucida Grande", 1, 13));
		light1Off.setText("Off");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 7;
		gridBagConstraints.insets = new java.awt.Insets(12, -200, 0, 0);
		this.add(light1Off, gridBagConstraints);

		light1OffTimeDisp.setToolTipText("Light 1 off at _ min");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 7;
		gridBagConstraints.ipadx = 35;
		gridBagConstraints.insets = new java.awt.Insets(6, -120, 0, 0);
		this.add(light1OffTimeDisp, gridBagConstraints);

		light2On.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
		light2On.setLabelFor(light2OnTimeDisp);
		light2On.setText("On");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 6;
		gridBagConstraints.insets = new java.awt.Insets(12, 60, 0, 0);
		this.add(light2On, gridBagConstraints);

		light2OnTimeDisp.setToolTipText("Light 2 on at _ min");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 6;
		gridBagConstraints.ipadx = 35;
		gridBagConstraints.insets = new java.awt.Insets(6, 140, 0, 0);
		this.add(light2OnTimeDisp, gridBagConstraints);

		light2OffTimeDisp.setToolTipText("Light 2 off at _ min");
		light2Off.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
		light2Off.setLabelFor(light2OffTimeDisp);
		light2Off.setText("Off");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 7;
		gridBagConstraints.insets = new java.awt.Insets(12, 60, 0, 0);
		this.add(light2Off, gridBagConstraints);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 7;
		gridBagConstraints.ipadx = 35;
		gridBagConstraints.insets = new java.awt.Insets(6, 140, 0, 0);
		this.add(light2OffTimeDisp, gridBagConstraints);

		lengthOfTrial.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
		lengthOfTrial.setLabelFor(lengthOfTrialDisp);
		lengthOfTrial.setText("Length of trial:");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 8;
		gridBagConstraints.insets = new java.awt.Insets(6, -125, 0, 0);
		this.add(lengthOfTrial, gridBagConstraints);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 8;
		gridBagConstraints.ipadx = 35;
		gridBagConstraints.insets = new java.awt.Insets(6, 80, 0, 0);
		this.add(lengthOfTrialDisp, gridBagConstraints);

		lengthOfTrialMin.setLabelFor(lengthOfTrialDisp);
		lengthOfTrialMin.setText("min.");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 8;
		gridBagConstraints.insets = new java.awt.Insets(12, 170, 0, 0);
		this.add(lengthOfTrialMin, gridBagConstraints);

		sampleEvery.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
		sampleEvery.setLabelFor(sampleEveryDisp);
		sampleEvery.setText("Sample every:");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 9;
		gridBagConstraints.insets = new java.awt.Insets(6, -130, 0, 0);
		this.add(sampleEvery, gridBagConstraints);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 9;
		gridBagConstraints.ipadx = 35;
		gridBagConstraints.insets = new java.awt.Insets(6, 80, 0, 0);
		this.add(sampleEveryDisp, gridBagConstraints);

		sampleEverySec.setLabelFor(sampleEveryDisp);
		sampleEverySec.setText("sec.");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 9;
		gridBagConstraints.insets = new java.awt.Insets(6, 170, 0, 0);
		this.add(sampleEverySec, gridBagConstraints);

		startAnalysis.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
		startAnalysis.setLabelFor(startAnalysisDisp);
		startAnalysis.setText("Start analysis:");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 10;
		gridBagConstraints.insets = new java.awt.Insets(12, -130, 0, 0);
		this.add(startAnalysis, gridBagConstraints);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 10;
		gridBagConstraints.ipadx = 35;
		gridBagConstraints.insets = new java.awt.Insets(6, 80, 0, 0);
		this.add(startAnalysisDisp, gridBagConstraints);

		startAnalysisMin.setLabelFor(startAnalysisDisp);
		startAnalysisMin.setText("min.");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 10;
		gridBagConstraints.insets = new java.awt.Insets(12, 170, 0, 0);
		this.add(startAnalysisMin, gridBagConstraints);

		endAnalysis.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
		endAnalysis.setLabelFor(endAnalysisDisp);
		endAnalysis.setText("End analysis:");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 11;
		gridBagConstraints.insets = new java.awt.Insets(12, -135, 0, 0);
		this.add(endAnalysis, gridBagConstraints);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 11;
		gridBagConstraints.ipadx = 35;
		gridBagConstraints.insets = new java.awt.Insets(6, 80, 0, 0);
		this.add(endAnalysisDisp, gridBagConstraints);

		endAnalysisMin.setLabelFor(endAnalysisDisp);
		endAnalysisMin.setText("min.");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 11;
		gridBagConstraints.insets = new java.awt.Insets(12, 170, 0, 0);
		this.add(endAnalysisMin, gridBagConstraints);

		startButton.setBackground(new java.awt.Color(255, 102, 102));
		startButton.setText("Start");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 12;
		gridBagConstraints.ipadx = 0;
		gridBagConstraints.ipady = 28;
		gridBagConstraints.insets = new java.awt.Insets(6, -160, 0, 0);
		this.add(startButton, gridBagConstraints);

		pauseButton.setBackground(new java.awt.Color(255, 102, 102));
		pauseButton.setText("Pause");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 12;
		gridBagConstraints.ipadx = 0;
		gridBagConstraints.ipady = 28;
		gridBagConstraints.insets = new java.awt.Insets(6, 6, 0, 0);
		this.add(pauseButton, gridBagConstraints);

		abortButton.setBackground(new java.awt.Color(255, 102, 102));
		abortButton.setText("Abort");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 12;
		gridBagConstraints.ipadx = 0;
		gridBagConstraints.ipady = 28;
		gridBagConstraints.insets = new java.awt.Insets(6, 170, 0, 0);
		this.add(abortButton, gridBagConstraints);

		lastDataRecordedToFile
				.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
		lastDataRecordedToFile.setLabelFor(lastDataRecordedToFileDisp);
		lastDataRecordedToFile.setText("Last data recorded to file:");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 13;
		gridBagConstraints.insets = new java.awt.Insets(12, -50, 0, 0);
		this.add(lastDataRecordedToFile, gridBagConstraints);

		lastDataRecordedToFileDisp.setEditable(false);
		lastDataRecordedToFileDisp.setCaretPosition(0);
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 14;
		gridBagConstraints.ipadx = 209;
		lastDataRecordedToFileDisp.setColumns(2);
		gridBagConstraints.insets = new java.awt.Insets(6, -10, 0, 0);
		this.add(lastDataRecordedToFileDisp, gridBagConstraints);

		meanAngle.setFont(new java.awt.Font("Lucida Grande", 1, 13));
		meanAngle.setLabelFor(angleDisp);
		meanAngle.setText("Mean angle = ");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 15;
		gridBagConstraints.insets = new java.awt.Insets(12, -130, 0, 0);
		this.add(meanAngle, gridBagConstraints);

		meanAngleDisp.setEditable(false);
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 15;
		gridBagConstraints.ipadx = 48;
		gridBagConstraints.insets = new java.awt.Insets(6, 90, 0, 0);
		this.add(meanAngleDisp, gridBagConstraints);

		r.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
		r.setLabelFor(rDisp);
		r.setText("(Complete) r = ");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 16;
		gridBagConstraints.insets = new java.awt.Insets(12, -130, 0, 0);
		this.add(r, gridBagConstraints);

		rDisp.setEditable(false);
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 16;
		gridBagConstraints.ipadx = 48;
		gridBagConstraints.insets = new java.awt.Insets(6, 90, 0, 0);
		this.add(rDisp, gridBagConstraints);

		chooseDirectory.setBackground(new java.awt.Color(255, 102, 102));
		chooseDirectory.setText("Directory");
		chooseDirectory.setToolTipText("Where do you want to save your file?");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 17;
		gridBagConstraints.ipadx = 0;
		gridBagConstraints.insets = new java.awt.Insets(12, -165, 45, 0);
		this.add(chooseDirectory, gridBagConstraints);

		directoryDisp.setEditable(false);
		directoryDisp.setColumns(2);
		directoryDisp.setCaretPosition(0);
		directoryDisp.setFont(new java.awt.Font("Lucida Grande", 0, 11));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 17;
		gridBagConstraints.ipadx = 120;
		gridBagConstraints.insets = new java.awt.Insets(12, 80, 45, 0);
		this.add(directoryDisp, gridBagConstraints);

	}

	// getters and setters

	public String getArenaName() {
		return arenaName.getText();
	}

	public void setArenaName(String arenaName) {
		this.arenaName.setText(arenaName);
	}

	public String getLight1OffTimeDisp() {
		return light1OffTimeDisp.getText();
	}

	public void setLight1OffTimeDisp(String light1OffTimeDisp) {
		this.light1OffTimeDisp.setText(light1OffTimeDisp);
	}

	public String getLight1OnTimeDisp() {
		return light1OnTimeDisp.getText();
	}

	public void setLight1OnTimeDisp(String light1OnTimeDisp) {
		this.light1OnTimeDisp.setText(light1OnTimeDisp);
	}

	public String getLengthOfTrialDisp() {
		return lengthOfTrialDisp.getText();
	}

	public void setLengthOfTrialDisp(String lengthOfTrialDisp) {
		this.lengthOfTrialDisp.setText(lengthOfTrialDisp);
	}

	public String getSampleEveryDisp() {
		return sampleEveryDisp.getText();
	}

	public void setSampleEveryDisp(String sampleEveryDisp) {
		this.sampleEveryDisp.setText(sampleEveryDisp);
	}

	public String getStartAnalysisDisp() {
		return startAnalysisDisp.getText();
	}

	public void setStartAnalysisDisp(String startAnalysisDisp) {
		this.startAnalysisDisp.setText(startAnalysisDisp);
		;
	}

	public String getEndAnalysisDisp() {
		return endAnalysisDisp.getText();
	}

	public void setEndAnalysisDisp(String endAnalysisDisp) {
		this.endAnalysisDisp.setText(endAnalysisDisp);
	}

	public String getLastDataRecordedToFileDisp() {
		return lastDataRecordedToFileDisp.getText();
	}

	public void setLastDataRecordedToFileDisp(String lastDataRecordedToFileDisp) {
		this.lastDataRecordedToFileDisp.setText(lastDataRecordedToFileDisp);
	}

	public String getRDisp() {
		return rDisp.getText();
	}

	public void setRDisp(String rDisp) {
		this.rDisp.setText(rDisp);
	}

	public String getAngleDisp() {
		return angleDisp.getText();
	}

	public void setAngleDisp(String angleDisp) {
		this.angleDisp.setText(angleDisp);
	}

	public String getCompletedDisp() {
		return completedDisp.getText();
	}

	public void setCompletedDisp(String completedDisp) {
		this.completedDisp.setText(completedDisp);
	}

	public String getMeanAngleDisp() {
		return meanAngleDisp.getText();
	}

	public void setMeanAngleDisp(String meanAngleDisp) {
		this.meanAngleDisp.setText(meanAngleDisp);
	}

	public String getRemainingDisp() {
		return remainingDisp.getText();
	}

	public void setRemainingDisp(String remainingDisp) {
		this.remainingDisp.setText(remainingDisp);
	}

	public String getLight2OnTimeDisp() {
		return light2OnTimeDisp.getText();
	}

	public void setLight2OnTimeDisp(String light2OnTimeDisp) {
		this.light2OnTimeDisp.setText(light2OnTimeDisp);
	}

	public String getLight2OffTimeDisp() {
		return light2OffTimeDisp.getText();
	}

	public void setLight2OffTimeDisp(String light2OffTimeDisp) {
		this.light2OffTimeDisp.setText(light2OffTimeDisp);
	}

	public ALine getLine() {
		return line;
	}

	// other methods

	public void resetEnabled(boolean val) {
		reset.setEnabled(val);
	}

	public void disableTextFields(boolean val) {
		light1OnTimeDisp.setEditable(val);
		light1OffTimeDisp.setEditable(val);
		light2OnTimeDisp.setEditable(val);
		light2OffTimeDisp.setEditable(val);
		light1.setEnabled(val);
		light2.setEnabled(val);
		startAnalysisDisp.setEditable(val);
		endAnalysisDisp.setEditable(val);
		sampleEveryDisp.setEditable(val);
		lengthOfTrialDisp.setEditable(val);
		arenaName.setEditable(val);
	}

	// event handling
	@Override
	public void addPropertyChangeListener(PropertyChangeListener l) {
		changes.addPropertyChangeListener(l);
	}

	@Override
	public void removePropertyChangeListener(PropertyChangeListener l) {
		changes.removePropertyChangeListener(l);
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		if (evt.getSource().getClass() == JButton.class) {
			JButton source = (JButton) evt.getSource();
			if (source == this.reset) {
				changes.firePropertyChange("reset", false, true);
			} else if (source == this.startButton) {
				String message = "Invalid Input: \n";
				boolean light1OnToggle = false;
				boolean light1OffToggle = false;
				boolean light1OnOffToggle = false;
				boolean light2OnToggle = false;
				boolean light2OffToggle = false;
				boolean light2OnOffToggle = false;
				try {
					if (path == null) {
						throw new DirectoryException();
					}
					int sampleEveryInt = Integer.parseInt(getSampleEveryDisp());
					changes.firePropertyChange("sampleEveryDisp", 1,
							sampleEveryDisp.getText());
					int lengthOfTrialInt = Integer
							.parseInt(getLengthOfTrialDisp());
					changes.firePropertyChange("lengthOfTrialDisp", 1,
							lengthOfTrialDisp.getText());
					int startAnalysisInt = Integer
							.parseInt(getStartAnalysisDisp());
					changes.firePropertyChange("startAnalysisDisp", 1,
							startAnalysisDisp.getText());
					int endAnalysisInt = Integer.parseInt(getEndAnalysisDisp());
					changes.firePropertyChange("endAnalysisDisp", 1,
							endAnalysisDisp.getText());
					if (light1.isSelected()) {
						int light1OnTimeInt = Integer
								.parseInt(getLight1OnTimeDisp());
						changes.firePropertyChange("light1OnTimeDisp", 1,
								light1OnTimeDisp.getText());
						int light1OffTimeInt = Integer
								.parseInt(getLight1OffTimeDisp());
						changes.firePropertyChange("light1OffTimeDisp", 1,
								light1OffTimeDisp.getText());
						if (light1OnTimeInt > lengthOfTrialInt) {
							light1OnToggle = true;
						}
						if (light1OffTimeInt > lengthOfTrialInt) {
							light1OffToggle = true;
						}
						if (light1OnTimeInt > light1OffTimeInt) {
							light1OnOffToggle = true;
						}
					}
					if (light2.isSelected()) {
						int light2OnTimeInt = Integer
								.parseInt(getLight2OnTimeDisp());
						changes.firePropertyChange("light2OnTimeDisp", 1,
								light2OnTimeDisp.getText());
						int light2OffTimeInt = Integer
								.parseInt(getLight2OffTimeDisp());
						changes.firePropertyChange("light2OffTimeDisp", 1,
								light2OffTimeDisp.getText());
						if (light2OnTimeInt > lengthOfTrialInt) {
							light2OnToggle = true;
						}
						if (light2OffTimeInt > lengthOfTrialInt) {
							light2OffToggle = true;
						}
						if (light2OnTimeInt > light2OffTimeInt) {
							light2OnOffToggle = true;
						}
					}
					if (light1OnToggle || light1OffToggle || light1OnOffToggle
							|| light2OnToggle || light2OffToggle
							|| light2OnOffToggle
							|| sampleEveryInt > lengthOfTrialInt * 60
							|| startAnalysisInt > lengthOfTrialInt
							|| endAnalysisInt > lengthOfTrialInt
							|| endAnalysisInt < startAnalysisInt) {

						if (light1OnToggle) {
							message = message
									+ "Please enter a valid Light 1 On time or extend trial length.\n";
						}
						if (light1OffToggle) {
							message = message
									+ "Please enter a valid Light 1 Off time or extend trial length.\n";
						}
						if (light1OnOffToggle) {
							message = message
									+ "Please enter valid Light 1 On and Light 1 Off times.\n";
						}
						if (light2OnToggle) {
							message = message
									+ "Please enter a valid Light 2 On time or extend trial length.\n";
						}
						if (light2OffToggle) {
							message = message
									+ "Please enter a valid Light 2 Off time or extend trial length.\n";
						}
						if (light2OnOffToggle) {
							message = message
									+ "Please enter valid Light 2 On and Light 2 Off times.\n";
						}
						if (sampleEveryInt > lengthOfTrialInt * 60) {
							message = message
									+ "Please enter a valid Sample Every time or extend trial length.\n";
						}
						if (startAnalysisInt > lengthOfTrialInt) {
							message = message
									+ "Please enter a valid Start Analysis time or extend trial length.\n";
						}
						if (endAnalysisInt > lengthOfTrialInt) {
							message = message
									+ "Please enter a valid End Analysis time or extend trial length.\n";
						}
						if (endAnalysisInt < startAnalysisInt) {
							message = message
									+ "Please enter valid Start Analysis and End Analysis times.\n";
						}
						throw new InvalidInputException();
					}
					changes.firePropertyChange("start", false, true);
				} catch (InvalidInputException e) {
					JOptionPane.showMessageDialog(null, message, message,
							JOptionPane.ERROR_MESSAGE);
				} catch (NumberFormatException e) {
					JOptionPane
							.showMessageDialog(
									null,
									"Invalid Input: Please check that you have filled out all required fields with valid integer inputs.",
									"Invalid Input: Please check that you have filled out all required fields with valid integer inputs.",
									JOptionPane.ERROR_MESSAGE);
				} catch (DirectoryException e) {
					JOptionPane.showMessageDialog(null,
							"Please choose a directory.",
							"Please choose a directory.",
							JOptionPane.ERROR_MESSAGE);
				}
			} else if (source == this.abortButton) {
				int result = JOptionPane
						.showConfirmDialog(
								null,
								"Are you sure you want to abort? You will not be able to resume your trial.",
								"Are you sure you want to abort? You will not be able to resume your trial.",
								JOptionPane.YES_NO_OPTION);
				switch (result) {
				case 0:
					changes.firePropertyChange("abort", false, true);
					break;
				case 1:
					break;
				}

			} else if (source == this.pauseButton) {
				changes.firePropertyChange("pause", false, true);
			} else if (source == this.chooseDirectory) {
				fileChooser = new JFileChooser();
				fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int returnVal = fileChooser.showOpenDialog(fileChooser);
				File file = fileChooser.getSelectedFile();
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					path = file.getAbsolutePath(); // finds the file path if a
													// file is chosen.
				}
				directoryDisp.setText(path);
				if (path != null) {
					changes.firePropertyChange("directory", 1, path);
				}
			}
		} else if (evt.getSource().getClass() == JCheckBox.class) {
			JCheckBox source = (JCheckBox) evt.getSource();
			if (source == this.light1) {
				if (source.isSelected()) {
					changes.firePropertyChange("light1", false, true);
				} else {
					changes.firePropertyChange("light1", true, false);
				}
			} else if (source == this.light2) {
				if (source.isSelected()) {
					changes.firePropertyChange("light2", false, true);
				} else {
					changes.firePropertyChange("light2", true, false);
				}
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent evt) {
		// do nothing
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// do nothing
	}

	@Override
	public void keyReleased(KeyEvent evt) {
		if ((evt.getSource().getClass() == JTextField.class)) {
			JTextField source = (JTextField) evt.getSource();
			String text = source.getText();
			if (source == this.arenaName) {
				changes.firePropertyChange("arenaName", 1, text);
			}
		}
	}

}
