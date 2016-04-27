import java.util.ArrayList;

public  class AIplayer {
	
	public void moveAIplayer(Paddle p,ArrayList<Ball> balls,Board b,double initialvelocity){
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
                if(predictedordinate > 0 && predictedordinate+p.Ydim/2 < b.getHeight()){
                	p.set_Ypos(predictedordinate);
                }
                	
                }
            }
		}
		else {
			if (movement+p.Ydim/2< b.getHeight() && (p.cYpos-predictedordinate < (-1*epsilon))) {
				if ((movement-predictedordinate)<((1)*epsilon)){
                	p.set_Ypos(movement);
                }
                else {
                	if(predictedordinate > 0 && predictedordinate+p.Ydim/2< b.getHeight()){
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
			if (p.cYpos+p.cYvel+p.Ydim/2< b.getHeight() && (p.cYpos-predictedordinate < (-1*epsilon))) {
            	p.set_Ypos(p.cYpos+p.cYvel);
            }
		}
	}
	
	public void moveAIplayer1(Paddle p,ArrayList<Ball> balls,Board b,double initialvelocity){
		
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
	
	public void moveAIplayer3(Paddle p,ArrayList<Ball> balls,Board b,double initialvelocity){
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
		
		/*double epsilon = 5 ;
		double movement = p.cXpos-p.cXvel ;
		double movdown = p.cXpos+p.cXvel ;
		if (p.cXpos - predictedordinate > epsilon){
			if (movement > p.Xdim/2) {
                if ((movement-predictedordinate)>((-1)*epsilon)){
                	p.set_Xpos(movement);
                }
                else {
                if(predictedordinate > 0 && predictedordinate+p.Xdim/2 < b.getWidth()){
                	p.set_Xpos(predictedordinate);
                }
                	
                }
            }
		}
		else {
			if (movement+p.Xdim/2< b.getWidth() && (p.cXpos-predictedordinate < (-1*epsilon))) {
				if ((movement-predictedordinate)<((1)*epsilon)){
                	p.set_Xpos(movement);
                }
                else {
                	if(predictedordinate > 0 && predictedordinate+p.Xdim/2< b.getWidth()){
                    	p.set_Xpos(predictedordinate);
                    }
                }
            }
		}*/
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
	
	public void moveAIplayer4(Paddle p,ArrayList<Ball> balls,Board b,double initialvelocity){
		
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