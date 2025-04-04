
package code_wizard.dao;

import code_wizard.dbutil.DBConnection;
import code_wizard.pojo.ProductPojo;
import code_wizard.pojo.UserProfile;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.lang.Exception;


public class OrderDao {
    public static String getNextOrderId() throws java.sql.SQLException
    {
        Connection con=DBConnection.getConnection();
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select max(order_id) from orders");
        rs.next();
        String ordid=rs.getString(1);
        if(ordid==null)
            return "O-101";
        int ordno=Integer.parseInt(ordid.substring(2));
        ordno++;
        
        return "O"+ordno;
     }
    
    
    public static boolean addOrder(ArrayList<ProductPojo> al,String ordid)throws Exception
    {
        Connection con=DBConnection.getConnection();
        PreparedStatement ps;
        
            ps = (PreparedStatement) con.prepareStatement("insert into orders values(?,?,?,?)");
        
        int count=0;
        for(ProductPojo p:al){
            ps.setString(1,ordid);
            ps.setString(2,p.getProductid());
            ps.setInt(3,p.getQuantity());
            ps.setString(4,UserProfile.getUserid());
            count =count+ps.executeUpdate();
            
        }
        return count==al.size();
    }
    
     public static List<String> viewOrderDetails(String oid)throws Exception
    {
        Connection con=DBConnection.getConnection();
        PreparedStatement ps=con.prepareStatement("Select orders.p_id,Product.p_name,Product.p_companyname,Product.p_price,Product.our_price,Product.p_tax,orders.quantity from orders,product where orders.p_id=product.p_id and  orders.order_id=?");
        ArrayList<String> al=new ArrayList<String>();
        ps.setString(1, oid);
        ResultSet rs=ps.executeQuery();
        while(rs.next())
        {
            al.add(rs.getString(1));
        }
        return al;
    }
    public static List<String> allOrdersId()throws Exception
    {
         Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select distinct(order_id) from orders ");
        ArrayList<String> al=new ArrayList<String>();
        while(rs.next())
        {
            al.add(rs.getString(1));
        }
        return al;
    }
}

