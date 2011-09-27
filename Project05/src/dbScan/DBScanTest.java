package dbScan;

import java.util.Vector;

public class DBScanTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector<double[]> data;	
		double eps;
		data=FileIO.ReadFile("iris.csv");
		eps=DBScan.getEPS(4, data);
		DBScan.dbScan(4, eps, data);
	}

}
