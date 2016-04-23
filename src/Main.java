import java.awt.BorderLayout;

import javax.swing.JFrame;

import aurelienribon.tweenengine.Tween;
import slidinglayout.SLAnimator;

public class Main {
	public static void main(String[] args) {
		Tween.registerAccessor(PingPanel.class, new PingPanel.Accessor());
		SLAnimator.start();

		Main_Frame frame = new Main_Frame(1000,1000);
		/*JFrame frame =new JFrame();
		Board board = new Board();
		frame.add(board);*/
		frame.setResizable(false);
		frame.setSize(1015, 1060);		
		frame.setVisible(true);
	}
}