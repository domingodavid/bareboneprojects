
package frog;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.image.*;
import java.awt.geom.AffineTransform;

public class Driver extends JPanel implements ActionListener, KeyListener
		 {

	int screen_width = 900;
	int screen_height = 900;
	Froggy froggy;

	// instantiate objct log

	Car[] car2 = new Car[10];

	Background bg;
	int my_variable = 3; // example

	String lose = "";
	String win = "";
	String lost = "";

	// ******************************************paint
	// method*********************************************************
	public void paint(Graphics g) {

		super.paintComponent(g);
		bg.paint(g);

		g.setFont(font);
		g.setColor(Color.white);
		g.drawString(("Lives:") + Integer.toString(my_variable), 0, 870);
		g.setFont(font2);

		// paint sprites for carss
		for (int i = 0; i < car2.length; i++) {
			car2[i].paint(g);
		}

		//paint and update froggy 
		froggy.paint(g);

		// car one
		g.drawString(lost, 0, 50);
		if (my_variable == 0) {
			lose = " u lost";
			g.drawString(lose, 0, 50);
		}
		
		//resetting
		if (my_variable > 0 && froggy.getY() == 0) {
			lose = "";
			win = "u won!";
			g.drawString(win, 0, 50);
			froggy.setX(425);
			froggy.setY(825);
		}

	}

	Font font = new Font("Courier New", 1, 50);
	Font font2 = new Font("Courier New", 1, 30);

	//
	public void update() {

		froggy.move();

		// car two
		for (int i = 0; i < car2.length; i++) {

			car2[i].setVx(-3);
			car2[i].move();
			
		}

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		update();
		repaint();
	}

	public static void main(String[] arg) {
		Driver d = new Driver();
	}

	public Driver() {
		JFrame f = new JFrame();
		f.setTitle("Frogger");
		f.setSize(screen_width, screen_height);
		f.setResizable(false);
		f.addKeyListener(this);

		// sprite instantiation

		froggy = new Froggy("frogpic.png");

		for (int i = 0; i < car2.length; i++) {
			car2[i] = new Car("carpic.png", i * 250 + 400, 350);
		}

		//Add background
		bg = new Background("background1.png");
		// do not add to frame, call paint on
		// these objects in paint method

		f.add(this);
		t = new Timer(17, this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	Timer t;

	@Override
	public void keyPressed(KeyEvent e) {
		// detect up, down, left, right arrow keypresses
		// call setters for volovety attributes accordingly
		// 37 <- ,
		// 38 up ,
		// 40 down,
		// 39 ->
		System.out.println("key is pressed");
		if (e.getKeyCode() == KeyEvent.VK_W) {
			froggy.setVy(-5);
		}

		

	}

	@Override
	public void keyReleased(KeyEvent e) {
		/* turn off velocity for Frog if you don't want it moving when
		 * you have stopped pressing the keys
		 */
		if (e.getKeyCode() == 38) {
			froggy.setVy(0);
			froggy.setVx(0);
		}

		if (e.getKeyCode() == 40) {
			froggy.setVy(0);
			froggy.setVx(0);
		}

		//do the same thing for the other keys
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	

}