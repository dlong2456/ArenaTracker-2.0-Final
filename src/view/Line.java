package view;

import java.awt.Graphics;

public interface Line {

	public void paintComponent(Graphics g);

	public int getAngle();

	public void setAngle(int newAngle);

}
