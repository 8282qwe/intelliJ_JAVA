package my_game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener, KeyListener {

	private Timer timer;
	private Spaceship ship;
	private ArrayList <Alien> alien = new ArrayList<>();
	private final int DELAY = 30;

	public Board() {
		addKeyListener(this);
		setFocusable(true);
		setBackground(Color.BLACK);

		ship = new Spaceship(500, 500);
		for (int i = 0; i < 5; i++){
			alien.add(new Alien(300*i,0));
		}
		timer = new Timer(DELAY, this);
		timer.start();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(ship.getImage(), ship.getX(), ship.getY(), this);
		for (Alien value : alien) {
			g2d.drawImage(value.getImage(), value.getX(), value.getY(), this);
		}
		if( ship.getMissile() != null )
			g2d.drawImage(ship.getMissile().getImage(), ship.getMissile().getX(), ship.getMissile().getY(), this);
		Toolkit.getDefaultToolkit().sync();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		ship.move();
		for (int i = 0; i < alien.size(); i++){
			alien.get(i).move();
			if(ship.getMissile() != null){
				if(alien.get(i).hit(ship.getMissile().getX(),ship.getMissile().getY())){
					alien.remove(i);
					ship.remove();
				}
			}
		}
		if( ship.getMissile() != null )
			ship.getMissile().move();
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		ship.keyReleased(e);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		ship.keyPressed(e);
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}
}