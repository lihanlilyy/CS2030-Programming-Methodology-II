import java.lang.Math;

public class BigCruise extends Cruise{

	private final String id;
	private final int timeOfArrival;
	private static final int lengthDiv = 40;
	private static final int numOfPeopleDiv = 50;
	public BigCruise(String id, int timeOfArrival, int length, int numOfPeople){
		super(id, timeOfArrival, (length % lengthDiv != 0) ? length / lengthDiv + 1 : length / lengthDiv, (numOfPeople % numOfPeopleDiv != 0) ? numOfPeople / numOfPeopleDiv + 1 : numOfPeople / numOfPeopleDiv);
		this.id = id;
		this.timeOfArrival = timeOfArrival;
	}
	@Override
		public String toString(){
			return this.id + "@" + String.format("%04d", this.timeOfArrival);
		}
}



/*
import java.lang.Math;

public class BigCruise extends Cruise{

	private static final int lenDivisor = 40;
	private static final int pplDivisor = 50;

	private final String id;
	private final int arrivalTime;
	private final int length;
	private final int numOfPeople;
	public BigCruise(String id, int arrivalTime, int length, int numOfPeople){
		super(id, arrivalTime, (length% lenDivisor != 0) ? length/lenDivisor + 1 : length/lenDivisor, (numOfPeople % pplDivisor !=0) ? numOfPeople / pplDivisor + 1 : numOfPeople / pplDivisor);
		this.id = id;
		this.arrivalTime = arrivalTime;
		this.length = length;
		this.numOfPeople = numOfPeople;
	}
	@Override
		public String toString(){
			return this.id + "@" + String.format("%04d", this.arrivalTime);
		}
}
*/

