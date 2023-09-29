package com.ami.tech.dl.dto;
import com.ami.tech.dl.interfaces.dto.*;
public class DTOBank implements DTOInterface{
    private String name;
    private String pin;
    private String balance;
    private String mobile_no;
    public DTOBank(){
        this.name="";
        this.pin="";
        this.balance="";
        this.mobile_no="";
    }
    public void setName(String name)
     {
        this.name=name;
     }
    public String getName(){
        return this.name;
    }
    public void setPin(String pin){
      this.pin=pin;
    }
    public String getPin(){
        return this.pin;
    }
    public void setBalance(String balance){
        this.balance = balance;
    }
    public String getBalance()
    {
        return this.balance;
    }
    public void setMobileNumber(String mobile_no){
        this.mobile_no=mobile_no;
    }
    public String getMobileNumber(){
        return this.mobile_no;
    }
}