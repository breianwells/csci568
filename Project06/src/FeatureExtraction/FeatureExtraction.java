package FeatureExtraction;

import java.util.Vector;

public class FeatureExtraction {

	public static void extractLetters(Vector<String> Records){
		String temp;
		int count;
		int totalValue;
		int doubledVowels;
		int totalcount;
		int vowelCount;
		Records.set(0, Records.get(0)+", A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, Total, Vowles, Consenents, percent, doubledV, score");
		for(int i =1;i<Records.size();i++){
			totalcount=0;
			totalValue=0;
			doubledVowels=0;
			vowelCount=0;
			for(int j =0;j<26;j++){
				count=0;
				temp=Records.get(i).split(",")[0];
				temp=temp.toLowerCase();
				for(int k=0;k<temp.length();k++){
					if(temp.charAt(k)==(char)(j+97)){
						count++;
						totalValue+=j;
						totalcount++;
						if(j==0||j==4||j==8||j==14||j==20){
							vowelCount++;
						}
					}
				}
				if((j==0||j==4||j==8||j==14||j==20)&&count>1){
					doubledVowels++;
				}
				Records.set(i, Records.get(i)+", "+count);
			}
			Records.set(i, Records.get(i)+", "+totalcount+", "+ vowelCount+", "+(totalcount-vowelCount)+", "+((double)vowelCount/totalcount)+", "+doubledVowels+", "+totalValue);
		}
	}
	
}
