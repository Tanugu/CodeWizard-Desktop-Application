/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code_wizard.pojo;

/**
 *
 * @author tanug
 */
public class ProductPojo {

    public String getProductid() {
        return Productid;
    }

    public void setProductid(String Productid) {
        this.Productid = Productid;
    }

    public String getProductname() {
        return Productname;
    }

    public void setProductname(String Productname) {
        this.Productname = Productname;
    }

    public String getProductcompanyname() {
        return Productcompanyname;
    }

    public void setProductcompanyname(String Productcompanyname) {
        this.Productcompanyname = Productcompanyname;
    }

   

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }
  // constructor withoutparameter;
  public ProductPojo()
  {
     // constructor code 
  }

    public ProductPojo(String Productid, String Productname, String Productcompanyname, double Productprice, double Ourprice, int Tax, int Quantity,double total) {
        this.Productid = Productid;
        this.Productname = Productname;
        this.Productcompanyname = Productcompanyname;
        this.Productprice = Productprice;
        this.Ourprice = Ourprice;
        this.Tax = Tax;
        this.Quantity = Quantity;
        this.Total=Total;
    }

    public double getProductprice() {
        return Productprice;
    }

    public void setProductprice(double Productprice) {
        this.Productprice = Productprice;
    }

    public double getOurprice() {
        return Ourprice;
    }

    public void setOurprice(double Ourprice) {
        this.Ourprice = Ourprice;
    }

    public int getTax() {
        return Tax;
    }

    public void setTax(int Tax) {
        this.Tax = Tax;
    }
  private String Productname;
  private String Productcompanyname;
  private double Productprice;
  private double Ourprice;
  private int Tax;
  private int Quantity;
  private String Productid;
  private double Total;

    public double getTotal() {
        return Total;
    }

    public void setTotal(double total) {
        this.Total = Total;
    }


}
    