package tictactoe;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class XorOButton extends JButton {
	ImageIcon x;
	ImageIcon o;
	ImageIcon base;
	boolean isInPlay;
	boolean isX;
	static int numInPlay = 0;
	
	public XorOButton() {
		isInPlay = true;
		
		
		x = new ImageIcon( "./src/tictactoe/ticTacToe/tic-tac-toe-X.png" );
		x = new ImageIcon((Image) x.getImage().getScaledInstance(70, 70, Image.SCALE_FAST)  );
		
		o = new ImageIcon("./src/tictactoe/ticTacToe/tic-tac-toe-O.png");
		o = new ImageIcon( (Image) o.getImage().getScaledInstance(70, 70, Image.SCALE_FAST)  );
		
		base = new ImageIcon ("./src/tictactoe/ticTacToe/default.jpeg");
		base = new ImageIcon( (Image) base.getImage().getScaledInstance(70, 70, Image.SCALE_FAST)  ); 
		
	setVisible(true);
		
	}

	
	public ImageIcon makeXImage() {isX = true; isInPlay = false; numInPlay--; return this.x;}
	public ImageIcon makeOImage() {isX=false; isInPlay = false; numInPlay--; return o;}
	public ImageIcon Default() {isX = false; isInPlay = true; numInPlay++; return base;  }
	public boolean getIsX() {return isX;}
	
}
