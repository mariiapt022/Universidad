import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MyChromosome implements Comparable<MyChromosome>{
	private Gen[] genes;
	private int tam;
	private int[][] sudoku;
	
	public MyChromosome() {
		sudoku = new int[9][9];
		genes = new Gen[38];
		tam = 0;
	}
	
	public MyChromosome(int[][] s) {
		sudoku = new int[9][9];
		tam = 0;
		genes = new Gen[81];
		for (int i=0; i<9; i++) {
			for (int j=0; j<9; j++) {
				sudoku[i][j] = s[i][j];
			}
		}
		for (int i=0; i<9; i++) {
			for (int j=0; j<9; j++) {
				if (sudoku[i][j] == 0) {
					this.addGen(new Gen(i, j));
					tam++;
				}
			}
			
		}
		Arrays.copyOf(genes, tam);
	}
	
	public MyChromosome(Gen x) {
		genes = new Gen[1];
		this.addGen(x);
		tam = 1;
	}
	
	public void addGen(Gen x) { genes[tam] = x; }

	public Gen[] getGenes() { return genes;}
	
	public int getTam() {return tam;}

	public void setGen(int pos, int v) {
		Gen g = genes[pos];
		sudoku[g.getRow()][g.getColumn()] = v;
	}
	
	public void setVal(int x, int y, int v) { sudoku[x][y] = v;}
	
	public int sudokuVal(int x, int y) { return sudoku[x][y];}
	
	@Override
	public int compareTo(MyChromosome m) {
		return MyChromosome.fitnessFunction( m.getSudoku()) - MyChromosome.fitnessFunction(sudoku);
	}
	
	public int[][] getSudoku() { return sudoku; }

	public void setSudoku(int[][] sudoku) { this.sudoku = sudoku; }

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
	
	@Override
	public int hashCode() { return tam; }
	
	@Override
	public boolean equals(Object o) {
		boolean x = o instanceof MyChromosome;
		MyChromosome item = null;
		if (x) {
			item = (MyChromosome) o;
			
		}
		boolean same = true;
		int i=0, j=0;
		while (i<9 && same) {
			while (j<9 && same) {
				if (this.sudoku[i][j] != item.sudokuVal(i, j)) {
					same = false;
				}
				j++;
			}
			j=0;
			i++;
		}
		return x && same;
	}
	
	public int FV() { return MyChromosome.fitnessFunction(sudoku);}

}
