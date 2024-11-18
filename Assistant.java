import java.util.*;
import java.util.concurrent.Semaphore;

public class Assistant extends Thread {
    
    ArrayList<Student> students;
    Thread t;
    Random rand = new Random();

    Assistant(ArrayList<Student> students) {

        this.students = students;

    }

    public boolean anyStud() {

        if (!students.isEmpty()) {
            return true;
        }

        return false;
    }

    public void helpStud(int studentNum) {

        try {
            int thing = rand.nextInt(1000, 3000);
            t.sleep(thing);
        }
        
        catch (InterruptedException e) {

            System.out.println("Think busted.");

        }

    }

    public void goSleep() {



    }

    public void run() {

        

    }
}
