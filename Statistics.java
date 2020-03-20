
/**
 * Statistics class to calculate and print total waiting time of customers.
 * the number of customers who are served.
 * the number of customers who left without being served.
 */
public class Statistics {
    private double totalWaitingTime;
    private int numberOfCustomersServed;
    private int numberOfCustomersLeft;

    /**
     * Creates Statistics object.
     * @param totalWaitingTime the total waiting time
     * @param numberOfCustomersServed number of customers served
     * @param numberOfCustomersLeft the number of customers left without being served
     */
    public Statistics(double totalWaitingTime,
                      int numberOfCustomersServed, int numberOfCustomersLeft) {
        this.totalWaitingTime = totalWaitingTime;
        this.numberOfCustomersServed = numberOfCustomersServed;
        this.numberOfCustomersLeft = numberOfCustomersLeft;
    }

    /**
     * Calculates the average waiting time from total waiting time and number of customers served.
     *
     * @return the average waiting time in double
     */
    public double getAverageWaitingTime() {
        return ((double) totalWaitingTime / (numberOfCustomersServed));
    }

    /**
     * Formats the Statistics to print all information gathered.
     */
    @Override
    public String toString() {
        return "[" + String.format("%.3f", getAverageWaitingTime()) + " " +
                this.numberOfCustomersServed + " " + this.numberOfCustomersLeft + "]";
    }
}