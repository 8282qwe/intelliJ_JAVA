package my_game;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Missile extends Sprite {

	private final int MISSILE_SPEED = 2;
	int dx = 1, dy = 1;

	public Missile(int x, int y) {
		super(x+40, y);
		loadImage("./image/missile.png");
	}

	public void move() {
		y -= MISSILE_SPEED;
		if (y < 0) {
			visible = false;
		}
	}
}