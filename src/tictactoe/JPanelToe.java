package tictactoe;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class JPanelToe extends JPanel implements ActionListener{
XorOButton[][] gameCharacters;
JLabel stats;
JButton newGame;
PrintWriter log;
int turncount = 0;
	
	public JPanelToe() {
	

		
		gameCharacters = new XorOButton[3][3];
		setLayout(new BorderLayout());
		
		
		JPanel gameBoard = new JPanel();
	gameBoard.setLayout(new GridLayout(3,3));
	
	for(int i = 0; i < 3; i++) for (int q = 0; q < 3; q++) {gameCharacters[i][q]= new XorOButton(); gameBoard.add(gameCharacters[i][q]); gameCharacters[i][q].setIcon(gameCharacters[i][q].Default());  gameCharacters[i][q].addActionListener(this); gameCharacters[i][q].setActionCommand("The cell occupied in this turn was " + i + "-" +q); }
	
	add(gameBoard, BorderLayout.CENTER);
	
	
	JPanel info = new JPanel();
	stats = new JLabel("Welcome. O goes first.");
	newGame = new JButton("New Game?");
	
	newGame.addActionListener(this);
	
	info.add(stats);
	info.add(newGame);
	
	add(info, BorderLayout.NORTH);
	
	setVisible(true);
	
	try {	log = new PrintWriter( new FileOutputStream("./src/tictactoe/ticTacToe/log.txt", true)); 
	log.println("A New Gaming Session Has Now Started.\n\n");
	}
	catch (FileNotFoundException e) {e.printStackTrace();}
	finally { if (log != null) log.close();}
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {	log = new PrintWriter( new FileOutputStream("./src/tictactoe/ticTacToe/log.txt", true));
		
		
		
		if (e.getSource() instanceof XorOButton) {
			log.println( e.getActionCommand() + ": the character played was a(n) " + ((turncount % 2 == 0)? "O":"X"));	
			
			
			XorOButton temp = (XorOButton) e.getSource();
			
			if (temp.isInPlay == true) {
			
			
			if (turncount % 2 == 0) {
			temp.setIcon(temp.makeOImage());
			stats.setText("it is x's turn");
			
			if (seeIfWin(false)) {
				log.println("This was the winning move.\n\n");
				for (XorOButton[] x : gameCharacters) for (XorOButton q : x) { q.setEnabled(false);; stats.setText("O Wins!!!!!"); }
				
				
			}
			}
			
			else {temp.setIcon(temp.makeXImage()); stats.setText("it is o's turn");
			
			
			
			if (seeIfWin(true)) {
				log.println("This was the winning move.\n\n");
				for (XorOButton[] x : gameCharacters) for (XorOButton q : x) { q.setEnabled(false); stats.setText("X Wins!!!!!"); }	
				
			}
			}
			
			
			
			turncount++;
			
			
			
			}
			
			
		}
		
		
		if (XorOButton.numInPlay==0) {for (XorOButton[] x : gameCharacters) for (XorOButton q : x) { q.setEnabled(false); } stats.setText("Tie.");  
		log.println("The game has resulted in a tie.\n\n");
		}
		
		
		if (e.getSource().equals(newGame)) {
			turncount = 0;
			log.println("A New Game has now started.");
		for (XorOButton[] x : gameCharacters) for (XorOButton q : x) {if (!q.isInPlay)q.setIcon( q.Default()); q.setEnabled(true);}
		stats.setText("Welcome. O goes first.");
			
		}
		} catch(FileNotFoundException q) {q.printStackTrace();}
		finally {if (log != null)    log.close();}
		
	}
	
	
	boolean seeIfWin(boolean checkForX) {
		
		//check row
		int count = 0;
		for (XorOButton[] x : gameCharacters) {{for (XorOButton q : x) {if (q.isX == checkForX && q.isInPlay == false) count ++;} } if (count == 3) return true; else count = 0;}
		
		//check collum
		count = 0;
		for (int i = 0; i < 3; i++) {{for (XorOButton[] x : gameCharacters) {if (x[i].isX == checkForX && x[i].isInPlay == false) count ++; } } if (count == 3) return true; else count = 0;}
		
		//checkdiag
		count = 0;
		for (int i = 0; i < 3; i++) {if (gameCharacters[i][i].isX == checkForX && gameCharacters[i][i].isInPlay == false) count++; if (count == 3) return true;}
		
		//check other diag
		count = 0;
		for (int i = 0; i < 3; i++) {if (gameCharacters[i][(2-i)].isX == checkForX && gameCharacters[i][(2-i)].isInPlay == false) count++; if (count == 3) return true;}
		
		
		return false;
		
		
		
		
	}
	
}
