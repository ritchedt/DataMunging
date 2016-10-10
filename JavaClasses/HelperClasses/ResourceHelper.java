package HelperClasses;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class ResourceHelper {
	
	String rowTitle;
	String regExWhiteSpace = "(\\s|\\d+\\.|-)+";
	
	
	public BufferedReader bufferReader(String resourceFile) throws FileNotFoundException{
		BufferedReader a = new BufferedReader(new FileReader(resourceFile));
		return a;
	}
	
	public HashMap getHeader(BufferedReader reader) throws IOException{
		
		HashMap headerValue = new HashMap();
		String[] getHeaderValues = reader.readLine().split(regExWhiteSpace);
		rowTitle = getHeaderValues[1];
		
		for(int i=0; i<getHeaderValues.length; i++) {
			headerValue.put(getHeaderValues[i],i);
	    }
		return headerValue;
	}
	
	public int getSmallestDifference(BufferedReader reader, HashMap headerValue, String columnHigh, String columnLow) throws IOException{
		
		int highVal,lowVal;
		int smallestSpread = Integer.MAX_VALUE;
		String readLine, rowTitle = "";
		
		while((readLine = reader.readLine()) != null) {
			
			if(!(readLine.contains("mo")) && !(readLine.contains("--"))){
				String[] getLineRowValues = readLine.split(regExWhiteSpace);
				
				highVal = Integer.parseInt(getLineRowValues[(int) headerValue.get(columnHigh)].replaceAll("\\*", ""));
				lowVal = Integer.parseInt(getLineRowValues[(int) headerValue.get(columnLow)].replaceAll("\\*", ""));
				
				if((highVal-lowVal) < smallestSpread){
					smallestSpread = (highVal-lowVal);
					rowTitle = getLineRowValues[(int) headerValue.get(this.rowTitle)].replaceAll("\\*", "");
				}
			}
		}
		System.out.println("Smallest difference was for: " + this.rowTitle + " " + rowTitle + " with " + smallestSpread);
		return smallestSpread;
	}

}
