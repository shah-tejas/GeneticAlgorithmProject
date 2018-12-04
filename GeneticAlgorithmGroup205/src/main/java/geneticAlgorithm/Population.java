package geneticAlgorithm;


public class Population {

	Arrangement[] arrangements;

	public Population(int populationSize, boolean initialize) {
		arrangements = new Arrangement[populationSize];
		
		if(initialize){
			for (int i = 0; i < populationSize; i++) {
				Arrangement arrangement=new Arrangement();
				arrangement.generateArrangement();
				saveArrangement(i, arrangement);
			}
		}
	}
	

	public void saveArrangement(int index, Arrangement arrangement){
		arrangements[index]=arrangement;
	}
	
	public Arrangement getArrangement(int index){
		return arrangements[index];	
	}
	
	public Arrangement getFittest(){
		Arrangement fittest= arrangements[0];
		
		for(int i=1; i<populationSize(); i++){
			if(fittest.getFitness() <= getArrangement(i).getFitness()){
				fittest=getArrangement(i);
			}
		}
		return fittest;
	}
	
	public int populationSize(){
		return arrangements.length;
	}
}
