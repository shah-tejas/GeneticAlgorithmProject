package geneticAlgorithm;

import java.util.ArrayList;

import org.apache.log4j.Logger;

public class Table {

	private static int count = 0;
	private int tableId;
	ArrayList<Seat> seats;
	final static Logger logger = Logger.getLogger(Table.class);
	
	public Table() {
		tableId = count++;
		seats = new ArrayList<>();
		logger.debug("Creating new table with id: " + tableId);
	}
	
	public Table(int tableId) {
		//Create table with existing tableid
		this.tableId = tableId;
		seats = new ArrayList<>();
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
	
	public void addSeat(Seat s) {
		this.seats.add(s);
	}
	
	public void emptyAllSeats() {
		for(int i = 0; i < seats.size(); i++) {
			seats.remove(i);
		}
	}
	
}
