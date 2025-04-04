/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code_wizard.pojo;

/**
 *
 * @author tanug
 */
public class ReceptionistPojo {
    private String empid;

    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    private String empname;

    public ReceptionistPojo(String empid, String empname, String userid, String job, int salary) {
        this.empid = empid;
        this.empname = empname;
        this.userid = userid;
        this.job = job;
        this.salary = salary;
    }
    
    public ReceptionistPojo(){
        //without parameter constructor
    }
    private String userid;
    private String job;
    private int salary;
    
}
