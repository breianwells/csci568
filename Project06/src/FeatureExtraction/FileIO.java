package FeatureExtraction;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

public class FileIO {

	public static Vector<String> ReadFile(String FileName){
		Vector<String> ret;
		BufferedReader bufRdr;
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
	
	public static void WriteFile(String FileName,Vector<String> Records){
		BufferedWriter file;
		try {
			file=new BufferedWriter(new FileWriter(FileName));
			for(int i =0;i<Records.size();i++){
				file.write(Records.get(i));
				file.newLine();
			}
			file.flush();
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
}
