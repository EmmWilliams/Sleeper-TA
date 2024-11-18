import java.util.ArrayList;

public class Office {
    
    public static void main(String[] args) {
        
        ArrayList<Student> students = new ArrayList<>();
        Assistant TA;

        for(int i = 0; i < 5; i++) {

            students.add(new Student(i));

        }

        TA = new Assistant(students);

        TA.start();

        for(Student student : students) {

            student.start();

        }

    }


}
