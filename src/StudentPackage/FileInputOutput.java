package StudentPackage;

import java.io.*;
import java.util.ArrayList;

public class FileInputOutput {
  public static void saveStudentDetailsInFile(Student[] students) throws FileNotFoundException {

      try{
          FileOutputStream fileOutPut = new FileOutputStream("obj.txt");
          ObjectOutputStream out = new ObjectOutputStream(fileOutPut);
          out.writeObject(students);
          out.close();
          fileOutPut.close();
          System.out.println("Serialized data is stored in obj.txt");
      }
       catch (IOException e) {
          throw new RuntimeException(e);
      }

      try{
          Student[] students1 = new Student[students.length];
          FileInputStream fileInPut = new FileInputStream("obj.txt");
          ObjectInputStream in = new ObjectInputStream(fileInPut);
          students1 = (Student[]) in.readObject();
          System.out.println("----------------------------------------------------------");
          System.out.println("Name \t Roll Number \t Age \t Address \t Courses");
          System.out.println("----------------------------------------------------------");

          for (int i = 0; i < students1.length; i++) {
              if (students1[i] == null)break;
              students1[i].display();
          }

      } catch (IOException e) {
          throw new RuntimeException(e);
      } catch (ClassNotFoundException e) {
          throw new RuntimeException(e);
      }
  }

}
