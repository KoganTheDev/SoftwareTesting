package propertyInjection_example;

import java.io.File;

import managers.FileManager;
import managers.IFileManager;

public class PropertyInjection {
	private IFileManager fileManager;
	
	public PropertyInjection() {
		fileManager = new FileManager();
	}
	
	public void setFileManager(IFileManager fileManager) {
		this.fileManager = fileManager;
	}
	
	public class LogAnalyzer
	{		
		public boolean IsValidLogFileName(String fileName, String extName) throws Exception {
			if (!fileManager.fileExists(fileName + "." + extName)) {	//it was	(1)
				throw new Exception("No log file with that name exists");
			}
			if(!extName.equalsIgnoreCase("pdf")) {
				return false;
			}
			return true;			
		}		
	}	
}
