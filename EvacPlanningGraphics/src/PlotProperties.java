public class PlotProperties {
	String filename="";
	nodeColumn nColumn = nodeColumn.Safety; 
	edgeColumn eColumn = edgeColumn.Safety;
	nodeShape nShape = nodeShape.Circle;
	enum nodeColumn {
		Safety, Capacity;
	}
	double	nMin, nMax;
	enum edgeColumn {
		Safety, Capacity;
	}
	double eMin,eMax;
	
	enum nodeShape {
		Circle, Triangle, Square;
	}
	double eShapeVal;
	boolean propertyError=false;
	
	public PlotProperties(String[] args) {
		if(GetNodeColumn(args)==false) {
			propertyError=true;
		} else {
			if(GetNodeValue(args)==false) {
				propertyError=true;
			}
		}
		if(GetEdgeColumn(args)==false) {
			propertyError=true;
		}
		if(GetNodeShape(args)==false) {
			propertyError=true;
		}
		if(GetEdgeShape(args)==false) {
			propertyError=true;
		}
	}
	
	private boolean GetNodeColumn(String[] args) {
		for(int i=0;i<args.length;i++) {
			if(args[i]=="-ncolor") {
				if((i+1)<args.length) {
					if(args[i+1]=="0") {
						nColumn=nodeColumn.Safety;
						return true;
					} else if(args[i+1]=="1") {
						nColumn = nodeColumn.Capacity;
						return true;
					} else {
						System.out.println("ncolor accepts first argument for column number as either 0 for safety or 1 for capacity");
						return false;
					}
				} else {
					System.out.println("ncolor accepts <node column number{0:Safety[default], 1:Capacity}> <nmin:nmax{default[0:1]}> <nminColor:nmaxColor{default[red:blue]}> \n");
					return false;
				}
			}
		} 
		return true;
		
	}
	
	private boolean GetNodeValue(String[] args) {
		for(int i=0;i<args.length;i++) {
			if(args[i]=="-ncolor") {
				if((i+2)<args.length) {
					if(args[i+2].contains(":")) {
						String nodeVal[] = args[i+2].split(":");
						nMin = Double.parseDouble(nodeVal[0]);
						nMax = Double.parseDouble(nodeVal[1]);
						return true;
					} else {
						System.out.println("ncolor accepts second argument <nmin:nmax{default[0:1]}>");
						return false;
					}
				} else {
					System.out.println("-ncolor accepts <node column number{0:Safety[default], 1:Capacity}> <nmin:nmax{default[0:1]}> <nminColor:nmaxColor{default[red:blue]}> \n");
					return false;
				}
			}
		}
		return true;
	}
	
	private boolean GetEdgeColumn(String[] args) {
		for(int i=0;i<args.length;i++) {
			if(args[i]=="-ecolor") {
				if((i+1)<args.length) {
					if(args[i+1]=="0") {
						eColumn=edgeColumn.Safety;
						return true;
					} else if(args[i+1]=="1") {
						eColumn = edgeColumn.Capacity;
						return true;
					} else {
						System.out.println("ecolor accepts first argument for column number as either 0 for safety or 1 for capacity");
						return false;
					}
				} else {
					System.out.println("ecolor <edge column number{0:Safety, 1:Capacity}> <nmin:nmax> <eminColor:emaxColor> \n");
					return false;
				}
			}
		} 
		return true;	
	}
	
	private boolean GetColValue(String[] args) {
		for(int i=0;i<args.length;i++) {
			if(args[i]=="-ecolor") {
				if((i+2)<args.length) {
					if(args[i+2].contains(":")) {
						String colVal[] = args[i+2].split(":");
						eMin = Double.parseDouble(colVal[0]);
						eMax = Double.parseDouble(colVal[1]);
						return true;
					} else {
						System.out.println("ecolor accepts second argument <emin:emax{default[0:1]}>");
						return false;
					}
				} else {
					System.out.println("-ecolor accepts <node column number{0:Safety[default], 1:Capacity}> <nmin:nmax{default[0:1]}> <nminColor:nmaxColor{default[red:blue]}> \n");
					return false;
				}
			}
		}
		return true;
	}
	
	private boolean GetNodeShape(String[] args) {
		for(int i=0;i<args.length;i++) {
			if(args[i]=="-nshape") {
				if((i+1)<args.length) {
					if(args[i+1]=="0") {
						nShape=nodeShape.Circle;
						return true;
					} else if(args[i+1]=="1") {
						nShape=nodeShape.Triangle;
						return true;
					} else if(args[i+1]=="2") {
						nShape=nodeShape.Square;
					} else {
						System.out.println("nshape accepts nxt argument either 0 for Circle, 1 for Triangle and 2 for Square");
						return false;
					}
				} else {
					System.out.println("nshape <Shape of the node>{0:circle, 1:triangle, 2:square}<Default:0> \n");
					return false;
				}
			}
		} 
		return true;
	}
	
	private boolean GetEdgeShape(String[] args) {
		for(int i=0;i<args.length;i++) {
			if(args[i]=="-eshape") {
				if((i+1)<args.length) {
					try {
						eShapeVal = Double.parseDouble(args[i+1]); 
						if(eShapeVal>=0 && eShapeVal<=1) {
							return true;
						}	
						 else {
							System.out.println("eshape accepts value between 0 and 1");
							return false;
						}
					} catch (Exception e) {
						// TODO: handle exception
						System.out.println("eshape accepts value between 0 and 1");
					}
					
				} else {
					System.out.println("-eshape <Accepts probability value, any value less than this represented as dotted line> \n");
					return false;
				}
			}
		} 
		return true;
	}
			
	
}
