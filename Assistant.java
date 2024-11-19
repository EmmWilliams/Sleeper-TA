import java.util.*;
import java.util.concurrent.Semaphore;

public class Assistant extends Thread {
    
    ArrayList<Student> wstudents;
    Thread t;
    Random rand = new Random();
    boolean needed = true;
  
    Assistant(ArrayList<Student> students) {

        this.wstudents = students;

    }

    public boolean anyStud() {

        if (!wstudents.isEmpty()) {
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

        while (true) {

            if (needed) {

                

            }
            
        }

    }

    public void setNeed (boolean isit) {

        this.needed = isit;

    }
}
