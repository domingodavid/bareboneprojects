import java.awt.Graphics;
import java.awt.Rectangle;

public class Ball {

	// attribute
	private int x;
	private int y;
	private int w; // position and width
	private int vx = 5;
	private int vy = 3; // velocities

	public void paint(Graphics g) {
		g.fillOval(x, y, w, w);
	}

	public Ball(){
		x = 450;
		y = 100;
		w = 50;
		vx = 5;
		vy = 3;
	}
	
	public Ball(int newX, int newY) {
		x = newX;
		y = newY;
		w = 50;
		vx = 5;
		vy = 3;
	}

	public void getBig() {
		// w+=10;
		vx *= -1;
	}

	public void move() {
		x += vx;
		y += vy;
		
		//left and right borders!
		if(x<0 || x>850){
			vx *= -1;//reverse
		}
		
		//top and bottom borders!
		if(y<0 || y > 540){
			vy *= -1;
		}
		
	}
	
	public void gotToGoFast(){
		vx *= 1.5;
	}
	
	/* check if this object has collided with a paddle*/
	public boolean collided(Paddle p){
		
		
		Rectangle b = new Rectangle(x,y,w,w); 
		Rectangle pad = new Rectangle(p.getX(), p.getY(), p.getW(), p.getH());
		System.out.println(b+" paddle: "+pad);
		return b.intersects(pad);
		
	}

	public int getVx() {
		return vx;
	}

	public void setVx(int vx) {
		this.vx = vx;
	}

	public int getVy() {
		return vy;
	}

	public void setVy(int vy) {
		this.vy = vy;
	}

}
