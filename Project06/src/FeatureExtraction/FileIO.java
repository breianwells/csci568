package FeatureExtraction;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class FileIO {

	public static Vector<String> ReadFile(String FileName){
		Vector<String> ret;
		BufferedReader bufRdr;
		int i;
		String line;
		ret = new Vector<String>();
		try {
			bufRdr= new BufferedReader(new FileReader(FileName));
			while((line = bufRdr.readLine()) != null){
				ret.add(line);	
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
		return ret;
		
	}
	
}
