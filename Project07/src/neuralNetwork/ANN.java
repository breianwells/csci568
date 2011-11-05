package neuralNetwork;

import java.util.Random;
import java.util.Vector;

public class ANN {
	private Vector<Node> startLayer;
	private Vector<Node> hiddenLayer;
	private Vector<Node> finalLayer;
	
	public ANN(int startLayerCount,int hiddenLayerCount,int finalLayerCount){
		Random weights = new Random();
		double newWeight;
		startLayer=new Vector<Node>();
		hiddenLayer=new Vector<Node>();
		finalLayer=new Vector<Node>();
		for(int i=0;i<startLayerCount;i++){
			startLayer.add(new Node());
		}
		for(int i=0;i<hiddenLayerCount;i++){
			hiddenLayer.add(new Node());
		}
		for(int i=0;i<finalLayerCount;i++){
			finalLayer.add(new Node());
		}
		for(int i=0;i<startLayer.size();i++){
			for(int j=0;j<hiddenLayer.size();j++){
				newWeight=weights.nextDouble();
				newWeight=newWeight*2-1;
				hiddenLayer.get(j).addEdge(newWeight, startLayer.get(i));
			}
		}
		for(int i=0;i<hiddenLayer.size();i++){
			for(int j=0;j<finalLayer.size();j++){
				newWeight=weights.nextDouble();
				newWeight=newWeight*2-1;
				finalLayer.get(j).addEdge(newWeight, hiddenLayer.get(i));
			}
		}
		
	}
	
	public void calculateNodes(){
		for(int i=0;i<hiddenLayer.size();i++){
			hiddenLayer.get(i).calculateValue();
		}
		for(int i=0;i<finalLayer.size();i++){
			finalLayer.get(i).calculateValue();
		}
	}
	
	public double getFinalValue(int index){
		return finalLayer.get(index).getValue();
	}
	
	public void setStartValue(int index,double val){
		startLayer.get(index).setValue(val);
	}
	
	public static void main(String[] args){
		ANN myANN=new ANN(3,2,3);
		myANN.setStartValue(0,1);
		myANN.setStartValue(1,.25);
		myANN.setStartValue(2,-.5);
		myANN.calculateNodes();
		System.out.println(myANN.getFinalValue(0));
		System.out.println(myANN.getFinalValue(1));
		System.out.println(myANN.getFinalValue(2));
	}

	
	
}
