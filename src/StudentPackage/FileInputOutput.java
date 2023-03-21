package StudentPackage;

import java.io.*;

public class FileInputOutput extends Student{
  public static void saveStudentDetailsInFile() throws FileNotFoundException {
      Student students = new Student();


      try{
          FileOutputStream fileOutPut = new FileOutputStream("obj.ser");
          ObjectOutputStream out = new ObjectOutputStream(fileOutPut);
          out.writeObject(students);
          out.close();
          fileOutPut.close();
          System.out.println("Serialized data is stored in obj.ser");
      }
       catch (IOException e) {
          throw new RuntimeException(e);
      }

      try{
          FileInputStream fileInPut = new FileInputStream("obj.ser");
          ObjectInputStream in = new ObjectInputStream(fileInPut);
          students = (Student) in.readObject();
          System.out.println("----------------------------------------------------------");
          System.out.println("Name \t Roll Number \t Age \t Address \t Courses");
          System.out.println("----------------------------------------------------------");
          DisplayingOutputFromUser.displayDetailsOfStudent(students);
      } catch (IOException e) {
          throw new RuntimeException(e);
      } catch (ClassNotFoundException e) {
          throw new RuntimeException(e);
      }
  }
}
