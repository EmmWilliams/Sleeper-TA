import java.util.Random;

public class Student extends Thread {
    
    int studentNum;
    Thread t;
    Random rand = new Random();
    Assistant TA;

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

        try {
            if (TA.chair.tryAcquire() == true) {
                System.out.println("Student " + studentNum + " got a seat");
                TA.needed.release();
                if (TA.sleeping.availablePermits() > 0) {
                TA.sleeping.acquire(); System.out.println("Student " + studentNum + " woke TA up"); 
                }
                System.out.println("Student " + studentNum + " is getting help");
            }
            else {
                System.out.println("Not available rn, student " + studentNum + " will be returning later");
            }
        }
        
        catch (InterruptedException e) {

            System.out.println("Study busted.");

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
