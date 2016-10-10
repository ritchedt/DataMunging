package Weather;

import java.io.*;
import java.util.HashMap;


public class Weather {
	
	String weatherFile;
	
	public Weather(String weatherFile){
		this.weatherFile = weatherFile;
	}
		
	public double getSmallestTemperatureSpread() throws IOException{
		
		BufferedReader reader = new BufferedReader(new FileReader(weatherFile));
		HashMap headerValue = new HashMap();
		
		String readLine = reader.readLine();
		String regExWhiteSpace = "(\\s)+";
		
		
		String[] getHeaderValues = readLine.split(regExWhiteSpace);
		
		for(int i=0; i<getHeaderValues.length; i++) {
			headerValue.put(getHeaderValues[i],i);
	    }
		
		reader.readLine();
		
		int maxTemp,minTemp;
		int smallestTempSpread = Integer.MAX_VALUE;
		
		while((readLine = reader.readLine()) != null) {
			
			if(readLine.contains("mo"))
				break;
			
			String[] getLineRowValues = readLine.split(regExWhiteSpace);
			
			maxTemp = Integer.parseInt(getLineRowValues[(int) headerValue.get("MxT")].replaceAll("\\*", ""));
			minTemp = Integer.parseInt(getLineRowValues[(int) headerValue.get("MnT")].replaceAll("\\*", ""));
			
			if((maxTemp-minTemp) < smallestTempSpread)
				smallestTempSpread = (maxTemp-minTemp);
		}
	
		reader.close();
		
		return smallestTempSpread;
	}	
	
}
