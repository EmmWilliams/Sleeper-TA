import java.util.*;

public class Office {
    
    public static void main(String[] args) { 
        

        int numStud;
        ArrayList<Student> students = new ArrayList<>();
        Assistant TA = new Assistant();
        Scanner s = new Scanner(System.in);


        System.out.println("This is an example for the Sleeping TA Problem - \nPlease enter number students you have (ex. '1,' '5,' or '10'): ");
        numStud = s.nextInt();
        s.close();

        TA.start();

        for(int i = 0; i < numStud; i++) {
            
            Student student = new Student(i, TA);
            student.setName(Integer.toString(i));
            students.add(student);
        }

        for(Student student : students) {
            student.start();
        }

    }
  
}
