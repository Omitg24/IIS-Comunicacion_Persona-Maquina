package logic;

import logic.boxes.Box;
import logic.boxes.Box1000Points;
import logic.boxes.Box250Points;
import logic.boxes.Box50Points;
import logic.boxes.BoxEmpty;
import logic.boxes.BoxGift;
import logic.boxes.BoxSpecial;
import logic.boxes.BoxX2Points;

/**
 * T�tulo: Clase Board
 * Descripci�n: Clase donde se crear� el tablero de juego con todas las casillas
 * de los distintos puntos 
 *
 * @author Omar Teixeira, UO281847
 * @version 31 dic. 2021
 */
public class Board {
//-- CONSTANTES ----------------------------------------------------------------
	/**
	 * Constante DIM
	 */
	public static final int DIM = 25;
	/**
	 * Constante N1000
	 */
	public static final int N1000 = 1;
	/**
	 * Constante N250
	 */
	public static final int N250 = 5;
	/**
	 * Constante N50
	 */
	public static final int N50 = 8;
	/**
	 * Constante NX2
	 */
	public static final int NX2 = 1;
	/**
	 * Constante NSPECIAL
	 */
	public static final int NSPECIAL = 2;
	/**
	 * Constante NGIFT
	 */
	public static final int NGIFT = 1;
//-- ATRIBUTOS -----------------------------------------------------------------
	/**
	 * Atributo boxes
	 */
	private Box[] boxes;
	/**
	 * Atributo posBox1000
	 */
	private int posBox1000;
	/**
	 * Atributo posBox250
	 */
	private int posBox250;
	/**
	 * Atributo posBox50
	 */
	private int posBox50;
	/**
	 * Atributo posBoxX2
	 */
	private int posBoxX2;
	/**
	 * Atributo posBoxSpecial
	 */
	private int posBoxSpecial;
	/**
	 * Atributo posBoxGift
	 */
	private int posBoxGift;
	
	/**
	 * Constructor del tablero
	 */
	public Board() {
		boxes = new Box[DIM];
		for (int i = 0; i < DIM; i++) {
			boxes[i]=new BoxEmpty();
		}
		placeBoxes();
	}
	
	/**
	 * M�todo que las casillas
	 * 
	 * @param boxes, tablero de casillas
	 */
	public void setBoxes(Box[] boxes) {
		this.boxes=boxes;
	}
	
	/**
	 * M�todo que devuelve las casillas
	 * 
	 * @return boxes, casillas
	 */
	public Box[] getBoxes() {
		return boxes;
	}
	
	/**
	 * M�todo que devuelve la posici�n de las casillas de 1000 puntos
	 * 
	 * @return posBox1000, posici�n de las casillas de 1000 puntos
	 */
	public int getPosBox1000() {
		return posBox1000;
	}

	/**
	 * M�todo que devuelve la posici�n de las casillas de 250 puntos
	 * 
	 * @return posBox250, posici�n de las casillas de 250 puntos
	 */
	public int getPosBox250() {
		return posBox250;
	}

	/**
	 * M�todo que devuelve la posici�n de las casillas de 50 puntos
	 * 
	 * @return posBox50, posici�n de las casillas de 50 puntos
	 */
	public int getPosBox50() {
		return posBox50;
	}

	/**
	 * M�todo que devuelve la posici�n de las casillas de multipar los puntos x2
	 * 
	 * @return posBoxX2, posici�n de las casillas de multiplicar los puntos x2
	 */
	public int getPosBoxX2() {
		return posBoxX2;
	}

	/**
	 * M�todo que devuelve la posici�n de las casillas especiales
	 * 
	 * @return posBoxSpecial, posici�n de las casillas especiales
	 */
	public int getPosBoxSpecial() {
		return posBoxSpecial;
	}	
	
	/**
	 * M�todo que situa las diferentes casillas en el tablero
	 */
	private void placeBoxes() {
		System.out.println("\n------ Casillas No Vac�as ------");
		System.out.println("\t------ 1000 Puntos ------");
		placeBoxes1000();
		System.out.println("\t------ 250 Puntos ------");
		placeBoxes250();
		System.out.println("\t------ 50 Puntos ------");
		placeBoxes50();
		System.out.println("\t------ Puntos X2 ------");
		placeBoxesX2();
		System.out.println("\t------ Especial ------");
		placeBoxesSpecial();
		System.out.println("\t------ Regalo ------");
		placeBoxesGift();
		System.out.println("\n------- Casillas Vac�as -------");
		showEmpty();
	}
	
	/**
	 * M�todo que comprueba si una posici�n del tablero esta ocupada
	 * 
	 * @param pos, posicion a comprobar
	 * @return true o false, si esta o no ocupada
	 */
	private boolean isEmpty(int pos) {
		if (getBoxes()[pos] instanceof BoxEmpty) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * M�todo que situa las casillas de 1000 Puntos
	 */
	private void placeBoxes1000() {
		this.posBox1000 = (int) (Math.random() * DIM);
		for (int i = 0; i < N1000; i++) {
			do {
				posBox1000 = (int) (Math.random() * DIM);
			} while (!isEmpty(posBox1000));
			boxes[posBox1000] = new Box1000Points();
			System.out.println("\tLa casilla " + i + " de 1000 puntos est� en: "  + posBox1000);
		}		
	}
	
	/**
	 * M�todo que situa las casillas de 250 Puntos
	 */
	private void placeBoxes250() {
		this.posBox250 = (int) (Math.random() * DIM);
		for (int i = 0; i < N250; i++) {
			do {
				posBox250 = (int) (Math.random() * DIM);
			} while (!isEmpty(posBox250));
			boxes[posBox250] = new Box250Points();
			System.out.println("\tLa casilla " + i + " de 250 puntos est� en: " + posBox250);
		}		
	}
	
	/**
	 * M�todo que situa las casillas de 50 Puntos
	 */
	private void placeBoxes50() {
		this.posBox50 = (int) (Math.random() * DIM);
		for (int i = 0; i < N50; i++) {
			do {
				posBox50 = (int) (Math.random() * DIM);
			} while (!isEmpty(posBox50));
			boxes[posBox50] = new Box50Points();
			System.out.println("\tLa casilla " + i + " de 50 puntos est� en: " + posBox50);
		}
	}
	
	/**
	 * M�todo que situa las casillas de multiplicar los puntos x2
	 */
	private void placeBoxesX2() {
		this.posBoxX2 = (int) (Math.random() * DIM);
		for (int i = 0; i < NX2; i++) {
			do {
				posBoxX2 = (int) (Math.random() * DIM);
			} while (!isEmpty(posBoxX2));
			boxes[posBoxX2] = new BoxX2Points();
			System.out.println("\tLa casilla " + i + " de multiplicar puntos X2 est� en: " + posBoxX2);
		}
	}
	
	/**
	 * M�todo que situa las casillas especiales
	 */
	private void placeBoxesSpecial() {
		this.posBoxSpecial = (int) (Math.random() * DIM);
		for (int i = 0; i < NSPECIAL; i++) {
			do {
				posBoxSpecial = (int) (Math.random() * DIM);
			} while (!isEmpty(posBoxSpecial));
			boxes[posBoxSpecial] = new BoxSpecial();
			System.out.println("\tLa casilla " + i + " especial est� en: " + posBoxSpecial);
		}
	}
	/**
	 * M�todo que situa la casilla de regalo
	 */
	private void placeBoxesGift() {
		this.posBoxGift = (int) (Math.random() * DIM);
		for (int i = 0; i < NGIFT; i++) {
			do {
				posBoxGift = (int) (Math.random() * DIM);
			} while (!isEmpty(posBoxGift));
			boxes[posBoxGift] = new BoxGift();
			System.out.println("\tLa casilla " + i + " regalo directo est� en: " + posBoxGift);
		}
	}	
	/**
	 * M�todo que muestra donde est�n las casillas vac�as
	 */
	private void showEmpty() {
		for (int i = 0; i < DIM; i++) {
			if (boxes[i] instanceof BoxEmpty) {
				System.out.println("\tCasilla vac�a en: " + i);
			}
		}
	}
} 