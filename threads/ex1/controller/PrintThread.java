package controller;

public class PrintThread extends Thread {
	
	private int IdThread;
	
	public PrintThread(int idThread) {
		this.IdThread = idThread;
	}
	
	@Override
	public void run() {
		//tudo que estiver aqui vai ser executado.
		showId(IdThread);
	}

	private void showId(int id) {
		int idThread = (int) getId();
		System.out.println("ID da thread de n�mero "+id+ " >>>>" + idThread);
	}
	
}
