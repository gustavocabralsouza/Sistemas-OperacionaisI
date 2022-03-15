package view;

import javax.swing.JOptionPane;

import controller.killController;

public class main {
	public static void main(String[] args) {
		killController killController = new killController(); 
			 
		String options = "Menu de escolhas \n1 - lista processos \n2 - mata por pid \n3 - mata por nome\n 4 - Finalizar";
		String name = JOptionPane.showInputDialog(null, "Olá, seje bem vindo ao sistema ControlaProcessos, qual seu nome ?", JOptionPane.QUESTION_MESSAGE);
		int choice = 0;
		while (choice != 3) {
			choice = Integer.parseInt(JOptionPane.showInputDialog(options));
			switch (choice) {
				case 1: 
					killController.listaProcessos();
					break;
				case 2:
					int pid = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o pid do processo que deseja matar :",JOptionPane.QUESTION_MESSAGE));
					killController.mataPid(pid);
					break;
				case 3:
					String nomeProcess = JOptionPane.showInputDialog(null, "Digite o nome do processo que deseja matar :",JOptionPane.QUESTION_MESSAGE);
					killController.mataNome(nomeProcess);
					break;
				case 4 :
					JOptionPane.showMessageDialog(null, "Agradecemos a preferência "+name+"!, volte sempre");
					System.exit(0);
					break;
				default:
					JOptionPane.showMessageDialog(null,"Opção Inválida!, favor digitar novamente",name,
						JOptionPane.WARNING_MESSAGE);			
				}
			}
	}
}
