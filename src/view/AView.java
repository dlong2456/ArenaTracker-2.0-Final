package view;

import java.awt.Component;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import main.TurtleTrackerInterface;

public class AView extends JFrame implements View {

	private static final long serialVersionUID = 3888102023798135265L;
	private ArenaTrackerPanel[] arenaTrackerPanels;
	private PropertyChangeSupport changes;
	private JFrame f;
	private TurtleTrackerInterface[] turtleTrackers;

	public AView(TurtleTrackerInterface[] newTurtleTrackers) {
		turtleTrackers = newTurtleTrackers;
		this.changes = new PropertyChangeSupport(this);
		this.f = new JFrame("ArenaTracker 2.0");
		f.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		f.setBackground(new java.awt.Color(204, 204, 204));
		f.setExtendedState(Frame.MAXIMIZED_BOTH);
		JPanel container = new JPanel();
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.weighty = 1;
		c.gridx = 0;
		c.gridy = 0;
		this.arenaTrackerPanels = new ArenaTrackerPanel[4];
		for (int i = 0; i < arenaTrackerPanels.length; i++) {
			arenaTrackerPanels[i] = new AnArenaTrackerPanel("" + (i + 1),
					turtleTrackers[i]);
			container.add((Component) arenaTrackerPanels[i]);
			arenaTrackerPanels[i].addPropertyChangeListener(this);
		}
		JScrollPane scrPane = new JScrollPane(container);
		f.add(scrPane, c);
		// finalize
		f.pack();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// done
		f.setVisible(true);
	}

	public void addPropertyChangeListener(PropertyChangeListener l) {
		changes.addPropertyChangeListener(l);
	}

	public void removePropertyChangeListener(PropertyChangeListener l) {
		changes.removePropertyChangeListener(l);
	}

	public ArenaTrackerPanel getArenaTrackerPanel1() {
		return arenaTrackerPanels[0];
	}

	public ArenaTrackerPanel getArenaTrackerPanel2() {
		return arenaTrackerPanels[1];
	}

	public ArenaTrackerPanel getArenaTrackerPanel3() {
		return arenaTrackerPanels[2];
	}

	public ArenaTrackerPanel getArenaTrackerPanel4() {
		return arenaTrackerPanels[3];
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		changes.firePropertyChange(evt);
	}

}
