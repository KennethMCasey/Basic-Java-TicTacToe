package tictactoe;



public class DaMain {

	public static void main(String[] args) {
	
		
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				JFrameToe gui = new JFrameToe();
				gui.setVisible(true);
				gui.setSize(900, 500);
				gui.setResizable(false);
			}

	});


	}

}
