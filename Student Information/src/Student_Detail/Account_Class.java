package Student_Detail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Scanner;

public class Account_Class {

    String user = "root";
    String pass = null;
    String url = "jdbc:mysql://localhost/suvrodev";
    Connection connection = DriverManager.getConnection(url, user, pass);
    Statement statement = connection.createStatement();
    Statement s = connection.createStatement();
    Scanner ip = new Scanner(System.in);
    BufferedReader ipp = new BufferedReader(new InputStreamReader(System.in));

    public Account_Class() throws SQLException {
    }

    void Amount() throws IOException, SQLException {

        int count = 0;

        System.out.printf("Enter ID_Number=");
        int id = ip.nextInt();
        String id_number = Integer.toString(id);
        String query = "SELECT ID FROM students";
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            String IDD = resultSet.getString("ID");
            if (IDD.equalsIgnoreCase(id_number)) {
                System.out.printf("How many amount do you add=");
                int amount = ip.nextInt();
                System.out.printf("Status=");
                String Status = ipp.readLine();
                String Add = "UPDATE `students` SET `Amount`=" + amount + ",`Status`='" + Status + "' WHERE ID= " + id;
                s.executeUpdate(Add);
                System.out.println("Account Created Successfully");
                count++;
            }
        }
        if (count == 0) {
            System.out.println("ID Number not Available");
        }
    }

    void Status() throws IOException, SQLException {
        int c=0;
        System.out.printf("Enter ID number to Change Status=");
        String id_number = ipp.readLine();
        String query = "SELECT ID FROM students";
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            String IDD = resultSet.getString("ID");
            if (IDD.equalsIgnoreCase(id_number)) {
                System.out.printf("Status=");
                String Status = ipp.readLine();
                String Update_Status = "UPDATE `students` SET `Status`='"+Status+"' WHERE ID= '" + id_number + "'";
                s.executeUpdate(Update_Status);
                System.out.println("Status Changed Successfully");
                c++;
            }

        }
        if(c==0){
            System.out.println("Id not found");
        }
    }
    void Transfer() throws IOException, SQLException {
        int c=0;
        double Amn_f=0;
        double Amn_t=0;

        System.out.printf("Enter From ID=");
        String fId=ipp.readLine();
        System.out.printf("Enter To ID=");
        String tId=ipp.readLine();
        String query = "SELECT * FROM students";
        ResultSet resultSet=statement.executeQuery(query);
        while (resultSet.next()) {
            String ID = resultSet.getString("ID");
            String Status = resultSet.getString("Status");
            String Amount=resultSet.getString("Amount");
            double amn=Double.parseDouble(Amount);
            if (fId.equalsIgnoreCase(ID) && Status.equalsIgnoreCase("Active")) {
                 c++;
                Amn_f=amn;
            }
            if (tId.equalsIgnoreCase(ID) && Status.equalsIgnoreCase("Active")) {
                c++;
                Amn_t=amn;
            }

        }
        if(c==2){
            System.out.printf("How many amount do you want to Transfer=");
            double Tranfer=ip.nextDouble();
            if(Amn_f>=Tranfer){
                String Transfer_Amount="UPDATE `students` SET `Amount`="+(Amn_f-Tranfer)+"WHERE ID='"+fId+"'";
                s.executeUpdate(Transfer_Amount);
                String Transfer_Amount_="UPDATE `students` SET `Amount`="+(Amn_t+Tranfer)+"WHERE ID='"+tId+"'";
                s.executeUpdate(Transfer_Amount_);
                System.out.println("Tranfered");
            }
            else {
                System.out.println("Amount is low");
            }
        }else {
            System.out.println("ID Deactive or Does not found");
        }
    }
}




