/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code_wizard.pojo;

/**
 *
 * @author tanug
 */
public class Employeepojo {

    public Employeepojo(String empid, String empname, String job, int salary) {
        this.empid = empid;
        this.empname = empname;
        this.job = job;
        this.salary = salary;
    }

    public Employeepojo() {
        
    }

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
    private String empid;
    private String empname;
    private String job;
    private int salary;
    
}
