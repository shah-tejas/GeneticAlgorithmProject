package geneticAlgorithm;

public class GeneticAlgorithm {

	
	public static final double mutationRate = 0.015;
	
	public static final int tournamentSize = 5;
	
	public static final boolean elitism = true;
	
	
	public static Population evolvePopulation(Population population){
		Population newPopulation=new Population(population.populationSize(), false);
		
		int elitismOffset = 0;
		
		if(elitism){
			newPopulation.saveArrangement(0, population.getFittest());
			elitismOffset=1;
		}
		
		for (int i = elitismOffset; i < population.populationSize(); i++) {
			
			//Arrangement arrangement=arr
		}
		
		return population;
		
	}
	
	public static Arrangement crossover(Arrangement parent1, Arrangement parent2){
		
		Arrangement child= new Arrangement();

		int startPosition= (int) (Math.random() * parent1.arrangementSize());
		
		int endPosition = (int) (Math.random() * parent2.arrangementSize());
		return child;
	}
	
}