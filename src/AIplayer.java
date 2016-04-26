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
		
		/*double epsilon = 5 ;
		double movement = p.cYpos-p.cYvel ;
		double movdown = p.cYpos+p.cYvel ;
		if (p.cYpos - predictedordinate > epsilon){
			if (movement > p.Ydim/2) {
                if ((movement-predictedordinate)>((-1)*epsilon)){
                	p.set_Ypos(movement);
                }
                else {
                if(predictedordinate > 0 && predictedordinate+p.Ydim/2 < b.Ydim){
                	p.set_Ypos(predictedordinate);
                }
                	
                }
            }
		}
		else {
			if (movement+p.Ydim/2< b.Ydim && (p.cYpos-predictedordinate < (-1*epsilon))) {
				if ((movement-predictedordinate)<((1)*epsilon)){
                	p.set_Ypos(movement);
                }
                else {
                	if(predictedordinate > 0 && predictedordinate+p.Ydim/2< b.Ydim){
                    	p.set_Ypos(predictedordinate);
                    }
                }
            }
		}*/
		double epsilon = initialvelocity/2+1 ;
		
		if (p.cYpos - predictedordinate > epsilon){
			if (p.cYpos-p.cYvel > p.Ydim/2) {
                p.set_Ypos(p.cYpos-p.cYvel);
            }
		}
		else {
			if (p.cYpos+p.cYvel+p.Ydim/2< b.Ydim && (p.cYpos-predictedordinate < (-1*epsilon))) {
            	p.set_Ypos(p.cYpos+p.cYvel);
            }
		}
	}
	
	public void moveAIplayer1(Paddle p,ArrayList<Ball> balls,Board b,double initialvelocity){
		
		Ball balltobefollowed = null  ;
		Ball temp  ; 		
		double farthestballfromleft = b.Xdim;
		
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
			if (p.cYpos+p.cYvel+p.Ydim/2< b.Ydim && (p.cYpos-predictedordinate < (-1*epsilon))) {
            	p.set_Ypos(p.cYpos+p.cYvel);
            }
		}
	}
}