import java.awt.EventQueue;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Panel;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Swing_Pong {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Swing_Pong window = new Swing_Pong();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Swing_Pong() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 200, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[418px]", "[41px][][][][][][]"));
		
		JButton btnDoSomething = new JButton("Do Something");
		btnDoSomething.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new JLabel("New Layout Created"),"cell 0 0");
				frame.revalidate();
				frame.repaint();
			}
		});
		
		JLabel lblHi = new JLabel("Hi");
		frame.getContentPane().add(lblHi, "cell 0 0");
		frame.getContentPane().add(btnDoSomething, "cell 0 6,growx,aligny top");
	}

}
