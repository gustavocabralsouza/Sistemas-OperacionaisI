package threads.ex05.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import threads.ex05.controller.NumeroController;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;

import javax.swing.SwingConstants;

public class Principal extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt1;
	private JTextField txt2;
	private JTextField txt3;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 380, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txt1 = new JTextField();
		txt1.setHorizontalAlignment(SwingConstants.CENTER);
		txt1.setFont(new Font("Tahoma", Font.PLAIN, 50));
		txt1.setEditable(false);
		txt1.setBounds(43, 94, 70, 60);
		contentPane.add(txt1);
		txt1.setColumns(10);
		
		txt2 = new JTextField();
		txt2.setFont(new Font("Tahoma", Font.PLAIN, 50));
		txt2.setHorizontalAlignment(SwingConstants.CENTER);
		txt2.setEditable(false);
		txt2.setBounds(136, 94, 70, 60);
		contentPane.add(txt2);
		txt2.setColumns(10);
		
		txt3 = new JTextField();
		txt3.setFont(new Font("Tahoma", Font.PLAIN, 50));
		txt3.setHorizontalAlignment(SwingConstants.CENTER);
		txt3.setEditable(false);
		txt3.setBounds(228, 94, 70, 60);
		contentPane.add(txt3);
		txt3.setColumns(10);
		
		JButton btnJogar = new JButton("Jogar");
		btnJogar.setBounds(128, 192, 89, 23);
		contentPane.add(btnJogar);
		
		NumeroController numeroController = new NumeroController(btnJogar, txt1, txt2, txt3);
		btnJogar.addActionListener( numeroController);
	}

}
