package mvc.dao;

import mvc.bean.Bean;
import java.sql.*;
import java.util.ArrayList;
public class Dao
{
   public Dao()
   {
     
   }
   public boolean insertData(Bean bean)
   {
       String fname=bean.getFname();
       String lname=bean.getLname();
       int roll=bean.getRoll();
         try{

           Class.forName("com.mysql.jdbc.Driver");
         }
         catch(Exception e)
         {
            return false;
         }
       try{

                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shiv","root","abc123");

                String query="INSERT INTO  student values (?,?,?)";

                PreparedStatement pstmt=con.prepareStatement(query);
                pstmt.setInt(1,roll);
                pstmt.setString(2,fname);
                pstmt.setString(3,lname);
                pstmt.executeUpdate();
       }
       catch(SQLException e)
       {
          return false;
       }
       return true;
   }


   public ArrayList<Bean> getData()
   {
         ArrayList<Bean> students=new ArrayList<Bean>();
     
         try{
           Class.forName("com.mysql.jdbc.Driver");
         }
         catch(Exception e)
         {
            return null;
         }
       try{
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shiv","root","abc123");

                String query="SELECT * FROM student";
                Statement st=con.createStatement();
                ResultSet rs=st.executeQuery(query);
                while(rs.next())
                {
                    int roll=rs.getInt("roll");
                    String fname=rs.getString("fname");
                    String lname=rs.getString("lname");
                    Bean student=new Bean(roll, fname, lname);
                    students.add(student);
                }
       }
       catch(SQLException e)
       {
          return null;
       }


       return students;
   }
}