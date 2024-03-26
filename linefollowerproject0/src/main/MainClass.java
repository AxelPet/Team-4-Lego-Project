package main;

import tools.Logger;

public class MainClass {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello world!");
		
		Logger logger = new Logger("logs/recent.txt");
		
		logger.logLine("Hello world!");
	}
}
