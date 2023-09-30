package com.ami.tech.dl.dto;
import com.ami.tech.dl.interfaces.dto.*;
public class DTOBank implements DTOInterface{
    private String name;
    private String accountNumber;
    private String pin;
    private String balance;
    private String mobile_no;
    private String id;
    private String designation;
    private String ifscCode;
    private String address;
    public DTOBank(){
        this.name="";
        this.pin="";
        this.balance="";
        this.mobile_no="";
        this.id="";
        this.designation="";
        this.ifscCode="999xyz111";
        this.address="";
        this.accountNumber="";
    }
     public void setAccountNumber(String accountNumber){
        this.accountNumber=accountNumber;
    }
    public String getAccountNumber(){
        return this.accountNumber;
    }
    
    public void setName(String name)
     {
        this.name=name;
     }
    public String getName(){
        return this.name;
    }
    public void setPassword(String pin){
      this.pin=pin;
    }
    public String getPassword(){
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
    public void setId(String id){
        this.id=id;
    }
    public String getId(){
        return this.id;
    }
    public void setDesignation(String designation){
        this.designation=designation;
    }
    public String getDesignation(){
        return this.designation;
    }
    public String getIfscCode()
    {
        return this.ifscCode;
    }
    public void setAddress(String address){
        this.address=address;
    }
    public String getAddress(){
        return this.address;
    }
   
}