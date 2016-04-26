import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;
import slidinglayout.SLAnimator;
import java.awt.Font;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.GridBagConstraints;
import javax.swing.JSeparator;
import java.awt.Insets;
import javax.swing.JComboBox;

public class Options extends JPanel {

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
	private String[] Keys1=new String[] {"Q","A","Z","W","S","X","E","D","C","R","F","V",
			"T","G","B","Y","H","N","U","J","M","UP","DOWN"};
	private String[] Keys2=new String[] {"A","Z","W","S","X","E","D","C","R","F","V",
			"T","G","B","Y","H","N","U","J","M","UP","DOWN","Q"};
	private String[] Keys3=new String[] {"Z","W","S","X","E","D","C","R","F","V",
			"T","G","B","Y","H","N","U","J","M","UP","DOWN","Q","A"};
	private String[] Keys4=new String[] {"UP","DOWN","Q","A","Z","W","S","X","E","D","C","R","F","V",
			"T","G","B","Y","H","N","U","J","M",};
	private String[] Keys5=new String[] {"DOWN","Q","A","Z","W","S","X","E","D","C","R","F","V",
			"T","G","B","Y","H","N","U","J","M","UP"};
	private String[] Keys6=new String[] {"M","UP","DOWN","Q","A","Z","W","S","X","E","D","C","R","F","V",
			"T","G","B","Y","H","N","U","J"};
	
	public Options() {
		
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
				if (action != null && actionEnabled && !expanded)action.run();
				if (!expanded){
					removeAll();
					populate_layout();
				}
				else{
					/*removeAll();
					show_small();*/
				}
			}
		});
	}
	
	private void show_small() {
		setLayout(new BorderLayout(0, 0));		
		JLabel lblOptions = new JLabel("Options");
		lblOptions.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblOptions.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblOptions, BorderLayout.CENTER);
		
	}

	private void populate_layout() {
		this.setAutoscrolls(true);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblOptions_1 = new JLabel("Options");
		lblOptions_1.setFont(new Font("Tahoma", Font.PLAIN, 38));
		panel.add(lblOptions_1);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 165, 181, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.insets = new Insets(25, 0, 25, 25);
		gbc_separator.gridx = 25;
		gbc_separator.gridy = 0;
		panel_1.add(separator, gbc_separator);
		
		JLabel lblTopControls = new JLabel("Player Controls");
		lblTopControls.setFont(new Font("Tahoma", Font.PLAIN, 34));
		GridBagConstraints gbc_lblTopControls = new GridBagConstraints();
		gbc_lblTopControls.insets = new Insets(0, 0, 5, 5);
		gbc_lblTopControls.gridx = 14;
		gbc_lblTopControls.gridy = 4;
		panel_1.add(lblTopControls, gbc_lblTopControls);

		JSeparator separator_36 = new JSeparator();
		GridBagConstraints gbc_separator_36 = new GridBagConstraints();
		gbc_separator_36.insets = new Insets(0, 0, 25, 25);
		gbc_separator_36.gridx = 10;
		gbc_separator_36.gridy = 8;
		panel_1.add(separator_36, gbc_separator_36);
		
		JLabel lblUpMovement = new JLabel("Up Movement");
		lblUpMovement.setFont(new Font("Tahoma", Font.PLAIN, 32));
		GridBagConstraints gbc_lblUpMovement = new GridBagConstraints();
		gbc_lblUpMovement.insets = new Insets(0, 0, 5, 5);
		gbc_lblUpMovement.gridx = 14;
		gbc_lblUpMovement.gridy = 8;
		panel_1.add(lblUpMovement, gbc_lblUpMovement);
		
		JSeparator separator_14 = new JSeparator();
		GridBagConstraints gbc_separator_14 = new GridBagConstraints();
		gbc_separator_14.insets = new Insets(0, 0, 25, 25);
		gbc_separator_14.gridx = 16;
		gbc_separator_14.gridy = 8;
		panel_1.add(separator_14, gbc_separator_14);

		
		final JComboBox<String> up1 = new JComboBox<String>(Keys1);
		up1.setFont(new Font("Tahoma", Font.PLAIN, 32));
		if (getWindowAncestor().keys[0]==26){
			up1.setSelectedItem("UP");
		}
		else if (getWindowAncestor().keys[0]==28){
			up1.setSelectedItem("DOWN");
		}
		else{
			up1.setSelectedItem(String.valueOf(((char)(getWindowAncestor().keys[0]))));
		}		
		//System.out.println((char) getWindowAncestor().keys[0]);
		GridBagConstraints gbc_up1 = new GridBagConstraints();
		gbc_up1.fill = GridBagConstraints.HORIZONTAL;
		gbc_up1.insets = new Insets(0, 0, 5, 5);
		gbc_up1.gridx = 29;
		gbc_up1.gridy = 8;
		panel_1.add(up1, gbc_up1);
		
		JSeparator separator_7 = new JSeparator();
		GridBagConstraints gbc_separator_7 = new GridBagConstraints();
		gbc_separator_7.insets = new Insets(0, 0, 25, 25);
		gbc_separator_7.gridx = 14;
		gbc_separator_7.gridy = 9;
		panel_1.add(separator_7, gbc_separator_7);

		JLabel lblDownMovement = new JLabel("Down Movement");
		lblDownMovement.setFont(new Font("Tahoma", Font.PLAIN, 32));
		GridBagConstraints gbc_lblDownMovement = new GridBagConstraints();
		gbc_lblDownMovement.insets = new Insets(0, 0, 5, 5);
		gbc_lblDownMovement.gridx = 14;
		gbc_lblDownMovement.gridy = 11;
		panel_1.add(lblDownMovement, gbc_lblDownMovement);
		
		JSeparator separator_18 = new JSeparator();
		GridBagConstraints gbc_separator_18 = new GridBagConstraints();
		gbc_separator_18.insets = new Insets(0, 0, 25, 25);
		gbc_separator_18.gridx = 19;
		gbc_separator_18.gridy = 11;
		panel_1.add(separator_18, gbc_separator_18);
		
		final JComboBox<String> down1 = new JComboBox<String>(Keys2);
		down1.setFont(new Font("Tahoma", Font.PLAIN, 32));
		if (getWindowAncestor().keys[1]==26){
			down1.setSelectedItem("UP");
		}
		else if (getWindowAncestor().keys[1]==28){
			down1.setSelectedItem("DOWN");
		}
		else{
			down1.setSelectedItem(String.valueOf(((char)(getWindowAncestor().keys[1]))));
		}
		GridBagConstraints gbc_down1 = new GridBagConstraints();
		gbc_down1.insets = new Insets(0, 0, 5, 5);
		gbc_down1.fill = GridBagConstraints.HORIZONTAL;
		gbc_down1.gridx = 29;
		gbc_down1.gridy = 11;
		panel_1.add(down1, gbc_down1);
		
		JSeparator separator_9 = new JSeparator();
		GridBagConstraints gbc_separator_9 = new GridBagConstraints();
		gbc_separator_9.insets = new Insets(0, 0, 25, 25);
		gbc_separator_9.gridx = 14;
		gbc_separator_9.gridy = 12;
		panel_1.add(separator_9, gbc_separator_9);
			
		JLabel lblActivate = new JLabel("Activate");
		lblActivate.setFont(new Font("Tahoma", Font.PLAIN, 32));
		GridBagConstraints gbc_lblActivate = new GridBagConstraints();
		gbc_lblActivate.insets = new Insets(0, 0, 5, 5);
		gbc_lblActivate.gridx = 14;
		gbc_lblActivate.gridy = 14;
		panel_1.add(lblActivate, gbc_lblActivate);
		
		JSeparator separator_32 = new JSeparator();
		GridBagConstraints gbc_separator_32 = new GridBagConstraints();
		gbc_separator_32.insets = new Insets(0, 0, 25, 25);
		gbc_separator_32.gridx = 18;
		gbc_separator_32.gridy = 14;
		panel_1.add(separator_32, gbc_separator_32);
		
		JComboBox<String> act1 = new JComboBox<String>(Keys3);
		if (getWindowAncestor().keys[2]==26){
			act1.setSelectedItem("UP");
		}
		else if (getWindowAncestor().keys[2]==28){
			act1.setSelectedItem("DOWN");
		}
		else{
			act1.setSelectedItem(String.valueOf(((char)(getWindowAncestor().keys[2]))));
		}
		act1.setFont(new Font("Tahoma", Font.PLAIN, 32));
		GridBagConstraints gbc_act1 = new GridBagConstraints();
		gbc_act1.insets = new Insets(0, 0, 5, 5);
		gbc_act1.fill = GridBagConstraints.HORIZONTAL;
		gbc_act1.gridx = 29;
		gbc_act1.gridy = 14;
		panel_1.add(act1, gbc_act1);
		
		JSeparator separator_49 = new JSeparator();
		GridBagConstraints gbc_separator_49 = new GridBagConstraints();
		gbc_separator_49.insets = new Insets(0, 0, 25, 25);
		gbc_separator_49.gridx = 14;
		gbc_separator_49.gridy = 25;
		panel_1.add(separator_49, gbc_separator_49);
		
		
		JLabel lblPlayerControls = new JLabel("Player 2 Controls");
		lblPlayerControls.setFont(new Font("Tahoma", Font.PLAIN, 34));
		GridBagConstraints gbc_lblPlayerControls = new GridBagConstraints();
		gbc_lblPlayerControls.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlayerControls.gridx = 14;
		gbc_lblPlayerControls.gridy = 22;
		panel_1.add(lblPlayerControls, gbc_lblPlayerControls);
		
		JSeparator separator_42 = new JSeparator();
		GridBagConstraints gbc_separator_42 = new GridBagConstraints();
		gbc_separator_42.insets = new Insets(0, 0, 25, 25);
		gbc_separator_42.gridx = 14;
		gbc_separator_42.gridy = 23;
		panel_1.add(separator_42, gbc_separator_42);
		
		
		JLabel lblUpMovement1 = new JLabel("Up Movement");
		lblUpMovement1.setFont(new Font("Tahoma", Font.PLAIN, 32));
		GridBagConstraints gbc_lblUpMovement1 = new GridBagConstraints();
		gbc_lblUpMovement1.insets = new Insets(0, 0, 5, 5);
		gbc_lblUpMovement1.gridx = 14;
		gbc_lblUpMovement1.gridy = 26;
		panel_1.add(lblUpMovement1, gbc_lblUpMovement1);
		
		final JComboBox<String> up2 = new JComboBox<String>(Keys4);
		up2.setFont(new Font("Tahoma", Font.PLAIN, 32));
		if (getWindowAncestor().keys[3]==26){
			up2.setSelectedItem("UP");
		}
		else if (getWindowAncestor().keys[3]==28){
			up2.setSelectedItem("DOWN");
		}
		else{
			up2.setSelectedItem(String.valueOf(((char)(getWindowAncestor().keys[3]))));
		}
		GridBagConstraints gbc_up2 = new GridBagConstraints();
		gbc_up2.insets = new Insets(0, 0, 5, 5);
		gbc_up2.fill = GridBagConstraints.HORIZONTAL;
		gbc_up2.gridx = 29;
		gbc_up2.gridy = 26;
		panel_1.add(up2, gbc_up2);
		
		JSeparator separator_45 = new JSeparator();
		GridBagConstraints gbc_separator_45 = new GridBagConstraints();
		gbc_separator_45.insets = new Insets(0, 0, 25, 25);
		gbc_separator_45.gridx = 14;
		gbc_separator_45.gridy = 27;
		panel_1.add(separator_45, gbc_separator_45);

		JLabel lblDownMovement1 = new JLabel("Down Movement");
		lblDownMovement1.setFont(new Font("Tahoma", Font.PLAIN, 32));
		GridBagConstraints gbc_lblDownMovement1 = new GridBagConstraints();
		gbc_lblDownMovement1.insets = new Insets(0, 0, 5, 5);
		gbc_lblDownMovement1.gridx = 14;
		gbc_lblDownMovement1.gridy = 29;
		panel_1.add(lblDownMovement1, gbc_lblDownMovement1);
		
		final JComboBox<String> down2 = new JComboBox<String>(Keys5);
		down2.setFont(new Font("Tahoma", Font.PLAIN, 32));
		if (getWindowAncestor().keys[4]==26){
			down2.setSelectedItem("UP");
		}
		else if (getWindowAncestor().keys[4]==28){
			down2.setSelectedItem("DOWN");
		}
		else{
			down2.setSelectedItem(String.valueOf(((char)(getWindowAncestor().keys[4]))));
		}GridBagConstraints gbc_down2 = new GridBagConstraints();
		gbc_down2.insets = new Insets(0, 0, 5, 5);
		gbc_down2.fill = GridBagConstraints.HORIZONTAL;
		gbc_down2.gridx = 29;
		gbc_down2.gridy = 29;
		panel_1.add(down2, gbc_down2);
		
		JSeparator separator_47 = new JSeparator();
		GridBagConstraints gbc_separator_47 = new GridBagConstraints();
		gbc_separator_47.insets = new Insets(0, 0, 25, 25);
		gbc_separator_47.gridx = 14;
		gbc_separator_47.gridy = 30;
		panel_1.add(separator_47, gbc_separator_47);
	
		
		JLabel lblActivate1 = new JLabel("Activate");
		lblActivate1.setFont(new Font("Tahoma", Font.PLAIN, 32));
		GridBagConstraints gbc_lblActivate1 = new GridBagConstraints();
		gbc_lblActivate1.insets = new Insets(0, 0, 0, 5);
		gbc_lblActivate1.gridx = 14;
		gbc_lblActivate1.gridy = 32;
		panel_1.add(lblActivate1, gbc_lblActivate1);
		
		JComboBox<String> act2 = new JComboBox<String>(Keys6);
		act2.setFont(new Font("Tahoma", Font.PLAIN, 32));
		if (getWindowAncestor().keys[5]==26){
			act2.setSelectedItem("UP");
		}
		else if (getWindowAncestor().keys[5]==28){
			act2.setSelectedItem("DOWN");
		}
		else{
			act2.setSelectedItem(String.valueOf(((char)(getWindowAncestor().keys[5]))));
		}
		GridBagConstraints gbc_act2 = new GridBagConstraints();
		gbc_act2.insets = new Insets(0, 0, 0, 5);
		gbc_act2.fill = GridBagConstraints.HORIZONTAL;
		gbc_act2.gridx = 29;
		gbc_act2.gridy = 32;
		panel_1.add(act2, gbc_act2);
		
		JPanel panel_2 = new JPanel();
		add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnBackToMain = new JButton("Back to Main Menu");
		btnBackToMain.setFont(new Font("Tahoma", Font.PLAIN, 34));
		btnBackToMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeAll();
				show_small();
				action.run();
			}
		});
		panel_2.add(btnBackToMain);
		
		JButton btnSaveChanges = new JButton("Save Current Settings");
		btnSaveChanges.setFont(new Font("Tahoma", Font.PLAIN, 34));
		btnSaveChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getWindowAncestor().keys[0]=convert((String)up1.getSelectedItem());
				getWindowAncestor().keys[1]=convert((String)down1.getSelectedItem());
				getWindowAncestor().keys[2]=convert((String)act1.getSelectedItem());
				getWindowAncestor().keys[3]=convert((String)up2.getSelectedItem());
				getWindowAncestor().keys[4]=convert((String)down2.getSelectedItem());
				getWindowAncestor().keys[5]=convert((String)act2.getSelectedItem());
				removeAll();
				show_small();
				action.run();
			}
		});
		panel_2.add(btnSaveChanges);
	}
	
	public Main_Frame getWindowAncestor(){		
		Main_Frame topFrame = (Main_Frame) SwingUtilities.getWindowAncestor(this);
		return topFrame;
	}
	
	public int convert(String s){
		if (s.equals("UP")){
			return KeyEvent.VK_UP;
		}
		else if (s.equals("DOWN")){
				return KeyEvent.VK_DOWN;
		}
		else{
			Character c=s.toCharArray()[0];
			return Character.getNumericValue(c)+55;
		}
		
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
			Options tp = (Options) target;

			int ret = super.getValues(target, tweenType, returnValues);
			if (ret >= 0) return ret;

			switch (tweenType) {
				case BORDER_THICKNESS: returnValues[0] = tp.borderThickness; return 1;
				default: return -1;
			}
		}

		@Override
		public void setValues(Component target, int tweenType, float[] newValues) {
			Options tp = (Options) target;

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
