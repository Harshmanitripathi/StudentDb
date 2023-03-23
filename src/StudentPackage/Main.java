package StudentPackage;

import java.io.*;
import java.util.Comparator;
import  java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {

//        Giving Input from User
        UserIO.TakingInput();

//       Saving the data in disk

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Enter particular thing what you want sorting=1, display=2, deleting=3");
            System.out.println(" ,Else type any key to exit");
            boolean comeOut=false;
            String operationToPerform = sc.next();
            switch (operationToPerform) {
                case "1":
                    UserIO.Sorting();
                    break;
                case "2":
                    UserIO.displayDetails();
                    break;
                case "3":
                    UserIO.deleteParticularStudent();
                    break;
                default:
                    comeOut = true;
                    break;
            }
            if (comeOut == true)
                break;
        }

    }
}

