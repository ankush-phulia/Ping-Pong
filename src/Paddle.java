public class Paddle {
	
	private double dia;
	private double Xdim;
	private double Ydim;
	private double cXpos;
    private double cYpos;    
    private double cXvel;
    private double cYvel;
    private double type;
    
//    public Paddle(double typ,double Xstart,double Ystart){
//    	if (typ==0){
//    		this.Xdim=10;
//    		this.Ydim=200;
//    	}
//    	else{
//    		this.dia=200;
//    	}
//    	this.type=typ;
//    	this.cXpos=Xstart;
//    	this.cYpos=Ystart;
//    }
    
    public Paddle(double d,double Xstart,double Ystart){
    	this.type=1;
    	this.dia=d;
    	this.cXpos=Xstart;
    	this.cYpos=Ystart;
    	this.cXvel=0;
    	this.cYvel=0;
    }
    
    public Paddle(double x,double y,double Xstart,double Ystart){
    	this.type=0;
    	this.Xdim=x;
    	this.Ydim=y;
    	this.cXpos=Xstart;
    	this.cYpos=Ystart;
    	this.cXvel=0;
    	this.cYvel=0;
    }
    
    public void set_type(int t){
    	this.type=t;
    }
    
    public void set_dia(int d){
    	this.dia=d;
    }
    
    public void set_xdim(int d){
    	this.Xdim=d;
    }
    
    public void set_ydim(int d){
    	this.Ydim=d;
    }
    
    public void set_Xpos(int x){
    	this.cXpos=x;
    }

    public void set_Ypos(int y){
    	this.cYpos=y;
    }
    
    public void set_cXvel(int vx){
    	this.cXvel=vx;
    }
    
    public void set_cYvel(int vy){
    	this.cYvel=vy;
    }
    
    

}
