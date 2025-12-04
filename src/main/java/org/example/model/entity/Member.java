package org.example.model.entity;

import org.example.controller.MemberService;

import java.sql.Date;
import java.util.List;

public class Member extends AbstractEntity {
    private Integer ID = null;
    private String Name;
    private String Email;
    private Date dt_join;
    private String phoneNumber;



    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Date getDt_join() {
        return dt_join;
    }

    public void setDt_join(Date dt_join) {
        this.dt_join = dt_join;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String toString(){
        return getID().toString()+": "+getName()+": "+getEmail()+": "+getDt_join()+": "+getPhoneNumber();
    }
}
