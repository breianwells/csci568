package neuralNetwork;

public class Edge {
	public Node startNode;
	public double weight;
	
	public Edge(Node start,double sweight){
		startNode=start;
		weight=sweight;
	}
	
	public double getValue(){
		return weight*startNode.getValue();
	}
	
	public void increaseValue(double ammount){
		double currentVal=this.getValue();
		double newval = currentVal+ammount;
		weight=weight*newval/currentVal;
		
	}

}
