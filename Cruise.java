public class Cruise{
    private final String identifier;
    private final int timeOfArr;
    private final int timeToSer;
    private final int noOfLoad;

    Cruise(String identifier,int timeOfArr,int noOfLoad,int timeToSer){
        this.identifier = identifier;
        this.timeOfArr = timeOfArr;
        this.timeToSer = timeToSer;
        this.noOfLoad = noOfLoad;
    }
    int getTimeOfArr(){
       return this.timeOfArr;
    }
    String getIdentifier(){
       return this.identifier;
    }
    int getArrivalTime(){
        return (this.timeOfArr / 100) * 60 + this.timeOfArr %  100;
    }
    int getNumOfLoadersRequired(){
        return this.noOfLoad;
    }
    int getServiceCompletionTime(){
        return timeOfArr / 100 * 60 + timeOfArr % 100 + timeToSer;
    }
   @Override 
   public String toString(){
        return this.identifier + "@" + String.format("%04d", this.timeOfArr);
}

}
