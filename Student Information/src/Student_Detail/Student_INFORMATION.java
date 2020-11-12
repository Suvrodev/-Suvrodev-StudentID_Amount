package Student_Detail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Scanner;

public class Student_INFORMATION {
    //Class.forName("com.mysql.cj.jdbc.Driver");
    String user = "root";
    String password = null;
    String url = "jdbc:mysql://localhost/suvrodev";
    Connection connection = DriverManager.getConnection(url, user, password);
    Statement statement = connection.createStatement();
    Statement s = connection.createStatement();
    Scanner ip=new Scanner(System.in);
    BufferedReader ipp=new BufferedReader(new InputStreamReader(System.in));

    public Student_INFORMATION() throws SQLException {
    }

    void ALL_INFO() throws SQLException {

        String query="SELECT * FROM students";
        ResultSet resultSet=statement.executeQuery(query);
        while (resultSet.next())
        {
            String ID=resultSet.getString("ID");
            String Name=resultSet.getString("Name");
            String CGPA=resultSet.getString("CGPA");
            String Age=resultSet.getString("Age");
            String Department=resultSet.getString("Department");
            String Phone_Number=resultSet.getString("Phone_Number");
            String Address=resultSet.getString("Location");
            String Sex=resultSet.getString("Gender");
            System.out.println("ID="+ID+" Name="+Name+" Age="+Age+" Sex="+Sex+" Department="+Department+
                    " CGPA="+CGPA+" Address="+Address+" Phone Number="+Phone_Number);
        }
    }
    void Detail() throws SQLException, IOException {
        int count=0;
        String query="SELECT * FROM students";
        System.out.printf("Enter ID Number=");
        String Id=ipp.readLine();

        String S_IO="SELECT * FROM `students` WHERE ID= '"+Id+"'";
        ResultSet resultSet=statement.executeQuery(S_IO);

        while (resultSet.next()){
            String ID=resultSet.getString("ID");
            String Name=resultSet.getString("Name");
            String CGPA=resultSet.getString("CGPA");
            String Age=resultSet.getString("Age");
            String Department=resultSet.getString("Department");
            String Phone_Number=resultSet.getString("Phone_Number");
            String Address=resultSet.getString("Location");
            String Sex=resultSet.getString("Gender");
            System.out.println("ID=" + ID + " Name=" + Name + " Age=" + Age + " Sex=" + Sex + " Department=" + Department +
                    " CGPA=" + CGPA + " Address=" + Address + " Phone Number=" + Phone_Number);
            count++;
        }
        if(count<=0){
            System.out.println("Not Found");
        }

    }
    void  Delete() throws SQLException {
        System.out.printf("Enter id Number to Delete Account=");
        int id_Number=ip.nextInt();
        String ID_NUMBER=Integer.toString(id_Number);
        int count=0;

        String query="SELECT ID FROM students";
        ResultSet resultSet=statement.executeQuery(query);
        while (resultSet.next())
        {
            String IDD=resultSet.getString("ID");
            if(IDD.equalsIgnoreCase(ID_NUMBER)){

                String Delete_ID="DELETE FROM `students` WHERE id="+id_Number;
                s.executeUpdate(Delete_ID);  //statement of Statement not usable
                System.out.println("ID Deleted Successfully");
                count++;
            }
        }
        if(count<=0){
            System.out.println("ID Number not Matched");
        }
        //System.out.println("Count="+count);

    }
    void Update() throws IOException, SQLException {
        System.out.printf("Enter id Number to Delete Account=");
        int ID=ip.nextInt();
        int c=0;
        String query="SELECT ID FROM students";
        ResultSet resultSet=statement.executeQuery(query);
        while (resultSet.next()){
            String IDD=resultSet.getString("ID");
            if(IDD.equalsIgnoreCase(Integer.toString(ID))){
                System.out.printf("Name=");
                String Name=ipp.readLine();
                System.out.printf("ID=");
                String Id=ipp.readLine();
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
                String Update_ID="UPDATE `students` SET `ID`="+Id+",`Name`='"+Name+"',`Age`='"+Age+"',`Gender`='"+Gender+"',`CGPA`="+CGPA+",`Department`='"+Department+"',`Location`='"+Address+"',`Phone_Number`='"+Phone_Number+"' WHERE ID="+ID;
                s.executeUpdate(Update_ID);
                System.out.println("Update Successfully");
                c++;
            }

        }
        if(c>=0){
            System.out.println("ID not found");
        }


    }
    void NumberOfStudents() throws SQLException {
        String Number="select count(*) from students";
       // statement.executeUpdate(Number);
        ResultSet resultSet=statement.executeQuery(Number);
        resultSet.next();
        int count = resultSet.getInt(1);
        System.out.println("Number of Students="+count);
    }
}
