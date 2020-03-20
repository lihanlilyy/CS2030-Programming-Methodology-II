import java.util.Scanner;
import java.util.ArrayList;
import java.util.Optional;
import java.util.NoSuchElementException;


public class Main{
    public static void main(String[] args) throws NoSuchRecordException {
        Scanner sc = new Scanner(System.in);
        int noOfRecords = sc.nextInt();
        Roster roster = new Roster("hello");
        for(int i = 0; i < noOfRecords; i++){
            String id = sc.next();
            String code = sc.next();
            String name = sc.next();
            String grade = sc.next();
        

            roster.get(id).ifPresentOrElse(s -> s.get(code).ifPresentOrElse(m -> m.put(new Assessment(name, grade)),
            () -> roster.get(id).map(x->x.put(new Module(code).put(new Assessment(name, grade))))),
            () -> roster.put(new Student(id).put(new Module(code).put(new Assessment(name, grade)))));
        }

        while(sc.hasNext()){
            String id = sc.next();
            String code = sc.next();
            String name = sc.next();
            try {
                System.out.println(roster.getGrade(id, code, name));
            } catch (NoSuchRecordException e) {
                System.out.println("NoSuchRecordException: No such record: " + id + " " + code + " " + name);
            }
        }

    }
}