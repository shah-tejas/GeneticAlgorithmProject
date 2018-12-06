package geneticAlgorithm;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Test;

public class PopulationTest {
	
	
	// Test the populationSize function of Population
	@Test
	public void testPopulationSize(){
		
		Arrangement arrangement=GeneticAlgorithmTest.getArrangement();
		
		ArrayList<Seat> list=arrangement.getArrangementSeats();

		Arrangement arrangement2=new Arrangement();
		
		arrangement2.setArrangmentSeats(list);
		
		Population population = new Population(2, false);
		
		population.arrangements[0] = arrangement;
		
		population.arrangements[1] = arrangement;
		
		
		assertEquals(2, population.populationSize(), 0.0001);
		
	}
	
	// Test the getFittest function of Population
	@Test
	public void testGetFittest(){
		
		Arrangement arrangement=GeneticAlgorithmTest.getArrangement();
		
		Arrangement arrangement2=PopulationTest.getArrangement();
		
		Population population = new Population(2, false);
		
		population.arrangements[0] = arrangement;
		
		population.arrangements[1] = arrangement2;
		
		Arrangement actual = population.getFittest();
		
		assertEquals(arrangement, actual);
	}
	
	
	//generate the random Arrangement 
	public static Arrangement getArrangement() {
		 
		Random random=new Random();
		Arrangement arrangement = new Arrangement();
			
		for(int tableno = 0; tableno < 5; tableno++) {
			Table t = new Table(tableno);
			
			for(int i = 0 ; i < 5 ; i++) {
				Seat s = new Seat();
				s.getPerson().setEatingPreferences(1 + random.nextInt(2));
				s.getPerson().setRelation(1 + random.nextInt(5));
				s.getPerson().setViews(1 + random.nextInt(5));
				s.setTableId(t.getTableId());
				t.addSeat(s);
			}
			arrangement.arrangement.add(t);
		}
			
		return arrangement;
	}

}
