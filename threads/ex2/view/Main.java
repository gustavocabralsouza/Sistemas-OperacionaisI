package view;

import java.security.SecureRandom;
import java.util.Arrays;

import controller.MatrizThread;


public class Main {

	public static void main(String[] args) {
		SecureRandom random = new SecureRandom();

		int[][] matriz = new int[3][5];

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++)
				matriz[i][j] = (random.nextInt(5)+1);
		}
		
		int linha = 0;
		
		for (int[] is : matriz) {
			System.out.println(Arrays.toString(is));
			Thread thread = new MatrizThread(linha, is);
			thread.start();
			linha++;
		}

	}

}
