package geneticAlgorithm;

import org.apache.log4j.Logger;

public class GAImplementation {
	
	final static Logger logger = Logger.getLogger(GAImplementation.class);

	public static void main(String args[]) {
		
		logger.debug("===========================");
		logger.debug("Starting the algorithm...");
		logger.debug("===========================");
		
		//Set number of tables and number of persons
		for(int i = 0; i < 10; i++) {
			Table t = new Table();
			ArrangementManager.addTable(t);
		}
		ArrangementManager.setNumberOfPersons(80);
		
		//Create initial population and print the fitness
		Population population = new Population(50, true);
		System.out.println("Initial best fitness : " + population.getFittest().getFitness());
		
		//evolve the population
		population = GeneticAlgorithm.evolvePopulation(population);
		
		
		//Print the fitness and the solution
		System.out.println("Final best fitness : " + population.getFittest().getFitness());
	}
}
