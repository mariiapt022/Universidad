
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.jgap.Configuration;
import org.jgap.Gene;
import org.jgap.IChromosome;
import org.jgap.IGeneConstraintChecker;
import org.jgap.InvalidConfigurationException;

import com.qqwing.QQWing;

public class Population{
	private int[][] sudoku = new int[9][9];
	private MyChromosome[] population;
	
	public Population(int[][] s) {
		population = new MyChromosome[20];
		for (int i=0; i<9; i++) {
			for (int j=0; j<9; j++) {
				sudoku[i][j] = s[i][j];
			}
		}
		population[0] = new MyChromosome(sudoku);
	}
	
	public int[][] getSudoku() { return sudoku; }

	public MyChromosome[] getPopulation() { return population; }
	
	public MyChromosome getChromosome(int pos) { return population[pos]; }

	public void setSudoku(int[][] sudoku) { this.sudoku = sudoku; }

	public void setPopulation(MyChromosome[] population) { this.population = population;}
	
}
