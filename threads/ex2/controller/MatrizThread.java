package controller;

/*
 * Fazer uma aplica��o que insira n�meros aleat�rios em uma matriz 3 x 5 e tenha 3 chamadas de Threads, onde 
cada uma calcula a  soma dos valores de cada linha, imprimindo a identifica��o da linha e o resultado da soma
Dica: A main deve gerar uma matriz com n�meros aleat�rios, mas a Thread recebe um vetor (uma linha da matriz)
 */

import java.util.stream.IntStream;


public class MatrizThread extends Thread {
	private int[] vetor;
	private int linha;

	public MatrizThread(int linha, int[] vetor) {
		this.vetor = vetor;
		this.linha = linha;
	}

	@Override
	public void run() {
		exibirSoma();
	}

	
	private void exibirSoma() {
		System.out.println("Linha " + linha + " - Resultado = " + IntStream.of(vetor).sum());
	}
	
}
