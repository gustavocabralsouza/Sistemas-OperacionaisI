package view;

import javax.swing.JOptionPane;

import controller.RedesController;
public class Main {

	public static void main(String[] args) {
		
		RedesController redesController = new RedesController();
		String options = "Menu de escolhas \n1 - ip \n2 - ping \n3 - Finalizar";
		String name = JOptionPane.showInputDialog(null, "Olá, seje bem vindo ao sistema ProcessosCabral, qual seu nome ?", JOptionPane.QUESTION_MESSAGE);
		int choice = 0;
		while (choice != 3) {
			choose = Integer.parseInt(JOptionPane.showInputDialog(options));
			switch (choice) {
				case 1: 
					redesController.ip();
					break;
				case 2:
					redesController.ping();
					break;
				case 3:
					JOptionPane.showMessageDialog(null, "Agradecemos a preferência "+name+"!, volte sempre");
					break;
				default:
					JOptionPane.showMessageDialog(null,"Opção Inválida!, favor digitar novamente",name,
					JOptionPane.WARNING_MESSAGE);			
			}
		}

	}
}