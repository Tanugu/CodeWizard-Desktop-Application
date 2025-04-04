/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code_wizard.dao;

import code_wizard.dbutil.DBConnection;
import code_wizard.pojo.ReceptionistPojo;
import code_wizard.pojo.user_pojo;
//import com.sun.jdi.connect.spi.Connection;
import java.util.Map;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tanug
 */
public class ReceptionistDao {
    public static Map<String,String> getNonRegisteredReceptionists() throws SQLException
    {
       Connection con=DBConnection.getConnection(); 
       Statement st=con.createStatement();
        ResultSet rs=(ResultSet) st.executeQuery("select empid,empname from employees where job='Receptionist' and empid Not In(select empid from users where usertype='receptionist')");
        HashMap<String,String> receptionistList =new HashMap<>();
        while(rs.next()){
            String id=rs.getString("empid");
            String name=rs.getString("empname");
            receptionistList.put(id, name);
        }
        return receptionistList;
    }
    public static boolean addReceptionist(user_pojo Users) throws SQLException
    {
        try{
        Connection con=DBConnection.getConnection();
        PreparedStatement ps=con.prepareStatement("insert into users values(?,?,?,?,?)");
        ps.setString(1,Users.getUserid());
        ps.setString(2, Users.getEmpid());
        ps.setString(3,Users.getPassword());
        ps.setString(4, Users.getUsertype());
        ps.setString(5,Users.getUsername());
        int result=ps.executeUpdate();
        return result==1;
        }
        catch(SQLException ex)
        {
           ex.printStackTrace();
        }
        return false;
        
    }
    
    public static List<ReceptionistPojo> getAllReceptionistDetails() throws SQLException
    {
        Connection con=DBConnection.getConnection(); 
       Statement st=con.createStatement();
        ResultSet rs=(ResultSet) st.executeQuery("select USERS.empid,empname,userid,job,salary from users,employees where usertype='Receptionist' and users.empid=employees.empid");
        ArrayList<ReceptionistPojo> al=new ArrayList<>();
        while(rs.next())
        {
            String id=rs.getString(1);
          String name=rs.getString(2);
            
        }
        
        return al;
    }

     public static Map<String,String>getAllReceptionistId() throws SQLException
     {
          Connection con=DBConnection.getConnection(); 
       Statement st=con.createStatement();
        ResultSet rs=(ResultSet) st.executeQuery("select userid,username from users where usertype='Receptionist' order by userid");
        HashMap<String,String> receptionistList=new HashMap<>();
        while(rs.next())
        {
           String id=rs.getString(1);
           String name=rs.getString(2);
           receptionistList.put(id,name);
        }
        return receptionistList;
        
     }
     
      public static boolean updatePassword(String userid,String pwd)throws SQLException
      {
          Connection con=DBConnection.getConnection();
          PreparedStatement ps=con.prepareStatement("update users set password=? where userid=?");
          ps.setString(1, pwd);
          ps.setString(2, userid);
          return ps.executeUpdate()==1;
      }
      
      
       public static boolean deleteReceptionist(String userid)throws SQLException{
      Connection con=DBConnection.getConnection();
       PreparedStatement ps=con.prepareStatement("delete from users where userid=?");
       ps.setString(1,userid);   
       int x=ps.executeUpdate();
       return x==1;
    }
    }
    

