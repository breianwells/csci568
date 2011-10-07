package FeatureExtraction;

import java.util.Vector;

public class ExtractExecute {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Vector<String> Records;
		Records=FileIO.ReadFile("winners_losers.csv");
		Records.add(0, "name, winner");
		FeatureExtraction.extractLetters(Records);
		FileIO.WriteFile("Updated.csv", Records);
	}

}
