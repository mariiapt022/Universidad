
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import com.qqwing.QQWing;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter("output.txt");
		QQWing MySudoku = new QQWing();
		generate(MySudoku);
		SortedSet<MyChromosome> sol = algorithm(MySudoku, pw);
		
		if (sol.last().FV() != 162) {
			System.out.println("No solution was found... ):");
			pw.append("No solution was found... ):");
		} else {
			System.out.println("Solution:\n");
			pw.append("Solution:");
			for (int i=0; i<9; i++) {
				for (int j=0; j<9; j++) {
					System.out.print(sol.last().sudokuVal(i, j) + " ");
					pw.append(sol.last().sudokuVal(i, j) + " ");
				}
				System.out.println();
				pw.append("\n");
			}
		}
		pw.close();
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
	
	
	private static int[] valoresFila(int fila, int[][] sudoku){
		Set<Integer> sol = new HashSet<>();
		Set<Integer> aux = new HashSet<>();
		for (int i=0; i<9; i++) {
			if (sudoku[fila][i] != 0) {
				aux.add((Integer) sudoku[fila][i]);
			}
		}
		for (int i=1; i<=9; i++) {
			if (!aux.contains((Integer) i)){
				sol.add(i);
			}
		}
		int[] res = new int[sol.size()];
		int c=0;
		for (int x: sol) {
			res[c] = x;
			c++;
		}
		return res;
	}

	public static SortedSet<MyChromosome> algorithm(QQWing sudoku, PrintWriter pw){
		int[] m = sudoku.getPuzzle();
		Population c = new Population(convert(m));
		SortedSet<MyChromosome> population = new TreeSet<>();
		Random r = new Random();
		MyChromosome[] chromosome = c.getPopulation();
		int[] values;
		int cont=0;
		for (int i=0; i<9; i++) {
			values = valoresFila(i, convert(m));
			for (int j=0; j<values.length; j++) {
				chromosome[0].setGen(cont, values[j]);
				cont++;
			}
		}
		population.add(c.getChromosome(0));
		Set<Integer> pos;
		int p;
		for (int k=1; k<20; k++) {
			chromosome[k] = new MyChromosome(convert(m));
			cont = 0;
			for (int i=0; i<9; i++) {
				pos = new HashSet<>();
				values = valoresFila(i, convert(m));
				for (int j=0; j<values.length; j++) {
					do {
						 p = r.nextInt(values.length);
					} while (pos.contains(p));
					pos.add(p);
					chromosome[k].setGen(cont, values[p]);
					cont++;
				}
			}
			population.add(c.getChromosome(k));
		}
		MyChromosome m1, m2;
		int t, row, it=0;
		while(population.last().FV()<162 && it < 100000) {
			p = r.nextInt(20);
			m1 = chromosome[p];
			do {
				t = r.nextInt(20);
			} while(p == t);
			m2 = chromosome[t];
			row = r.nextInt(9);
			exchange(m1, m2, row);
			it++;
			System.out.println("Generation "+it);
			pw.append("Generation "+it+"\n");
			System.out.println("The mean fitness of the population is: " + mF(c));
			pw.append("The mean fitness of the individuals is: " + mF(c)+"\n");
			System.out.println("The fitness of the best individual is: " + population.last().FV());
			pw.append("The fitness of the best individual is: " + population.last().FV()+"\n");
		}
		return population;
	}
	
	private static void exchange(MyChromosome m1, MyChromosome m2, int row) {
		int aux;
		for (int i=0; i<m1.getTam(); i++) {
			if (m1.getGenes()[i].getRow() == row) {
				aux = m1.sudokuVal(row, m1.getGenes()[i].getColumn());
				m1.setVal(row, m1.getGenes()[i].getColumn(), m2.sudokuVal(row, m2.getGenes()[i].getColumn()));
				m2.setVal(row, m2.getGenes()[i].getColumn(), aux);
			}
		}
	}

	private static double mF(Population p) {
		double sol=0;
		for (int i=0; i<20; i++) {
			sol+=p.getChromosome(i).FV();
		}
		return sol/20;
	}
}
