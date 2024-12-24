package mock_example;

import java.io.File;

//import javax.jws.WebService; //3 this errors

public class Mock_Example {
	public class LogAnalyzer
	{		
		IWebService service; //1
		
		public LogAnalyzer() {
			service = new WebService(); //<--1
		}
		
		public LogAnalyzer(IWebService webService) { // Changed property type to interface one
			service = webService;
		}
				
		public void Analyze(String fileName) throws Exception {
			if (fileName.length() < 8) { // Fix bug: this should be file name not file content (based on the log)
				service.LogError("File name too short: "+fileName);
			}			
		}		
	}
	
	public interface IWebService {
		public void LogError(String message);
	}
	
	public class WebService implements IWebService {
		public void LogError(String message) {
			System.out.print(message);
		}
	}
}
