package frog;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Car {

	private int x; // the x position of Car
	private int y; // the y position of Car
	private int vx; // the movement of car
	private int vy; // the movement of the car in the y direction
	private String fileName;
	private Image img;// the image of the Car
	private int width;
	private int hieght;

	public Car(String fileName, int startX, int startY) {
		// assignment statements for attributes

		x = startX;
		y = startY;
		width = 50;
		hieght = 50;
		vx = -1;
		vy = 0;

		img = getImage(fileName);
		init(x, y);

	}

	public Car(String fileName) {
		// assignment statements for attributes

		x = 0;
		y = 0;
		vx = 0;
		width = 50;
		hieght = 50;

		img = getImage(fileName);
		init(x, y);

	}

	// getters and setters

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setVx(int vx) {
		this.vx = vx;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHieght() {
		return hieght;
	}

	public void setHieght(int hieght) {
		this.hieght = hieght;
	}

	public void move() {
		tx.translate(vx, 0);
		x += vx;
		
		if(x<0){
			
			x=950;
			tx.setToTranslation(x, y);
		}

	}

	private AffineTransform tx = AffineTransform.getTranslateInstance(x, y);

	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img, tx, null);
	}

	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(1, 1);
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Car.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
}
