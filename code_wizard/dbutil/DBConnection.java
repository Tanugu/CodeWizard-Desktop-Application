/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code_wizard.dbutil;
import java.awt.HeadlessException;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author tanug
 */
public class DBConnection {
    private static Connection con;
    static
    {
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
          JOptionPane.showMessageDialog(null,"Driver loaded successfully!","Success",JOptionPane.INFORMATION_MESSAGE);
         con = DriverManager.getConnection("jdbc:mysql://localhost:3306/barcode_generator","root","root");
            //System.out.println("connection build");
            JOptionPane.showMessageDialog(null,"Connection open successfully!","Success",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null, "error in db"+ex);
            ex.printStackTrace();
            System.exit(1);
        }
        catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "error in db"+ex);
            ex.printStackTrace();
            System.exit(1);
        }
    }
    public static Connection getConnection()
    {
        return con;
    }
    public static void closeConnection(){
//        try{
//            con.close();
//            JOptionPane.showMessageDialog(null, "connection connect successfully","success",JOptionPane.INFORMATION_MESSAGE);
//        }catch(HeadlessException | SQLException ex)
//        {
//            JOptionPane.showMessageDialog(null,"error in db"+ ex);
//            ex.printStackTrace();
//        }

       try {
            if (con != null && !con.isClosed()) {
                con.close();
                JOptionPane.showMessageDialog(null, "Connection closed successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error in closing connection: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
    
}

   