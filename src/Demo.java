import java.sql.*;

public class Demo {

    public static  void main(String[] args) throws Exception{

        String url="jdbc:mysql://localhost:3306/university";
        String username="root";
        String password="";

        Connection con= DriverManager.getConnection(url,username,password);
        Statement st=con.createStatement();



        st.executeUpdate("INSERT INTO engineeringstudent (Student_ID, Department, First_Name, Last_Name, PassOutYear, UniversityRank) " +
                "VALUES (1010, 'Computer Science', 'Alice', 'Johnson', 2022, 5)");
        st.executeUpdate("INSERT INTO engineeringstudent (Student_ID, Department, First_Name, Last_Name, PassOutYear, UniversityRank) " +
                "VALUES (1011, 'Electrical Engineering', 'Bob', 'Smith', 2021, 8)");
        st.executeUpdate("INSERT INTO engineeringstudent (Student_ID, Department, First_Name, Last_Name, PassOutYear, UniversityRank) " +
                "VALUES (1012, 'Mechanical Engineering', 'Charlie', 'Brown', 2023, 12)");
        st.executeUpdate("INSERT INTO engineeringstudent (Student_ID, Department, First_Name, Last_Name, PassOutYear, UniversityRank) " +
                "VALUES (1013, 'Civil Engineering', 'David', 'Williams', 2020, 3)");
        st.executeUpdate("INSERT INTO engineeringstudent (Student_ID, Department, First_Name, Last_Name, PassOutYear, UniversityRank) " +
                "VALUES (1014, 'Chemical Engineering', 'Eve', 'Davis', 2024, 15)");


        String DeleteSql="DELETE FROM engineeringstudent WHERE STUDENT_ID=104";
        st.executeUpdate(DeleteSql);

        String UpdateSql="UPDATE engineeringstudent SET First_Name = 'Winny' WHERE Student_ID=1014";
        st.executeUpdate(UpdateSql);
        System.out.println("Updated the user with id 1014");
        String sql="select * from engineeringstudent";
        ResultSet rs= st.executeQuery(sql);



        while (rs.next()){
            int stu_id=rs.getInt("Student_ID");
            String department=rs.getString("Department");
            String firstName=rs.getString("First_Name");
            String lastName=rs.getString("Last_Name");
            int Year=rs.getInt("PassOutYear");
            int Rank =rs.getInt("UniversityRank");

            System.out.println(stu_id + " " + department + " " + firstName + " " + lastName + " " + Year + " " + Rank);

        }
        rs.close();
        st.close();
        con.close();
    }
}
