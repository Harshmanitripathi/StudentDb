package StudentPackage;

import java.io.IOException;
import java.net.BindException;
import java.util.*;
import java.util.Comparator;
public class UserIO {
   static Student[] student;
    public static void TakingInput() throws IOException {

//        Taking Input from user Starts over here
        Scanner sc = new Scanner(System.in);
        String noOfStudents1="";
        System.out.println("Enter the no. of Student to enter the details");

//        Validation for Number Of Student
        while (true) {
            try {
                System.out.print("No. of Student: ");
                noOfStudents1 = sc.next();boolean check=true;
                for (int i=0;i<noOfStudents1.length();i++) {
                    if (!(noOfStudents1.charAt(i)>='0' && noOfStudents1.charAt(i)<='9'))
                        check=false;
                    if (check == false)
                        throw new BadDataEnteredException("Number of Student Must be in Digits");
                }
            } catch (BadDataEnteredException x) {
                System.out.println(x.toString());
                continue;
            }
            break;
        }
        int noOfStudents = Integer.parseInt(noOfStudents1);
        String rollNo1 = "", ageOfStudent1 = "";
        String addressOfStudent = "", nameOfStudent = "";
        String[] setOfCourses = new String[1000];

         student = new Student[noOfStudents];

        for (int i = 0; i < noOfStudents; i++) {
            System.out.println("Enter the details of " + i + 1 + " Student");

//            Validation for Roll No
            while (true) {
                try {
                    System.out.print("Enter the roll no.: ");
                    rollNo1 = sc.next();
                    boolean checkRollno = true;
                    for (int j = 0; j < rollNo1.length(); j++) {
                        if (!(rollNo1.charAt(j) >= '0' && rollNo1.charAt(j) <= '9')) {
                            checkRollno = false;
                            break;
                        }
                    }
                    if (checkRollno == false)
                        throw new BadDataEnteredException("Roll No. should be an integer type");
                    if (Integer.parseInt(rollNo1) > noOfStudents)
                        throw new BadDataEnteredException("Roll No. of Students can't be greater than Student available");


                } catch (BadDataEnteredException x) {
                    System.out.println(x.toString());
                    continue;
                }
                break;
            }
            int rollNo = Integer.parseInt(rollNo1);
            System.out.println("Enter the age");

//            Validation for Age
            while (true) {
                try {
                    System.out.print("Enter the age: ");
                    ageOfStudent1 = sc.next();
                    boolean check = true;
                    for (int j = 0; j < ageOfStudent1.length(); j++) {
                        if (!(ageOfStudent1.charAt(j) >= '0' && ageOfStudent1.charAt(j) <= '9')) {
                            check = false;
                            break;
                        }
                    }
                    if (check == false)
                        throw new BadDataEnteredException("Age should be an integer type");


                } catch (BadDataEnteredException x) {
                    System.out.println(x.toString());
                    continue;
                }
                break;
            }

            int ageOfStudent = Integer.parseInt(ageOfStudent1);

//            Validation for Name
            while (true) {
                try {
                    System.out.print("Enter the name of student: ");
                    nameOfStudent = sc.next();
                    if (nameOfStudent.charAt(0) >= '0' && nameOfStudent.charAt(0) <= '9')
                        throw new BadDataEnteredException("Name should not start with Digit");
                    if (nameOfStudent.charAt(0) >= 'a' && nameOfStudent.charAt(0) <= 'z')
                        throw new BadDataEnteredException("Name should not start with Small Alphabets");
                    int checkForSpace = 0;
                    for (int j = 0; j < nameOfStudent.length(); j++) {
                        if (nameOfStudent.charAt(i) == ' ') {
                            checkForSpace++;
                            if (nameOfStudent.charAt(i + 1) >= '0' && nameOfStudent.charAt(i + 1) <= '9')
                                throw new BadDataEnteredException("Any part of Name should not start with Digit");
                        }
                    }
                    if (checkForSpace > 2)
                        throw new BadDataEnteredException("Name should not be more than 3 words");
                } catch (BadDataEnteredException x) {
                    System.out.println(x.toString());
                    continue;
                }
                break;
            }

//            Validation for Address
            while (true) {
                try {
                    System.out.print("Enter the address of student: ");
                    addressOfStudent = sc.next();
                    if (addressOfStudent.charAt(0) == ',')
                        throw new BadDataEnteredException("Enter valid Address");
                } catch (BadDataEnteredException x) {
                    System.out.println(x.toString());
                    continue;
                }
                break;
            }

            System.out.println("enter the courses name whom you want to take , enter done when its over");


                int k=0;
            while (true) {

                try {
                    while (true) {
                        String inputFromUserAboutTheCourses = sc.next();
                        if (((inputFromUserAboutTheCourses).toLowerCase()).equals("y") == true)
                            break;
                        if (Arrays.asList(setOfCourses).contains(inputFromUserAboutTheCourses.toUpperCase()) == true)
                            System.out.println("This course you entered previously");
                        else
                            setOfCourses[k++] = inputFromUserAboutTheCourses.toUpperCase();

                        String d = inputFromUserAboutTheCourses.toUpperCase();

                        if (!(d.equals("A") || d.equals("B") || d.equals("C") || d.equals("D") || d.equals("E") || d.equals("F")))
                            throw new BadDataEnteredException("Courses available are A,B,C,D,E,F");
                        if (d.equals("Y"))
                            if (!(k >= 4 && k <= 6))
                                throw new BadDataEnteredException("Courses entered should be atleast 4 and less than 6");
                    }
                       }
                      catch (BadDataEnteredException x){
                           System.out.println(x.toString());
                           continue;
                       }

                break;
            }

            student[i]= new Student(rollNo, ageOfStudent, nameOfStudent, addressOfStudent, setOfCourses);
            setOfCourses = new String[setOfCourses.length];
        }
//       Taking Input Ends Over here

//        Default Sorting based on Age
        Arrays.sort(student, new SortByAge());


        FileInputOutput.saveStudentDetailsInFile(student);
    }

   static void Sorting(){
        System.out.println("enter the way you want to sort by age=1, name=2, rollno=3, address=4 etc.");
        Scanner sc = new Scanner(System.in);
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
    }

    static void displayDetails(){
        System.out.println("----------------------------------------------------------");
        System.out.println("Name \t Roll Number \t Age \t Address \t Courses");
        System.out.println("----------------------------------------------------------");
        for (int i = 0; i < student.length; i++) {
            if (student[i] == null)break;
            student[i].display();
        }
    }

    static void deleteParticularStudent(){
        Scanner sc = new Scanner(System.in);
        String finishDeleting = "";
        while (!(finishDeleting.equals("y"))) {
            System.out.println("Enter the rollno you want to delete");
            int rollNoToBeDeleted = sc.nextInt();
            boolean checkForRollNo = false;
            DeletingStudents.studentDeleted(student,rollNoToBeDeleted, checkForRollNo);
            System.out.println("If you are done deleting type y else type no");
            finishDeleting = sc.next();
        }
    }

}







