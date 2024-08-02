import java.util.*;
public class Theatre{
	private final String name;
	private final int numRows;
	private final int seatsPerRow;
	private ArrayList<Seat> seats;
	/**
	 * CONSTRUCTOR
	 */
	public Theatre (String name, int numRows , int seatsPerRow){
		this.name = name;
		this.numRows = numRows;
		this.seatsPerRow = seatsPerRow;

		seats = new ArrayList<Seat>(numRows * seatsPerRow);
		initializeSeats();
	}

	/**
	 * ALL PUBLIC METHOD
	 */
	public void timepassWithSeats(int op){
		Collections.sort(this.seats,RESERVATION_COMPARATOR);
		System.out.println(Collections.max(this.seats,PRICE_COMPARATOR));
				System.out.println(Collections.max(this.seats,RESERVATION_COMPARATOR));
	}
	public boolean reserveSeat(String seatNumber){
		Seat seat = getSeatFromSeatNumber(seatNumber);
		if(seat==null){ return false;}
		return seat.reserve();
	}
	public void printSeatStatus(){
		System.out.println("SEAT STATUS");
		for(int i=0 ;i<seats.size();i++){
			System.out.print(seats.get(i)+" ");
		}
		System.out.println();
		System.out.println();
	}
	public static Comparator<Seat> PRICE_COMPARATOR = new Comparator<Seat>(){
		@Override
		public int compare(Seat s1 , Seat s2){
			return (int)s1.getPrice() - (int)s2.getPrice();
		}
	};
 
   public static  Comparator<Seat> RESERVATION_COMPARATOR = new Comparator<Seat>(){
		@Override
		public int compare(Seat s1 , Seat s2){
			if(s2.isReserved()){   
				return 1;
			}
			return -1;
		}
	};

	/**
	 * GETTERS
	 */
	public String getName(){return this.name;}
	public int  getNumRows(){return this.numRows;}
	public int  getSeatsPerRow(){return this.seatsPerRow;}

/**
 * ALL PRIVATE MEHTODS
 */
	private double calculatePrice(int numRows , int seatsPerRow , int seatNumber , int currentRow){
		int increamentFactor = numRows / 3 ;
		if(currentRow < increamentFactor){
			if(seatNumber <= 2 || seatNumber>= seatsPerRow-1){
				return 150;
			}
			return 100;
		}
		else if(currentRow < (increamentFactor<<1)){
			if(seatNumber <=2 || seatNumber >= seatsPerRow-1){
				return 250;
			}
			return 200;
		}
		else if(currentRow == numRows -1){
			return 350;
		}
		if(seatNumber<=2 || seatNumber >= seatsPerRow-1){
			return 325;
		}
		return 300;
	}

	private Seat getSeatFromSeatNumber(String seatNumber){
		Seat key  = new Seat(seatNumber,0);
		int index = Collections.binarySearch(this.seats,key);
		if(index < 0 ){
			return null;
		}
		Seat seat = this.seats.get(index);
		return seat;
	}

	private void initializeSeats(){
		int lastRow = 'A' + numRows -1 ;
		for(char row = 'A' ; row<=lastRow ; row++){
			for(int tempSeatNumber = 1; tempSeatNumber<= seatsPerRow ; tempSeatNumber++){
				String seatNumber = row + String.format("%02d",tempSeatNumber);
				double price = calculatePrice(numRows,seatsPerRow , tempSeatNumber , (int)row);
				Seat seat = new Seat(seatNumber,price);
				seats.add(seat);
			}
		}
	}

	private class Seat implements Comparable<Seat>{
		final String seatNumber ;
		boolean reserved ;
		final double price;
		public Seat(String seatNumber , double price){
			this.seatNumber = seatNumber;
			this.price = price;
			this.reserved = false;
		}

		public String getSeatNumber(){return this.seatNumber;}
				public boolean isReserved(){return this.reserved;}
						public double getPrice(){return this.price;}

	   public boolean reserve(){
	   	if(!this.reserved){
	   		this.reserved = true ;
	   		return true;
	   	}
	   	return false;
	   }

	   @Override
       public int compareTo(Seat otherSeat){
       	return  (this.seatNumber).compareTo(otherSeat.seatNumber);
       }
       @Override
       public String toString(){
       	return "["+this.seatNumber + ", "+this.price +", "+this.reserved + "]";
       }
	}
}