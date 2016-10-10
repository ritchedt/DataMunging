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
		HashMap columnName = new HashMap();
		
		String readLine = reader.readLine();
		
		
		
		reader.close();
		
		return 0;
	}	
	
}
