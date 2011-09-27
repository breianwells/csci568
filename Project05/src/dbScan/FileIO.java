package dbScan;

import java.util.Vector;
import java.io.*;


public class FileIO {

	public static Vector<double[]> ReadFile(String FileName){
		Vector<double[]> ret;
		Vector<String> temp;
		double[]current;
		BufferedReader bufRdr;
		int i;
		String line;
		String[]Tokens;
		ret = new Vector<double[]>();
		try {
			temp=new Vector<String>();
			bufRdr= new BufferedReader(new FileReader(FileName));
			while((line = bufRdr.readLine()) != null){
					Tokens=line.split(",");
					for(i=0;i<Tokens.length;i++){
						
						try{
							Double.parseDouble(Tokens[i]);
							temp.add(Tokens[i]);
						}
						catch(NumberFormatException e){
							
						}
					}
					
					current=new double[temp.size()];
					for(i=0;i<temp.size();i++){
						try{
							current[i]=Double.parseDouble(temp.get(i));
						}
						catch(NumberFormatException e){
						
						}		
					}
					ret.add(current);
			}
			return ret;
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
