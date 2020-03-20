import java.util.PriorityQueue;

/**
 * EventManager class processes the sequence in which customers in the PriorityQueue are served.
 * and prints out the entire sequence as well as the statistics required.
 */
public class EventManager {
    public static final int ARRIVES = 1;
    public static final int SERVED = 2;
    public static final int LEAVES = 3;
    public static final int DONE = 4;
    public static final int WAITS = 5;

    /**
     * printEvent method to print the sequence of event as well as the final statisitics.
     */
    public static void printEvent() {
        PriorityQueue<Customer> cus = CustomerEntry.entry();
        double nextService = 0;
        int numberOfCustomersServed = 0;
        int numberOfCustomersLeft = 0;
        double totalWaitingTime = 0;
        Server server = new Server();
        while ((cus.size() > 0)) {
            Customer firstCus = cus.poll();
            if (firstCus.getState() == ARRIVES) {
                System.out.println(firstCus);
                if (server.canServe(firstCus)) {
                    server = new Server(firstCus, false, true);
                    firstCus = new Customer(firstCus.getId(),
                            firstCus.getArrivalTime(), ARRIVES, SERVED);
                    cus.add(firstCus);
                    nextService = firstCus.getServiceCompletionTime();
                    numberOfCustomersServed++;
                    System.out.println(firstCus);
                } else if (!server.isLeaving) {
                    firstCus = new Customer(firstCus.getId(),
                            firstCus.getArrivalTime(), ARRIVES, WAITS);
                    cus.add(firstCus);
                    server = new Server(firstCus, true, false);
                    totalWaitingTime += nextService - firstCus.getArrivalTime();
                    System.out.println(firstCus);
                } else if (server.isLeaving) {
                    firstCus = new Customer(firstCus.getId(),
                            firstCus.getArrivalTime(), ARRIVES, LEAVES);
                    numberOfCustomersLeft++;
                    System.out.println(firstCus);
                }
            } else if (firstCus.getState() == WAITS) {
                firstCus = new Customer(firstCus.getId(), nextService, WAITS, SERVED);
                cus.add(firstCus);
                server = new Server(firstCus, true, false);
                nextService = firstCus.getServiceCompletionTime();
                numberOfCustomersServed++;
            } else if (firstCus.getState() == SERVED && firstCus.getPreviousState() == WAITS) {
                System.out.println(firstCus);
                firstCus = new Customer(firstCus.getId(), nextService, SERVED, DONE);
                server = new Server(firstCus, false, true);
                cus.add(firstCus);
            } else if (firstCus.getState() == SERVED && firstCus.getPreviousState() == ARRIVES) {
                firstCus = new Customer(firstCus.getId(), nextService, SERVED, DONE);
                cus.add(firstCus);
                server = new Server(firstCus, false, true);
            } else if (firstCus.getState() == DONE) {
                System.out.println(firstCus);
                server = new Server();
            }
        }
        Statistics stats = new Statistics(totalWaitingTime, numberOfCustomersServed,
                numberOfCustomersLeft);
        System.out.println(stats);
    }
}
