import java.util.HashSet;
import java.util.Set;

import com.qqwing.QQWing;

public class Main {

	public static void main(String[] args) {
		QQWing MySudoku = new QQWing();;
		generate(MySudoku);
		
		int[][] sudoku = convert(MySudoku.getSolution());
		
		System.out.print(fitnessFunction(sudoku));
	}
	
	private static int[][] convert(int[] solution) {
		int[][] sol = new int[9][9];
		int pos=0;
		
		for (int i=0; i<9; i++) {
			for (int j=0; j<9; j++) {
				sol[i][j] = solution[pos];
				pos++;
			}
		}
		
		return sol;
	}

	public static void generate(QQWing MySudoku) {
		MySudoku.generatePuzzle();
		MySudoku.printPuzzle();
		MySudoku.solve();
		MySudoku.printSolution();
	}
	
	public static int fitnessFunction(int[][] sudoku) {
		int f=0;
		
		f += columnCount(sudoku);
		f += blockCount(sudoku);
		
		return f;
	}

	private static int blockCount(int[][] sudoku) {
		int aux=0;
		Set<Integer> uniques;
		
		for (int j=0; j<sudoku[0].length; j++) {
			uniques = new HashSet<>();
			
			for (int i=0; i<sudoku.length; i++) {
				if (!uniques.contains(sudoku[i][j])) {
					uniques.add(sudoku[i][j]);
					aux++;
				}
			}
		}
		
		return aux;
	}

	private static int columnCount(int[][] sudoku) {
		int aux=0, cont=0, aux_i=0, aux_j=0;
		Set<Integer> uniques;
		
		while(cont!=9) {
			aux_j = 3*(cont%3);
			if (cont == 3) {
				aux_i = 3;
			} else if (cont == 6) {
				aux_i = 6;
			}
		
			for (int i=aux_i; i<aux_i+3; i++) {
				uniques = new HashSet<>();
			
				for (int j=aux_j; j<aux_j+3; j++) {
					if (!uniques.contains(sudoku[i][j])) {
						uniques.add(sudoku[i][j]);
						aux++;
					}
				}
			}
			cont++;
		}
		
		return aux;
	}

}
