import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.BoxLayout;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Game extends JPanel {

	/**
	 * Create the panel.
	 */
	public Game (String ownPosition,int ownLives,
			String GameMode,int ball_Num,int spd,boolean powerups,
			String Difficulty1,int Lives1,String Position1,
			String Difficulty2,int Lives2,String Position2,
			String Difficulty3,int Lives3,String Position3, int[] keys){
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		Board board=new Board (ownPosition,ownLives,
				GameMode,ball_Num,spd,powerups,
				Difficulty1,Lives1,Position1,
				Difficulty2,Lives2,Position2,
				Difficulty3,Lives3,Position3,keys);
		board.setFocusTraversalPolicyProvider(true);

		add(board);		
		GridBagLayout gbl_board = new GridBagLayout();
		gbl_board.columnWidths = new int[]{0};
		gbl_board.rowHeights = new int[]{0};
		gbl_board.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_board.rowWeights = new double[]{Double.MIN_VALUE};
		board.setLayout(gbl_board);
		board.requestFocusInWindow();
		board.requestFocus();
		
		JPanel panel = new JPanel();
		panel.setFocusTraversalKeysEnabled(false);
		add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		JButton btnBackToMain = new JButton("Back to Main Menu");
		btnBackToMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Single_Player sp = (Single_Player) getParent();
				RXCardLayout cdl=(RXCardLayout) sp.getLayout();
				cdl.show(sp, "MenuPanel");
			}
		});
		btnBackToMain.setFont(new Font("Tahoma", Font.PLAIN, 34));
		panel.add(btnBackToMain);
		panel.setFocusable(false);

		this.setFocusable(true);
		
		this.addComponentListener( new ComponentAdapter() {
            public void componentShown( ComponentEvent e ) {
                Game.this.requestFocusInWindow();
            }
        });
		
		board.grabFocus();
		
	}

}
