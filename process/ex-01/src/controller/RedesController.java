package controller;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {
	public RedesController() {
		super();
	}
	
	private String os() {
		return  System.getProperty("os.name");
	}

	public void ip() {
		String systemName = os();
		try {
			if (systemName.contains("Windows") || systemName.contains("windows")) {
				Process processo = Runtime.getRuntime().exec("ipconfig");
				InputStream fluxo = processo.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null) {
					String[] linhas = linha.split(" ");
					for (int i = 0; i < linhas.length; i++) {
						if (linhas[i].contains("Ethernet") || linhas[i].contains("IPv4")) {
							System.out.println(linha);
						}
					}
					linha = buffer.readLine();
				}
				buffer.close();
				fluxo.close();
				leitor.close();
			} else if (systemName.contains("Linux")) || systemName.contains("linux") {
				Process processo = Runtime.getRuntime().exec("Ifconfig");
				InputStream fluxo = processo.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null) {
					String[] linhas = linha.split(" ");
					for (int i = 0; i < linhas.length; i++) {
						if (linhas[i].contains("flags") || linhas[i].contains("inet")) {
							System.out.println(linha);
						}
					}
					linha = buffer.readLine();
				}

				buffer.close();
				fluxo.close();
				leitor.close(); 
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void ping() {
		String systemName = os();
		try {
			if (systemName.contains("Windows")) || systemName.contains("windows")) {
				Process processo = Runtime.getRuntime().exec("ping -n 10 www.google.com.br");
				InputStream fluxo = processo.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null) {
					String[] linhas = linha.split(" ");
					for (int i = 0; i < linhas.length; i++) {
						if (linhas[i].contains("ms")) {
							System.out.println(linhas[i]);
						}
					}
					linha = buffer.readLine();
				}
				buffer.close();
				fluxo.close();
				leitor.close();
			} else if (systemName.contains("Linux")) || systemName.contains("linux")) {
				Process processo = Runtime.getRuntime().exec("ping -c 10 www.google.com.br");
				InputStream fluxo = processo.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null) {
					String[] linhas = linha.split(" ");
					for (int i = 0; i < linhas.length; i++) {
						if (linhas[i].contains("ms")) {
							System.out.println(linhas[i]);
						} 
					}
					linha = buffer.readLine();
				}
				buffer.close();
				fluxo.close();
				leitor.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}