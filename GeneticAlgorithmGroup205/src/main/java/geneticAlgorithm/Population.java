package geneticAlgorithm;

public class Population {

	Arrangement[] arrangements;

	public Population(int populationSize, boolean initialize) {
		arrangements = new Arrangement[populationSize];
		
		if(initialize){
			for (int i = 0; i < populationSize; i++) {
				Arrangement arrangement=new Arrangement();
				//arrangement.generateIndividual();.
			}
		}
	}
	
	
}
