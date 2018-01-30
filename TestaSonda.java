package br.com.sondaespacial;

import java.io.*;

public class TestaSonda {

	public static void main(String[] args) {
		String saida = null;
		try {
			FileReader fr = new FileReader(args[0]);
			BufferedReader br = new BufferedReader(fr);
			
			//Leitura do tamanho do planalto
			String line = br.readLine().toUpperCase();
			String[] lineX = line.split("\\s");		
			Mapa map = new Mapa(Integer.parseInt(lineX[0]), Integer.parseInt(lineX[1]));
			
			//System.out.println(map.imprime());
			
			//Posição inicial da Sonda
			line = br.readLine().toUpperCase();
			lineX = line.split("\\s");
			Sonda curiosity = new Sonda(Integer.parseInt(lineX[0]), Integer.parseInt(lineX[1]), 'C', lineX[2].charAt(0));
			
			//System.out.println(curiosity.getPosX() + " " + curiosity.getPosY() + " " + curiosity.getDirection());
			
			// Comandos para caminhar
			char[] caminho = br.readLine().toUpperCase().toCharArray();
			for(int i = 0; i < caminho.length; i++) {
				//System.out.println(caminho[i]);
				if (caminho[i] == 'M') {
					saida = curiosity.move(map);	
				} else {
					curiosity.rotate(caminho[i]);
				}
				//System.out.println("--> " + curiosity.getPosX() + " " + curiosity.getPosY() + " " + curiosity.getDirection());	
			}
			
			br.close();
			fr.close();
			
			
			if(saida.equals("OK")) {
				System.out.println(curiosity.getPosX() + " " + curiosity.getPosY() + " " + curiosity.getDirection());
			} else {
				System.out.println(saida);
			}
			
			//System.out.println(map.imprime());
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
