/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code_wizard.dao;
import code_wizard.dbutil.DBConnection;
import code_wizard.pojo.Employeepojo;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;


public class EmployeeDao {
    public static String getNextEmpId() throws SQLException
    {
        Connection con=DBConnection.getConnection();
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select max(empid) from employees");
        rs.next();
        String empid=rs.getString(1);
        int empno=Integer.parseInt(empid.substring(1));
        empno=empno+1;
        return "E"+empno;
        
        
    }
    public static boolean addEmployee(Employeepojo emp)throws SQLException{
        Connection con=DBConnection.getConnection();
        PreparedStatement ps=con.prepareStatement("Insert into employees values(?,?,?,?)");
        ps.setString(1,emp.getEmpid());
        ps.setString(2,emp.getEmpname());
        ps.setString(4,emp.getJob());
        ps.setInt(3,emp.getSalary());
        int result=ps.executeUpdate();
        // ResultSet rs=ps.executeQuery();
        return result==1;
    }
    
   public static List<Employeepojo> getAllEmployees() throws SQLException{
       Connection con=DBConnection.getConnection();
       Statement st=con.createStatement();
       ResultSet rs=st.executeQuery("select * from employees order by empid");
       ArrayList <Employeepojo> empList=new ArrayList<>();
       while(rs.next())
       {
           Employeepojo emp =new Employeepojo();
           emp.setEmpid(rs.getString(1));
           emp.setEmpname(rs.getString(2));
        //   emp.setJob(rs.getString(3));
//           emp.setSalary( rs.getInt(4));
//           empList.add(emp);
//       }
//       return empList;
//   }       
        String salaryStr = rs.getString(3);
        if (isNumeric(salaryStr)) {
            emp.setSalary(Integer.parseInt(salaryStr));
        } else {
            System.err.println("Invalid salary for employee ID " + emp.getEmpid() + ": " + salaryStr);
            // Handle invalid salary case, e.g., set default value or skip this record
            emp.setSalary(0); // Example of setting a default value
        }
         emp.setJob(rs.getString(4));
        empList.add(emp);
    }
       
    return empList;
}

public static boolean isNumeric(String str) {
    if (str == null || str.isEmpty()) {
        return false;
    }
    try {
        Integer.parseInt(str);
    } catch (NumberFormatException e) {
        return false;
    }
    return true;
}
   
   public static List<String>getAllEmpId() throws SQLException{
       Connection con=DBConnection.getConnection();
       Statement st=con.createStatement();
       ResultSet rs=st.executeQuery("select empid from employees order by empid");
       ArrayList <String> allId=new ArrayList<>();
       while(rs.next()){
           allId.add(rs.getString(1));
       }
       return allId;
   }
   public static Employeepojo findEmpById(String empid)throws SQLException{
      Connection con=DBConnection.getConnection();
      PreparedStatement ps=con.prepareStatement("select * from employees where empid=?");
      ps.setString(1,empid);
      ResultSet rs=ps.executeQuery();
      rs.next();
      Employeepojo e=new Employeepojo();
      e.setEmpid(rs.getString(1));
      e.setEmpname(rs.getString(2));
      //e.setJob(rs.getString(4));
      e.setSalary(rs.getInt(3));
       e.setJob(rs.getString(4));
      return e;
   }
   
   public static boolean updateEmployee(Employeepojo e)throws SQLException{
       Connection con=DBConnection.getConnection();
       PreparedStatement ps=con.prepareStatement("update employees set empname=?,job=?,salary=? where empid=?");
       ps.setString(1, e.getEmpname());
       ps.setString(2, e.getJob());
       ps.setInt(3, e.getSalary());
       ps.setString(4,e.getEmpid());
       int x=ps.executeUpdate();
       if(x==0){
           return false;}
       else{
       boolean result=UserDao.isUserPresent(e.getEmpid());
       if(result==false)
           return true;
  
        ps=con.prepareStatement("update users set username=?,usertype=? where empid=?");
        ps.setString(1, e.getEmpname());
       ps.setString(2, e.getJob());
        ps.setString(3,e.getEmpid());
        int y=ps.executeUpdate();
        return y==1;
       
       }
   }
   
    public static boolean deleteEmployee(String empid)throws SQLException{
      Connection con=DBConnection.getConnection();
       PreparedStatement ps=con.prepareStatement("delete from employees where empid=?");
       ps.setString(1,empid);   
       int x=ps.executeUpdate();
       return x==1;
    }

    }

   

