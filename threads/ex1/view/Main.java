package view;

import controller.PrintThread;

public class Main {

	public static void main(String[] args) {
		
		for(int IdThread=0;IdThread<5;IdThread++) {
			Thread printThread = new PrintThread(IdThread);
			printThread.start();
		}  
		
	}

}
