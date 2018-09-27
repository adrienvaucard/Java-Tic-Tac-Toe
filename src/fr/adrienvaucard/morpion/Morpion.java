package fr.adrienvaucard.morpion;

import java.util.Scanner;

public class Morpion {

	public static void main(String[] args) {
		
		//Initialisation du Tableau
		
		Scanner sc = new Scanner(System.in);
		
		String grid[][] = {{".",".", "."}, {".", ".", "."}, {".", ".", "."}};
	
		
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				System.out.print(grid[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
		
		Integer row;
		Integer col;
		String shape = null;
		
		Boolean isFinish = false;
		Integer actualPlayer = 1;
		
		
		//Début de jeu
		
		while (isFinish == false) {
			
			if (actualPlayer == 1) {
				shape = "X";
			}
			else if (actualPlayer == 2) {
				shape = "O";
			}
			
			
			System.out.println("Joueur " + actualPlayer + ", à ton tour !");
			System.out.println("Ligne ?");
			row = Integer.parseInt(sc.nextLine());
			while (row != 1 && row != 2 && row != 3) {
				System.out.println("ERREUR");
				System.out.println("Veuillez saisir un nombre entier");
				row = Integer.parseInt(sc.nextLine());
			}
			row -= 1;
			
			while (row < 0 || row > 2) {
				System.out.println("ERREUR");
				System.out.println("Veuillez rentrer une valeur entre 1 et 3");
				row = Integer.parseInt(sc.nextLine());
				
				while (row != 1 && row != 2 && row != 3) {
					System.out.println("ERREUR");
					System.out.println("Veuillez saisir un nombre entier");
					row = Integer.parseInt(sc.nextLine());
				}
				row -= 1;
			}
		
			
			System.out.println("Colonne ?");
			col = Integer.parseInt(sc.nextLine());
			while (col != 1 && col != 2 && col != 3) {
				System.out.println("ERREUR");
				System.out.println("Veuillez saisir un nombre entier");
				col = Integer.parseInt(sc.nextLine());
			}
			col -= 1;
					
			while (col < 0 || col > 2) {
				System.out.println("ERREUR");
				System.out.println("Veuillez rentrer une valeur entre 1 et 3");
				col = Integer.parseInt(sc.nextLine());
				while (col != 1 && col != 2 && col != 3) {
					System.out.println("ERREUR");
					System.out.println("Veuillez saisir un nombre entier");
				}
				col -= 1;
			}
			
			grid[row][col] = shape;
			
			
			//Test de Victoire
			
			
			if (grid[0][0] == grid[0][1] && grid[0][1] == grid[0][2] && (grid[0][0] == "X" || grid[0][0] == "O") ||
				grid[1][0] == grid[1][1] && grid[1][1] == grid[1][2] && (grid[1][0] == "X" || grid[1][0] == "O") ||
				grid[2][0] == grid[2][1] && grid[2][1] == grid[2][2] && (grid[2][0] == "X" || grid[2][0] == "O") ||
				
				grid[0][0] == grid[1][0] && grid[1][0] == grid[2][0] && (grid[0][0] == "X" || grid[0][0] == "O") ||
				grid[0][1] == grid[1][1] && grid[1][1] == grid[2][1] && (grid[0][1] == "X" || grid[0][1] == "O") ||
				grid[0][2] == grid[1][2] && grid[1][2] == grid[2][2] && (grid[0][2] == "X" || grid[0][2] == "O") ||
				
				grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2] && (grid[0][0] == "X" || grid[0][0] == "O") ||
				grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0] && (grid[0][2] == "X" || grid[0][0] == "O") ) {
				
				isFinish = true;
			}
			else {
				isFinish = false;
			}
			
			//Changement de Joueur
				
			if (actualPlayer == 1) {
				actualPlayer = 2;
			}
			else if (actualPlayer == 2) {
				actualPlayer = 1;
			}
			
			//Afficher la grille de jeu
			
			for (int i = 0; i < grid.length; i++) {
				for (int j = 0; j < grid[i].length; j++) {
					System.out.print(grid[i][j]);
					System.out.print(" ");
				}
				System.out.println();
			}
				
			
		}
		
		if (actualPlayer == 1) {
			actualPlayer = 2;
		}
		else if (actualPlayer == 2) {
			actualPlayer = 1;
		}
		
		System.out.println("Joueur " + actualPlayer + " a gagné. Félicitations à lui !");
		
	}

}
