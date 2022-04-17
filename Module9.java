import java.util.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.stream.Collectors;

public class Module9 {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Student s = null;
        // PART A
        Scanner filesScanner = new Scanner(new File("inputData.txt"));
        String line;
        /*
        String line = filesScanner.nextLine();
        while (filesScanner.hasNext()) {
            line = filesScanner.nextLine();
            System.out.println(line);
        }
        filesScanner.close();*/



        System.out.println("\n\nNow, here's a listing of only student data:");
        File file = new File("inputData.txt");
        Scanner in = null;
        try {
            in = new Scanner(file);
            while(in.hasNext())
            {
                line=in.nextLine();
                if(line.contains("student")) {
                    // prints student listing correctly as well...
                    // System.out.println(line);

                    // Create arraylist for student data
                    ArrayList<Student> studentList = new ArrayList<>();
                    String[] details = line.split(",");

                    // variables
                    String classType = details[0];
                    String firstName = details[1];
                    String lastName = details[2];
                    int id = Integer.parseInt(details[3]);
                    String major = details[4];
                    double gpa = Double.parseDouble(details[5]);
                    int credits = Integer.parseInt(details[6]);

                    // object
                    Student student = new Student(classType, firstName, lastName, id, major, gpa, credits);
                    studentList.add(student);
                   
                    // Collections.sort(studentList);
                    

                    /*
                    Collections.sort(studentList,
                         Comparator.comparingDouble(Student::getGPA));
        System.out.println("\nAfterSort:");
        studentList.forEach(user -> System.out.println(user));

                    /*
                    studentList.sort(Comparator.comparingDouble(Student::getGPA));
                    System.out.println(studentList);*/
                    

                    // Collections.sort(studentList, (s1, s2) -> s1.getGPA().compareTo(s2.getGPA()));
                    /*
                    Comparator<Student> gpaComparator = (a,b) -> Double
                    .compare(a.getGPA(), b.getGPA());

                    gpaComparator = Comparator.comparingDouble(Student::getGPA);
                    studentList.sort(gpaComparator);
                    System.out.println(studentList);
                    // Next potential solution...
                    List<Student> sortedList = studentList.stream().sorted(Comparator.comparingDouble(Student::getGPA)).collect(Collectors.toList());
                    // sortedList.forEach(System.out::println);
                    System.out.println(sortedList.toString());
                    // student.display();*/
                }
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
