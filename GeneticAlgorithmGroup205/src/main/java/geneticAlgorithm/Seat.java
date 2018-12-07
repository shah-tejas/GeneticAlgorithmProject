package geneticAlgorithm;

public class Seat {

	private Person person;
	private int tableId;
	private int seatId;
	private static int count = 1;
	
	public Seat(){
		seatId = count++;
		person = new Person();
	}
	
	Seat(int dummy){
		
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public int getTableId() {
		return tableId;
	}

	public void setTableId(int tableId) {
		this.tableId = tableId;
	}

	public int getSeatId() {
		return seatId;
	}

	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}
	
        public static void reset(){
            count = 0;
        }
	
}
