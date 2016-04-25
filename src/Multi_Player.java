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
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import network.ConnectionToServer;
import network.LocalServer;

public class Multi_Player extends JPanel {

	boolean expanded=false;
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
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else{
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
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.insets = new Insets(0, 0, 150, 150);
		gbc_separator.gridx = 15;
		gbc_separator.gridy = 0;
		panel_1.add(separator, gbc_separator);
		
		JSeparator separator_1 = new JSeparator();
		GridBagConstraints gbc_separator_1 = new GridBagConstraints();
		gbc_separator_1.insets = new Insets(0, 0, 5, 5);
		gbc_separator_1.gridx = 15;
		gbc_separator_1.gridy = 1;
		panel_1.add(separator_1, gbc_separator_1);
		
		JSeparator separator_2 = new JSeparator();
		GridBagConstraints gbc_separator_2 = new GridBagConstraints();
		gbc_separator_2.insets = new Insets(0, 0, 5, 5);
		gbc_separator_2.gridx = 15;
		gbc_separator_2.gridy = 2;
		panel_1.add(separator_2, gbc_separator_2);
		
		JSeparator separator_3 = new JSeparator();
		GridBagConstraints gbc_separator_3 = new GridBagConstraints();
		gbc_separator_3.insets = new Insets(0, 0, 5, 5);
		gbc_separator_3.gridx = 15;
		gbc_separator_3.gridy = 3;
		panel_1.add(separator_3, gbc_separator_3);
		
		JSeparator separator_4 = new JSeparator();
		GridBagConstraints gbc_separator_4 = new GridBagConstraints();
		gbc_separator_4.insets = new Insets(0, 0, 5, 5);
		gbc_separator_4.gridx = 15;
		gbc_separator_4.gridy = 4;
		panel_1.add(separator_4, gbc_separator_4);
		
		JSeparator separator_5 = new JSeparator();
		GridBagConstraints gbc_separator_5 = new GridBagConstraints();
		gbc_separator_5.insets = new Insets(0, 0, 5, 5);
		gbc_separator_5.gridx = 15;
		gbc_separator_5.gridy = 5;
		panel_1.add(separator_5, gbc_separator_5);
		
		JSeparator separator_6 = new JSeparator();
		GridBagConstraints gbc_separator_6 = new GridBagConstraints();
		gbc_separator_6.insets = new Insets(0, 0, 5, 5);
		gbc_separator_6.gridx = 0;
		gbc_separator_6.gridy = 6;
		panel_1.add(separator_6, gbc_separator_6);
		
		JSeparator separator_7 = new JSeparator();
		GridBagConstraints gbc_separator_7 = new GridBagConstraints();
		gbc_separator_7.insets = new Insets(0, 0, 5, 5);
		gbc_separator_7.gridx = 1;
		gbc_separator_7.gridy = 6;
		panel_1.add(separator_7, gbc_separator_7);
		
		JSeparator separator_8 = new JSeparator();
		GridBagConstraints gbc_separator_8 = new GridBagConstraints();
		gbc_separator_8.insets = new Insets(0, 0, 5, 5);
		gbc_separator_8.gridx = 2;
		gbc_separator_8.gridy = 6;
		panel_1.add(separator_8, gbc_separator_8);
		
		JSeparator separator_9 = new JSeparator();
		GridBagConstraints gbc_separator_9 = new GridBagConstraints();
		gbc_separator_9.insets = new Insets(0, 0, 5, 5);
		gbc_separator_9.gridx = 3;
		gbc_separator_9.gridy = 6;
		panel_1.add(separator_9, gbc_separator_9);
		
		JSeparator separator_10 = new JSeparator();
		GridBagConstraints gbc_separator_10 = new GridBagConstraints();
		gbc_separator_10.insets = new Insets(0, 0, 5, 5);
		gbc_separator_10.gridx = 4;
		gbc_separator_10.gridy = 6;
		panel_1.add(separator_10, gbc_separator_10);
		
		JSeparator separator_11 = new JSeparator();
		GridBagConstraints gbc_separator_11 = new GridBagConstraints();
		gbc_separator_11.insets = new Insets(0, 0, 5, 5);
		gbc_separator_11.gridx = 5;
		gbc_separator_11.gridy = 6;
		panel_1.add(separator_11, gbc_separator_11);
		
		JSeparator separator_12 = new JSeparator();
		GridBagConstraints gbc_separator_12 = new GridBagConstraints();
		gbc_separator_12.insets = new Insets(0, 0, 5, 5);
		gbc_separator_12.gridx = 6;
		gbc_separator_12.gridy = 6;
		panel_1.add(separator_12, gbc_separator_12);
		
		JSeparator separator_13 = new JSeparator();
		GridBagConstraints gbc_separator_13 = new GridBagConstraints();
		gbc_separator_13.insets = new Insets(0, 0, 5, 5);
		gbc_separator_13.gridx = 9;
		gbc_separator_13.gridy = 6;
		panel_1.add(separator_13, gbc_separator_13);
		
		JSeparator separator_28 = new JSeparator();
		GridBagConstraints gbc_separator_28 = new GridBagConstraints();
		gbc_separator_28.insets = new Insets(0, 0, 5, 5);
		gbc_separator_28.gridx = 40;
		gbc_separator_28.gridy = 7;
		panel_1.add(separator_28, gbc_separator_28);
		
		JSeparator separator_32 = new JSeparator();
		GridBagConstraints gbc_separator_32 = new GridBagConstraints();
		gbc_separator_32.insets = new Insets(0, 0, 5, 5);
		gbc_separator_32.gridx = 40;
		gbc_separator_32.gridy = 8;
		panel_1.add(separator_32, gbc_separator_32);
		
		JSeparator separator_31 = new JSeparator();
		GridBagConstraints gbc_separator_31 = new GridBagConstraints();
		gbc_separator_31.insets = new Insets(0, 0, 5, 5);
		gbc_separator_31.gridx = 40;
		gbc_separator_31.gridy = 9;
		panel_1.add(separator_31, gbc_separator_31);
		
		JSeparator separator_30 = new JSeparator();
		GridBagConstraints gbc_separator_30 = new GridBagConstraints();
		gbc_separator_30.insets = new Insets(0, 0, 5, 5);
		gbc_separator_30.gridx = 40;
		gbc_separator_30.gridy = 10;
		panel_1.add(separator_30, gbc_separator_30);
		
		JSeparator separator_29 = new JSeparator();
		GridBagConstraints gbc_separator_29 = new GridBagConstraints();
		gbc_separator_29.insets = new Insets(0, 0, 5, 5);
		gbc_separator_29.gridx = 40;
		gbc_separator_29.gridy = 11;
		panel_1.add(separator_29, gbc_separator_29);
		
		JSeparator separator_35 = new JSeparator();
		GridBagConstraints gbc_separator_35 = new GridBagConstraints();
		gbc_separator_35.insets = new Insets(0, 0, 5, 5);
		gbc_separator_35.gridx = 16;
		gbc_separator_35.gridy = 12;
		panel_1.add(separator_35, gbc_separator_35);
		
		JSeparator separator_33 = new JSeparator();
		GridBagConstraints gbc_separator_33 = new GridBagConstraints();
		gbc_separator_33.insets = new Insets(0, 0, 5, 5);
		gbc_separator_33.gridx = 25;
		gbc_separator_33.gridy = 12;
		panel_1.add(separator_33, gbc_separator_33);
		
		JSeparator separator_34 = new JSeparator();
		GridBagConstraints gbc_separator_34 = new GridBagConstraints();
		gbc_separator_34.insets = new Insets(0, 0, 5, 5);
		gbc_separator_34.gridx = 29;
		gbc_separator_34.gridy = 12;
		panel_1.add(separator_34, gbc_separator_34);
		
		JButton btnStartNewGame = new JButton("Host a New Game");
		btnStartNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					LocalServer gameServer=new LocalServer(8080);
					RXCardLayout cdl=(RXCardLayout) getLayout();
					Multi_New mn=new Multi_New(gameServer);
					add(mn,"new game");
					cdl.show(Multi_Player.this, "new game");
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}			
			}
		});
		btnStartNewGame.setFont(new Font("Tahoma", Font.PLAIN, 34));
		GridBagConstraints gbc_btnStartNewGame = new GridBagConstraints();
		gbc_btnStartNewGame.insets = new Insets(0, 0, 5, 5);
		gbc_btnStartNewGame.gridx = 40;
		gbc_btnStartNewGame.gridy = 12;
		panel_1.add(btnStartNewGame, gbc_btnStartNewGame);
		
		JSeparator separator_26 = new JSeparator();
		GridBagConstraints gbc_separator_26 = new GridBagConstraints();
		gbc_separator_26.insets = new Insets(0, 0, 5, 5);
		gbc_separator_26.gridx = 40;
		gbc_separator_26.gridy = 13;
		panel_1.add(separator_26, gbc_separator_26);
		
		JSeparator separator_27 = new JSeparator();
		GridBagConstraints gbc_separator_27 = new GridBagConstraints();
		gbc_separator_27.insets = new Insets(0, 0, 5, 5);
		gbc_separator_27.gridx = 40;
		gbc_separator_27.gridy = 14;
		panel_1.add(separator_27, gbc_separator_27);
		
		JSeparator separator_25 = new JSeparator();
		GridBagConstraints gbc_separator_25 = new GridBagConstraints();
		gbc_separator_25.insets = new Insets(0, 0, 5, 5);
		gbc_separator_25.gridx = 40;
		gbc_separator_25.gridy = 15;
		panel_1.add(separator_25, gbc_separator_25);
		
		JLabel lblOr = new JLabel("OR");
		lblOr.setHorizontalAlignment(SwingConstants.CENTER);
		lblOr.setFont(new Font("Tahoma", Font.PLAIN, 34));
		GridBagConstraints gbc_lblOr = new GridBagConstraints();
		gbc_lblOr.insets = new Insets(0, 0, 5, 5);
		gbc_lblOr.gridx = 40;
		gbc_lblOr.gridy = 16;
		panel_1.add(lblOr, gbc_lblOr);		
		
		JSeparator separator_24 = new JSeparator();
		GridBagConstraints gbc_separator_24 = new GridBagConstraints();
		gbc_separator_24.insets = new Insets(0, 0, 5, 5);
		gbc_separator_24.gridx = 40;
		gbc_separator_24.gridy = 17;
		panel_1.add(separator_24, gbc_separator_24);
		
		JSeparator separator_23 = new JSeparator();
		GridBagConstraints gbc_separator_23 = new GridBagConstraints();
		gbc_separator_23.insets = new Insets(0, 0, 5, 5);
		gbc_separator_23.gridx = 40;
		gbc_separator_23.gridy = 18;
		panel_1.add(separator_23, gbc_separator_23);
		
		JSeparator separator_22 = new JSeparator();
		GridBagConstraints gbc_separator_22 = new GridBagConstraints();
		gbc_separator_22.insets = new Insets(0, 0, 5, 5);
		gbc_separator_22.gridx = 40;
		gbc_separator_22.gridy = 19;
		panel_1.add(separator_22, gbc_separator_22);
		
		JLabel lblEnterIpAddress = new JLabel("Enter IP Address");
		lblEnterIpAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterIpAddress.setFont(new Font("Tahoma", Font.PLAIN, 34));
		GridBagConstraints gbc_lblEnterIpAddress = new GridBagConstraints();
		gbc_lblEnterIpAddress.insets = new Insets(0, 0, 5, 5);
		gbc_lblEnterIpAddress.gridx = 40;
		gbc_lblEnterIpAddress.gridy = 20;
		panel_1.add(lblEnterIpAddress, gbc_lblEnterIpAddress);
		
		JSeparator separator_20 = new JSeparator();
		GridBagConstraints gbc_separator_20 = new GridBagConstraints();
		gbc_separator_20.insets = new Insets(0, 0, 5, 5);
		gbc_separator_20.gridx = 40;
		gbc_separator_20.gridy = 21;
		panel_1.add(separator_20, gbc_separator_20);
		
		JSeparator separator_21 = new JSeparator();
		GridBagConstraints gbc_separator_21 = new GridBagConstraints();
		gbc_separator_21.insets = new Insets(0, 0, 5, 5);
		gbc_separator_21.gridx = 40;
		gbc_separator_21.gridy = 22;
		panel_1.add(separator_21, gbc_separator_21);
		
		JSeparator separator_19 = new JSeparator();
		GridBagConstraints gbc_separator_19 = new GridBagConstraints();
		gbc_separator_19.insets = new Insets(0, 0, 5, 5);
		gbc_separator_19.gridx = 40;
		gbc_separator_19.gridy = 23;
		panel_1.add(separator_19, gbc_separator_19);
		
		MaskFormatter mf;
		mf = new MaskFormatter("###.###.###.###");
		JFormattedTextField ipAddress = new JFormattedTextField(mf);
		ipAddress.setHorizontalAlignment(SwingConstants.CENTER);
		ipAddress.setFont(new Font("Tahoma", Font.PLAIN, 34));
		GridBagConstraints gbc_ipAddress = new GridBagConstraints();
		gbc_ipAddress.fill = GridBagConstraints.HORIZONTAL;
		gbc_ipAddress.insets = new Insets(0, 0, 5, 5);
		gbc_ipAddress.gridx = 40;
		gbc_ipAddress.gridy = 24;
		panel_1.add(ipAddress, gbc_ipAddress);
		
		JSeparator separator_15 = new JSeparator();
		GridBagConstraints gbc_separator_15 = new GridBagConstraints();
		gbc_separator_15.insets = new Insets(0, 0, 5, 5);
		gbc_separator_15.gridx = 40;
		gbc_separator_15.gridy = 25;
		panel_1.add(separator_15, gbc_separator_15);
		
		JSeparator separator_18 = new JSeparator();
		GridBagConstraints gbc_separator_18 = new GridBagConstraints();
		gbc_separator_18.insets = new Insets(0, 0, 5, 5);
		gbc_separator_18.gridx = 40;
		gbc_separator_18.gridy = 26;
		panel_1.add(separator_18, gbc_separator_18);
		
		JSeparator separator_17 = new JSeparator();
		GridBagConstraints gbc_separator_17 = new GridBagConstraints();
		gbc_separator_17.insets = new Insets(0, 0, 5, 5);
		gbc_separator_17.gridx = 40;
		gbc_separator_17.gridy = 27;
		panel_1.add(separator_17, gbc_separator_17);
		
		JSeparator separator_16 = new JSeparator();
		GridBagConstraints gbc_separator_16 = new GridBagConstraints();
		gbc_separator_16.insets = new Insets(0, 0, 5, 5);
		gbc_separator_16.gridx = 40;
		gbc_separator_16.gridy = 28;
		panel_1.add(separator_16, gbc_separator_16);
		
		JSeparator separator_14 = new JSeparator();
		GridBagConstraints gbc_separator_14 = new GridBagConstraints();
		gbc_separator_14.insets = new Insets(0, 0, 5, 5);
		gbc_separator_14.gridx = 40;
		gbc_separator_14.gridy = 29;
		panel_1.add(separator_14, gbc_separator_14);
		
		JSeparator separator_45 = new JSeparator();
		GridBagConstraints gbc_separator_45 = new GridBagConstraints();
		gbc_separator_45.insets = new Insets(0, 0, 5, 5);
		gbc_separator_45.gridx = 10;
		gbc_separator_45.gridy = 30;
		panel_1.add(separator_45, gbc_separator_45);
		
		JSeparator separator_56 = new JSeparator();
		GridBagConstraints gbc_separator_56 = new GridBagConstraints();
		gbc_separator_56.insets = new Insets(0, 0, 5, 5);
		gbc_separator_56.gridx = 7;
		gbc_separator_56.gridy = 31;
		panel_1.add(separator_56, gbc_separator_56);
		
		JSeparator separator_49 = new JSeparator();
		GridBagConstraints gbc_separator_49 = new GridBagConstraints();
		gbc_separator_49.insets = new Insets(0, 0, 5, 5);
		gbc_separator_49.gridx = 8;
		gbc_separator_49.gridy = 31;
		panel_1.add(separator_49, gbc_separator_49);
		
		JSeparator separator_57 = new JSeparator();
		GridBagConstraints gbc_separator_57 = new GridBagConstraints();
		gbc_separator_57.insets = new Insets(0, 0, 5, 5);
		gbc_separator_57.gridx = 12;
		gbc_separator_57.gridy = 31;
		panel_1.add(separator_57, gbc_separator_57);
		
		JSeparator separator_46 = new JSeparator();
		GridBagConstraints gbc_separator_46 = new GridBagConstraints();
		gbc_separator_46.insets = new Insets(0, 0, 5, 5);
		gbc_separator_46.gridx = 13;
		gbc_separator_46.gridy = 31;
		panel_1.add(separator_46, gbc_separator_46);
		
		JSeparator separator_44 = new JSeparator();
		GridBagConstraints gbc_separator_44 = new GridBagConstraints();
		gbc_separator_44.insets = new Insets(0, 0, 5, 5);
		gbc_separator_44.gridx = 14;
		gbc_separator_44.gridy = 31;
		panel_1.add(separator_44, gbc_separator_44);
		
		JSeparator separator_51 = new JSeparator();
		GridBagConstraints gbc_separator_51 = new GridBagConstraints();
		gbc_separator_51.insets = new Insets(0, 0, 5, 5);
		gbc_separator_51.gridx = 17;
		gbc_separator_51.gridy = 31;
		panel_1.add(separator_51, gbc_separator_51);
		
		JSeparator separator_59 = new JSeparator();
		GridBagConstraints gbc_separator_59 = new GridBagConstraints();
		gbc_separator_59.insets = new Insets(0, 0, 5, 5);
		gbc_separator_59.gridx = 18;
		gbc_separator_59.gridy = 31;
		panel_1.add(separator_59, gbc_separator_59);
		
		JSeparator separator_60 = new JSeparator();
		GridBagConstraints gbc_separator_60 = new GridBagConstraints();
		gbc_separator_60.insets = new Insets(0, 0, 5, 5);
		gbc_separator_60.gridx = 19;
		gbc_separator_60.gridy = 31;
		panel_1.add(separator_60, gbc_separator_60);
		
		JSeparator separator_53 = new JSeparator();
		GridBagConstraints gbc_separator_53 = new GridBagConstraints();
		gbc_separator_53.insets = new Insets(0, 0, 5, 5);
		gbc_separator_53.gridx = 20;
		gbc_separator_53.gridy = 31;
		panel_1.add(separator_53, gbc_separator_53);
		
		JSeparator separator_50 = new JSeparator();
		GridBagConstraints gbc_separator_50 = new GridBagConstraints();
		gbc_separator_50.insets = new Insets(0, 0, 5, 5);
		gbc_separator_50.gridx = 21;
		gbc_separator_50.gridy = 31;
		panel_1.add(separator_50, gbc_separator_50);
		
		JSeparator separator_62 = new JSeparator();
		GridBagConstraints gbc_separator_62 = new GridBagConstraints();
		gbc_separator_62.insets = new Insets(0, 0, 5, 5);
		gbc_separator_62.gridx = 22;
		gbc_separator_62.gridy = 31;
		panel_1.add(separator_62, gbc_separator_62);
		
		JSeparator separator_55 = new JSeparator();
		GridBagConstraints gbc_separator_55 = new GridBagConstraints();
		gbc_separator_55.insets = new Insets(0, 0, 5, 5);
		gbc_separator_55.gridx = 23;
		gbc_separator_55.gridy = 31;
		panel_1.add(separator_55, gbc_separator_55);
		
		JSeparator separator_58 = new JSeparator();
		GridBagConstraints gbc_separator_58 = new GridBagConstraints();
		gbc_separator_58.insets = new Insets(0, 0, 5, 5);
		gbc_separator_58.gridx = 24;
		gbc_separator_58.gridy = 31;
		panel_1.add(separator_58, gbc_separator_58);
		
		JSeparator separator_54 = new JSeparator();
		GridBagConstraints gbc_separator_54 = new GridBagConstraints();
		gbc_separator_54.insets = new Insets(0, 0, 5, 5);
		gbc_separator_54.gridx = 26;
		gbc_separator_54.gridy = 31;
		panel_1.add(separator_54, gbc_separator_54);
		
		JSeparator separator_63 = new JSeparator();
		GridBagConstraints gbc_separator_63 = new GridBagConstraints();
		gbc_separator_63.insets = new Insets(0, 0, 5, 5);
		gbc_separator_63.gridx = 27;
		gbc_separator_63.gridy = 31;
		panel_1.add(separator_63, gbc_separator_63);
		
		JSeparator separator_61 = new JSeparator();
		GridBagConstraints gbc_separator_61 = new GridBagConstraints();
		gbc_separator_61.insets = new Insets(0, 0, 5, 5);
		gbc_separator_61.gridx = 28;
		gbc_separator_61.gridy = 31;
		panel_1.add(separator_61, gbc_separator_61);
		
		JSeparator separator_47 = new JSeparator();
		GridBagConstraints gbc_separator_47 = new GridBagConstraints();
		gbc_separator_47.insets = new Insets(0, 0, 5, 5);
		gbc_separator_47.gridx = 30;
		gbc_separator_47.gridy = 31;
		panel_1.add(separator_47, gbc_separator_47);
		
		JSeparator separator_48 = new JSeparator();
		GridBagConstraints gbc_separator_48 = new GridBagConstraints();
		gbc_separator_48.insets = new Insets(0, 0, 5, 5);
		gbc_separator_48.gridx = 31;
		gbc_separator_48.gridy = 31;
		panel_1.add(separator_48, gbc_separator_48);
		
		JSeparator separator_37 = new JSeparator();
		GridBagConstraints gbc_separator_37 = new GridBagConstraints();
		gbc_separator_37.insets = new Insets(0, 0, 5, 5);
		gbc_separator_37.gridx = 32;
		gbc_separator_37.gridy = 31;
		panel_1.add(separator_37, gbc_separator_37);
		
		JSeparator separator_38 = new JSeparator();
		GridBagConstraints gbc_separator_38 = new GridBagConstraints();
		gbc_separator_38.insets = new Insets(0, 0, 5, 5);
		gbc_separator_38.gridx = 33;
		gbc_separator_38.gridy = 31;
		panel_1.add(separator_38, gbc_separator_38);
		
		JSeparator separator_39 = new JSeparator();
		GridBagConstraints gbc_separator_39 = new GridBagConstraints();
		gbc_separator_39.insets = new Insets(0, 0, 5, 5);
		gbc_separator_39.gridx = 34;
		gbc_separator_39.gridy = 31;
		panel_1.add(separator_39, gbc_separator_39);
		
		JSeparator separator_40 = new JSeparator();
		GridBagConstraints gbc_separator_40 = new GridBagConstraints();
		gbc_separator_40.insets = new Insets(0, 0, 5, 5);
		gbc_separator_40.gridx = 35;
		gbc_separator_40.gridy = 31;
		panel_1.add(separator_40, gbc_separator_40);
		
		JSeparator separator_41 = new JSeparator();
		GridBagConstraints gbc_separator_41 = new GridBagConstraints();
		gbc_separator_41.insets = new Insets(0, 0, 5, 5);
		gbc_separator_41.gridx = 36;
		gbc_separator_41.gridy = 31;
		panel_1.add(separator_41, gbc_separator_41);
		
		JSeparator separator_42 = new JSeparator();
		GridBagConstraints gbc_separator_42 = new GridBagConstraints();
		gbc_separator_42.insets = new Insets(0, 0, 5, 5);
		gbc_separator_42.gridx = 37;
		gbc_separator_42.gridy = 31;
		panel_1.add(separator_42, gbc_separator_42);
		
		JSeparator separator_43 = new JSeparator();
		GridBagConstraints gbc_separator_43 = new GridBagConstraints();
		gbc_separator_43.insets = new Insets(0, 0, 5, 5);
		gbc_separator_43.gridx = 38;
		gbc_separator_43.gridy = 31;
		panel_1.add(separator_43, gbc_separator_43);
		
		JSeparator separator_36 = new JSeparator();
		GridBagConstraints gbc_separator_36 = new GridBagConstraints();
		gbc_separator_36.insets = new Insets(0, 0, 10, 10);
		gbc_separator_36.gridx = 39;
		gbc_separator_36.gridy = 31;
		panel_1.add(separator_36, gbc_separator_36);
		
		JButton btnJoinExistingOne = new JButton("Join Existing One");
		btnJoinExistingOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ConnectionToServer cs = new ConnectionToServer(ipAddress.getText(), 8080);
					String resp = cs.readFromClient();
					System.out.println(resp);
					cs.writeToServer("Fuck you!");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnJoinExistingOne.setFont(new Font("Tahoma", Font.PLAIN, 34));
		GridBagConstraints gbc_btnJoinExistingOne = new GridBagConstraints();
		gbc_btnJoinExistingOne.insets = new Insets(0, 0, 5, 5);
		gbc_btnJoinExistingOne.gridx = 40;
		gbc_btnJoinExistingOne.gridy = 31;
		panel_1.add(btnJoinExistingOne, gbc_btnJoinExistingOne);
		
		JSeparator separator_52 = new JSeparator();
		GridBagConstraints gbc_separator_52 = new GridBagConstraints();
		gbc_separator_52.insets = new Insets(0, 0, 0, 5);
		gbc_separator_52.gridx = 11;
		gbc_separator_52.gridy = 32;
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
