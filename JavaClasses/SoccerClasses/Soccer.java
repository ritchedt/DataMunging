package SoccerClasses;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

import HelperClasses.ResourceHelper;

public class Soccer {

	String soccerFile;
	BufferedReader reader;
	ResourceHelper helper;
	
	
	public Soccer(String soccerFile){
		this.soccerFile = soccerFile;
		this.helper = new ResourceHelper();
	}
		
	public int getSmallestPointSpread() throws IOException{
		
		reader = helper.bufferReader(soccerFile);
		HashMap header = helper.getHeader(reader);
		
		reader.readLine();
		
		int smallestTempSpread = helper.getSmallestDifference(reader, header, "F", "A");
	
		reader.close();
		return smallestTempSpread;
	}
	
}
