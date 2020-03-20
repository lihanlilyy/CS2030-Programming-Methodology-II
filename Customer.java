
/**
 * Customer class holds customer information.
 * There are also getters to retrive the relevant information.
 * The compareTo method helps sorting the cusstomer objects in the PriorityQueue.
 * The toString method help to print the customer information.
 */
public class Customer implements Comparable<Customer> {
    private final int id;
    private final double arrivalTime;
    private final int previousState;
    private final int state;

    /**
     * Creates an customer object.
     *
     * @param id            customer's ID
     * @param arrivalTime   customer's arrival time
     * @param previousState customer's previous state
     * @param state         customer's current state
     */
    public Customer(int id, double arrivalTime, int previousState, int state) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.previousState = previousState;
        this.state = state;
    }

    /**
     * Get the id of the customer.
     * @return int the id
     */
    public int getId() {
        return this.id;
    }

    /**
     * Get the arirval time of the customer.
     * @return double the arrivalTime
     */
    public double getArrivalTime() {
        return this.arrivalTime;
    }

    /**
     * Get the service completition time of the customer.
     * @return double the service completion time for a customer being served
     */
    double getServiceCompletionTime() {
        return this.getArrivalTime() + 1;
    }

    /**
     * Get the state of the customer.
     * @return int the current state of a customer
     */
    public int getState() {
        return this.state;
    }

    /**
     * Get the previous state of the customer.
     * @return int the previous state of a customer
     */
    public int getPreviousState() {
        return this.previousState;
    }

    /**
     * Compares 2 Events and decides which is smaller, equal or greater.
     * The first key is to check for the earlier arrival time.
     * If there is a tie breaker, customerID is checked instead,
     * which also hints on the priority of different type of events.
     *
     * @param o the customer being compared with
     * @return int -1 if this is prioritised over o.
     *             0 if there is not a priority.
     *             1 if o is prioritised over this.
     */
    @Override
    public int compareTo(Customer o) {
        if (this.arrivalTime > o.arrivalTime) {
            return 1;
        } else if (this.arrivalTime < o.arrivalTime) {
            return -1;
        } else {
            if (this.id > o.id) {
                return 1;
            } else if (this.id < o.id) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    /**
     * Formats the customer information to print all information on customer gathered.
     */
    @Override
    public String toString() {
        if (this.getState() == 1) {
            return String.format("%.3f", this.arrivalTime) + " " + this.id + " arrives";
        } else if (this.getState() == 2) {
            return String.format("%.3f", this.arrivalTime) + " " + this.id + " served";
        } else if (this.getState() == 3) {
            return String.format("%.3f", this.arrivalTime) + " " + this.id + " leaves";
        } else if (this.getState() == 4) {
            return String.format("%.3f", this.arrivalTime) + " " + this.id + " done";
        } else if (this.getState() == 5) {
            return String.format("%.3f", this.arrivalTime) + " " + this.id + " waits";
        } else {
            return null;
        }
    }
}