package preprocess;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

public class PreprocessData {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BufferedReader bufRdr;
		BufferedWriter bufWrt;
		String line;
		String[] elements;
		try {
			bufRdr= new BufferedReader(new FileReader("mushroom.csv"));
			bufWrt = new BufferedWriter(new FileWriter("CleanedMushroomBin.csv"));
			line="IsEdible,capBell,capConical,capConvex,capFlat,capKnobbed,capSunken,capFibrous,capGrooves,capScaly,capSmooth";
			line+=",capBrown,capBuff,capCinnamon,capGray,capGreen,cappink,capPurple,capRed,capWhite,capYellow,IsBruisable";
			line+=",odorAlmond,odorAnise,odorCreosote,odorFishy,odorFoul,odorMusty,odorNone,odorPungent,odorSpicy,gillAttached,gillDescending,gillFree,gillNotched";
			line+=",gillClose,gillCrowded,gillDistant,isGillBroad,gillBlack,gillBrown,gillBuff,gillChocolate,gillGray";
			line+=",gillGreen,gillOrange,gillPink,gillPurple,gillRed,gillWhite,gillYellow,stalkEnlarge,stalkTaper";
			line+=",stalkBulbous,stalkClub,stalkCup,stalkEqual,stalkRhizo,stalkroot,stalkMissing,aboveFibrous,aboveScaly,aboveSilky,aboveSmooth";
			line+=",belowFibrous,belowScaly,belowSilky,belowSmooth,aboveBrown,aboveBuff,aboveCinnamon,aboveGray,aboveOrange,abovePink,aboveRed,aboveWhite,aboveYellow";
			line+=",belowBrown,belowBuff,belowCinnamon,belowGray,belowOrange,belowPink,belowRed,belowWhite,belowYellow,isVeilPartial,veilBrown,veilOrange,veilWhite,veilYellow";
			line+=",ringZero,ringOne,ringTwo,ringCobweb,ringEvan,ringFlaring,ringLarge,ringNone,ringPendant,ringSheath,ringZone";
			line+=",sporeBlack,sporeBrown,sporeBuff,sporeChocolate,sporeGreen,sporeOrange,sporePurple,sporeWhite,sporeYellow,abundant,clustered,numerous,scattered,several,solitary,grass,leaves,meadow,path,urban,waste,woods\n";
			bufWrt.write(line);
			bufWrt.flush();
			line=bufRdr.readLine();
			while((line = bufRdr.readLine()) != null){
				elements=line.split(",");
				line="";
				if(elements[0].equals("e"))
					line+="1";
				else
					line+="0";
				if(elements[1].equals("b"))
					line+=",1,0,0,0,0,0";
				if(elements[1].equals("c"))
					line+=",0,1,0,0,0,0";
				if(elements[1].equals("x"))
					line+=",0,0,1,0,0,0";
				if(elements[1].equals("f"))
					line+=",0,0,0,1,0,0";
				if(elements[1].equals("k"))
					line+=",0,0,0,0,1,0";
				if(elements[1].equals("s"))
					line+=",0,0,0,0,0,1";
				if(elements[2].equals("f"))
					line+=",1,0,0,0";
				if(elements[2].equals("g"))
					line+=",0,1,0,0";
				if(elements[2].equals("y"))
					line+=",0,0,1,0";
				if(elements[2].equals("s"))
					line+=",0,0,0,1";
				if(elements[3].equals("n"))
					line+=",1,0,0,0,0,0,0,0,0,0";
				if(elements[3].equals("b"))
					line+=",0,1,0,0,0,0,0,0,0,0";
				if(elements[3].equals("c"))
					line+=",0,0,1,0,0,0,0,0,0,0";
				if(elements[3].equals("g"))
					line+=",0,0,0,1,0,0,0,0,0,0";
				if(elements[3].equals("r"))
					line+=",0,0,0,0,1,0,0,0,0,0";
				if(elements[3].equals("p"))
					line+=",0,0,0,0,0,1,0,0,0,0";
				if(elements[3].equals("u"))
					line+=",0,0,0,0,0,0,1,0,0,0";
				if(elements[3].equals("e"))
					line+=",0,0,0,0,0,0,0,1,0,0";
				if(elements[3].equals("w"))
					line+=",0,0,0,0,0,0,0,0,1,0";
				if(elements[3].equals("y"))
					line+=",0,0,0,0,0,0,0,0,0,1";
				if(elements[4].equals("t"))
					line+=",1";
				else
					line+=",0";
				if(elements[5].equals("a"))
					line+=",1,0,0,0,0,0,0,0,0";
				if(elements[5].equals("l"))
					line+=",0,1,0,0,0,0,0,0,0";
				if(elements[5].equals("c"))
					line+=",0,0,1,0,0,0,0,0,0";
				if(elements[5].equals("y"))
					line+=",0,0,0,1,0,0,0,0,0";
				if(elements[5].equals("f"))
					line+=",0,0,0,0,1,0,0,0,0";
				if(elements[5].equals("m"))
					line+=",0,0,0,0,0,1,0,0,0";
				if(elements[5].equals("n"))
					line+=",0,0,0,0,0,0,1,0,0";
				if(elements[5].equals("p"))
					line+=",0,0,0,0,0,0,0,1,0";
				if(elements[5].equals("s"))
					line+=",0,0,0,0,0,0,0,0,1";
				if(elements[6].equals("a"))
					line+=",1,0,0,0";
				if(elements[6].equals("d"))
					line+=",0,1,0,0";
				if(elements[6].equals("f"))
					line+=",0,0,1,0";
				if(elements[6].equals("n"))
					line+=",0,0,0,1";
				if(elements[7].equals("c"))
					line+=",1,0,0";
				if(elements[7].equals("w"))
					line+=",0,1,0";
				if(elements[7].equals("d"))
					line+=",0,0,1";
				if(elements[8].equals("b"))
					line+=",1";
				else
					line+=",0";
				if(elements[9].equals("k"))
					line+=",1,0,0,0,0,0,0,0,0,0,0,0";
				if(elements[9].equals("n"))
					line+=",0,1,0,0,0,0,0,0,0,0,0,0";
				if(elements[9].equals("b"))
					line+=",0,0,1,0,0,0,0,0,0,0,0,0";
				if(elements[9].equals("h"))
					line+=",0,0,0,1,0,0,0,0,0,0,0,0";
				if(elements[9].equals("g"))
					line+=",0,0,0,0,1,0,0,0,0,0,0,0";
				if(elements[9].equals("r"))
					line+=",0,0,0,0,0,1,0,0,0,0,0,0";
				if(elements[9].equals("o"))
					line+=",0,0,0,0,0,0,1,0,0,0,0,0";
				if(elements[9].equals("p"))
					line+=",0,0,0,0,0,0,0,1,0,0,0,0";
				if(elements[9].equals("u"))
					line+=",0,0,0,0,0,0,0,0,1,0,0,0";
				if(elements[9].equals("e"))
					line+=",0,0,0,0,0,0,0,0,0,1,0,0";
				if(elements[9].equals("w"))
					line+=",0,0,0,0,0,0,0,0,0,0,1,0";
				if(elements[9].equals("y"))
					line+=",0,0,0,0,0,0,0,0,0,0,0,1";
				if(elements[10].equals("e"))
					line+=",1,0";
				if(elements[10].equals("t"))
					line+=",0,1";
				if(elements[11].equals("b"))
					line+=",1,0,0,0,0,0,0";
				if(elements[11].equals("c"))
					line+=",0,1,0,0,0,0,0";
				if(elements[11].equals("u"))
					line+=",0,0,1,0,0,0,0";
				if(elements[11].equals("e"))
					line+=",0,0,0,1,0,0,0";
				if(elements[11].equals("z"))
					line+=",0,0,0,0,1,0,0";
				if(elements[11].equals("r"))
					line+=",0,0,0,0,0,1,0";
				if(elements[11].equals("?"))
					line+=",0,0,0,0,0,0,1";
				if(elements[12].equals("f"))
					line+=",1,0,0,0";
				if(elements[12].equals("y"))
					line+=",0,1,0,0";
				if(elements[12].equals("k"))
					line+=",0,0,1,0";
				if(elements[12].equals("s"))
					line+=",0,0,0,1";
				if(elements[13].equals("f"))
					line+=",1,0,0,0";
				if(elements[13].equals("y"))
					line+=",0,1,0,0";
				if(elements[13].equals("k"))
					line+=",0,0,1,0";
				if(elements[13].equals("s"))
					line+=",0,0,0,1";
				if(elements[14].equals("n"))
					line+=",1,0,0,0,0,0,0,0,0";
				if(elements[14].equals("b"))
					line+=",0,1,0,0,0,0,0,0,0";
				if(elements[14].equals("c"))
					line+=",0,0,1,0,0,0,0,0,0";
				if(elements[14].equals("g"))
					line+=",0,0,0,1,0,0,0,0,0";
				if(elements[14].equals("o"))
					line+=",0,0,0,0,1,0,0,0,0";
				if(elements[14].equals("p"))
					line+=",0,0,0,0,0,1,0,0,0";
				if(elements[14].equals("e"))
					line+=",0,0,0,0,0,0,1,0,0";
				if(elements[14].equals("w"))
					line+=",0,0,0,0,0,0,0,1,0";
				if(elements[14].equals("y"))
					line+=",0,0,0,0,0,0,0,0,1";
				if(elements[15].equals("n"))
					line+=",1,0,0,0,0,0,0,0,0";
				if(elements[15].equals("b"))
					line+=",0,1,0,0,0,0,0,0,0";
				if(elements[15].equals("c"))
					line+=",0,0,1,0,0,0,0,0,0";
				if(elements[15].equals("g"))
					line+=",0,0,0,1,0,0,0,0,0";
				if(elements[15].equals("o"))
					line+=",0,0,0,0,1,0,0,0,0";
				if(elements[15].equals("p"))
					line+=",0,0,0,0,0,1,0,0,0";
				if(elements[15].equals("e"))
					line+=",0,0,0,0,0,0,1,0,0";
				if(elements[15].equals("w"))
					line+=",0,0,0,0,0,0,0,1,0";
				if(elements[15].equals("y"))
					line+=",0,0,0,0,0,0,0,0,1";
				if(elements[16].equals("p"))
					line+=",1";
				else
					line+=",0";
				if(elements[17].equals("n"))
					line+=",1,0,0,0";
				if(elements[17].equals("o"))
					line+=",0,1,0,0";
				if(elements[17].equals("w"))
					line+=",0,0,1,0";
				if(elements[17].equals("y"))
					line+=",0,0,0,1";
				if(elements[18].equals("n"))
					line+=",1,0,0";
				if(elements[18].equals("o"))
					line+=",0,1,0";
				if(elements[18].equals("t"))
					line+=",0,0,1";
				if(elements[19].equals("c"))
					line+=",1,0,0,0,0,0,0,0";
				if(elements[19].equals("e"))
					line+=",0,1,0,0,0,0,0,0";
				if(elements[19].equals("f"))
					line+=",0,0,1,0,0,0,0,0";
				if(elements[19].equals("l"))
					line+=",0,0,0,1,0,0,0,0";
				if(elements[19].equals("n"))
					line+=",0,0,0,0,1,0,0,0";
				if(elements[19].equals("p"))
					line+=",0,0,0,0,0,1,0,0";
				if(elements[19].equals("s"))
					line+=",0,0,0,0,0,0,1,0";
				if(elements[19].equals("z"))
					line+=",0,0,0,0,0,0,0,1";
				if(elements[20].equals("k"))
					line+=",1,0,0,0,0,0,0,0,0";
				if(elements[20].equals("n"))
					line+=",0,1,0,0,0,0,0,0,0";
				if(elements[20].equals("b"))
					line+=",0,0,1,0,0,0,0,0,0";
				if(elements[20].equals("h"))
					line+=",0,0,0,1,0,0,0,0,0";
				if(elements[20].equals("r"))
					line+=",0,0,0,0,1,0,0,0,0";
				if(elements[20].equals("o"))
					line+=",0,0,0,0,0,1,0,0,0";
				if(elements[20].equals("u"))
					line+=",0,0,0,0,0,0,1,0,0";
				if(elements[20].equals("w"))
					line+=",0,0,0,0,0,0,0,1,0";
				if(elements[20].equals("y"))
					line+=",0,0,0,0,0,0,0,0,1";
				if(elements[21].equals("a"))
					line+=",1,0,0,0,0,0";
				if(elements[21].equals("c"))
					line+=",0,1,0,0,0,0";
				if(elements[21].equals("n"))
					line+=",0,0,1,0,0,0";
				if(elements[21].equals("s"))
					line+=",0,0,0,1,0,0";
				if(elements[21].equals("v"))
					line+=",0,0,0,0,1,0";
				if(elements[21].equals("y"))
					line+=",0,0,0,0,0,1";
				if(elements[22].equals("g"))
					line+=",1,0,0,0,0,0,0";
				if(elements[22].equals("l"))
					line+=",0,1,0,0,0,0,0";
				if(elements[22].equals("m"))
					line+=",0,0,1,0,0,0,0";
				if(elements[22].equals("p"))
					line+=",0,0,0,1,0,0,0";
				if(elements[22].equals("u"))
					line+=",0,0,0,0,1,0,0";
				if(elements[22].equals("w"))
					line+=",0,0,0,0,0,1,0";
				if(elements[22].equals("d"))
					line+=",0,0,0,0,0,0,1";
				line+="\n";
				bufWrt.write(line);
				bufWrt.flush();
			}
			bufWrt.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
	}

}