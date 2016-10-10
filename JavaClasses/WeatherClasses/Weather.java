package WeatherClasses;

import java.io.*;
import java.util.HashMap;
import HelperClasses.ResourceHelper;


public class Weather {
	
	String weatherFile;
	BufferedReader reader;
	ResourceHelper helper;
	
	
	public Weather(String weatherFile){
		this.weatherFile = weatherFile;
		this.helper = new ResourceHelper();
	}
		
	public double getSmallestTemperatureSpread() throws IOException{
		
		reader = helper.bufferReader(weatherFile);
		HashMap header = helper.getHeader(reader);
		
		reader.readLine();
		
		int smallestTempSpread = helper.getSmallestDifference(reader, header, "MxT", "MnT");
	
		reader.close();
		return smallestTempSpread;
	}	
	
}
