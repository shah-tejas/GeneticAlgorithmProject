package geneticAlgorithm;

import java.util.ArrayList;

public class Table {

	private static int count = 0;
	private int tableId;
	ArrayList<Seat> seats;
	
	public Table() {
		tableId = count++;
		seats = new ArrayList<>();
	}
	
	public Table(int numberOfSeats) {
		this();
		
		for(int i = 0; i < numberOfSeats; i++) {
			seats.add(new Seat(tableId));
		}
	}

	public int getTableId() {
		return tableId;
	}

	public void setTableId(int tableId) {
		this.tableId = tableId;
	}

	public ArrayList<Seat> getSeats() {
		return seats;
	}

	public void setSeats(ArrayList<Seat> seats) {
		this.seats = seats;
	}
	
	
	
}
