/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code_wizard.dao;

import code_wizard.dbutil.DBConnection;
import code_wizard.pojo.UserProfile;
import code_wizard.pojo.user_pojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tanug
 */
public class UserDao {
    
    public static boolean ValidateUser(user_pojo user)throws SQLException{
        try {
            Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement("select * from users where userid=? and password=? and usertype=? ");
            ps.setString(1,user.getUserid());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getUsertype());
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                UserProfile.setUsername(rs.getString(5));
                return true;
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        
    }

//    public static boolean validateUser(user_pojo u) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
    
    public static boolean isUserPresent(String empid)throws SQLException{
        Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement("select 1 from users where empid=?  ");
            ps.setString(1,empid);
             ResultSet rs=ps.executeQuery();
             return rs.next();
    }

    
}
