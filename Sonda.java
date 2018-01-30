package br.com.sondaespacial;

public class Sonda {
	private int posX;
	private int posY;
	private char sonda;
	private char direction;
	
	public Sonda() {
		this.posX = 0;
		this.posY = 0;
		this.sonda = 'A';
		this.direction = 'N';
	}
	
	public Sonda(int i, int j, char s, char d) {
		this.posX = i;
		this.posY = j;
		this.direction = d;
		this.sonda = s;
	}
	
	public int getPosX() {
		return this.posX;
	}
	
	public void setPosX(int x) {
		this.posX = x;
	}

	public int getPosY() {
		return this.posY;
	}
	
	public void setPosY(int y) {
		this.posY = y;
	}

	public char getDirection() {
		return this.direction;
	}
	
	public void setDirection(char d) {
		this.direction = d;
	}
	
	public char getSonda() {
		return this.sonda;
	}
	
	public void setSonda(char s) {
		this.sonda = s;
	}
	
	public void rotate(char r) {
		boolean flag = false;
		
		if(this.direction == 'N' && r == 'R' && flag == false) {
			this.direction = 'E';
			flag = true;
		} 
		
		if(this.direction == 'N' && r == 'L' && flag == false) {
			this.direction = 'W';
			flag = true;
		}

		if(this.direction == 'E' && r == 'R' && flag == false) {
			this.direction = 'S';
			flag = true;
		} 
		
		if(this.direction == 'E' && r == 'L' && flag == false) {
			this.direction = 'N';
			flag = true;
		}

		if(this.direction == 'S' && r == 'R' && flag == false) {
			this.direction = 'W';
			flag = true;
		}
		
		if(this.direction == 'S' && r == 'L' && flag == false) {
			this.direction = 'E';
			flag = true;
		}

		if(this.direction == 'W' && r == 'R' && flag == false) {
			this.direction = 'N';
			flag = true;
		}
		
		if(this.direction == 'W' && r == 'L' && flag == false) {
			this.direction = 'S';
			flag = true;
		}

		
	}
	
	public String move(Mapa map) {
		String retorno = new String();
		switch(this.direction) {
		case 'N': this.posY++;
			break;
		case 'S' : this.posY--;
			break;
		case 'E': this.posX++;
			break;
		case 'W': this.posX--;
			break;
		}
		
		retorno = map.setPosition(this.posX, this.posY, this.sonda);
		
		return retorno;
	}

}
