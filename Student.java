import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Student extends Thread {
    
    int studentNum;
    Thread t;
    Random rand = new Random();
    Assistant TA;
    Lock lock = new ReentrantLock();

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
        try {
            if (TA.chair.tryAcquire()) {
                
                System.out.println("Student " + studentNum + " got a seat");
                
                TA.needed.release();

                if (TA.needed.availablePermits() == 0) {
                System.out.println("Student " + studentNum + " woke TA up"); 
                }

                TA.helping.acquire();
                System.out.println("Student " + studentNum + " got help");
                TA.chair.release();
            }
            else {
                System.out.println("Not available rn, student " + studentNum + " will be returning later");
            }
        } 
        //finally {
           // lock.unlock();
        //}
        catch (InterruptedException e ) {
            System.out.println("Alas you beefed it!");
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