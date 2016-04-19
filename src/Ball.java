public class Ball {
	
	private double dia;
	private double Xpos;
    private double Ypos;    
    private double Xvel;
    private double Yvel;
    private double type;
    
    public Ball(double Xstart,double Ystart,double Vxstart,double Vystart){
    	this.dia=25;
    	this.Xpos=Xstart;
    	this.Ypos=Ystart;
    	this.Xvel=Vxstart;
    	this.Yvel=Vystart;
    	this.type=0;
    }
    
    public void set_dia(int d){
    	this.dia=d;
    }
    
    public void set_Xpos(int x){
    	this.Xpos=x;
    }

    public void set_Ypos(int y){
    	this.Ypos=y;
    }
    
    public void set_Xvel(int vx){
    	this.Xvel=vx;
    }
    
    public void set_Yvel(int vy){
    	this.Yvel=vy;
    }
    
    public void set_type(int t){
    	this.type=t;
    }

}
