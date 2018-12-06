package geneticAlgorithm;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ArrangementTest {

		//Test the getFitness function of GeneticAlgorithm
		@Test
		public void testGetFitness(){
			
			Arrangement arrangement=GeneticAlgorithmTest.getArrangement();
					
			assertEquals(arrangement.getFitness(), 120, 0.0001);
			
		}
		
		//Test size of the arrangement
		@Test
		public void testArrangementSize(){
			
			Arrangement arrangement = GeneticAlgorithmTest.getArrangement();
			
			int actualSize = arrangement.arrangementSize();
			
			int expectedSize = 5;
			
			assertEquals(expectedSize, actualSize);
		}
		
		
}
