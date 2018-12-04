package geneticAlgorithm;

import java.util.ArrayList;

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

		int startPosition= (int) (Math.random() * parent1.arrangementSeatsSize());
		
		int endPosition = (int) (Math.random() * parent1.arrangementSeatsSize());
		
		ArrayList<Seat> seats=new ArrayList<>(parent1.getArrangementSeats().size());
		
		for (int i = 0; i < parent1.arrangementSeatsSize(); i++) { 							
			if(startPosition < endPosition && i > startPosition && i<endPosition){
				seats.set(i, parent1.getArrangementSeats().get(i));
			}
			else if(startPosition > endPosition){
				if(!(i < startPosition && i > endPosition)){
					seats.set(i, parent1.getArrangementSeats().get(i));
				}
			}
		}
		
		for (int i = 0; i < parent2.arrangementSeatsSize(); i++) {
			if(!seats.contains(parent2.getArrangementSeats().get(i))){
				for (int j = 0; j < parent2.arrangementSeatsSize(); j++) {
					if(seats.get(j) == null){
						seats.set(j, parent2.getArrangementSeats().get(i));
						break;
					}
				}
			}
		}
		
		child.setArrangmentSeats(seats);
		return child;
	}
	
}
