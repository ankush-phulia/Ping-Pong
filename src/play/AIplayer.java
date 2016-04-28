package play;

import java.util.ArrayList;

public  class AIplayer {
	
	public static void moveAIplayer(Paddle p,ArrayList<Ball> balls,Board b,double initialvelocity){
		Ball balltobefollowed = null  ;
		Ball temp  ; 
		double farthestballfromleft = 0;
		
		for (int i= 0;i<balls.size();i++){
			temp = balls.get(i) ;
			if ((temp.Xpos > farthestballfromleft) && (temp.Xvel > 0)){
				balltobefollowed = balls.get(i) ;
				farthestballfromleft = temp.Xpos ;
			}
		}
		
		if (balltobefollowed  == null){
			balltobefollowed = balls.get(0) ;
		}
		//System.out.println(balls.size());
		double predictedordinate = (balltobefollowed.Yvel/balltobefollowed.Xvel)*1000+(balltobefollowed.Ypos-(balltobefollowed.Yvel/balltobefollowed.Xvel)*balltobefollowed.Xpos) ; 
		
		p.set_cYvel(initialvelocity);

		double epsilon = initialvelocity/2+1 ;
		
		if (p.cYpos - predictedordinate > epsilon){
			if (p.cYpos-p.cYvel > p.Ydim/2) {
                p.set_Ypos(p.cYpos-p.cYvel);
            }
		}
		else {
			if (p.cYpos+p.cYvel+p.Ydim/2< b.getHeight() && (p.cYpos-predictedordinate < (-1*epsilon))) {
            	p.set_Ypos(p.cYpos+p.cYvel);
            }
		}
	}
	
	public static void moveAIplayer1(Paddle p,ArrayList<Ball> balls,Board b,double initialvelocity){
		
		Ball balltobefollowed = null  ;
		Ball temp  ; 		
		double farthestballfromleft = b.getWidth();
		
		for (int i= 0;i<balls.size();i++){
			temp = balls.get(i) ;
			if ((temp.Xpos < farthestballfromleft) && (temp.Xvel < 0)){
				balltobefollowed = balls.get(i) ;
				farthestballfromleft = temp.Xpos ;
			}
		}
		
		if (balltobefollowed  == null){
			balltobefollowed = balls.get(0) ;
		}
		
		//System.out.println(balls.size());
		double predictedordinate = (balltobefollowed.Ypos-(balltobefollowed.Yvel/balltobefollowed.Xvel)*balltobefollowed.Xpos) ; 
		
		p.set_cYvel(initialvelocity);
		
		double epsilon = initialvelocity/2+1 ;
		
		if (p.cYpos - predictedordinate > epsilon){
			if (p.cYpos-p.cYvel > p.Ydim/2) {
                p.set_Ypos(p.cYpos-p.cYvel);
            }
		}
		else {
			if (p.cYpos+p.cYvel+p.Ydim/2< b.getHeight() && (p.cYpos-predictedordinate < (-1*epsilon))) {
            	p.set_Ypos(p.cYpos+p.cYvel);
            }
		}
	}
	
	public static void moveAIplayer3(Paddle p,ArrayList<Ball> balls,Board b,double initialvelocity){
		Ball balltobefollowed = null  ;
		Ball temp  ; 
		double farthestballfromleft = 0;
		
		for (int i= 0;i<balls.size();i++){
			temp = balls.get(i) ;
			if ((temp.Ypos > farthestballfromleft) && (temp.Yvel > 0)){
				balltobefollowed = balls.get(i) ;
				farthestballfromleft = temp.Ypos ;
			}
		}
		
		if (balltobefollowed  == null){
			balltobefollowed = balls.get(0) ;
		}
		//System.out.println(balls.size());
		double predictedordinate = (balltobefollowed.Xvel/balltobefollowed.Yvel)*1000+(balltobefollowed.Xpos-(balltobefollowed.Xvel/balltobefollowed.Yvel)*balltobefollowed.Ypos) ; 
		
		p.set_cXvel(initialvelocity);
		
		double epsilon = initialvelocity/2+1 ;
		
		if (p.cXpos - predictedordinate > epsilon){
			if (p.cXpos-p.cXvel > p.Xdim/2) {
                p.set_Xpos(p.cXpos-p.cXvel);
            }
		}
		else {
			if (p.cXpos+p.cXvel+p.Xdim/2< b.getWidth() && (p.cXpos-predictedordinate < (-1*epsilon))) {
            	p.set_Xpos(p.cXpos+p.cXvel);
            }
		}
	}
	
	public static void moveAIplayer4(Paddle p,ArrayList<Ball> balls,Board b,double initialvelocity){
		
		Ball balltobefollowed = null  ;
		Ball temp  ; 		
		double farthestballfromleft = b.getHeight();
		
		for (int i= 0;i<balls.size();i++){
			temp = balls.get(i) ;
			if ((temp.Ypos < farthestballfromleft) && (temp.Yvel < 0)){
				balltobefollowed = balls.get(i) ;
				farthestballfromleft = temp.Ypos ;
			}
		}
		
		if (balltobefollowed  == null){
			balltobefollowed = balls.get(0) ;
		}
		
		//System.out.println(balls.size());
		double predictedordinate = (balltobefollowed.Xpos-(balltobefollowed.Xvel/balltobefollowed.Yvel)*balltobefollowed.Ypos) ; 
		
		p.set_cXvel(initialvelocity);
		
		double epsilon = initialvelocity/2+1 ;
		
		if (p.cXpos - predictedordinate > epsilon){
			if (p.cXpos-p.cXvel > p.Xdim/2) {
                p.set_Xpos(p.cXpos-p.cXvel);
            }
		}
		else {
			if (p.cXpos+p.cXvel+p.Xdim/2< b.getWidth() && (p.cXpos-predictedordinate < (-1*epsilon))) {
            	p.set_Xpos(p.cXpos+p.cXvel);
            }
		}
	}
}