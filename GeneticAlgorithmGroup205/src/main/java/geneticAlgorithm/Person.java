package geneticAlgorithm;

import java.util.Random;

public class Person {
	
	private int personId;
	private static int count = 1;

	private int views;
	private int relation;
	private int eatingPreferences;
	
	Random random=new Random();

	public Person(int views, int relation, int eatingPreferences) {
		this.views = views;
		this.relation = relation;
		this.eatingPreferences = eatingPreferences;
		personId = count++;
	}

	public Person() {
		this.views = 1 + random.nextInt(5);
		this.relation = 1 + random.nextInt(5);
		this.eatingPreferences = 1 + random.nextInt(2);
		personId = count++;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public int getRelation() {
		return relation;
	}

	public void setRelation(int relation) {
		this.relation = relation;
	}

	public int getEatingPreferences() {
		return eatingPreferences;
	}

	public void setEatingPreferences(int eatingPreferences) {
		this.eatingPreferences = eatingPreferences;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}
	
	
	public static void reset(){
            count = 0;
        }
	
	
}
