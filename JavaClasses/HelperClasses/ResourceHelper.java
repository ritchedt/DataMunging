package HelperClasses;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class ResourceHelper {
	
	String regExWhiteSpace = "(\\s|\\d+\\.|-)+";
	
	
	public BufferedReader bufferReader(String resourceFile) throws FileNotFoundException{
		BufferedReader a = new BufferedReader(new FileReader(resourceFile));
		return a;
	}
	
	public HashMap getHeader(BufferedReader reader) throws IOException{
		
		HashMap headerValue = new HashMap();
		String[] getHeaderValues = reader.readLine().split(regExWhiteSpace);
		
		for(int i=0; i<getHeaderValues.length; i++) {
			headerValue.put(getHeaderValues[i],i);
	    }
		return headerValue;
	}
	
	public int getSmallestDifference(BufferedReader reader, HashMap headerValue, String columnHigh, String columnLow) throws IOException{
		
		int highVal,lowVal;
		int smallestSpread = Integer.MAX_VALUE;
		String readLine;
		
		while((readLine = reader.readLine()) != null) {
			
			if(!(readLine.contains("mo")) && !(readLine.contains("--"))){
				String[] getLineRowValues = readLine.split(regExWhiteSpace);
				
				highVal = Integer.parseInt(getLineRowValues[(int) headerValue.get(columnHigh)].replaceAll("\\*", ""));
				lowVal = Integer.parseInt(getLineRowValues[(int) headerValue.get(columnLow)].replaceAll("\\*", ""));
				
				if((highVal-lowVal) < smallestSpread)
					smallestSpread = (highVal-lowVal);
			}
		}
		return smallestSpread;
	}

}
