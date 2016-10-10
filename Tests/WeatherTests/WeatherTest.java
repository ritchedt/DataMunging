package WeatherTests;

import static org.junit.Assert.*;
import java.io.IOException;
import org.junit.Test;
import Weather.Weather;

public class WeatherTest {

	@Test
	public void getSmallestTemperatureSpread() throws IOException {
		Weather test = new Weather("Resources/weather.dat");
		assertTrue(test.getSmallestTemperatureSpread() == 2);
	}

}
