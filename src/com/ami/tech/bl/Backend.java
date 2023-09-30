package com.ami.tech.bl;

import com.ami.tech.dl.dao.*;
import com.ami.tech.dl.dto.*;
import com.ami.tech.dl.exceptions.*;
import com.ami.tech.dl.interfaces.dao.*;
import com.ami.tech.dl.interfaces.dto.*;

public class Backend {
 int check=0;
 String type="";
 String account_no="";
 String name="";
 String ifscCode="";
 String mobileNumber="";
 String balance="" ;
 String id="" ;
 String designation=""; 
 String address="" ;
 String pin="" ;
 DTOInterface user=new DTOBank();
boolean validation=false;
  public int backendLogin(String id,String password) {
    DAOInterface dao;
    dao=new DAOBank();
    if (id.length() == 0 || password.length() == 0) {
      return -1;
    }
    try{
    check=Integer.parseInt(id);
    this.type="customer";
    }
    catch(Exception user){
      this.type="admin";
    }
  this.validation=dao.loginValidation(id,password,this.type);
   if(validation==true){
   user= dao.login();
   }
    return 0;
  }

  public void login(){
    DAOInterface dao;
    dao=new DAOBank();
    user=dao.login();
    if(type.equalsIgnoreCase("customer")){
    this.account_no= user.getAccountNumber();
    this.name=user.getName();
    this.mobileNumber=user.getMobileNumber();
    this.balance=user.getBalance();
    this.address=user.getAddress();
   }
   else{
    this.id=user.getId();
    this.designation=user.getDesignation();
   }
  }

  public String getAccountNumber(){
       return this.account_no;
  }
  public String getName(){
     return this.name;
  }
   public String getIfscCode(){
     return this.ifscCode;
  }

 public String getmobileNmber(){
     return this.mobileNumber;
  }

 public String getBalance(){
     return this.balance;
  }
   public String getId(){
     return this.id;
  }
   public String getDesignation(){
     return this.designation;
  }
  public String getAddress(){
    return this.address;
  }

public void createAccount(String name,String mobileNumber,String address,String pin,String balance){
 this.name=name;
   user.setName(this.name);
   this.mobileNumber=mobileNumber;
   user.setMobileNumber(this.mobileNumber);
   this.address=address;
   user.setAddress(this.address);
   this.pin=pin;
   user.setPassword(this.pin);
   this.balance=balance;
   user.setBalance(this.balance);
   DAOInterface dao;
   dao.createAccount(user);
}

public void withdraw(String amount,String password){
  DAOInterface dao;
 dao=new DAOBank();
  int availAmount=Integer.parseInt(this.balance);
  int withdrawAmount=Integer.parseInt(amount);
  withdrawAmount=withdrawAmount-availAmount;
  this.balance=String.valueOf(withdrawAmount);
  user.setBalance(this.balance);
  if(this.validation==true)
  dao.withdraw(user);
}
public void deposit(String amount){
  DAOInterface dao;
  dao=new DAOBank();
  int availAmount=Integer.parseInt(this.balance);
  int depositeAmount=Integer.parseInt(amount);
  depositeAmount=depositeAmount+availAmount;
  this.balance=String.valueOf(depositeAmount);
  user.setBalance(this.balance);
  if(this.validation==true)
  dao.deposite(user);
}

public void accountChange(String name,String mobileNumber,String address){
   this.name=name;
   user.setName(this.name);
   this.mobileNumber=mobileNumber;
   user.setMobileNumber(this.mobileNumber);
   this.address=address;
   user.setAddress(this.address);
   DAOInterface dao;
   dao.accountChange(user);
}

public void deleteAccount(String account,String password){
   this.account_no=account;
   user.setAccountNumber(this.name);
   DAOInterface dao;
   dao.deleteAccount(user);
}

}

