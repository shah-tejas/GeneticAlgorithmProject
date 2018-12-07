package geneticAlgorithm;

import java.util.ArrayList;

public class ArrangementManager {

	private static ArrayList<Table> tables = new ArrayList<>();
	private static int GuestsPerTable;

	// methods for tables
	public static void addTable(Table table) {
		tables.add(table);
	}

	public static Table getTable(int index) {
		return tables.get(index);
	}

	public static int numberOfTables() {
		return tables.size();
	}

	public static int getGuestsPerTable() {
		return GuestsPerTable;
	}

	public static void setGuestsPerTable(int guestsPerTable) {
		GuestsPerTable = guestsPerTable;
	}

	public static ArrayList<Seat> getAllSeats() {
		ArrayList<Seat> allSeats = new ArrayList<>();

		for (Table t : tables) {
			for (Seat s : t.getSeats()) {
				allSeats.add(s);
			}
		}

		return allSeats;
	}
        
        public static void reset(){
            GuestsPerTable = 0;
            tables.clear();
            Person.reset();
            Table.reset();
            Seat.reset();
        }

}
