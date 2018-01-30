package br.com.sondaespacial;

public class Mapa {
	private char[][] planalto;
	
	protected Mapa() {
		this.planalto = new char[2][2];
		for(int i = 0; i < 2; i++) {
			for(int j = 0;j < 2; j++) {
				planalto[i][j] = 'N';
			}
		}
		
	}
	
	protected Mapa(int x, int y) {
//O valor da entrada é o ponto superior direito, e não o tamanho do planalto.
		x++;
		y++;
		this.planalto = new char[x][y];
		for(int i = 0; i < x; i++) {
			for(int j = 0;j < y; j++) {
				planalto[i][j] = 'N';
			}
		}
	}
	
	protected String setPosition(int x, int y, char sonda)  {
		try {
			this.planalto[x][y] = sonda;
		} catch (ArrayIndexOutOfBoundsException e) {
			return new String("A Sonda saiu do planalto");
		}
		
		return new String("OK");
	}
	
	protected String imprime() {
		String retorno = new String();
		for(int i = 0; i < this.planalto.length; i++) {
			for(int j = 0; j < this.planalto[i].length; j++) {
			retorno = retorno + planalto[i][j];
			}
			retorno = retorno + "\n";
		}
		
		return retorno;
	}
}
