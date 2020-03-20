public class SmallCruise extends Cruise{

    private static final int haha = 1;
	private static final int hehe = 30;
    private final String id;
    private final int timeOfArrival;
    public SmallCruise(String id, int timeOfArrival){
        super(id, timeOfArrival, haha, hehe);
        this.id = id;
        this.timeOfArrival = timeOfArrival;
    }

    @Override
    public String toString(){

        return this.id + "@" + String.format("%04d", this.timeOfArrival);
    }


}

/*
public class SmallCruise extends Cruise{

    private static final int haha= 1;
	private static final int hehe= 30;
    private final String ID;
    private final int arrivalTime;
    public SmallCruise(String ID, int arrivalTime){
        super(ID, arrivalTime, haha, hehe);
        this.ID = ID;
        this.arrivalTime = arrivalTime;
    }
    @Override
    public String toString(){

        return this.ID + "@" + String.format("%04d", this.arrivalTime);
    }


}
*/
