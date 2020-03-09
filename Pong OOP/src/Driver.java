import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Driver extends JPanel implements ActionListener, KeyListener {
	
	int table_width = 900; //width of the screen "table"
	int table_height = 600;//height of the screen "table"
	
	//PONG TABLE
	// what attributes / objects
	// need to be here?

	Ball ball2 = new Ball();
	Paddle paddleLeft 	= new Paddle(50, 300);
	Paddle paddleRight 	= new Paddle(700, 300);
	
	int scoreLeft 	= 0;
	int scoreRight 	= 0;
	
	//A Font object to represent a bigger text in paint
	Font biggerFont = new Font ("Courier New", 1, 50);
	
	/*
	 * Paint all the graphics here.
	 */
	public void paint(Graphics g) {
		super.paintComponent(g);
		paddleLeft.paint(g);
		ball2.paint(g);
		
		g.setFont(biggerFont); //set it to bigger Font object
		g.drawString(scoreLeft+"", 310, 100); //draw left score
		g.drawString(scoreRight+"", 550, 100);//draw right score
		
	}//end of paint method - put code above for anything dealing with drawing -
	
	public void update() {
		//update variables for game here
		//Assume this is run 60times per second 
		ball2.move();
		
		//call the move method for paddle
		//it'll move if its vy is non-zero!
		paddleLeft.move();
		
		if(ball2.collided(paddleLeft)){
			
			//set velocity (x) to its opposite
			//use setter and getter of the ball
			
		}

		
	}//end of update method - put code above for any updates on variable
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		update();
		repaint();
	}
	
	public static void main(String[] arg) {
		Driver d = new Driver();
	}
	public Driver(){
		
		//SETUP the JFRAME
		JFrame f = new JFrame();
		f.setTitle("Pong");
		f.setSize(table_width,table_height);
		f.setBackground(Color.BLACK);
		f.setResizable(false);
		f.addKeyListener(this);
		f.add(this);
		
		
		
		//SETUP TImer for animation purposes	
		t = new Timer(17,this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		
	}
	Timer t;

	public void keyPressed(KeyEvent e) {
		System.out.println(e.getKeyCode());
		if(e.getKeyCode()==38){ //key up was pressed
			paddleLeft.setVy(-5);
		}
	
		//detect arrow down key pressed
		if(e.getKeyCode()==40){
			paddleLeft.setVy(5);
		}		
		
	}

	public void keyReleased(KeyEvent e) {

		if(e.getKeyCode()==38){ //key up was pressed
			paddleLeft.setVy(0);
		}
		
		if(e.getKeyCode()==40){
			paddleLeft.setVy(0);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}