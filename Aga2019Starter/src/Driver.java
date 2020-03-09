import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Driver extends JPanel implements ActionListener, KeyListener, MouseListener, MouseMotionListener {
	//size of jframe
	int screen_width 	= 900;
	int screen_height 	= 800;
	
	//max number
	int max = 9001;
	
	//array for radii of each Cell (food)
	int[] rads 	= new int[max];	//arrays holding all the diff radii of the food
	int[] x 	= new int[max]; //x and y arrays for the food position
	int[] y 	= new int[max];
	
	Color[] colors = new Color[max]; 
	
	//declare a new set of arrays for food
	int[] foodx = new int[max];
	int[] foody = new int[max];
	
	
	//velocity for player
	int vx = 0;
	int vy = 0;
	
	
	
	//player variables
	int pw = 30;
	int px = screen_width/2		-	pw/2;
	int py = screen_height/2	-	pw/2;
	
	//movement variables
	int pvx = 0;
	int pvy = 0;
	
	
	
	// reading a val from a 1d array
	// System.out.print( x[0]); //reading value
	// x[0] = 5; //writing is similar to regular variables but now you have to specify WHERE
	public void paint(Graphics g) {
		super.paintComponent(g);
		
		//write loop setup to visit every possible index in x
		for(int i =0; i < x.length; i++){
			
		//	g.setColor(colors[i]);
		//	g.fillOval(x[i],y[i],rads[i]*2,rads[i]*2);
			
			//draw food
			g.setColor(Color.green);
			g.fillOval(foodx[i],foody[i],10, 10);
			
		}
		
		//draw the player
		g.setColor(Color.red);
		g.fillOval(px, py, pw, pw);

	}//end of paint method - put code above for anything dealing with drawing -
	
	Font font = new Font ("Courier New", 1, 50);
	public void update() {
		
		//px += pvx;
		//py += pvy;
		
		//move the background (enemies and food)
		//and it will look like the player is moving! 
		for(int i =0; i < foodx.length;i++){
			foodx[i] += pvx;
			foody[i] += pvy;
		}
		
		
		
		
		
	}//end of update method - put code above for any updates on variable
		
	
	//==================code above ===========================
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		update();
		repaint();
	}
	
	public static void main(String[] arg) {
		Driver d = new Driver();
	}
	
	public Driver(){
		JFrame f = new JFrame();
		f.setTitle("Agar.IO");
		f.setSize(screen_width, screen_height);
		f.setBackground(Color.BLACK);
		f.setResizable(false);
		f.addKeyListener(this);
		f.addMouseMotionListener(this);

		//this special "method" is called the Constructor
		//initialized structures here!
		
		
		//this entire block generates random values for our
		//arrays which are the properties of the cells
		int counter = 0;
		while(counter<max){
			rads[counter] = 10; //all must be the same size to start
			x[counter] = (int)(Math.random()*(800)+0);
			y[counter] = (int)(Math.random()*(600)+0);
			
			//randomize food using constructor (which runs only once! ever)
			
			// x-> [-500000, 500000]
			// y-> [-500000, 500000]
			
			foodx[counter] = (int)(Math.random()*(9001)-4500);
			foody[counter] = (int)(Math.random()*(9001)-4500);			
			
			//create colors from your color lab
			// students: generate r,g,b values for Color
			// #############fix me##################################
			Color newColor = new Color(0,0,0); //use random numbers
			colors[counter] = newColor;
			// #############fix me##################################
			counter++;
			
		}
		
		
		
		
		
		
		
		
		f.add(this);
		
		
		t = new Timer(17,this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	Timer t;

	
	@Override
	public void keyPressed(KeyEvent e) {
		
		System.out.println(e.getKeyCode());
		switch(e.getKeyCode()){
			
			case 38:
				if(pvx!=0){
					//if they press up and its already moving
					//set pvx and pvy accordingly
					if(pvx>0){
						pvx = (int) Math.sqrt(50);
					}else{
						pvx = -(int)(Math.sqrt(50));
					}					
					pvy = (int) Math.sqrt(50);					
				}else{
					pvy = 10;
				}
				break;
				
			case 40: //if down key is pressed
				if(pvx!=0){
					//if they press up and its already moving
					//set pvx and pvy accordingly
					if(pvx>0){
						pvx = (int) Math.sqrt(50);
					}else{
						pvx = -(int)(Math.sqrt(50));
					}	
					pvy = -(int) Math.sqrt(50);
					
				}else{
					pvy = -10;
				}
				
				break;
			case 37: //left
				pvx = 10;
				break;
			case 39://right
				pvx = -10;
				break;
		
		}
		
		
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		switch(e.getKeyCode()){
		
			case 38:
				pvy = 0;
				break;
				
			case 40: //if down key is pressed
				pvy = 0;
				break;
			
			case 39:
				
			case 37:
				pvx = 0;
				break;
	
		}	
	}
	

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getX());
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
 

	
	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {

		
		
	}
	
	@Override
	public void mouseMoved(MouseEvent m) {

		
		
	}
	
}
