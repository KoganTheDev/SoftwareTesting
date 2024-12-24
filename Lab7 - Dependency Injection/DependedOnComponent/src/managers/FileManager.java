package managers;
import java.io.File;

public class FileManager implements IFileManager {
	public boolean fileExists(String fileName) {
		return new File(fileName).exists();
	}
}
