package fr.adrienvaucard.morpion;

import java.util.Scanner;

public class Morpion {

	private static Scanner sc;

	public static void main(String[] args) {
		String[][] grid = initializeGame();
		
		startGame(grid);

	}

	public static String[][] initializeGame() {

		// Initialisation du Tableau

		sc = new Scanner(System.in);
		String[][] grid = { { ".", ".", "." }, { ".", ".", "." }, { ".", ".", "." } };

		return grid;
	}

	public static void startGame(String[][] grid) {

		String row;
		String col;
		String shape = null;

		Boolean isFinish = false;
		Integer actualPlayer = 1;
		Boolean isTurnFinished = false;
		

		printGrid(grid);

		while (isFinish == false) {
			
			isTurnFinished = false;
		
			if (actualPlayer == 1) {
				shape = "X";

			} else if (actualPlayer == 2) {
				shape = "O";
			}

			System.out.println("Joueur " + actualPlayer + ", à ton tour !");
			
			while (!isTurnFinished) {

				System.out.println("Ligne ?");
	
				row = sc.nextLine();
				Integer rowInt = checkInt(row);
	
				System.out.println("Colonne ?");
	
				col = sc.nextLine();
				Integer colInt = checkInt(col);
				
				
				if (grid[rowInt][colInt] == ".") {
					
					grid[rowInt][colInt] = shape;
					isTurnFinished = true;
				}
				else {
					System.out.println("ERREUR");
					System.out.println("Veuillez sélectionner une case libre.");
				}
				
			}

			printGrid(grid);

			isFinish = checkVictory(grid);

			if (!isFinish) {
				// Changement de Joueur
	
				if (actualPlayer == 1) {
					actualPlayer = 2;
				} else if (actualPlayer == 2) {
					actualPlayer = 1;
				}
				
			} else {
				System.out.println("Joueur " + actualPlayer + " a gagné. Félicitations à lui !");
				
			}

		}

	}

	public static void printGrid(String[][] grid) {
		// Afficher Grille de base

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				System.out.print(grid[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}

	public static Integer checkInt(String x) {

		Integer y = null;

		while (y == null) {

			if (!x.equals("1") && !x.equals("2") && !x.equals("3")) {
				System.out.println("ERREUR");
				System.out.println("Veuillez entrer un nombre entier entre 1 et 3");
				x = sc.nextLine();
			} else {
				y = Integer.valueOf(x);
			}

		}

		return y - 1;

	}

	public static Boolean checkVictory(String[][] grid) {

		Boolean isFinish = false;

		// Test de Victoire

		if (grid[0][0] == grid[0][1] && grid[0][1] == grid[0][2] && (grid[0][0] == "X" || grid[0][0] == "O")
				|| grid[1][0] == grid[1][1] && grid[1][1] == grid[1][2] && (grid[1][0] == "X" || grid[1][0] == "O")
				|| grid[2][0] == grid[2][1] && grid[2][1] == grid[2][2] && (grid[2][0] == "X" || grid[2][0] == "O") ||

				grid[0][0] == grid[1][0] && grid[1][0] == grid[2][0] && (grid[0][0] == "X" || grid[0][0] == "O")
				|| grid[0][1] == grid[1][1] && grid[1][1] == grid[2][1] && (grid[0][1] == "X" || grid[0][1] == "O")
				|| grid[0][2] == grid[1][2] && grid[1][2] == grid[2][2] && (grid[0][2] == "X" || grid[0][2] == "O") ||

				grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2] && (grid[0][0] == "X" || grid[0][0] == "O")
				|| grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0] && (grid[0][2] == "X" || grid[0][0] == "O")) {

			isFinish = true;
		} else {
			isFinish = false;
		}

		return isFinish;
	}

}
