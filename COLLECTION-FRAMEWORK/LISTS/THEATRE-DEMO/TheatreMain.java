

public class TheatreMain{
	public static void main(String[] args) {
		Theatre t = new Theatre("PVR",10,12);
		if(t.reserveSeat("A05")){
			System.out.println("A05 is reserved for you");
		}
		else{
			System.out.println("A05 not is reserved for you");
		}

		t.printSeatStatus();
		t.timepassWithSeats(1);
		t.printSeatStatus();

		t.timepassWithSeats(1);
		t.printSeatStatus();
 
        t.timepassWithSeats(1);
		t.printSeatStatus();
		
	}
}