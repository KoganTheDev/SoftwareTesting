package testingCourse.lab8_Mockito_testing;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import testingCourse.lab8_Mockito.Location;
import testingCourse.lab8_Mockito.LocationPoint;
import testingCourse.lab8_Mockito.LocationService;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.WARN)
class LocationTest {
	@Mock
	LocationService locationService;
	
	Location location;
	
	@BeforeEach
	void setUp() {
		location = new Location(locationService);
		location.SetCheckPoint(null); // Ensure that the test don't bother each other due to static value
	}
	
	// Test locate with positive values
	@Test
	void testLocate() {
		// Prepare
		int x = -4, y = -5;
		
		// Execute
		LocationPoint point = location.locate(x, y);
		
		// Verify that geoLocate was not called this time
		Mockito.verify(locationService, times(0)).geoLocate(Mockito.isA(LocationPoint.class));
		
		// Assert that it returned positive of the location given
		assertEquals(point.getX(), -x);
		assertEquals(point.getY(), -y);
	}
	
	// Test locate with negative values
	@Test
	void testLocateNegative() {
		// Prepare
		int x = 4, y = 5;
		LocationPoint expectedPoint = new LocationPoint(x, y);
		
		// Use mockito to make geoLocate return expectPoint
		when(locationService.geoLocate(Mockito.isA(LocationPoint.class))).thenReturn(expectedPoint);
	
		// Execute
		LocationPoint point = location.locate(x, y);
		
		// Verify that geoLocate was called once
		Mockito.verify(locationService, times(1)).geoLocate(Mockito.isA(LocationPoint.class));
		
		// Assert that the point returned is the expected point
		assertEquals(point, expectedPoint);
	}

	// Tests printCalculationStatus in case OK is given by the locationService
	@Test
	void testPrintCalculationStatus() {
		// Prepare
		LocationPoint expectedPoint = new LocationPoint(3, 1);

		// Use mockito to make printStatus return "OK"
		when(locationService.printStatus(expectedPoint)).thenReturn("OK");

		// Execute
		location.printCalculationStatus(expectedPoint);

		// Verify that printStatus was called once
		Mockito.verify(locationService, times(1)).printStatus(expectedPoint);
		
		// Assert that the point was truly set in the Location class
		assertEquals(location.GetCheckPoint(), expectedPoint);
	}

	// Tests printCalculationStatus in case null is given / locationService doesn't return OK
	@Test
	void testPrintCalculationStatusException() {
		// Make printStatus return "NOT_OK" when called with null
		when(locationService.printStatus(null)).thenReturn("NOT_OK");
		
		// Execute with try
		try {
			location.printCalculationStatus(null);
			fail(); // Should throw!
		} catch (NullPointerException e) {
			assertEquals(e.getMessage(), "null object");
		} catch (Exception e) {
			fail(); // Should throw NullPointerException
		}
		
		// Verify that printStatus was called once
		Mockito.verify(locationService, times(1)).printStatus(null);
		
		// Assert that the point wasn't set
		assertEquals(location.GetCheckPoint(), null);
	}
}
