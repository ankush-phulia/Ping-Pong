import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.ParseException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;
import slidinglayout.SLAnimator;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JSeparator;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import network.ConnectionToServer;
import network.LocalServer;

public class Multi_Player extends JPanel {

	LocalServer gameServer;

	boolean expanded = false;
	private static final Color FG_COLOR = new Color(0xFFFFFF);
	private static final Color BG_COLOR = new Color(0x3B5998);
	private static final Color BORDER_COLOR = new Color(0x000000);
	private static final TweenManager tweenManager = SLAnimator.createTweenManager();
	private BufferedImage bgImg;
	private Runnable action;
	private boolean actionEnabled = true;
	private boolean hover = false;
	private int borderThickness = 1;
	
	public Multi_Player() {
		
		show_small();
		//populate_layout();

		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				hover = true;
				if (actionEnabled) showBorder();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				hover = false;
				hideBorder();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (action != null && actionEnabled)action.run();
				if (!expanded){
					removeAll();
					try {
						populate_layout();
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
				}
				else {
					removeAll();
					show_small();
				}
			}
		});
		
		
	}
	
	private void show_small() {
		setLayout(new BorderLayout(0, 0));		
		JLabel lblMultiPlayer = new JLabel("Multi player");
		lblMultiPlayer.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblMultiPlayer.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblMultiPlayer, BorderLayout.CENTER);
	}

	private void populate_layout() throws ParseException {
		this.setAutoscrolls(true);
		setLayout(new RXCardLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		add(panel_2, "Multiplayer");
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		panel_2.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel label = new JLabel("Multi player");
		label.setFont(new Font("Tahoma", Font.PLAIN, 38));
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_2.add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JSeparator separator_6 = new JSeparator();
		GridBagConstraints gbc_separator_6 = new GridBagConstraints();
		gbc_separator_6.insets = new Insets(0, 0, 75, 250);
		gbc_separator_6.gridx = 0;
		gbc_separator_6.gridy = 0;
		panel_1.add(separator_6, gbc_separator_6);
		
		JSeparator separator_28 = new JSeparator();
		GridBagConstraints gbc_separator_28 = new GridBagConstraints();
		gbc_separator_28.insets = new Insets(0, 0, 50, 350);
		gbc_separator_28.gridx = 3;
		gbc_separator_28.gridy = 1;
		panel_1.add(separator_28, gbc_separator_28);
		
		JButton btnStartNewGame = new JButton("Host a New Game");
		btnStartNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					gameServer = new LocalServer(8080);
					RXCardLayout cdl = (RXCardLayout) getLayout();
					Multi_New mn = new Multi_New(gameServer);
					add(mn,"new game");
					cdl.show(Multi_Player.this, "new game");
					//System.out.println(getParent().getParent().getParent().getParent().getParent().getClass());
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(getParent().getParent().getParent().getParent().getParent(),"Error Establishing Host");
					//e1.printStackTrace();
				}			
			}
		});
		btnStartNewGame.setFont(new Font("Tahoma", Font.PLAIN, 34));
		GridBagConstraints gbc_btnStartNewGame = new GridBagConstraints();
		gbc_btnStartNewGame.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnStartNewGame.insets = new Insets(0, 0, 5, 5);
		gbc_btnStartNewGame.gridx = 3;
		gbc_btnStartNewGame.gridy = 2;
		panel_1.add(btnStartNewGame, gbc_btnStartNewGame);
		
		JSeparator separator_26 = new JSeparator();
		GridBagConstraints gbc_separator_26 = new GridBagConstraints();
		gbc_separator_26.insets = new Insets(0, 0, 15, 15);
		gbc_separator_26.gridx = 3;
		gbc_separator_26.gridy = 3;
		panel_1.add(separator_26, gbc_separator_26);
		
		JLabel lblOr = new JLabel("OR");
		lblOr.setHorizontalAlignment(SwingConstants.CENTER);
		lblOr.setFont(new Font("Tahoma", Font.PLAIN, 34));
		GridBagConstraints gbc_lblOr = new GridBagConstraints();
		gbc_lblOr.insets = new Insets(0, 0, 5, 5);
		gbc_lblOr.gridx = 3;
		gbc_lblOr.gridy = 4;
		panel_1.add(lblOr, gbc_lblOr);		
		
		JSeparator separator_24 = new JSeparator();
		GridBagConstraints gbc_separator_24 = new GridBagConstraints();
		gbc_separator_24.insets = new Insets(0, 0, 15, 15);
		gbc_separator_24.gridx = 3;
		gbc_separator_24.gridy = 5;
		panel_1.add(separator_24, gbc_separator_24);
		
		JLabel lblEnterIpAddress = new JLabel("Enter IP Address");
		lblEnterIpAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterIpAddress.setFont(new Font("Tahoma", Font.PLAIN, 34));
		GridBagConstraints gbc_lblEnterIpAddress = new GridBagConstraints();
		gbc_lblEnterIpAddress.insets = new Insets(0, 0, 5, 5);
		gbc_lblEnterIpAddress.gridx = 3;
		gbc_lblEnterIpAddress.gridy = 6;
		panel_1.add(lblEnterIpAddress, gbc_lblEnterIpAddress);
		
		JSeparator separator_20 = new JSeparator();
		GridBagConstraints gbc_separator_20 = new GridBagConstraints();
		gbc_separator_20.insets = new Insets(0, 0, 15, 15);
		gbc_separator_20.gridx = 3;
		gbc_separator_20.gridy = 7;
		panel_1.add(separator_20, gbc_separator_20);

		MaskFormatter mf;
		mf = new MaskFormatter("###.###.###.###");
		final JFormattedTextField ipAddress = new JFormattedTextField(mf);
		ipAddress.setHorizontalAlignment(SwingConstants.CENTER);
		ipAddress.setFont(new Font("Tahoma", Font.PLAIN, 34));
		GridBagConstraints gbc_ipAddress = new GridBagConstraints();
		gbc_ipAddress.fill = GridBagConstraints.HORIZONTAL;
		gbc_ipAddress.insets = new Insets(0, 0, 5, 5);
		gbc_ipAddress.gridx = 3;
		gbc_ipAddress.gridy = 8;
		panel_1.add(ipAddress, gbc_ipAddress);
		
		JSeparator separator_45 = new JSeparator();
		GridBagConstraints gbc_separator_45 = new GridBagConstraints();
		gbc_separator_45.insets = new Insets(0, 0, 55, 55);
		gbc_separator_45.gridx = 1;
		gbc_separator_45.gridy = 9;
		panel_1.add(separator_45, gbc_separator_45);
		
		JButton btnJoinExistingOne = new JButton("Join Existing One");
		btnJoinExistingOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ConnectionToServer cs = new ConnectionToServer(ipAddress.getText(), 8080);
				if (cs.connectionEstablished()) {
					// cs.writeToServer("MYIP:" + cs.getIPAddress());

					String resp, type;
					do {
						resp = cs.readFromServer();
						type = parseResponse(resp);
					} while (!type.equalsIgnoreCase("START"));

					// start the game here

				}
				else {
					// do something here if connection could not be established

				}
			}
		});
		btnJoinExistingOne.setFont(new Font("Tahoma", Font.PLAIN, 34));
		GridBagConstraints gbc_btnJoinExistingOne = new GridBagConstraints();
		gbc_btnJoinExistingOne.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnJoinExistingOne.insets = new Insets(0, 0, 5, 5);
		gbc_btnJoinExistingOne.gridx = 3;
		gbc_btnJoinExistingOne.gridy = 10;
		panel_1.add(btnJoinExistingOne, gbc_btnJoinExistingOne);
		
		JSeparator separator_52 = new JSeparator();
		GridBagConstraints gbc_separator_52 = new GridBagConstraints();
		gbc_separator_52.insets = new Insets(0, 0, 0, 5);
		gbc_separator_52.gridx = 2;
		gbc_separator_52.gridy = 11;
		panel_1.add(separator_52, gbc_separator_52);
	}
	
	public void setAction(Runnable action) {this.action = action;}
	public void enableAction() {actionEnabled = true; if (hover) showBorder();}
	public void disableAction() {actionEnabled = false;}

	private void showBorder() {
		tweenManager.killTarget(borderThickness);
		Tween.to(this, Accessor.BORDER_THICKNESS, 0.4f)
			.target(10)
			.start(tweenManager);
	}

	private void hideBorder() {
		tweenManager.killTarget(borderThickness);
		Tween.to(this, Accessor.BORDER_THICKNESS, 0.4f)
			.target(2)
			.start(tweenManager);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D gg = (Graphics2D) g;

		int w = getWidth();
		int h = getHeight();

		if (bgImg != null) {
			int imgW = bgImg.getWidth();
			int imgH = bgImg.getHeight();

			if ((float)w/h < (float)imgW/imgH) {
				int tw = h * imgW/ imgH;
				int th = h;
				gg.drawImage(bgImg, (w-tw)/2, 0, tw, th, null);
			} else {
				int tw = w;
				int th = w * imgH / imgW;
				gg.drawImage(bgImg, 0, (h-th)/2, tw, th, null);
			}
		}

		int t = borderThickness;
		gg.setColor(BORDER_COLOR);
		gg.fillRect(0, 0, t, h-1);
		gg.fillRect(0, 0, w-1, t);
		gg.fillRect(0, h-1-t, w-1, t);
		gg.fillRect(w-1-t, 0, t, h-1);
	}


	private String parseResponse (String response) {
		if (response == null)
			return null;

		String[] tokens = response.split(":");
		switch (tokens[0]) {
			/*case "MYIP":
				String ipOfClient = tokens[1];
				gameServer.writeToAllClients("CONNECTTOIP:" + ipOfClient);
				break;
			case "CONNECTTOIP":
				String ipOfOtherClient = tokens[1];

				break;*/
			default:

		}
		return tokens[0];
	}


	// -------------------------------------------------------------------------
	// Tween Accessor
	// -------------------------------------------------------------------------

	public static class Accessor extends SLAnimator.ComponentAccessor {
		public static final int BORDER_THICKNESS = 100;

		@Override
		public int getValues(Component target, int tweenType, float[] returnValues) {
			Multi_Player tp = (Multi_Player) target;

			int ret = super.getValues(target, tweenType, returnValues);
			if (ret >= 0) return ret;

			switch (tweenType) {
				case BORDER_THICKNESS: returnValues[0] = tp.borderThickness; return 1;
				default: return -1;
			}
		}

		@Override
		public void setValues(Component target, int tweenType, float[] newValues) {
			Multi_Player tp = (Multi_Player) target;

			super.setValues(target, tweenType, newValues);

			switch (tweenType) {
				case BORDER_THICKNESS:
					tp.borderThickness = Math.round(newValues[0]);
					tp.repaint();
					break;
			}
		}
	}

}
