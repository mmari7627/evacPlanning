import java.awt.Color;

public class Node {
	public int ID;
	public int capacity;
	public double safety;
	//public double waitTime;
	public float longitude;
	public float latitude;
	
	
	public Node(int cnodeID,int ccapacity,double csafety,float clongitude, float clatitude,float scale) {
		ID = cnodeID;
		capacity = ccapacity;
		safety = csafety;
		//waitTime = cwaittime;
		longitude = clongitude * scale;
		latitude = clatitude * scale;
	}
	public Color getNodeColor() {
		Color c;
		if(this.safety==1) {
			 c = new Color(0,0,255);
			return c;
		
		}
		else if(this.safety==0){
			 c = new Color(255,0,0);
				return c;
		}
		else {
			c = new Color(255,255,51);
			return c;
		}
	}
	public String getNodeByFilter(int filter) {
		switch(filter) {
		case 0:
			return Double.toString(safety);
		case 1:
			return Integer.toString(ID);
		case 2:
			return Integer.toString(capacity);
		
		}
		return null;
		 
	}
}
