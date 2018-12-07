package geneticAlgorithm;

import java.util.Scanner;

import org.apache.log4j.Logger;

public class GAImplementationConsole {
	
	final static Logger logger = Logger.getLogger(GAImplementationConsole.class);

	public static void main(String args[]) {
		
		logger.debug("===========================");
		logger.debug("Starting the algorithm...");
		logger.debug("===========================");
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number of Tables");
		int tablesno = Integer.parseInt(scanner.nextLine());
		
		System.out.println("Enter number of Guests");
		int guestsno = Integer.parseInt(scanner.nextLine());
		
		int GuestsPerTable = (int) guestsno / tablesno;
		ArrangementManager.setGuestsPerTable(GuestsPerTable);
		
		//Set number of tables and number of persons
		for(int i = 0; i < tablesno; i++) {
			Table t = new Table();
			for(int j = 0; j < GuestsPerTable; j++) {
				t.getSeats().add(new Seat());
			}
			ArrangementManager.addTable(t);
		}
		
		//Create initial population and print the fitness
		Population population = new Population(50, true);
		Arrangement fittest = population.getFittest();
		logger.debug("Initial best fitness : " + population.getFittest().getFitness());
		//fittest.displayArrangement();
		
		int j = 0;
		//evolve the population
		for(int i = 0 ; i < 500000 ; i++) {
			population = GeneticAlgorithm.evolvePopulation(population);
			//log fitness after every 1000 evolution
//			if(j == 1000){
//				logger.debug("Evolution of fitness : " + population.getFittest().getFitness());
//				j=0;
//			}
//			
//			j++;
		}
		
		//Print the fitness and the solution
		fittest = population.getFittest();
		logger.debug("Final best fitness : " + fittest.getFitness());
		//fittest.displayArrangement();
	}
}
