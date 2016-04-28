package play;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.net.InetAddress;

import javax.swing.JLabel;
import javax.swing.JPanel;
import network.LocalServer;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.JSlider;
import javax.swing.JSeparator;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComboBox;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JCheckBox;


public class Multi_New extends JPanel implements ActionListener{

	LocalServer gameServer;
	List<Thread> clientsThread = new ArrayList<>();

	boolean expanded=false;
	private static final Color FG_COLOR = new Color(0xFFFFFF);
	private static final Color BG_COLOR = new Color(0x3B5998);
	private static final Color BORDER_COLOR = new Color(0x000000);
	private BufferedImage bgImg;
	private int borderThickness = 1;	

	public Multi_New(LocalServer gs) {

		this.gameServer = gs;
		takeEntry();
		
		populate_layout();		
	
		Timer timer = new Timer((int) (1000/60), this);
		timer.start();

	}

	private void takeEntry() {
		
		clientsThread.add(gameServer.acceptClient());
		clientsThread.add(gameServer.acceptClient());
		clientsThread.add(gameServer.acceptClient());
		
		System.out.println(LocalServer.getAllAvailableIP());
	}

	private void populate_layout() {
		
		this.setAutoscrolls(true);
		final RXCardLayout cdl = new RXCardLayout(0, 0);
		cdl.setRequestFocusOnCard(true);
		setLayout(cdl);
		
		JPanel MenuPanel = new JPanel();		
		MenuPanel.setLayout(new BoxLayout(MenuPanel, BoxLayout.Y_AXIS));

		add(MenuPanel, "MenuPanel");		

		cdl.show(Multi_New.this, "MenuPanel");

				
		JPanel SelectionPanel = new JPanel();	
		MenuPanel.add(SelectionPanel);
		GridBagLayout gbl_SelectionPanel = new GridBagLayout();
		gbl_SelectionPanel.columnWidths = new int[]{58, 0, 0, 307, 0, 249, 0, 289, 81, 0, 0};
		gbl_SelectionPanel.rowHeights = new int[]{33, 0, 0, 0, 0, -15, 0, 0, 0, 0, 0, 0, 0, 0, 0, 56, 0, 0, 0, 0, 0};
		gbl_SelectionPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_SelectionPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
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
		
		JLabel label_1 = new JLabel("play.Paddle Position");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 34));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 3;
		gbc_label_1.gridy = 2;
		SelectionPanel.add(label_1, gbc_label_1);
		
		final JComboBox<String> ownPosition = new JComboBox<String>();
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
		
		final JSlider ownLives = new JSlider(SwingConstants.HORIZONTAL, 1, 25, 5);
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
		
		final JComboBox<String> GameMode = new JComboBox<String>();
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
		
		final JSlider ball_Num = new JSlider(SwingConstants.HORIZONTAL, 1, 3, 1);
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
		
		final JSlider spd = new JSlider(SwingConstants.HORIZONTAL, 1, 3, 1);
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
		
		JSeparator separator_2 = new JSeparator();
		GridBagConstraints gbc_separator_2 = new GridBagConstraints();
		gbc_separator_2.insets = new Insets(0, 0, 15, 15);
		gbc_separator_2.gridx = 3;
		gbc_separator_2.gridy = 12;
		SelectionPanel.add(separator_2, gbc_separator_2);
		
		JLabel lblPowerupsEnabled = new JLabel("Powerups Enabled");
		lblPowerupsEnabled.setFont(new Font("Tahoma", Font.PLAIN, 34));
		GridBagConstraints gbc_lblPowerupsEnabled = new GridBagConstraints();
		gbc_lblPowerupsEnabled.insets = new Insets(0, 0, 5, 5);
		gbc_lblPowerupsEnabled.gridx = 3;
		gbc_lblPowerupsEnabled.gridy = 13;
		SelectionPanel.add(lblPowerupsEnabled, gbc_lblPowerupsEnabled);
		
		final JCheckBox powerups = new JCheckBox("");
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
		
		JLabel lblPlayer = new JLabel("Player 2");
		lblPlayer.setFont(new Font("Tahoma", Font.PLAIN, 34));
		GridBagConstraints gbc_lblPlayer = new GridBagConstraints();
		gbc_lblPlayer.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlayer.gridx = 3;
		gbc_lblPlayer.gridy = 15;
		SelectionPanel.add(lblPlayer, gbc_lblPlayer);
		
		final JCheckBox Player2 = new JCheckBox("");
		Player2.setFont(new Font("Tahoma", Font.PLAIN, 34));
		GridBagConstraints gbc_Player2 = new GridBagConstraints();
		gbc_Player2.insets = new Insets(0, 0, 5, 5);
		gbc_Player2.gridx = 7;
		gbc_Player2.gridy = 15;
		SelectionPanel.add(Player2, gbc_Player2);
		
		JSeparator separator_1 = new JSeparator();
		GridBagConstraints gbc_separator_1 = new GridBagConstraints();
		gbc_separator_1.insets = new Insets(0, 0, 15, 15);
		gbc_separator_1.gridx = 3;
		gbc_separator_1.gridy = 16;
		SelectionPanel.add(separator_1, gbc_separator_1);
		
		JLabel lblPlayerTwo = new JLabel("PC Players");
		lblPlayerTwo.setFont(new Font("Tahoma", Font.PLAIN, 34));
		GridBagConstraints gbc_lblPlayerTwo = new GridBagConstraints();
		gbc_lblPlayerTwo.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlayerTwo.gridx = 3;
		gbc_lblPlayerTwo.gridy = 17;
		SelectionPanel.add(lblPlayerTwo, gbc_lblPlayerTwo);
		
		final JCheckBox PCpl = new JCheckBox("");
		GridBagConstraints gbc_PCpl = new GridBagConstraints();
		gbc_PCpl.insets = new Insets(0, 0, 5, 5);
		gbc_PCpl.gridx = 7;
		gbc_PCpl.gridy = 17;
		SelectionPanel.add(PCpl, gbc_PCpl);


		JPanel ButtonPanel = new JPanel();
		MenuPanel.add(ButtonPanel);		
		JButton button = new JButton("Back to Multiplayer Menu");
		button.setFont(new Font("Tahoma", Font.PLAIN, 34));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				RXCardLayout cdl = (RXCardLayout) getParent().getLayout();

				if (gameServer != null) {
					gameServer.disconnect();

					if (!gameServer.alive()) {
						removeAll();
						cdl.show(getParent(), "Multiplayer");
					}
				}
				else {
					removeAll();
					cdl.show(getParent(), "Multiplayer");
				}

			}
		});
		ButtonPanel.add(button);
		
		JButton button_1 = new JButton("Start a New Game");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				while (!clientsThread.isEmpty()) {
					clientsThread.get(0).stop();
					clientsThread.remove(0);
				}
				
				List<InetAddress> l = gameServer.getAllClients();

				String startData = "START:"+(String)ownPosition.getSelectedItem()+":"+
						((Integer)ownLives.getValue())+":"+(String)GameMode.getSelectedItem()+":"+
						((Integer)ball_Num.getValue())+":"+((Integer)spd.getValue())+":"+
						((Boolean)powerups.isSelected()+":"+((Boolean)PCpl.isSelected()));
				
				int k=get_pos((String)ownPosition.getSelectedItem());
				
				boolean[] isPC = new boolean[] {true,true,true,true};
				isPC[k]=false;				
				
				startData += ":"+l.size();
				for (int i=0; i< l.size(); i++){
					InetAddress ip = l.get(i);
					startData += ":"+ip+","+((k+i+1)%4);
					isPC[(k+i+1)%4]=false;
				}
				
				for (int i=0; i<4;i++){
/*					if (isPC[i]){
						isPC[i]=(PCpl.isSelected());
						
					}*/
					startData += ":"+(Boolean)isPC[i];
				}

				gameServer.writeToAllClients(startData);
				
				BoardMulti game = new BoardMulti(gameServer,getWidth(),getHeight(),(String)ownPosition.getSelectedItem(),ownLives.getValue(),
						(String)GameMode.getSelectedItem(),ball_Num.getValue(),spd.getValue(),powerups.isSelected(),Player2.isSelected()
						,getWindowAncestor().keys,isPC,PCpl.isSelected(),(ArrayList<InetAddress>) gameServer.getAllClients());

				add(game,"Game");
				cdl.show(Multi_New.this, "Game");
				game.requestFocusInWindow();
			}
		});
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 34));
		ButtonPanel.add(button_1);
			
		
	}
	
	private int get_pos(String position) {
		switch (position){
			case "Left":
				return 0;
		    case "Right":
				return 1;
			case "Top":
				return 2;
			case "Bottom":
				return 3;
			}
		return 0;
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
		List<InetAddress> otherConnectedPlayers = gameServer.getAllClients();
		for (InetAddress ip : otherConnectedPlayers) {
			String resp = gameServer.readFromClient(ip);
			parseResponse(resp);
		}

		repaint();
	}


	private void parseResponse (String response) {
		if (response == null)
			return;

		String[] tokens = response.split(":");
		switch (tokens[0]) {
			/*case "MYIP":
				String ipOfClient = tokens[1];
				gameServer.writeToAllClients("CONNECTTOIP:" + ipOfClient);
				break;*/
			default:

		}
	}
}
