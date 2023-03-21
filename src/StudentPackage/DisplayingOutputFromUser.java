package StudentPackage;

public class DisplayingOutputFromUser {

    public static void displayDetailsOfStudent(Student student) {

        System.out.print(student.getNameOfStudent()+"\t"+student.getRollNoOfStudent()+"\t"+student.getAgeOfStudent()+"\t"+student.getAddressOfStudent()+"\t");
        for (String courses: student.coursesTakenByUser) {
            if (courses == null)break;
            System.out.print(courses+", ");
        }
        System.out.println();
    }
}
