package UnitTest;

import managers.IFileManager;

public class StubFileManager implements IFileManager {
	@Override
	public boolean fileExists(String fileName) {
		return true;
	}
}
