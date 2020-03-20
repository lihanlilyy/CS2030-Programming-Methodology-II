
/**
 * Server class to keep track of which customer is waiting and which customer is being served.
 * It also determines when a customer needs to leave.
 */
public class Server {
    private final Customer cstm;
    boolean isLeaving;
    boolean isWaiting;
    public static final int ARRIVES = 1;
    public static final int SERVED = 2;
    public static final int LEAVES = 3;
    public static final int DONE = 4;
    public static final int WAITS = 5;

    /**
     * Creates an initial Server object.
     */
    public Server() {
        this.cstm = null;
        this.isLeaving = false;
        this.isWaiting = false;
    }

    /**
     * Creates an customer object.
     *
     * @param cstm      a customer that is served
     * @param isLeaving a boolean that reflects if the next customer that comes needs to leave
     * @param isWaiting a boolean that reflects if the next customer that comes can wait first 
     *        before he or she is served.
     */
    public Server(Customer cstm, boolean isLeaving, boolean isWaiting) {
        this.cstm = cstm;
        this.isLeaving = isLeaving;
        this.isWaiting = isWaiting;
    }

    /**
     * This method makes a server serve a specific customer a. A new Server object is 
     * created and returned according to the current availibility of server to reflect 
     * the change the status of server after serving the specific customer.
     *
     * @param a a customer 
     * @return Server
     */
    public Server serve(Customer a) {
        if (a.getState() == ARRIVES) {
            if (canServe(a)) {
                return new Server(a, false, true);
            } else if (!this.isLeaving) {
                return new Server(a, true, false);
            } else {
                return null;
            }
        } else if (a.getState() == WAITS) {
            return new Server(a, true, false);
        } else if (a.getState() == SERVED && a.getPreviousState() == WAITS) {
            return new Server(a, false, true);
        } else if (a.getState() == SERVED && a.getPreviousState() == ARRIVES) {
            return new Server(a, false, true);
        } else {
            return null;
        }
    }

    /**
     * Reset the server.
     * @return Server
     */
    public Server reset() {
        return new Server();
    }

    /**
     * check if a server can serve a specific customer b.
     * @param b check if a server can serve a specific customer b
     * @return boolean
     */
    public boolean canServe(Customer b) {
        if (this.cstm == null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Check if a customer can wait to be served.
     * @param aPoorGuy check if a customer can wait to be served
     *        when the server is currently serveing another customer
     * @return boolean
     */
    public boolean canWait(Customer aPoorGuy) {
        if (this.cstm != null && this.isWaiting) {
            return true;
        } else {
            return false;
        }
    }
}