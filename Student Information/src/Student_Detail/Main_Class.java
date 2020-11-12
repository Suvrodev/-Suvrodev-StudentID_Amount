package Student_Detail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Scanner;

public class Main_Class {
    public static void main(String[] args) throws SQLException, IOException {
        Scanner ip=new Scanner(System.in);
        BufferedReader ipp=new BufferedReader(new InputStreamReader(System.in));
        Abstract_Class abstract_class ;
        Login_Class login_class=new Login_Class();
        Student_Class student_class;
        Student_INFORMATION student_information=new Student_INFORMATION();
        Account_Class account_class=new Account_Class();
       // Class.forName("com.mysql.cj.jdbc.Drivrt");

        
        System.out.println("Welcome to OUR INFORMATION");
        while (true) {
            System.out.printf("C-> Creat Account\nL->Login\nNow Write=");
            char ch = ip.next().charAt(0);
            if (ch == 'c') {
                abstract_class = new Login_Class();
                abstract_class.Register();
            }
            if (ch == 'l') {
                boolean Return_Type = login_class.Login();
                if (Return_Type == true)
                {
                    System.out.println("Login SuccessFully");
                    System.out.printf("A for Add Account\nS for See all INFO\nK for know info\nU for Update" +
                           "\nD for Delete "+"\nN for Number of Students"
                            +"\nX for Creat Account"+"\nYFor Active Status"+"\nZ for Transfer"+"\nL " +
                            "Foe Loan(Not Relised)"+"\nNow Press=");
                    char chh=ip.next().charAt(0);
                    if(chh=='a')
                    {
                        System.out.printf("Name=");
                        String Name=ipp.readLine();
                        System.out.printf("ID=");
                        String ID=ipp.readLine();
                        System.out.printf("Age=");
                        String Age=ipp.readLine();
                        System.out.printf("Gender=");
                        String Gender=ipp.readLine();
                        System.out.printf("Department=");
                        String Department=ipp.readLine();
                        System.out.printf("CGPA=");
                        String CGPA=ipp.readLine();
                        System.out.printf("Address=");
                        String Address=ipp.readLine();
                        System.out.printf("Phone Number=");
                        String Phone_Number=ipp.readLine();
                        student_class=new Student_Class(Name,ID,Age,Gender,Department,CGPA,Address,Phone_Number);
                    }
                   else if(chh=='s')
                    {
                       student_information.ALL_INFO();
                    }
                    else if(chh=='k')
                    {
                        student_information.Detail();
                    }
                    else if(chh=='d')
                    {
                        student_information.Delete();
                    }
                    else if(chh=='u')
                    {
                        student_information.Update();
                    }
                    else if(chh=='n')
                    {
                        student_information.NumberOfStudents();
                    }
                    else if(chh=='x'){
                        account_class.Amount();
                    }
                    else if(chh=='y'){
                        account_class.Status();
                    }
                    else if(chh=='z'){
                        account_class.Transfer();
                    }
                }
                else {
                    System.out.println("See You Next Time.....");
                    break;
                }
            }
           
        }
    }
}
