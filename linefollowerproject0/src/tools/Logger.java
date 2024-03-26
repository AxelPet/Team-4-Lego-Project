package tools;

import java.io.FileOutputStream;

public class Logger {
	/*
	 * This is a logger, with meaning to log text in files when printing text is not possible.
	 */
	
	
	// Private attributes:
	public FileOutputStream fos = null;
	
	public Logger(String filepath) {
		try {
			fos = new FileOutputStream(filepath);
		}
		
		catch (Exception e) {
			System.out.println("Error while initializing object Logger.");
		}
	}
	
	public boolean close() {
		/* 
		 * Closes the fos, if it's not null.
		 * Returns true if the close is successful, otherwise false.
		 */
		try {
			if (fos != null) {
				// Attempting to close the fos.
				fos.close();
				// If no errors occurred, everything has gone as planned. We can return true.
				return true;
			}
			
			else {
				// If the fos is null, then something must be wrong, returning false.
				return false;
			}
			
		}
		
		catch (Exception e) {
			System.out.println("Error while closing object Logger.");
			// If an error occurred, something must be wrong, returning false.
			return false;
		}
	}
	
	public boolean logLine(String s) {
		try {
			fos.write((s + "\n").getBytes());
			return true;
		}
		
		catch (Exception e) {
			System.out.println("Error while logging text " + s);
			return false;
		}
	}
}
