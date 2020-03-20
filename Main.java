import java.util.Scanner;
import java.util.Collection;

public class Main{

public static boolean isBigCruise(Cruise cruise){
    return cruise.getIdentifier().charAt(0) == 'B';
}

public static boolean isSmallCruise(Cruise cruise){
    return cruise.getIdentifier().charAt(0) == 'S';
    }

public static void main(String[] args){
    int maxCruise = 30;
    int numOfLoaderNeed;
    int loaderUsed = 0;
    Scanner sc = new Scanner(System.in);
    int inputCruise = sc.nextInt();
    Cruise[] cruise = new Cruise[30];

    for(int i = 0; i < Math.min(maxCruise, inputCruise); i = i + 1){
     String checkCruise = sc.next();
        if(checkCruise.charAt(0) == 'B'){
            cruise[i] = new BigCruise(checkCruise, sc.nextInt(), sc.nextInt(), sc.nextInt());

        }
        else{
            cruise[i] = new SmallCruise(checkCruise, sc.nextInt());

        }
    }

    Loader[] loader = new Loader[270];
    for(int i = 0; i < inputCruise; i++){
        numOfLoaderNeed = cruise[i].getNumOfLoadersRequired();

        if (loaderUsed > 0){
            for(int j = 1; j <= loaderUsed; j++) {
                if (loader[j].canServe(cruise[i])) {
                    loader[j] = loader[j].serve(cruise[i]);
                    System.out.println(loader[j]);
                    numOfLoaderNeed--;
                }
                if (numOfLoaderNeed <= 0) {
                    break;
                }
            }

                while (numOfLoaderNeed > 0) {
                    loaderUsed++;
                    loader[loaderUsed] = new Loader(loaderUsed, cruise[i]);
                    System.out.println(loader[loaderUsed]);
                    numOfLoaderNeed--;
                }

        }else{
            while(numOfLoaderNeed > 0) {
                loaderUsed++;
                loader[loaderUsed] = new Loader(loaderUsed, cruise[i]);
                System.out.println(loader[loaderUsed]);
                numOfLoaderNeed--;
            }
        }
    }


}

}
