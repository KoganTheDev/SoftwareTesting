package UnitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import propertyInjection_example.PropertyInjection;
import propertyInjection_example.PropertyInjection.LogAnalyzer;


class PropertyInjectionTest {
	private LogAnalyzer logAnalyzer;
	
	@BeforeEach
	void setUp() throws Exception {
		PropertyInjection propertyInjection = new PropertyInjection();
		propertyInjection.setFileManager(new StubFileManager());
		logAnalyzer = propertyInjection.new LogAnalyzer();
	}

	/**
	 * Tests the case if the file name is valid (contains .pdf)
	 * We do "throws" but if all goes well it shouldn't throw in any circumstance thanks to the stub.
	 * @throws Exception
	 */
	@Test
	void testFileValidExtension() throws Exception {
		assertTrue(logAnalyzer.IsValidLogFileName("z:\\answer-sheet", "pdf"));
	}

	/**
	 * Tests the case if the file name is invalid (doesn't contain .pdf)
	 * @throws Exception
	 */
	@Test
	void testFileInvalidExtension() throws Exception {
		assertFalse(logAnalyzer.IsValidLogFileName("z:\\nuclear-codes", "txt"));
	}

}

/*
 * Things I changed:
 * 1. Made PropertyInjection a public class. You cannot test private classes.
 * 2. Fixed the file existence check so that it checks with extension too.
 * 3. Fixed the file name check to check file extension instead because fileName no longer holds the extension.
 * Since the extension now is separate, we don't need to check endsWith but equals.
 */