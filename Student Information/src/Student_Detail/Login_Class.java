package Student_Detail;

import java.io.*;
import java.util.Scanner;

public class Login_Class extends Abstract_Class {
    Scanner ip = new Scanner(System.in);
    BufferedReader ipp = new BufferedReader(new InputStreamReader(System.in));

    @Override
    void Register() throws IOException {
        System.out.println("Welcome to Registration");
        try {
            FileWriter fileWriter = new FileWriter("E:\\Register.txt", true);
            System.out.printf("Write UserName=");
            String UsrName = ipp.readLine();
            System.out.printf("Write Password=");
            String Password = ipp.readLine();
            System.out.printf("Confirm Password=");
            String ConfirmPassword = ipp.readLine();
            if (Password.equalsIgnoreCase(ConfirmPassword)) {
                fileWriter.append(UsrName + "\n");
                fileWriter.append(ConfirmPassword + "\n");
                System.out.println("Registration Successfully");
            }
            else {
                System.out.println("Password Not Matched");
            }

            fileWriter.close();
        } catch (Exception E) {
            System.out.println("Problem="+E);
        }


    }



    boolean Login() {
        try {
            String U_N;
            String PASS;
            System.out.println("Welcome to Login Series");
            int count = 3;
            while (count >= 1) {

                File file = new File("E:\\Register.txt");
                Scanner scanner = new Scanner(file);
                System.out.printf("USER NAME=");
                String User_Name = ipp.readLine();
                System.out.print("PASSWORD=");
                String Password = ipp.readLine();
                while (scanner.hasNext()) {
                    U_N = scanner.nextLine();
                    PASS = scanner.nextLine();
                    if (U_N.equalsIgnoreCase(User_Name) && PASS.equalsIgnoreCase(Password)) {
                        return true;
                    }
                }
                count--;
                System.out.println("Invalid Username or Password..Try Again "+count+" Times");
                if(count<=0){
                    return false;
                }

            }
        } catch (Exception e) {
            System.out.println("Username or Password Not Match");
        }
       return false;
    }

}
