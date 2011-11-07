package neuralNetwork;

import java.util.Random;
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
		if(value>.33){
			return 1;
		}
		if(value<-.33){
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
	
	public void backPropegate(double actualValue){
		int i;
		Random myRandom= new Random();
		
		int changedIndex=0;
		this.calculateValue();
		double minVal;
		if(this.getValue()!=actualValue){
			if(actualValue==1){
				minVal=Double.MAX_VALUE;
				for(i=0;i<incomingEdges.size();i++){
					if(incomingEdges.get(i).getValue()<=minVal&&incomingEdges.get(i).getValue()!=0){
						minVal=incomingEdges.get(i).getValue();
						changedIndex=i;
					}
				}
				if(minVal==Double.MAX_VALUE){
					//all hidden nodes have zero value must go back one to create a changeable value
					incomingEdges.get(myRandom.nextInt(incomingEdges.size())).startNode.backPropegate(1);
					this.backPropegate(actualValue);
					return;
				}
				incomingEdges.get(changedIndex).increaseValue(.34-value);
			}
			if(actualValue==0){
				if(value<0){
					minVal=Double.MAX_VALUE;
					for(i=0;i<incomingEdges.size();i++){
						if(incomingEdges.get(i).getValue()<=minVal&&incomingEdges.get(i).getValue()!=0){
							minVal=incomingEdges.get(i).getValue();
							changedIndex=i;
						}
					}		
					incomingEdges.get(changedIndex).increaseValue(-.32-value);
				}
				else{
					minVal=Double.MIN_VALUE;
					for(i=0;i<incomingEdges.size();i++){
						if(incomingEdges.get(i).getValue()>=minVal&&incomingEdges.get(i).getValue()!=0){
							minVal=incomingEdges.get(i).getValue();
							changedIndex=i;
						}
					}
					incomingEdges.get(changedIndex).increaseValue(.32-value);
				}
			}
			if(actualValue==-1){
				minVal=Double.MIN_VALUE;
				for(i=0;i<incomingEdges.size();i++){
					if(incomingEdges.get(i).getValue()>=minVal&&incomingEdges.get(i).getValue()!=0){
						minVal=incomingEdges.get(i).getValue();
						changedIndex=i;
					}
				}
				if(minVal==Double.MAX_VALUE){
					//all hidden nodes have zero value must go back one to create a changeable value
					incomingEdges.get(myRandom.nextInt(incomingEdges.size())).startNode.backPropegate(1);
					this.backPropegate(actualValue);
					return;
				}
				incomingEdges.get(changedIndex).increaseValue(-.34-value);
			}
			this.calculateValue();
		}
	}
}
