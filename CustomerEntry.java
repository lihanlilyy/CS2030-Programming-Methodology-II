import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * CustomerEntry class to take in the inputs, which are the information about the customers.
 * Each customer is given an id number, a time of arrival, as well as their previous status and
 * current status, as specified in the customer class.
 * The customers are then stored in a PriorityQueue
 */
public class CustomerEntry {

    /**
     * This method initiates a PriorityQueue and takes in the customers using
     * a scanner.
     *
     * @return At the end of it, the PriorityQueue is returned with the customer objects inputs.
     */
    public static PriorityQueue<Customer> entry() {
        final PriorityQueue<Customer> cus = new PriorityQueue<>();
        final Scanner sc = new Scanner(System.in);
        int counter = 1;
        while (sc.hasNextDouble()) {
            final double time = sc.nextDouble();
            final Customer ctm = new Customer(counter, time, 0, 1);
            cus.add(ctm);
            counter++;
        }
        sc.close();
        return cus;
    }
}