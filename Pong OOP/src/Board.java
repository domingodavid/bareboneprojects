import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;


public class Board extends JFrame {
	
	//add a main that instantiates this Board class
	public static void main(String[] main){
		Board b = new Board();
		b.setSize(300,300);
		b.setVisible(true);
	}
	
	
	
	boolean isx = true;
	
	public Board() {
		setTitle("Tic Tac Finger");
		getContentPane().setLayout(new GridLayout(3, 3, 0, 0));
		
		JButton btnNewButton_6 = new JButton("New button");
		getContentPane().add(btnNewButton_6);
		
		JButton btnNewButton_3 = new JButton("New button");
		getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_2 = new JButton("New button");
		getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("New button");
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_4 = new JButton("New button");
		btnNewButton_4.setBackground(Color.RED);
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
							
				
				JButton actual = (JButton) e.getComponent();
				if(!actual.isEnabled()){
					return; //this button has already been used!
				}
				
				
				if(isx){
					actual.setText("X");
				}else{
					actual.setText("Y");
				}
				actual.setEnabled(false);
				
				isx =  !isx;
			}
		});
		
		getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton = new JButton("New button");
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_5 = new JButton("New button");
		getContentPane().add(btnNewButton_5);
		
		JButton btnNewButton_7 = new JButton("New button");
		getContentPane().add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("New button");
		getContentPane().add(btnNewButton_8);
	}
	
	//can add aadditional stuff up here
	boolean[][] status = new boolean[3][3];
	
	
	
	
}
