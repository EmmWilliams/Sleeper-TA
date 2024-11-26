import java.util.*;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Assistant extends Thread {
    

    Thread t;
    Random rand = new Random();
    public Semaphore needed = new Semaphore(0);
    public Semaphore helping = new Semaphore(0);
    public Semaphore chair = new Semaphore(3);
    Lock lock = new ReentrantLock();

    public void helpStud() {

        try {
            int thing = rand.nextInt(1000, 3000);
            t.sleep(thing);
            helping.release();
            System.out.println("Done helping in TA"); 
        }
        
        catch (InterruptedException e) {

            System.out.println("Help error.");

        }

    }


    public void run() {

        while (true) {

            if (needed.availablePermits() == 0) {
                System.out.println("TA is asleep");
            }
            
            try {
            
            needed.acquire();
            System.out.println("Helping in TA"); 
            //lock.lock();
            
            // try {
            
            helpStud(); 
            // chair.release();
            
            // } 
            // finally {
            //     lock.unlock();
            // } 

            }

            catch (InterruptedException e) {
                System.out.println("TA error in run.");
            }
        
        }

    }

}