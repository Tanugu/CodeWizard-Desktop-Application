/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code_wizard.dao;

import code_wizard.dbutil.DBConnection;
import code_wizard.pojo.ProductPojo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author tanug
 */
public class ProductDao {
     public static String getNextProductId() throws java.sql.SQLException
    {
        Connection con=DBConnection.getConnection();
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select max(p_id) from product");
        rs.next();
        String productid=rs.getString(1);
        if(productid==null)
            return "P101";
        int productno=Integer.parseInt(productid.substring(1));
        productno=productno+1;
        return "P"+productno;
        
        
    }
     
     public static boolean addProduct(ProductPojo P)throws Exception
     { 
         try{
          Connection con=DBConnection.getConnection();
          PreparedStatement ps=con.prepareStatement("insert into product values(?,?,?,?,?,?,?,'Y')");
          ps.setString(1,P.getProductid());
          ps.setString(2,P.getProductname());
          ps.setString(3, P.getProductcompanyname());
          ps.setDouble(4,P.getProductprice());
          ps.setDouble(5,P.getOurprice());
          ps.setInt(6,P.getTax());
          ps.setInt(7, P.getQuantity());
          return ps.executeUpdate()==1;
     }
      catch( java.sql.SQLException ex)
        {
           JOptionPane.showMessageDialog(null,"DB Error!","Error!",JOptionPane.ERROR_MESSAGE);
           ex.printStackTrace() ;   
        }
         return true;
     }
     
     public static List<ProductPojo> getProductDetails()throws Exception
     {
       
        Connection con=DBConnection.getConnection();
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select * from product where status='Y' order by p_id");
        ArrayList<ProductPojo> productsList = new ArrayList<>();
        while(rs.next())
        {
            ProductPojo p=new ProductPojo();
            p.setProductid(rs.getString(1));
            p.setProductname(rs.getString(2));
            p.setProductcompanyname(rs.getString(3));
            p.setProductprice(Double.parseDouble(rs.getString(4)));
            p.setOurprice(Double.parseDouble(rs.getString(5)));
            p.setTax(Integer.parseInt(rs.getString(6)));
            p.setQuantity(Integer.parseInt(rs.getString(7)));
            productsList.add(p);
        }
        return productsList; 
     }
      public static boolean deleteProduct(String productid)throws Exception
     {
         Connection conn=DBConnection.getConnection();
         PreparedStatement ps=conn.prepareStatement("Update product set status='N' where p_id=?");
         ps.setString(1, productid);
         return ps.executeUpdate()==1;
     }
        
        public static boolean updateProduct(ProductPojo p)throws Exception
        {
         try {
             Connection con=DBConnection.getConnection();
             PreparedStatement ps=con.prepareStatement("update product set p_name=?,p_companyname=?,p_price=?,our_price=?,p_tax=?,quantity=? where p_id=?");
             // ps.setString(1,p.getProductId());
              ps.setString(1, p.getProductname());
              ps.setString(2, p.getProductcompanyname());
              ps.setDouble(3, p.getProductprice());
              ps.setDouble(4, p.getOurprice());
              ps.setInt(5, p.getTax());
              ps.setInt(6, p.getQuantity());
              ps.setString(7, p.getProductid());
              return ps.executeUpdate()==1;
         } 
         catch (java.sql.SQLException ex)
         {
             Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
         }
         return false;
        }
        public static ProductPojo getProductById(String pid)throws Exception
        {
          
           Connection con=DBConnection.getConnection();
          PreparedStatement ps=con.prepareStatement("select * from product where p_id=? and status='Y'");
           ps.setString(1,pid);
           ResultSet rs=ps.executeQuery();
           if(!rs.next())
           {
               return null;
           }
            ProductPojo p=new ProductPojo();   
            p.setProductid(rs.getString(1));
            p.setProductname(rs.getString(2));
            p.setProductcompanyname(rs.getString(3));
            p.setProductprice(rs.getDouble(4));
            p.setOurprice(rs.getDouble(5));
            p.setTax(rs.getInt(6));
            p.setQuantity(rs.getInt(7));
           
            return p;
        }
        public static boolean updateProducts(List<ProductPojo> pList)throws Exception
        {
            int x=0;
        
         try {
             Connection con=DBConnection.getConnection();
             PreparedStatement ps=con.prepareStatement("update product set quantity=quantity-? where p_id=? and status='y'");
             //int x=0;
             for(ProductPojo p:pList)
             {
                 
                 ps.setInt(1,p.getQuantity());
                 ps.setString(2,p.getProductid());
                 int rows=ps.executeUpdate();
                 if(rows!=0){
                     x++;
                 }
             }
             
             //return x==productList.size();
         } catch (java.sql.SQLException ex) {
             //Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
             ex.printStackTrace();
         }
         return x==pList.size();
       }
       

  }        
             
     
       

