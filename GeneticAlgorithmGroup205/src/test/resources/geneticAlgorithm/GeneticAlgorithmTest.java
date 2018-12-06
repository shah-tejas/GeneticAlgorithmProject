package geneticAlgorithm;


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

public class GeneticAlgorithmTest {
	

	
	
	//Test crossover function of GeneticAlgorithm
	@Test
	public void testCrossover(){
		
		
		Arrangement parent1=GeneticAlgorithmTest.getArrangement();
		
		ArrayList<Seat> list=parent1.getArrangementSeats();
		
		Collections.reverse(list);
		
		Arrangement parent2=new Arrangement();
		
		parent2.setArrangmentSeats(list);
				
		Arrangement child = GeneticAlgorithm.crossover(parent1, parent2);
		
		assertNotEquals(child, parent1);
		
		assertNotEquals(child, parent2);         
		
	}
	
	
	//Test testMutate function of GeneticAlgorithm
	@Test
	public void testMutate(){
		
		Arrangement arrangement=GeneticAlgorithmTest.getArrangement();
		
		ArrayList<Seat> list=arrangement.getArrangementSeats();

		Arrangement arrangement2=new Arrangement();
		
		arrangement2.setArrangmentSeats(list);
		
		GeneticAlgorithm.mutate(arrangement2);
		
		assertNotEquals(arrangement, arrangement2);
		
	}
	

	
	
	public static Arrangement getArrangement() {
		 
		 Arrangement arrangement = new Arrangement();
			
		for(int tableno = 0; tableno < 5; tableno++) {
			Table t = new Table(tableno);
			
			for(int i = 0 ; i < 5 ; i++) {
				Seat s = new Seat();
				s.getPerson().setEatingPreferences(2);
				s.getPerson().setRelation(1);
				s.getPerson().setViews(4);
				s.setTableId(t.getTableId());
				t.addSeat(s);
			}
			arrangement.arrangement.add(t);
		}
			
		return arrangement;
	}
}
