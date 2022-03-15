package threads.ex05.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;


public class NumeroController implements ActionListener {

	private JButton btnJogar;
	private JTextField txt1;
	private JTextField txt2;
	private JTextField txt3;
	
	public NumeroController(JButton btnJogar, JTextField txt1, JTextField txt2,JTextField txt3) {
		this.btnJogar = btnJogar;
		this.txt1 = txt1;
		this.txt2 = txt2;
		this.txt3 = txt3;
	}
	
	private void gerarPersonagem() {
		Thread t1 = new ThreadJogo(btnJogar, txt1);
		Thread t2 = new ThreadJogo(btnJogar, txt2);
		Thread t3 = new ThreadJogo(btnJogar, txt3);
		t1.start();
		t2.start();
		t3.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		gerarPersonagem();
	}

}
