import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Student extends Thread {
    
    private int studentNum;
    private Thread t;
    private Random rand = new Random();
    private Assistant TA;
    Lock lock = new ReentrantLock();
    private boolean isWaiting;

    Student (int studNum, Assistant teachAssistant) {

        this.studentNum = studNum;
        this.TA = teachAssistant;

    }

    private void study() {

        try {
            int thing = rand.nextInt(1000, 3000);
            t.sleep(thing);
        }
        
        catch (InterruptedException e) {

            System.out.println("Study busted.");

        }

    }
    
    private void requestHelp() {
        //lock.lock();
        if (isWaiting) {
            return; // Prevent multiple requests while waiting for help
        }
        try {

            if (TA.chair.availablePermits() == 3 && TA.helping.availablePermits() == 1) {
                System.out.println("Student " + studentNum + " woke TA up");
                TA.setStudID(studentNum); // Set the current student ID
                TA.needed.release();
                TA.chair.release();
                TA.helping.acquire();
                System.out.println("Student " + studentNum + " got help");
            }
            
            if (TA.chair.tryAcquire()) {
                TA.setStudID(studentNum);
                System.out.println("Student " + studentNum + " got a seat");
                
                TA.needed.release();
                
                TA.helping.acquire();
                TA.chair.release();
                System.out.println("Student " + studentNum + " got help");
            }
            else {
                System.out.println("Not available rn, student " + studentNum + " will be returning later");
            }
        } 
        
        catch (InterruptedException e ) {
            System.out.println("Alas you beefed it!");
        }
        finally {
            isWaiting = false;
         }
    }

    public void run() {

        System.out.println("Student " + studentNum + " beginning");
        while (true) {

            study();
            requestHelp();
            

        }

    }

}