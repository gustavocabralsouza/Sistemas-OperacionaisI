package view;

import java.security.SecureRandom;
import java.util.Arrays;

import controller.RunThread;


public class Main {

	public static void main(String[] args) {
		for (int id = 0; id < 5; id++) {
			int posicaoInicial = 0;
			Thread t = new RunThread(id, posicaoInicial);
			t.start();
		}
		
	}

}