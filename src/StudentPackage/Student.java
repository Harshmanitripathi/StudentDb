package StudentPackage;

import java.util.Queue;
import java.io.Serializable;

public class Student implements Serializable{
    public int rollNoOfStudent, ageOfStudent;
    public String nameOfStudent, addressOfStudent;
    //    boolean courseA, courseB, courseC, courseD, courseE, courseF;
    public String coursesTakenByUser[] = new String[100000];



    public void setDetails(int rollNoOfStudent, int ageOfStudent, String nameOfStudent, String addressOfStudent, Queue<String> course)
    {
        this.rollNoOfStudent = rollNoOfStudent;
        this.ageOfStudent = ageOfStudent;
        this.nameOfStudent = nameOfStudent;
        this.addressOfStudent = addressOfStudent;
        int i=0;
//        converting set to Array
        while(course.size() > 0){
            this.coursesTakenByUser[i++] = course.peek();
            course.remove();

        }


    }

    public int getRollNoOfStudent() {
        return rollNoOfStudent;
    }

    public void setRollNoOfStudent(int rollNoOfStudent) {
        this.rollNoOfStudent = rollNoOfStudent;
    }

    public int getAgeOfStudent() {
        return ageOfStudent;
    }

    public void setAgeOfStudent(int ageOfStudent) {
        this.ageOfStudent = ageOfStudent;
    }

    public String getNameOfStudent() {
        return nameOfStudent;
    }

    public void setNameOfStudent(String nameOfStudent) {
        this.nameOfStudent = nameOfStudent;
    }

    public String getAddressOfStudent() {
        return addressOfStudent;
    }

    public void setAddressOfStudent(String addressOfStudent) {
        this.addressOfStudent = addressOfStudent;
    }

    public String[] getCoursesTakenByUser() {
        return coursesTakenByUser;
    }

    public void setCoursesTakenByUser(String[] coursesTakenByUser) {
        this.coursesTakenByUser = coursesTakenByUser;
    }
}
