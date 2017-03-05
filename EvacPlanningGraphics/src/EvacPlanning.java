import java.io.File;
public class EvacPlanning {
	public static void main(String[] args) {
		//File sampleFile = new File("/Users/homanaren/Documents/Plot/mrccpCityFinal.txt");
		
		if (args.length ==0){
			//System.out.println("accepts arg1: filename - Abosulte or Releative path");
			System.out.println("Help menu for plotting: /n");
			System.out.println("-f <filename{Absolute or Relative path}> \n"); 
			System.out.println("-ncolor <node column number{0:Safety[default], 1:Capacity}> <nmin:nmax{default[0:1]}> <nminColor:nmaxColor{default[red:blue]}> \n");
			System.out.println("-ecolor <edge column number{0:Safety, 1:Capacity}> <nmin:nmax> <eminColor:emaxColor>\n");
			System.out.println("-nshape <Shape of the node>{0:circle, 1:triangle, 2:square}<Default:0> \n");
			System.out.println("-eshape <Accepts probability value, any value less than this represented as dotted line>");
			return;
		}
		
		File sampleFile = new File(args[1]);
		boolean exists = sampleFile.exists();
		
		if (!exists)
			System.out.println(args[0]);
			sampleFile =  new File(System.getProperty("user.dir") + "/" + args[0]);
		
		exists = sampleFile.exists();
		if(exists)
		{
			@SuppressWarnings("unused")
			NetworkXPlot objPlot = new NetworkXPlot(args[0]);
		//	NetworkXPlot objPlot = new NetworkXPlot("/Users/homanaren/Documents/Plot/mrccpCityFinal.txt");
		} else {
			System.out.println("Input File doesn't exist");
		}
	}
}
