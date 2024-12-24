package constructorInjection_example;
import java.io.File;

import managers.FileManager;
import managers.IFileManager;
 

public class ConstructorInjection {
	private IFileManager fileManager;
	
	public ConstructorInjection() {
		fileManager = new FileManager();
	}
	
	public ConstructorInjection(IFileManager fileManager) {
		this.fileManager = fileManager;
	}
	
	public class LogAnalyzer
	{
		public boolean IsValidLogFileName(String fileName) throws Exception {
			if (!fileManager.fileExists(fileName)) {
				throw new Exception("No log file with that name exists");
			}
			if( !fileName.toLowerCase().endsWith(".docx")) {
				return false;
			}
			return true;			
		}		
	}	
}
