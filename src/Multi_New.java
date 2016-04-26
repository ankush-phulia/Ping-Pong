import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.net.SocketAddress;

import javax.swing.JLabel;
import javax.swing.JPanel;
import aurelienribon.tweenengine.TweenManager;
import network.LocalServer;
import slidinglayout.SLAnimator;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.JSlider;
import javax.swing.JSeparator;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JSpinner;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;


public class Multi_New extends JPanel implements ActionListener{

	LocalServer gameServer;	
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
	private SpinnerModel sm = new SpinnerNumberModel(0, 0, 31, 1);
	private SpinnerModel sm2 = new SpinnerNumberModel(0, 0, 31, 1);
	private SpinnerModel sm3 = new SpinnerNumberModel(0, 0, 31, 1);
	
	public Multi_New(LocalServer gs) {

		this.gameServer=gs;
		gs.acceptClient();
		gs.acceptClient();
		gs.acceptClient();
		System.out.println(LocalServer.getAllAvailableIP());
		
		populate_layout();		
	
		Timer timer = new Timer((int) (1000/60), this);
		timer.start();
		
	}

	private void populate_layout() {
		
		this.setAutoscrolls(true);
		final RXCardLayout cdl=new RXCardLayout(0, 0);
		cdl.setRequestFocusOnCard(true);
		setLayout(cdl);
		
		JPanel MenuPanel = new JPanel();		
		MenuPanel.setLayout(new BoxLayout(MenuPanel, BoxLayout.Y_AXIS));

		add(MenuPanel, "MenuPanel");		

		cdl.show(Multi_New.this, "MenuPanel");
		
//		Board game=new Board();
//		add(game,"Game");
//		cdl.show(Multi_New.this,"Game");
				
		JPanel SelectionPanel = new JPanel();	
		MenuPanel.add(SelectionPanel);
		GridBagLayout gbl_SelectionPanel = new GridBagLayout();
		gbl_SelectionPanel.columnWidths = new int[]{58, 0, 0, 307, 0, 249, 0, 289, 81, 0, 0};
		gbl_SelectionPanel.rowHeights = new int[]{33, 0, 0, 0, 0, -15, 0, 0, 0, 0, 0, 0, 0, 0, 0, 56, -78, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_SelectionPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_SelectionPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		SelectionPanel.setLayout(gbl_SelectionPanel);
		
		JLabel label = new JLabel("Multi Player");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 38));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.NORTH;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 5;
		gbc_label.gridy = 0;
		SelectionPanel.add(label, gbc_label);
		
		JSeparator separator_14 = new JSeparator();
		GridBagConstraints gbc_separator_14 = new GridBagConstraints();
		gbc_separator_14.insets = new Insets(0, 0, 25, 25);
		gbc_separator_14.gridx = 6;
		gbc_separator_14.gridy = 0;
		SelectionPanel.add(separator_14, gbc_separator_14);
		
		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.insets = new Insets(0, 0, 35, 35);
		gbc_separator.gridx = 5;
		gbc_separator.gridy = 1;
		SelectionPanel.add(separator, gbc_separator);
		
		JLabel label_1 = new JLabel("Paddle Position");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 34));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 3;
		gbc_label_1.gridy = 2;
		SelectionPanel.add(label_1, gbc_label_1);
		
		JComboBox<String> ownPosition = new JComboBox<String>();
		ownPosition.setFont(new Font("Tahoma", Font.PLAIN, 34));
		ownPosition.addItem("Left");
		ownPosition.addItem("Right");
		ownPosition.addItem("Top");
		ownPosition.addItem("Bottom");	
		GridBagConstraints gbc_ownPosition = new GridBagConstraints();
		gbc_ownPosition.fill = GridBagConstraints.HORIZONTAL;
		gbc_ownPosition.insets = new Insets(0, 0, 5, 5);
		gbc_ownPosition.gridx = 7;
		gbc_ownPosition.gridy = 2;
		SelectionPanel.add(ownPosition, gbc_ownPosition);
		
		JSeparator separator_5 = new JSeparator();
		GridBagConstraints gbc_separator_5 = new GridBagConstraints();
		gbc_separator_5.insets = new Insets(0, 0, 15, 15);
		gbc_separator_5.gridx = 3;
		gbc_separator_5.gridy = 3;
		SelectionPanel.add(separator_5, gbc_separator_5);
		
		JLabel label_2 = new JLabel("Number of Lives");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 34));
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 3;
		gbc_label_2.gridy = 4;
		SelectionPanel.add(label_2, gbc_label_2);
		
		JSlider ownLives = new JSlider(SwingConstants.HORIZONTAL, 1, 25, 5);
		ownLives.setPaintTicks(true);
		ownLives.setPaintLabels(true);
		ownLives.setMinorTickSpacing(1);
		ownLives.setMajorTickSpacing(3);
		ownLives.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_ownLives = new GridBagConstraints();
		gbc_ownLives.fill = GridBagConstraints.HORIZONTAL;
		gbc_ownLives.insets = new Insets(0, 0, 5, 5);
		gbc_ownLives.gridx = 7;
		gbc_ownLives.gridy = 4;
		SelectionPanel.add(ownLives, gbc_ownLives);
		
		JSeparator separator_23 = new JSeparator();
		GridBagConstraints gbc_separator_23 = new GridBagConstraints();
		gbc_separator_23.insets = new Insets(0, 0, 15, 15);
		gbc_separator_23.gridx = 3;
		gbc_separator_23.gridy = 5;
		SelectionPanel.add(separator_23, gbc_separator_23);
		
		JSeparator separator_7 = new JSeparator();
		GridBagConstraints gbc_separator_7 = new GridBagConstraints();
		gbc_separator_7.insets = new Insets(0, 0, 15, 15);
		gbc_separator_7.gridx = 3;
		gbc_separator_7.gridy = 6;
		SelectionPanel.add(separator_7, gbc_separator_7);
		
		JLabel lblGameMode = new JLabel("Game Mode");
		lblGameMode.setFont(new Font("Tahoma", Font.PLAIN, 34));
		GridBagConstraints gbc_lblGameMode = new GridBagConstraints();
		gbc_lblGameMode.insets = new Insets(0, 0, 5, 5);
		gbc_lblGameMode.gridx = 3;
		gbc_lblGameMode.gridy = 7;
		SelectionPanel.add(lblGameMode, gbc_lblGameMode);
		
		JComboBox<String> GameMode = new JComboBox<String>();
		GameMode.setFont(new Font("Tahoma", Font.PLAIN, 34));
		GameMode.addItem("Classic");
		GameMode.addItem("Arcade");
		GameMode.addItem("Endless");
		//GameMode.addItem("Many vs One");
		GridBagConstraints gbc_GameMode = new GridBagConstraints();
		gbc_GameMode.insets = new Insets(0, 0, 5, 5);
		gbc_GameMode.fill = GridBagConstraints.HORIZONTAL;
		gbc_GameMode.gridx = 7;
		gbc_GameMode.gridy = 7;
		SelectionPanel.add(GameMode, gbc_GameMode);
		
		JSeparator separator_8 = new JSeparator();
		GridBagConstraints gbc_separator_8 = new GridBagConstraints();
		gbc_separator_8.insets = new Insets(0, 0, 15, 15);
		gbc_separator_8.gridx = 3;
		gbc_separator_8.gridy = 8;
		SelectionPanel.add(separator_8, gbc_separator_8);
		
		JLabel lblNumberOfBalls = new JLabel("Number of Balls");
		lblNumberOfBalls.setFont(new Font("Tahoma", Font.PLAIN, 34));
		GridBagConstraints gbc_lblNumberOfBalls = new GridBagConstraints();
		gbc_lblNumberOfBalls.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumberOfBalls.gridx = 3;
		gbc_lblNumberOfBalls.gridy = 9;
		SelectionPanel.add(lblNumberOfBalls, gbc_lblNumberOfBalls);
		
		JSlider ball_Num = new JSlider(SwingConstants.HORIZONTAL, 1, 3, 1);
		ball_Num.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ball_Num.setPaintTicks(true);
		ball_Num.setPaintLabels(true);
		ball_Num.setMinorTickSpacing(1);
		ball_Num.setMajorTickSpacing(1);
		GridBagConstraints gbc_ball_Num = new GridBagConstraints();
		gbc_ball_Num.fill = GridBagConstraints.HORIZONTAL;
		gbc_ball_Num.insets = new Insets(0, 0, 5, 5);
		gbc_ball_Num.gridx = 7;
		gbc_ball_Num.gridy = 9;
		SelectionPanel.add(ball_Num, gbc_ball_Num);
		
		JSeparator separator_33 = new JSeparator();
		GridBagConstraints gbc_separator_33 = new GridBagConstraints();
		gbc_separator_33.insets = new Insets(0, 0, 15, 15);
		gbc_separator_33.gridx = 3;
		gbc_separator_33.gridy = 10;
		SelectionPanel.add(separator_33, gbc_separator_33);
		
		JLabel lblGameSpeed = new JLabel("Game Speed");
		lblGameSpeed.setFont(new Font("Tahoma", Font.PLAIN, 34));
		GridBagConstraints gbc_lblGameSpeed = new GridBagConstraints();
		gbc_lblGameSpeed.insets = new Insets(0, 0, 5, 5);
		gbc_lblGameSpeed.gridx = 3;
		gbc_lblGameSpeed.gridy = 11;
		SelectionPanel.add(lblGameSpeed, gbc_lblGameSpeed);
		
		JSlider spd = new JSlider(SwingConstants.HORIZONTAL, 1, 3, 1);
		spd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		spd.setPaintTicks(true);
		spd.setPaintLabels(true);
		spd.setMinorTickSpacing(1);
		spd.setMajorTickSpacing(1);
		GridBagConstraints gbc_spd = new GridBagConstraints();
		gbc_spd.fill = GridBagConstraints.HORIZONTAL;
		gbc_spd.insets = new Insets(0, 0, 5, 5);
		gbc_spd.gridx = 7;
		gbc_spd.gridy = 11;
		SelectionPanel.add(spd, gbc_spd);
		
		JSeparator separator_26 = new JSeparator();
		GridBagConstraints gbc_separator_26 = new GridBagConstraints();
		gbc_separator_26.insets = new Insets(0, 0, 15, 15);
		gbc_separator_26.gridx = 3;
		gbc_separator_26.gridy = 12;
		SelectionPanel.add(separator_26, gbc_separator_26);
		
		JLabel lblPowerupsEnabled = new JLabel("Powerups Enabled");
		lblPowerupsEnabled.setFont(new Font("Tahoma", Font.PLAIN, 34));
		GridBagConstraints gbc_lblPowerupsEnabled = new GridBagConstraints();
		gbc_lblPowerupsEnabled.insets = new Insets(0, 0, 5, 5);
		gbc_lblPowerupsEnabled.gridx = 3;
		gbc_lblPowerupsEnabled.gridy = 13;
		SelectionPanel.add(lblPowerupsEnabled, gbc_lblPowerupsEnabled);
		
		JCheckBox powerups = new JCheckBox("");
		powerups.setFont(new Font("Tahoma", Font.PLAIN, 34));
		GridBagConstraints gbc_powerups = new GridBagConstraints();
		gbc_powerups.insets = new Insets(0, 0, 5, 5);
		gbc_powerups.gridx = 7;
		gbc_powerups.gridy = 13;
		SelectionPanel.add(powerups, gbc_powerups);
		
		JSeparator separator_30 = new JSeparator();
		GridBagConstraints gbc_separator_30 = new GridBagConstraints();
		gbc_separator_30.insets = new Insets(0, 0, 15, 15);
		gbc_separator_30.gridx = 3;
		gbc_separator_30.gridy = 14;
		SelectionPanel.add(separator_30, gbc_separator_30);
		
		JLabel label_3 = new JLabel("PC Players");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 34));
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 3;
		gbc_label_3.gridy = 15;
		SelectionPanel.add(label_3, gbc_label_3);
		
		JSeparator separator_10 = new JSeparator();
		GridBagConstraints gbc_separator_10 = new GridBagConstraints();
		gbc_separator_10.insets = new Insets(0, 0, 15, 15);
		gbc_separator_10.gridx = 3;
		gbc_separator_10.gridy = 16;
		SelectionPanel.add(separator_10, gbc_separator_10);
		
		JLabel label_4 = new JLabel("Difficulty");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 34));
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 3;
		gbc_label_4.gridy = 17;
		SelectionPanel.add(label_4, gbc_label_4);
		
		JLabel label_5 = new JLabel("Lives");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 34));
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.insets = new Insets(0, 0, 5, 5);
		gbc_label_5.gridx = 5;
		gbc_label_5.gridy = 17;
		SelectionPanel.add(label_5, gbc_label_5);
		
		JLabel label_6 = new JLabel("Position");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 34));
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.insets = new Insets(0, 0, 5, 5);
		gbc_label_6.gridx = 7;
		gbc_label_6.gridy = 17;
		SelectionPanel.add(label_6, gbc_label_6);
		
		JSeparator separator_12 = new JSeparator();
		GridBagConstraints gbc_separator_12 = new GridBagConstraints();
		gbc_separator_12.insets = new Insets(0, 0, 15, 15);
		gbc_separator_12.gridx = 3;
		gbc_separator_12.gridy = 18;
		SelectionPanel.add(separator_12, gbc_separator_12);
		
		JLabel one = new JLabel("1");
		one.setFont(new Font("Tahoma", Font.PLAIN, 34));
		one.setVisible(true);
		GridBagConstraints gbc_one = new GridBagConstraints();
		gbc_one.anchor = GridBagConstraints.EAST;
		gbc_one.insets = new Insets(0, 0, 5, 5);
		gbc_one.gridx = 0;
		gbc_one.gridy = 19;
		SelectionPanel.add(one, gbc_one);
		
		JComboBox<String> Difficulty1 = new JComboBox<String>();
		Difficulty1.setFont(new Font("Tahoma", Font.PLAIN, 34));
		Difficulty1.setVisible(true);
		Difficulty1.addItem("");
		Difficulty1.addItem("Easy");
		Difficulty1.addItem("Medium");
		Difficulty1.addItem("Difficult");
		Difficulty1.addItem("Ridiculous");
		Difficulty1.addItem("WTF??!!");
		GridBagConstraints gbc_Difficulty1 = new GridBagConstraints();
		gbc_Difficulty1.fill = GridBagConstraints.HORIZONTAL;
		gbc_Difficulty1.insets = new Insets(0, 0, 5, 5);
		gbc_Difficulty1.gridx = 3;
		gbc_Difficulty1.gridy = 19;
		SelectionPanel.add(Difficulty1, gbc_Difficulty1);
		
		JSpinner Lives1 = new JSpinner(sm);
		Lives1.setFont(new Font("Tahoma", Font.PLAIN, 34));
		Lives1.setVisible(true);
		DefaultEditor edit=new JSpinner.DefaultEditor(Lives1);
		edit.setAlignmentX(RIGHT_ALIGNMENT);
		Lives1.setEditor(edit);
		GridBagConstraints gbc_Lives1 = new GridBagConstraints();
		gbc_Lives1.fill = GridBagConstraints.HORIZONTAL;
		gbc_Lives1.insets = new Insets(0, 0, 5, 5);
		gbc_Lives1.gridx = 5;
		gbc_Lives1.gridy = 19;
		SelectionPanel.add(Lives1, gbc_Lives1);
		
		JComboBox<String> Position1 = new JComboBox<String>();
		Position1.setFont(new Font("Tahoma", Font.PLAIN, 34));		
		Position1.setVisible(true);
		Position1.addItem("");	
		Position1.addItem("Right");		
		Position1.addItem("Top");
		Position1.addItem("Bottom");
		Position1.addItem("Left");	
		GridBagConstraints gbc_Position1 = new GridBagConstraints();
		gbc_Position1.fill = GridBagConstraints.HORIZONTAL;
		gbc_Position1.insets = new Insets(0, 0, 5, 5);
		gbc_Position1.gridx = 7;
		gbc_Position1.gridy = 19;
		SelectionPanel.add(Position1, gbc_Position1);
		
		JSeparator separator_15 = new JSeparator();
		GridBagConstraints gbc_separator_15 = new GridBagConstraints();
		gbc_separator_15.insets = new Insets(0, 0, 15, 15);
		gbc_separator_15.gridx = 3;
		gbc_separator_15.gridy = 20;
		SelectionPanel.add(separator_15, gbc_separator_15);
		
		JLabel two = new JLabel("2");
		two.setFont(new Font("Tahoma", Font.PLAIN, 34));
		two.setVisible(true);
		GridBagConstraints gbc_two = new GridBagConstraints();
		gbc_two.anchor = GridBagConstraints.EAST;
		gbc_two.insets = new Insets(0, 0, 5, 5);
		gbc_two.gridx = 0;
		gbc_two.gridy = 21;
		SelectionPanel.add(two, gbc_two);
		
		JSeparator separator_17 = new JSeparator();
		GridBagConstraints gbc_separator_17 = new GridBagConstraints();
		gbc_separator_17.insets = new Insets(0, 0, 15, 15);
		gbc_separator_17.gridx = 1;
		gbc_separator_17.gridy = 21;
		SelectionPanel.add(separator_17, gbc_separator_17);
		
		JSeparator separator_18 = new JSeparator();
		GridBagConstraints gbc_separator_18 = new GridBagConstraints();
		gbc_separator_18.insets = new Insets(0, 0, 15, 15);
		gbc_separator_18.gridx = 2;
		gbc_separator_18.gridy = 21;
		SelectionPanel.add(separator_18, gbc_separator_18);
		
		JComboBox<String> Difficulty2 = new JComboBox<String>();
		Difficulty2.setFont(new Font("Tahoma", Font.PLAIN, 34));
		Difficulty2.setVisible(true);
		Difficulty2.addItem("");
		Difficulty2.addItem("Easy");
		Difficulty2.addItem("Medium");
		Difficulty2.addItem("Difficult");
		Difficulty2.addItem("Ridiculous");
		Difficulty2.addItem("WTF??!!");
		GridBagConstraints gbc_Difficulty2 = new GridBagConstraints();
		gbc_Difficulty2.fill = GridBagConstraints.HORIZONTAL;
		gbc_Difficulty2.insets = new Insets(0, 0, 5, 5);
		gbc_Difficulty2.gridx = 3;
		gbc_Difficulty2.gridy = 21;
		SelectionPanel.add(Difficulty2, gbc_Difficulty2);
		
		JSeparator separator_21 = new JSeparator();
		GridBagConstraints gbc_separator_21 = new GridBagConstraints();
		gbc_separator_21.insets = new Insets(0, 0, 15, 15);
		gbc_separator_21.gridx = 4;
		gbc_separator_21.gridy = 21;
		SelectionPanel.add(separator_21, gbc_separator_21);
		
		JSpinner Lives2 = new JSpinner(sm2);
		Lives2.setFont(new Font("Tahoma", Font.PLAIN, 34));
		Lives2.setVisible(true);
		DefaultEditor edit2=new JSpinner.DefaultEditor(Lives2);
		edit2.setAlignmentX(RIGHT_ALIGNMENT);
		Lives2.setEditor(edit2);
		GridBagConstraints gbc_Lives2 = new GridBagConstraints();
		gbc_Lives2.fill = GridBagConstraints.HORIZONTAL;
		gbc_Lives2.insets = new Insets(0, 0, 5, 5);
		gbc_Lives2.gridx = 5;
		gbc_Lives2.gridy = 21;
		SelectionPanel.add(Lives2, gbc_Lives2);
		
		JComboBox<String> Position2 = new JComboBox<String>();
		Position2.setFont(new Font("Tahoma", Font.PLAIN, 34));
		Position2.setVisible(true);
		Position2.addItem("");
		Position2.addItem("Top");
		Position2.addItem("Bottom");
		Position2.addItem("Left");
		Position2.addItem("Right");
		GridBagConstraints gbc_Position2 = new GridBagConstraints();
		gbc_Position2.fill = GridBagConstraints.HORIZONTAL;
		gbc_Position2.insets = new Insets(0, 0, 5, 5);
		gbc_Position2.gridx = 7;
		gbc_Position2.gridy = 21;
		SelectionPanel.add(Position2, gbc_Position2);
		
		JSeparator separator_19 = new JSeparator();
		GridBagConstraints gbc_separator_19 = new GridBagConstraints();
		gbc_separator_19.insets = new Insets(0, 0, 15, 15);
		gbc_separator_19.gridx = 3;
		gbc_separator_19.gridy = 22;
		SelectionPanel.add(separator_19, gbc_separator_19);
		
		JLabel three = new JLabel("3");
		three.setFont(new Font("Tahoma", Font.PLAIN, 34));
		three.setVisible(true);
		GridBagConstraints gbc_three = new GridBagConstraints();
		gbc_three.anchor = GridBagConstraints.EAST;
		gbc_three.insets = new Insets(0, 0, 0, 5);
		gbc_three.gridx = 0;
		gbc_three.gridy = 23;
		SelectionPanel.add(three, gbc_three);
		
		JComboBox<String> Difficulty3 = new JComboBox<String>();
		Difficulty3.setFont(new Font("Tahoma", Font.PLAIN, 34));
		Difficulty3.setVisible(true);
		Difficulty3.addItem("");
		Difficulty3.addItem("Easy");
		Difficulty3.addItem("Medium");
		Difficulty3.addItem("Difficult");
		Difficulty3.addItem("Ridiculous");
		Difficulty3.addItem("WTF??!!");
		GridBagConstraints gbc_Difficulty3 = new GridBagConstraints();
		gbc_Difficulty3.fill = GridBagConstraints.HORIZONTAL;
		gbc_Difficulty3.insets = new Insets(0, 0, 0, 5);
		gbc_Difficulty3.gridx = 3;
		gbc_Difficulty3.gridy = 23;
		SelectionPanel.add(Difficulty3, gbc_Difficulty3);
		
		JSpinner Lives3 = new JSpinner(sm3);
		Lives3.setFont(new Font("Tahoma", Font.PLAIN, 34));
		Lives3.setVisible(true);
		DefaultEditor edit3=new JSpinner.DefaultEditor(Lives3);
		edit3.setAlignmentX(RIGHT_ALIGNMENT);
		Lives3.setEditor(edit3);
		GridBagConstraints gbc_Lives3 = new GridBagConstraints();
		gbc_Lives3.fill = GridBagConstraints.HORIZONTAL;
		gbc_Lives3.insets = new Insets(0, 0, 0, 5);
		gbc_Lives3.gridx = 5;
		gbc_Lives3.gridy = 23;
		SelectionPanel.add(Lives3, gbc_Lives3);
		
		JComboBox<String> Position3 = new JComboBox<String>();
		Position3.setFont(new Font("Tahoma", Font.PLAIN, 34));
		Position3.setVisible(true);
		Position3.addItem("");		
		Position3.addItem("Bottom");
		Position3.addItem("Left");
		Position3.addItem("Right");
		Position3.addItem("Top");
		GridBagConstraints gbc_Position3 = new GridBagConstraints();
		gbc_Position3.fill = GridBagConstraints.HORIZONTAL;
		gbc_Position3.insets = new Insets(0, 0, 0, 5);
		gbc_Position3.gridx = 7;
		gbc_Position3.gridy = 23;
		SelectionPanel.add(Position3, gbc_Position3);
		
//		JSlider PCpl = new JSlider(SwingConstants.HORIZONTAL, 1, 3, 1);
//		PCpl.addPropertyChangeListener(new PropertyChangeListener() {
//			public void propertyChange(PropertyChangeEvent evt) {
//				switch(PCpl.getValue()){
//				case 1:
//					one.setVisible(true);
//					Position1.setVisible(true);
//					Lives1.setVisible(true);
//					Difficulty1.setVisible(true);
//					two.setVisible(true);
//					Position2.setVisible(true);
//					Lives2.setVisible(true);
//					Difficulty2.setVisible(true);
//					three.setVisible(true);
//					Position3.setVisible(true);
//					Lives3.setVisible(true);
//					Difficulty3.setVisible(true);
//					//repaint();
//					break;
//				case 2:
//					one.setVisible(true);
//					Position1.setVisible(true);
//					Lives1.setVisible(true);
//					Difficulty1.setVisible(true);
//					two.setVisible(true);
//					Position2.setVisible(true);
//					Lives2.setVisible(true);
//					Difficulty2.setVisible(true);
//					three.setVisible(true);
//					Position3.setVisible(true);
//					Lives3.setVisible(true);
//					Difficulty3.setVisible(true);
//					//repaint();
//					break;
//				case 3:
//					one.setVisible(true);
//					Position1.setVisible(true);
//					Lives1.setVisible(true);
//					Difficulty1.setVisible(true);
//					two.setVisible(true);
//					Position2.setVisible(true);
//					Lives2.setVisible(true);
//					Difficulty2.setVisible(true);
//					three.setVisible(true);
//					Position3.setVisible(true);
//					Lives3.setVisible(true);
//					Difficulty3.setVisible(true);
//					//repaint();
//					break;
//				}
//				repaint();
//			}
//		});
//		PCpl.setPaintTicks(true);
//		PCpl.setPaintLabels(true);
//		PCpl.setMinorTickSpacing(1);
//		PCpl.setMajorTickSpacing(1);
//		PCpl.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		GridBagConstraints gbc_PCpl = new GridBagConstraints();
//		gbc_PCpl.fill = GridBagConstraints.HORIZONTAL;
//		gbc_PCpl.insets = new Insets(0, 0, 5, 5);
//		gbc_PCpl.gridx = 10;
//		gbc_PCpl.gridy = 20;
//		SelectionPanel.add(PCpl, gbc_PCpl);
		
		JPanel ButtonPanel = new JPanel();
		MenuPanel.add(ButtonPanel);		
		JButton button = new JButton("Back to Multiplayer Menu");
		button.setFont(new Font("Tahoma", Font.PLAIN, 34));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RXCardLayout cdl=(RXCardLayout) getParent().getLayout();
				cdl.show(getParent(), "Multiplayer");
			}
		});
		ButtonPanel.add(button);
		
		JButton button_1 = new JButton("Start a New Game");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SocketAddress firstClient = gameServer.getAllClients().get(0);
				gameServer.writeToClient(firstClient, "Yo Bitch Client!");
				String resp = gameServer.readFromClient(firstClient);
				System.out.println(resp);
				
				/*Board game = new Board((String)ownPosition.getSelectedItem(),ownLives.getValue(),
						(String)GameMode.getSelectedItem(),ball_Num.getValue(),spd.getValue(),powerups.isSelected(),
						(String)Difficulty1.getSelectedItem(),(Integer)Lives1.getValue(),(String)Position1.getSelectedItem(),
						(String)Difficulty2.getSelectedItem(),(Integer)Lives2.getValue(),(String)Position2.getSelectedItem(),
						(String)Difficulty3.getSelectedItem(),(Integer)Lives3.getValue(),(String)Position3.getSelectedItem(),getWindowAncestor().keys);
				//Board game = new Board();
				add(game,"Game");
				cdl.show(Multi_New.this, "Game");
				game.requestFocusInWindow();
				//cdl.last(Multi_New.this);
				//requestFocusInWindow();*/
			}
		});
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 34));
		ButtonPanel.add(button_1);
			
		
	}
	
	public Main_Frame getWindowAncestor(){		
		Main_Frame topFrame = (Main_Frame) SwingUtilities.getWindowAncestor(this);
		return topFrame;
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		repaint();
	}
}
