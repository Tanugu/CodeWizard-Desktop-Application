/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code_wizard.pojo;

/**
 *
 * @author tanug
 */
public class OrderPojo {
    private String order_id;
    private String p_id;

    public OrderPojo(String order_id, String p_id, String quantity, String userid) {
        this.order_id = order_id;
        this.p_id = p_id;
        this.quantity = quantity;
        this.userid = userid;
    }

    public String getOrderid() {
        return order_id;
    }

    public void setOrderid(String order_id) {
        this.order_id = order_id;
    }

    public String getProductid() {
        return p_id;
    }

    public void setProductid(String p_id) {
        this.p_id = p_id;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
    private String quantity;
    private String userid;
}
