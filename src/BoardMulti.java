import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;


public class BoardMulti extends JPanel implements ActionListener, KeyListener{
	
	//game screens
	public String state;
	Timer timer;
	//public boolean route2=false;
    
    //AESTHETICS
	public double Xdim;
	public double Ydim;
    public Color bgcolor;
    public Color ccolor;
    public double fps;
    public int gameSpd=1;
    
    //Players
    public int player_num=2;
    public ArrayList<Paddle> players;
    public ArrayList<Paddle> players2;
    
    //Balls
    public int ball_num=1;
    public ArrayList<Ball> balls ;
    public ArrayList<Ball> balls2 ;
    
    //Scores/Lives
    public int[] playerScores,playerScores2;
    public int[] playerLives,playerLives2;
    
    //Controls
    public int[] keys;
        
    //KeyPresses
   // public boolean paused=false;
    public boolean[] pressed=new boolean[] {false,false,false,false,false,false};

    public BoardMulti() {

    	
    	this.Xdim=1000;
    	this.Ydim=1000;
    	this.bgcolor=Color.black;
    	this.ccolor=Color.white;
    	this.fps=60;
    	this.state="Start";
    	this.keys=new int[] {KeyEvent.VK_Q,KeyEvent.VK_A,KeyEvent.VK_UP,KeyEvent.VK_DOWN,KeyEvent.VK_C,KeyEvent.VK_V,KeyEvent.VK_O,KeyEvent.VK_P};;

        this.setFocusable(true);
        this.requestFocusInWindow();
        this.grabFocus();
        
        addKeyListener(this);        
        setBackground(this.bgcolor);        
        timer = new Timer((int) (1000/this.fps), this);
        
        timer.start();
                
        this.addComponentListener( new ComponentAdapter() {
            public void componentShown( ComponentEvent e ) {
            	BoardMulti.this.requestFocusInWindow();
            }
        });
        
    }
    
    public BoardMulti (String ownPosition,int ownLives,
			String GameMode,int ball_Num,int spd,boolean powerups,
			String Difficulty1,int Lives1,String Position1,
			String Difficulty2,int Lives2,String Position2,
			String Difficulty3,int Lives3,String Position3, int[] keys){    	
    	
    	//appearance
    	this.Xdim=1000;
    	this.Ydim=1000;
    	this.bgcolor=Color.black;
    	this.ccolor=Color.white;
    	this.fps=60;
    	
    	//balls
    	this.ball_num=ball_Num;
    	this.gameSpd=spd;
    	this.balls=new ArrayList<Ball>();
    	this.balls2=new ArrayList<Ball>();
    	this.balls.add(new Ball(this.Xdim/2, this.Ydim/2, -4*gameSpd, 8*gameSpd,1));
    	this.balls2.add(new Ball(this.Xdim/2, this.Ydim/2, -4*gameSpd, 8*gameSpd,1));
    	if (ball_Num>1){
    		this.balls.add(new Ball(this.Ydim/2, Xdim/2, 6*gameSpd, 12*gameSpd,0));
    		this.balls2.add(new Ball(this.Ydim/2, Xdim/2, 6*gameSpd, 12*gameSpd,0));
    		if (ball_Num>2){    			
				this.balls.add(new Ball(this.Ydim/2, Xdim/2, 12*gameSpd, 6*gameSpd,3));
				this.balls2.add(new Ball(this.Ydim/2, Xdim/2, 12*gameSpd, 6*gameSpd,3));
        	}
    	}
    	//paddles
    	this.players=new ArrayList<Paddle>();
    	this.players2=new ArrayList<Paddle>();
    	this.players.add(new Paddle(Xdim/100, Ydim/5, 5+Xdim/100, this.Ydim/2));
    	this.players2.add(new Paddle(Xdim/100, Ydim/5, 5+Xdim/100, this.Ydim/2));
	
    	if (!Difficulty1.equals("")){
    		this.players.add(new Paddle(Xdim/100, Ydim/5, Xdim-(5+Xdim/100), this.Ydim/2));
    		this.players2.add(new Paddle(Xdim/100, Ydim/5, Xdim-(5+Xdim/100), this.Ydim/2));
			if (!Difficulty2.equals("")){
	    		this.players.add(new Paddle(Xdim/5, Ydim/100, Xdim/2, 5+this.Ydim/100));
	    		this.players2.add(new Paddle(Xdim/5, Ydim/100, Xdim/2, 5+this.Ydim/100));
				if (!Difficulty3.equals("")){
					this.players.add(new Paddle(Xdim/5, Ydim/100, Xdim/2, this.Ydim-(5+this.Ydim/100)));
					this.players2.add(new Paddle(Xdim/5, Ydim/100, Xdim/2, this.Ydim-(5+this.Ydim/100)));
				}
			}
		}
    	else
    	{
    		//System.out.println("No Players");
    	}
				
    	this.playerLives=new int[] {ownLives,Lives1,Lives2,Lives3};
    	this.playerLives2=new int[] {ownLives,Lives1,Lives2,Lives3};
    	this.playerScores=new int[] {0,0,0,0};
    	
    	//focused window
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.grabFocus();
        
        //controls
        this.keys=keys;
        addKeyListener(this);        
        setBackground(this.bgcolor);        
        timer = new Timer((int) (1000/this.fps), this);
        timer.start();
        
        this.addComponentListener( new ComponentAdapter() {
            public void componentShown( ComponentEvent e ) {
            	BoardMulti.this.requestFocusInWindow();
            }
        });
        
        this.state="Playing";
        
    }
    
    @Override
	public void actionPerformed(ActionEvent e) {
		step();	
	}
    
    public void step(){
    	
    	if(this.state.equals("Playing")){
            
    		Paddle P1=this.players.get(0);
    		P1.set_cYvel(20*gameSpd);
    		Paddle P2=this.players.get(1);
    		P2.set_cYvel(20*gameSpd);
    		//move player 1
            if (pressed[0]) {
                if (P1.cYpos-P1.cYvel > P1.Ydim/2 ) {
                    P1.set_Ypos(P1.cYpos-P1.cYvel);
                }
            }
            if (pressed[1]) {
                if (P1.cYpos+P1.cYvel+P1.Ydim/2< this.Ydim) {
                	P1.set_Ypos(P1.cYpos+P1.cYvel);
                }
            }

            //move player 2
            if (pressed[3]) {
            	if (P2.cYpos-P2.cYvel > P2.Ydim/2 ) {
                    P2.set_Ypos(P2.cYpos-P2.cYvel);
                }
            }
            if (pressed[4]) {
            	if (P2.cYpos+P2.cYvel+P2.Ydim/2< this.Ydim ) {
                	P2.set_Ypos(P2.cYpos+P2.cYvel);
                }
            }
            
            if (this.players.size()>2){
            	
            	Paddle P3=this.players.get(2);
        		P3.set_cXvel(20*gameSpd);
        		            	
            	//move player 3
//                if (cPressed) {
//                	if (P3.cXpos-P3.cXvel > P3.Xdim/2) {
//                        P3.set_Xpos(P3.cXpos-P3.cXvel);
//                    }
//                }
//                if (vPressed) {
//                	if (P3.cXpos+P3.cXvel < Xdim - P3.Xdim/2) {
//                    	P3.set_Xpos(P3.cXpos+P3.cXvel);
//                    }
//                }
                
                if (this.players.size()>3){
                	
                	Paddle P4=this.players.get(3);
            		P4.set_cXvel(20*gameSpd);
                	
                	//move plaXer 4
//                    if (oPressed) {
//                    	if (P4.cXpos-P4.cXvel > P4.Xdim/2) {
//                            P4.set_Xpos(P4.cXpos-P4.cXvel);
//                        }
//                    }
//                    if (pPressed) {
//                    	if (P4.cXpos+P4.cXvel < Xdim - P4.Xdim/2) {
//                        	P4.set_Xpos(P4.cXpos+P4.cXvel);
//                        }
//                    }  	
                } 
                else{
                	
                }
            }
            
            for (int i=0;i<this.balls.size();i++){
            	Ball b=this.balls.get(i);
            	analyse(b);
            }
            repaint();
    	} 
    }
    
    public void analyse(Ball b){

    	//next positions of the ball
    	double nextLeftPos = b.Xpos - b.dia;
    	double nextRightPos = b.Xpos + b.dia;
    	double nextTopPos = b.Ypos - b.dia;
    	double nextBottomPos = b.Ypos + b.dia;
    	
    	//positions of the players
    	Paddle P1=this.players.get(0);
    	double playerOneRight = P1.cXpos - P1.Xdim;
    	double playerOneTop = P1.cYpos-(P1.Ydim/2);
    	double playerOneBottom = playerOneTop+(P1.Ydim);
    	
    	Paddle P2=this.players.get(1);
    	double playerTwoLeft = P2.cXpos + P2.Xdim;
    	double playerTwoTop = P2.cYpos - (P2.Ydim/2);
    	double playerTwoBottom = playerTwoTop + (P2.Ydim);
    	
    	if (this.players.size()>2){
    		
    		Paddle P3=this.players.get(2);
        	double playerThreeRight = P3.cXpos+(P3.Xdim/2);
        	double playerThreeLeft = P3.cXpos-(P3.Xdim/2);
        	double playerThreeBottom = P3.cYpos - P3.Ydim;
        	
        	if (this.players.size()>3){
        		
        		Paddle P4=this.players.get(3);
            	double playerFourRight = P4.cXpos+(P4.Xdim/2);
            	double playerFourLeft = P4.cXpos-(P4.Xdim/2);
            	double playerFourTop = P4.cYpos + P4.Ydim;
            	
        		//will the ball go off the left side?
            	if (nextLeftPos < playerOneRight) { 
                    //is it going to miss the paddle?
                    if (b.Ypos < playerOneTop || b.Ypos > playerOneBottom) {
                    	
                    	if (this.playerLives[0]>0){
                    		if (this.playerLives[b.origin]>0){
                            	this.playerScores[b.origin]++;
                            }
                            this.playerLives[0]--;
                    	}                    	

                    }
                    b.origin=0;
                    b.Xvel *=-1;
                }
                //will the ball go off the right side?
            	if (nextRightPos > playerTwoLeft) {
                    //is it going to miss the paddle?
                	if (b.Ypos < playerTwoTop || b.Ypos > playerTwoBottom) {

                		if (this.playerLives[1]>0){
                			if (this.playerLives[b.origin]>0){
                            	this.playerScores[b.origin]++;
                            }
                            this.playerLives[1]--;
                    	}
                    }
                	b.origin=1;
                    b.Xvel *= -1;
                }
              //will the ball go off the top?
                if (nextTopPos < playerThreeBottom) {
                    //is it going to miss the paddle?
                	if (b.Xpos > playerThreeRight || b.Xpos < playerThreeLeft) {

                		if (this.playerLives[2]>0){
                			if (this.playerLives[b.origin]>0){
                            	this.playerScores[b.origin]++;
                            }
                            this.playerLives[2]--;
                    	}
                    }
                	b.origin=2;
                    b.Yvel *= -1;
                }
              //will the ball go off the bottom?
                if (nextBottomPos > playerFourTop) {
                    //is it going to miss the paddle?
                	if (b.Xpos > playerFourRight || b.Xpos < playerFourLeft) {

                		if (this.playerLives[3]>0){
                			if (this.playerLives[b.origin]>0){
                            	this.playerScores[b.origin]++;
                            }
                            this.playerLives[3]--;
                    	}
                    }
                	b.origin=3;
                    b.Yvel *= -1;
                }        	
                if (zeros(this.playerLives,3)){
            		this.state="Done";
            	}
        	}
        	else{
        		//bounce off the bottom
        		if (nextBottomPos > this.Ydim) {
        			b.origin=3;
                    b.Yvel *=-1;               
                }
        		//will the ball go off the left side?
        		if (nextLeftPos < playerOneRight) { 
                    //is it going to miss the paddle?
                    if (b.Ypos < playerOneTop || b.Ypos > playerOneBottom) {
                    	
                    	if (this.playerLives[0]>0){
                    		if (this.playerLives[b.origin]>0){
                            	this.playerScores[b.origin]++;
                            }
                            this.playerLives[0]--;
                    	}
                    }
                    b.origin=0;
                    b.Xvel *=-1;
                }
                //will the ball go off the right side?
        		if (nextRightPos > playerTwoLeft) {
                    //is it going to miss the paddle?
                	if (b.Ypos < playerTwoTop || b.Ypos > playerTwoBottom) {

                		if (this.playerLives[1]>0){
                			if (this.playerLives[b.origin]>0){
                            	this.playerScores[b.origin]++;
                            }
                            this.playerLives[1]--;
                    	}
                    }
                	b.origin=1;
                    b.Xvel *= -1;
                }
              //will the ball go off the top?
                if (nextTopPos < playerThreeBottom) {
                    //is it going to miss the paddle?
                	if (b.Xpos > playerThreeRight || b.Xpos < playerThreeLeft) {
                    	
                		if (this.playerLives[2]>0){
                            this.playerLives[2]--;
                            if (this.playerLives[b.origin]>0){
                            	this.playerScores[b.origin]++;
                            }                            
                    	}
                    }
                	b.origin=2;
                    b.Yvel *= -1;
                }
                
        	}
        	if (zeros(this.playerLives,3)){
        		this.state="Done";
        	}
    		
    	}
    	else{
    		//bounce off the top and bottom
    		if (nextTopPos < 0 || nextBottomPos > this.Ydim) {
                b.Yvel *=-1;               
            }
    		//will the ball go off the left side?
            if (nextLeftPos < playerOneRight) { 
                //is it going to miss the paddle?
                if (b.Ypos < playerOneTop || b.Ypos > playerOneBottom) {
            		          	
                	this.playerScores[1]++;
                    this.playerLives[0]--;

                    if (playerLives[0] == 0) {
                        this.state="Done";
                    }
                }
                b.Xvel *=-1;
            }
            //will the ball go off the right side?
            if (nextRightPos > playerTwoLeft) {
                //is it going to miss the paddle?
            	if (b.Ypos < playerTwoTop || b.Ypos > playerTwoBottom) {
                	
            		this.playerScores[0]++;
                    this.playerLives[1]--;

                    if (playerLives[1] == 0) {
                        this.state="Done";
                    }
                }
                b.Xvel *= -1;
            }
    	}
    	//move the ball            	
        b.Xpos += b.Xvel;
        b.Ypos += b.Yvel;
    }
    
  //paint the game screen
    @Override
    public void paintComponent(Graphics g){

        super.paintComponent(g);
        g.setColor(ccolor);

        switch(state){
        	case "Start":
        		g.setFont(new Font(Font.DIALOG, Font.BOLD, 24));
                g.drawString("Press 'SPACE' to play", (int)Xdim/2-150, (int)this.Ydim/2);        		
        		break;
        		
//        	case "Player Select":
//        		g.setFont(new Font(Font.DIALOG, Font.BOLD, 24));
//                g.drawString("Select number of human players 2-4", (int)Xdim/2-150, (int)this.Ydim/2);
//        		break;
//        		
//        	case "Mode Select":
//        		g.setFont(new Font(Font.DIALOG, Font.BOLD, 24));
//                g.drawString("Select number of balls 1-3", (int)Xdim/2-150, (int)this.Ydim/2);
//        		break;
        		
			case "Playing":
				
				//draw "goal lines" on each side
	            g.drawLine((int)(5+Xdim/100), 0,(int) (5+Xdim/100),(int) (this.Ydim));
	            g.drawLine((int)(Xdim-(5+Xdim/100)), 0,(int) (Xdim-(5+Xdim/100)),(int) (this.Ydim));
				g.drawLine(0, (int)(5+this.Ydim/100), (int) (Xdim), (int)(5+this.Ydim/100));
				g.drawLine(0, (int)(this.Ydim-(5+this.Ydim/100)), (int) (Xdim), (int)(this.Ydim-(5+this.Ydim/100)));
				
				//draw paddles
				for (int i=0;i<this.players.size();i++){
					if (this.playerLives[i]>0) {
						Paddle b=this.players.get(i);
						g.fillRect((int)(b.cXpos-b.Xdim/2),(int)(b.cYpos-b.Ydim/2),(int) (b.Xdim), (int) (b.Ydim));
					}
				}
				
				//draw balls
				for (int i=0;i<this.balls.size();i++){
					Ball b=this.balls.get(i);
					g.fillOval((int)(b.Xpos-b.dia/2),(int)(b.Ypos-b.dia/2),(int) (b.dia), (int) (b.dia));
				}
				
				//draw the scores
	            g.setFont(new Font(Font.DIALOG, Font.BOLD, 36));
	            g.drawString(String.valueOf(this.playerScores[0]), (int)(this.Ydim/2-200), (int) (Xdim/2-100));
	            g.drawString(String.valueOf(this.playerLives[0]), (int)(this.Ydim/2-200), (int) (Xdim/2+100));
	            g.drawString(String.valueOf(this.playerScores[1]), (int)(this.Ydim/2+200), (int) (Xdim/2-100));
	            g.drawString(String.valueOf(this.playerLives[1]), (int)(this.Ydim/2+200), (int) (Xdim/2+100));
	            
	            if (this.players.size()>2){
	            	g.drawString(String.valueOf(this.playerScores[2]), (int)(this.Ydim/2-100), (int) (Xdim/2-200));
		            g.drawString(String.valueOf(this.playerLives[2]), (int)(this.Ydim/2+100), (int) (Xdim/2-200));
		            if (this.players.size()>3){
		            	g.drawString(String.valueOf(this.playerScores[3]), (int)(this.Ydim/2-100), (int) (Xdim/2+200));
			            g.drawString(String.valueOf(this.playerLives[3]), (int)(this.Ydim/2+100), (int) (Xdim/2+200));
			            
		            }
		            else{
		            	this.playerLives[3]=0;
		            }
	            }
	            else{
		            this.playerLives[2]=0;
	            }
	            
				break;
				
			case "Done":
				g.setFont(new Font(Font.DIALOG, Font.BOLD, 24));
				
				int winner=0;
				int maxscore=0;
				for (int i=1;i<3;i++){
					int sc=this.playerLives[i];
					if (sc>maxscore){
						winner=i;
						maxscore=sc;
					}
				}				
				g.drawString("Player "+(winner+1)+" won!", (int)Xdim/2, (int)this.Ydim/2-200);
                g.drawString("Press 'SPACE' to play again", (int)Xdim/2, (int)this.Ydim/2);
				break;
        }
        
    }
    
	public void keyTyped(KeyEvent e) {
		
	}
	
	public void keyPressed(KeyEvent e) {
		switch(state){
			case "Start":
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					this.players=new ArrayList<Paddle>();
					this.balls=new ArrayList<Ball>();
					this.state="Player Select";
					repaint();
	            }
				break;
				
//			case "Player Select":
//				this.players.add(new Paddle(Xdim/100, Ydim/5, 5+Xdim/100, this.Ydim/2));
//				this.players.add(new Paddle(Xdim/100, Ydim/5, Xdim-(5+Xdim/100), this.Ydim/2));
//				if (e.getKeyCode() == KeyEvent.VK_2) {					
//					this.player_num=2;
//					this.state="Mode Select";
//	            }
//				else if (e.getKeyCode() == KeyEvent.VK_3) {					
//					this.player_num=3;
//					this.players.add(new Paddle(Xdim/5, Ydim/100, Xdim/2, 5+this.Ydim/100));
//					this.state="Mode Select";
//	            }
//				else if (e.getKeyCode() == KeyEvent.VK_4) {					
//					this.player_num=4;
//					this.players.add(new Paddle(Xdim/5, Ydim/100, Xdim/2, 5+this.Ydim/100));
//					this.players.add(new Paddle(Xdim/5, Ydim/100, Xdim/2, this.Ydim-(5+this.Ydim/100)));
//					this.state="Mode Select";
//	            }
//				if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
//	            	this.ball_num=1;
//					this.player_num=2;
//					this.state="Start";
//	            }
//				else {
//					this.player_num=2;
//					this.state="Mode Select";					
//	            }
//				repaint();
//				break;
//				
//			case "Mode Select":
//				this.balls.add(new Ball(this.Xdim/2, this.Ydim/2, -4*gameSpd, 8*gameSpd,1));
//				if (e.getKeyCode() == KeyEvent.VK_1) {
//					this.state="Playing";
//	            }
//				else if (e.getKeyCode() == KeyEvent.VK_2) {
//					this.ball_num=2;
//					this.balls.add(new Ball(this.Ydim/2, Xdim/2, 6*gameSpd, 12*gameSpd,0));
//					this.state="Playing";
//	            }
//				else if (e.getKeyCode() == KeyEvent.VK_3) {
//					this.ball_num=3;
//					this.balls.add(new Ball(this.Ydim/2, Xdim/2, 6*gameSpd, 12*gameSpd,0));
//					this.balls.add(new Ball(this.Ydim/2, Xdim/2, 12*gameSpd, 6*gameSpd,3));
//					this.state="Playing";
//	            }
//				if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
//	            	this.state="Start";
//	            	this.ball_num=1;
//					this.player_num=2;
//	            }
//				else {
//					this.state="Playing";
//	            }
//				int lives=5*ball_num;
//				this.playerLives=new int[] {lives,lives,lives,lives};
//				this.playerScores=new int[] {0,0,0,0};
//				repaint();
//				break;
				
			case "Playing":				
				if (e.getKeyCode() == keys[0]) {
	                pressed[0] = true;
	            }
	            else if (e.getKeyCode() == keys[1]) {
	                pressed[1] = true;
	            }
	            else if (e.getKeyCode() == keys[2]) {
	                pressed[2] = true;
	            }
	            else if (e.getKeyCode() == keys[3]) {
	                pressed[3] = true;
	            }
	            else if (e.getKeyCode() == keys[4]) {
	                pressed[4] = true;
	            }
	            else if (e.getKeyCode() == keys[5]) {
	                pressed[5] = true;
	            }
	            if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
	            	RXCardLayout cdl=(RXCardLayout) getParent().getLayout();
	            	cdl.show(getParent(), "MenuPanel");
	            }
	            repaint();
				break;
				
			case "Done":
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					this.state="Playing";
					this.playerScores=new int[] {0,0,0,0};
					for (int i=0;i<4;i++){
						int x=this.playerLives2[i];
						this.playerLives[i]=x;
					}
					this.balls=new ArrayList<Ball>();
					for (int i=0;i<this.balls2.size();i++){
						Ball b=this.balls2.get(i);
						Ball bb=new Ball(b.Xpos, b.Ypos, b.Xvel, b.Yvel, b.origin);						
						this.balls.add(bb);
					}
					this.players=new ArrayList<Paddle>();
					for (int i=0;i<this.players2.size();i++){
						Paddle b=this.players2.get(i);
						Paddle bb=new Paddle(b.Xdim, b.Ydim, b.cXpos, b.cYpos);
						this.players.add(bb);
					}
	            }
				if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
	            	RXCardLayout cdl=(RXCardLayout) getParent().getLayout();
	            	cdl.show(getParent(), "MenuPanel");
	            }
				repaint();
				break;
		}
		
	}
	
	public void keyReleased(KeyEvent e) {
		if (state.equals("Playing")) {            
            if (e.getKeyCode() == keys[0]) {
                pressed[0] = false;
            }
            else if (e.getKeyCode() == keys[1]) {
                pressed[1] = false;
            }
            else if (e.getKeyCode() == keys[2]) {
                pressed[2] = false;
            }
            else if (e.getKeyCode() == keys[3]) {
                pressed[3] = false;
            }
            else if (e.getKeyCode() == keys[4]) {
                pressed[4] = false;
            }
            else if (e.getKeyCode() == keys[5]) {
                pressed[5] = false;
            }
        }
		
	}
	
    public boolean zeros(int[] arr, int z){
    	int cnt = 0;
    	for (int i=0;i<arr.length;i++){
    		if (arr[i]==0){
    			cnt++;
    		}
    	}
    	return cnt==z;
    }   
    
}
