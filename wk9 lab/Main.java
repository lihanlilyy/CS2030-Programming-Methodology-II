import java.util.stream.*;

public class Pair {

    private final int element0;
    private final int element1;

    public Pair(int element0, int element1) {
        this.element0 = element0;
        this.element1 = element1;
    }

    static Pair createPair(int element0, int element1) {
        return new Pair(element0, element1);
    }

    public int first() {
        return element0;
    }

    public int second() {
        return element1;
    }

}

class Main{

    static int gcd(int a, int b){
        int m = 0;
        int n = 0;
        if( a >= b){
            m = a;
            n = b;
        } else {
            m = b;
            n = a;
        }

        return Stream.iterate(
                new Pair(m, n), 
                r -> r.second() != 0, 
                x -> new Pair(x.second(), x.first() % x.second()))
                .findFirst().get().first();

    }

}