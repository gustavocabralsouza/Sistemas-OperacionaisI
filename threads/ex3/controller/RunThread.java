package controller;


import java.util.Random;

public class RunThread extends Thread {

	private int id = 0;
	private int posicaoInicial = 0;
	final int fim = 10;
	private static int colocacao = 1;
	
	public RunThread(int id, int posicaoInicial) {
		this.id = id;
		this.posicaoInicial = posicaoInicial;
	}
	
	Random random = new Random();
	
	@Override
	public void run() {
		iniciarCorrida();
	}

	private void iniciarCorrida() {
		while(posicaoInicial < fim) {
			System.out.printf("Id = %d -> posicao %d \n", id, posicaoInicial);
			posicaoInicial += random.nextInt(3);
		}
		
		System.out.println("Id = " +id+ " " +colocacao+ "°");
		colocacao ++;
	}
	
	
}
