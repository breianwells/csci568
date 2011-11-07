package neuralNetwork;

import java.util.Vector;

public class Node {
	private double value;
	private Vector<Edge> incomingEdges;
	
	public Node(){
		value=0;
		incomingEdges=new Vector<Edge>();
	}
	
	public void setValue(double newval){
		value=newval;
	}
	
	public void addEdge(double weight,Node start){
		incomingEdges.add(new Edge(start,weight));
	}
	
	public double getValue(){
		if(value>.5){
			return 1;
		}
		if(value<-.5){
			return -1;
		}
		return 0;
	}
	
	public void calculateValue(){
		value=0;
		for(int i=0;i<incomingEdges.size();i++){
			value+=incomingEdges.get(i).getValue();
		}
	}
}