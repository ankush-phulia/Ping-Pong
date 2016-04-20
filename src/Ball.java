public class Ball {
	
	public double dia;
	public double Xpos;
    public double Ypos;    
    public double Xvel;
    public double Yvel;
    public double Xacc;
    public double Yacc;
    public int type;
    public int origin;
    public int destination;
    
    public Ball(double Xstart,double Ystart,double Vxstart,double Vystart,int or){
    	this.dia=25;
    	this.Xpos=Xstart;
    	this.Ypos=Ystart;
    	this.Xvel=Vxstart;
    	this.Yvel=Vystart;
    	this.Xacc=0;
    	this.Yacc=0;
    	this.type=0;
    	this.origin=or;
    }
    
    public void set_dia(double d){
    	this.dia=d;
    }
    
    public void set_Xpos(double x){
    	this.Xpos=x;
    }

    public void set_Ypos(double y){
    	this.Ypos=y;
    }
    
    public void set_Xvel(double vx){
    	this.Xvel=vx;
    }
    
    public void set_Yvel(double vy){
    	this.Yvel=vy;
    }
    
    public void set_Xacc(double ax){
    	this.Xacc=ax;
    }
    
    public void set_Yacc(double ay){
    	this.Yacc=ay;
    }
    
    public void set_type(int t){
    	this.type=t;
    }

    public void set_origin(int t){
    	this.origin=t;
    }

}
