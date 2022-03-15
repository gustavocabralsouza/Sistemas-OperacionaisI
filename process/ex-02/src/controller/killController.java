package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class killController {
	public killController() {
		super();
	}
	
	private String os() {
		return System.getProperty("os.name");
	}
	
	public void listaProcessos() {
		String systemName = os();
			try {
				if(systemName.contains("Windows") || systemName.contains("windows")) {
					Process processo = Runtime.getRuntime().exec("TASKLIST /FO TABLE");
					InputStream fluxo = processo.getInputStream();
					InputStreamReader leitor = new InputStreamReader(fluxo);
					BufferedReader buffer = new BufferedReader(leitor);
					String linha = buffer.readLine();
					while(linha != null) {
						System.out.println(linha);
						linha = buffer.readLine();
					}
					buffer.close();
					leitor.close();
					fluxo.close();
				}else if(systemName.contains("Linux") || systemName.contains("linux")) {
					Process processo = Runtime.getRuntime().exec("ps -ef");
					InputStream fluxo = processo.getInputStream();
					InputStreamReader leitor = new InputStreamReader(fluxo);
					BufferedReader buffer = new BufferedReader(leitor);
					String linha = buffer.readLine();
					while(linha != null) {
						System.out.println(linha);
						linha = buffer.readLine();
					}
					buffer.close();
					leitor.close();
					fluxo.close();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	
	public void mataPid(int pid) {
		String systemName = os();
		try {
			if(systemName.contains("Windows") || systemName.contains("windows")) {
				String processoCommand = "TASKKILL /PID";
				int pidReference = 0;
				StringBuffer buffer = new StringBuffer();
				buffer.append(processoCommand);
				buffer.append(" ");
				buffer.append(pid);
				Runtime.getRuntime().exec(buffer.toString());
				
			}else if(systemName.contains("Linux") || systemName.contains("linux")) {
				String processoCommand = "kill -9";
				int pidReference = 0;
				StringBuffer buffer = new StringBuffer();
				buffer.append(processoCommand);
				buffer.append(" ");
				buffer.append(pid);
				Runtime.getRuntime().exec(buffer.toString());				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void mataNome(String nameProcess) {
		String systemName = os();
		try {
			if(systemName.contains("Windows") || systemName.contains("windows")) {
				String processoCommand = "TASKKILL /IM";
				StringBuffer buffer = new StringBuffer();
				buffer.append(processoCommand);
				buffer.append(" ");
				buffer.append(nameProcess);
				Runtime.getRuntime().exec(buffer.toString());
				
			}else if(systemName.contains("Linux") || systemName.contains("linux")) {
				String processoCommand = "pkill -f ";
				StringBuffer buffer = new StringBuffer();
				buffer.append(processoCommand);
				buffer.append(" ");
				buffer.append(nameProcess);
				Runtime.getRuntime().exec(buffer.toString());				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	
}
		
