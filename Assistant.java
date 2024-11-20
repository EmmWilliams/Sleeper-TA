import java.util.*;
import java.util.concurrent.Semaphore;

public class Assistant extends Thread {
    

    Thread t;
    Random rand = new Random();
    public Semaphore sleeping = new Semaphore(1);
    public Semaphore needed = new Semaphore(0);
    public Semaphore chair = new Semaphore(3);

  
    Assistant() {



    }


    public void helpStud() {

        try {
            int thing = rand.nextInt(1000, 3000);
            t.sleep(thing);
            System.out.println("Done helping in TA"); 
            chair.release();
        }
        
        catch (InterruptedException e) {

            System.out.println("Think busted.");

        }

    }


    public void run() {

        while (true) {
            
            if (needed.availablePermits() == 0) {
            System.out.println("Will sleep until there is student.");
            sleeping.release();
            }
            System.out.println("Helping in TA"); 
            helpStud(); 

        }

    }

}
