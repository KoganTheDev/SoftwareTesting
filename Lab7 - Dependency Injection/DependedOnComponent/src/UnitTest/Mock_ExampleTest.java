package UnitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mock_example.Mock_Example;
import mock_example.Mock_Example.LogAnalyzer;

class Mock_ExampleTest {
	LogAnalyzer logAnalyzer;
	public MockWebService webService;
	
	@BeforeEach
	void setUp() throws Exception {
		Mock_Example example = new Mock_Example();
		webService = new MockWebService();
		logAnalyzer = example.new LogAnalyzer(webService);
	}

	/**
	 * Tests that expects the WebService to contain one log regarding too short of a file name
	 * @throws Exception 
	 */
	@Test
	void testItLogsWhenFileNameTooShort() throws Exception {
		logAnalyzer.Analyze("t.txt");
		assertEquals(webService.lastMessage, "File name too short: t.txt");
	}

	/**
	 * Tests that expects the WebService to not contain one log regarding too short of a file name
	 * @throws Exception 
	 */
	@Test
	void testItDoesntLogWhenFileNameIsLongEnough() throws Exception {
		logAnalyzer.Analyze("longFileThatShouldntFailThisTest.txt");
		assertNull(webService.lastMessage);
	}
}
