package UnitTest;

import mock_example.Mock_Example;

public class MockWebService implements Mock_Example.IWebService {
	public String lastMessage; 
	
	@Override
	public void LogError(String message) {
		lastMessage = message;
	}
}
