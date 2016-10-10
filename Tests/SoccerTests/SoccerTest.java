package SoccerTests;

import static org.junit.Assert.*;
import java.io.IOException;
import org.junit.Test;
import SoccerClasses.Soccer;


public class SoccerTest {

	@Test
	public void getSmallestTemperatureSpread() throws IOException {
		Soccer test = new Soccer("Resources/football.dat");
		assertTrue(test.getSmallestPointSpread() == -34);
	}

}
