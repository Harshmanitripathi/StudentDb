package StudentPackage;

import java.io.IOException;
import java.util.*;
import java.util.Comparator;
public class TakingInputFromUser {

    public static void TakingInput() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no. of Student to enter the details");
        int noOfStudents = sc.nextInt();
        int rollNo = 0, ageOfStudent = 0;
        String addressOfStudent = "", nameOfStudent = "";
        Queue<String> setOfCourses = new LinkedList<>();

        Student[] student = new Student[noOfStudents];

        for (int i = 0; i < noOfStudents; i++) {

            student[i] = new Student();
            System.out.println("Enter the details of " + i + 1 + " Student");
            System.out.println("Enter the roll no.");
            rollNo = sc.nextInt();
            System.out.println("Enter the age");
            ageOfStudent = sc.nextInt();
            System.out.println("Enter the name of student");
            nameOfStudent = sc.next();
            System.out.println("Enter the address of student");
            addressOfStudent = sc.next();

            System.out.println("enter the courses name whom you want to take , enter done when its over");

            Set<String> course = new HashSet<String>();

            while (true) {
                String inputFromUserAboutTheCourses = sc.next();
                if (((inputFromUserAboutTheCourses).toLowerCase()).equals("done"))
                    break;
                if (setOfCourses.contains((inputFromUserAboutTheCourses).toUpperCase()))
                    System.out.println("This course you entered previously");
                else
                    setOfCourses.add((inputFromUserAboutTheCourses).toUpperCase());

            }

            student[i].setDetails(rollNo, ageOfStudent, nameOfStudent, addressOfStudent, setOfCourses);

        }

        Arrays.sort(student, new SortByAge());


        System.out.println("----------------------------------------------------------");
        System.out.println("Name \t Roll Number \t Age \t Address \t Courses");
        System.out.println("----------------------------------------------------------");
        for (int i = 0; i < noOfStudents; i++) {
            if (student[i] == null)break;
            DisplayingOutputFromUser.displayDetailsOfStudent(student[i]);
        }

        System.out.println("enter the way you want to sort by age=1, name=2, rollno=3, address=4 etc.");
        int sortBy = sc.nextInt();
        switch (sortBy) {
            case 1:
                Arrays.sort(student, new SortByAge());
                break;
            case 2:
                Arrays.sort(student, new SortByName());
                break;
            case 3:
                Arrays.sort(student, new SortByRollNo());
                break;
            case 4:
                Arrays.sort(student, new SortByAddress());
        }
        System.out.println("----------------------------------------------------------");
        System.out.println("Name \t Roll Number \t Age \t Address \t Courses");
        System.out.println("----------------------------------------------------------");
        for (int i = 0; i < noOfStudents; i++) {
            if (student[i] == null)break;
            DisplayingOutputFromUser.displayDetailsOfStudent(student[i]);
        }


        String finishDeleting = "";
        while (!(finishDeleting.equals("done"))) {
            System.out.println("Enter the rollno you want to delete");
            int rollNoToBeDeleted = sc.nextInt();
            boolean checkForRollNo = false;
            DeletingStudents.studentDeleted(student, rollNoToBeDeleted, checkForRollNo);
            System.out.println("If you are done deleting type done else type no");
            finishDeleting = sc.next();
        }
        System.out.println("----------------------------------------------------------");
        System.out.println("Name \t Roll Number \t Age \t Address \t Courses");
        System.out.println("----------------------------------------------------------");
        for (int i = 0; i < noOfStudents; i++) {
            if (student[i] == null)break;
            DisplayingOutputFromUser.displayDetailsOfStudent(student[i]);
        }

    }

}







