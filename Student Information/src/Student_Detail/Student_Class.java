package Student_Detail;

import java.sql.*;

public class Student_Class extends Add_Class {
    //Database

        String user = "root";
        String password = null;
        String url = "jdbc:mysql://localhost/suvrodev";
        Connection connection = DriverManager.getConnection(url, user, password);
         Statement statement = connection.createStatement();

     //   System.out.println("Database Connected Successfully");


    String Address,Phone_Number;
    public Student_Class(String Name, String ID, String Age, String Gender, String Department, String CGPA,String Address, String Phone_Number) throws SQLException {
        super(Name, ID, Age, Gender, Department, CGPA);
        this.Address=Address;
        this.Phone_Number=Phone_Number;


        int c=0;
        String Query="SELECT ID FROM students";
        ResultSet resultSet=statement.executeQuery(Query);
        while (resultSet.next()) {
            String IDD = resultSet.getString("ID");
            if (IDD.equalsIgnoreCase(ID)){
                System.out.println("ID Number not Exist");
                c++;
            }
        }
        try {
            if (c <= 0) {
                String query = "INSERT INTO `students`(`ID`, `Name`, `Age`, `Gender`, `CGPA`, `Department`, `Location`, `Phone_Number`, `Amount`, `Status`, `Loan`, `Paid`, `Remaining`) VALUES (" + ID + ",'" + Name + "'," + Age + ",'" + Gender + "'," + CGPA + ",'" + Department + "','" + Address + "','" + Phone_Number + "',"+0+",'"+""+"',"+0+","+0+","+0+")";
                statement.executeUpdate(query);
                System.out.println("ID Inserted");
            }
        }catch (Exception e){
            System.out.println("Problem="+e);
        }
    }

}
