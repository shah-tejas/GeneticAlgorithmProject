package geneticAlgorithm;

import java.util.ArrayList;

public class ArrangementManager {

	private static ArrayList<Seat> seats = new ArrayList<>();
	private static ArrayList<Table> tables = new ArrayList<>();
	private static ArrayList<Person> persons = new ArrayList<>();
	private static int NumberOfPersons;
	
	//methods for seats
	public static void addSeat(Seat seat) {
		seats.add(seat);
	}
	
	public static Seat getSeat(int index) {
		return seats.get(index);
	}
	
	public static int numberOfSeats() {
		return seats.size();
	}
	
	//methods for tables
	public static void addTable(Table table) {
		tables.add(table);
	}
	
	public static Table getTable(int index) {
		return tables.get(index);
	}
	
	public static int numberOfTables() {
		return tables.size();
	}
	
	//methods for persons
	public static void addPerson(Person person) {
		persons.add(person);
	}
	
	public static Person getPerson(int index) {
		return persons.get(index);
	}
	
	public static int numberOfPersons() {
		return persons.size();
	}

	public static int getNumberOfPersons() {
		return NumberOfPersons;
	}

	public static void setNumberOfPersons(int numberOfPersons) {
		NumberOfPersons = numberOfPersons;
	}
	
	
}
