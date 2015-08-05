package view;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class ALine extends JPanel implements Line {

	private static final long serialVersionUID = 8071862751630284039L;
	private int angle;

	// TODO: Change this to gridbag layout.
	public ALine() {
		setForeground(new java.awt.Color(255, 255, 255));
		setBackground(new java.awt.Color(255, 255, 255));
		setSize(400, 400);
		org.jdesktop.layout.GroupLayout lineLayout = new org.jdesktop.layout.GroupLayout(
				this);
		setLayout(lineLayout);
		lineLayout.setHorizontalGroup(lineLayout.createParallelGroup(
				org.jdesktop.layout.GroupLayout.LEADING).add(0, 100,
				Short.MAX_VALUE));
		lineLayout.setVerticalGroup(lineLayout.createParallelGroup(
				org.jdesktop.layout.GroupLayout.LEADING).add(0, 100,
				Short.MAX_VALUE));
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(new java.awt.Color(255, 132, 132));
		g.fillOval(10, 10, 80, 80);
		Graphics2D g2d = (Graphics2D) g;
		g2d.rotate(Math.toRadians(angle), 50, 50);
		g2d.setColor(new java.awt.Color(255, 255, 255));
		g2d.drawLine(50, 10, 50, 50);
	}

	public int getAngle() {
		return angle;
	}

	public void setAngle(int newAngle) {
		angle = newAngle;
		repaint();
	}

}
