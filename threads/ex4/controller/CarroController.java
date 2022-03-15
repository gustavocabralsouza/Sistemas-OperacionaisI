package threads.ex04.controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CarroController implements ActionListener {
	private JLabel lblCarro1;
	private JLabel lblCarro2;
	private JButton btnIniciar;
	private JTextField txtVencedor;
	private JTextField txtPerdedor;

	public CarroController(JLabel lblCarro1, JLabel lblCarro2, JButton btnIniciar, JTextField txtVencedor, JTextField txtPerdedor) {
		this.lblCarro1 = lblCarro1;
		this.lblCarro2 = lblCarro2;
		this.btnIniciar = btnIniciar;
		this.txtVencedor = txtVencedor;
		this.txtPerdedor = txtPerdedor;
	}

	private void gerarCarro() {
		Thread t1 = new ThreadCorrida(lblCarro1, btnIniciar, "Carro1", txtVencedor, txtPerdedor, this);
		Thread t2 = new ThreadCorrida(lblCarro2, btnIniciar, "Carro2", txtVencedor, txtPerdedor, this);
		t1.start();
		t2.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		gerarCarro();
	}
	
	public void retornarPosicao() {
		lblCarro1.setBounds(10, 53, 55, 55);
		lblCarro2.setBounds(10, 130, 55, 55);
	}
}