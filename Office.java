import java.util.ArrayList;

public class Office {
    
    public static void main(String[] args) { 
        
        int numStud = 3; // Change to ask user at some point ||||||||||!
        ArrayList<Student> students = new ArrayList<>();
        Assistant TA = new Assistant();

        TA.start();

        for(int i = 0; i < numStud; i++) {
            students.add(new Student(i, TA));
        }

        for(Student student : students) {
            student.start();
        }

    }
  
}
