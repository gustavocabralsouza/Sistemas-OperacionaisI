package threads.ex05.controller;

import java.util.Random;

import javax.swing.JButton;
import javax.swing.JTextField;

public class ThreadJogo extends Thread {
	
	private static int contador;
	private JButton btnJogar;
	private JTextField txt;
	
	public ThreadJogo(JButton btnJogar, JTextField txt) {
		this.btnJogar = btnJogar;
		this.txt = txt;
	}
	
	private void iniciarJogo() {
		btnJogar.setVisible(false);
		Random random = new Random();
		int totalGiros = random.nextInt(150)+1;
		
		for(int i = 1; i < totalGiros; i ++) {
			
			try {
				Thread.sleep(70);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
			
			int numero = random.nextInt(7)+1;
			txt.setText(Integer.toString((numero)));
		}
		contador ++;
		if(contador > 2) {
			btnJogar.setVisible(true);
			contador = 0;
		}
		
	}
	
	@Override
	public void run() {
		iniciarJogo();
	}
	
	
}
