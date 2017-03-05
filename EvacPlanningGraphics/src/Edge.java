
public class Edge {
	int edgeID;
	Node fromNode;
	Node toNode;
	double safety;
	double probability;
	int agtCapacity;
	public Edge(int edgeID2, Node fromNode2, Node toNode2, double safety2, double probability2) {
		edgeID=edgeID2;
		fromNode=fromNode2;
		toNode=toNode2;
		safety=safety2;
		probability=probability2;
	}
	public void addAgent() {
		agtCapacity++;
	}

}
