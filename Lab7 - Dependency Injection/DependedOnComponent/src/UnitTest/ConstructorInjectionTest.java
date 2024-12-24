package UnitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import constructorInjection_example.ConstructorInjection;
import constructorInjection_example.ConstructorInjection.LogAnalyzer;

public class ConstructorInjectionTest {
	private LogAnalyzer logAnalyzer;
	
	@BeforeEach
	void setUp() throws Exception {
		ConstructorInjection constructorInjection = new ConstructorInjection(new StubFileManager());
		logAnalyzer = constructorInjection.new LogAnalyzer();
	}

	/**
	 * Tests the case if the file name is valid (contains .docx)
	 * We do "throws" but if all goes well it shouldn't throw in any circumstance thanks to the stub.
	 * @throws Exception
	 */
	@Test
	void testFileValidExtension() throws Exception {
		assertTrue(logAnalyzer.IsValidLogFileName("z:\\test-course.docx"));
	}

	/**
	 * Tests the case if the file name is invalid (doesn't contain .docx)
	 * @throws Exception
	 */
	@Test
	void testFileInvalidExtension() throws Exception {
		assertFalse(logAnalyzer.IsValidLogFileName("z:\\great-file.doc"));
	}

}

/*
 * Things I changed:
 * 1. Added IFileManager, FileManager and of course StubFileManager for the testing part
 * FileManager handles just telling if a file exists or not in testing we tell the method under testing it does regardless.
 * 2.
 */