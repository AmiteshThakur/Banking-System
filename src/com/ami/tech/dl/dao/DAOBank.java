package com.ami.tech.dl.dao;
import com.ami.tech.dl.dto.*;
import com.ami.tech.dl.interfaces.dao.*;
import com.ami.tech.dl.exceptions.*;
import com.ami.tech.dl.interfaces.dto.*;
import com.ami.tech.dl.connection.*; 
import java.sql.*;

public class DAOBank implements DAOInterface{
    
   boolean validity=false;
   String type;
   String ac_no="";
   String coustomerTableName="";
  public boolean loginValidation(String account,String password,String userType){     
      try{
      Conn c1=new Conn();
       if(userType.equalsIgnoreCase("customer")){
        validity=c1.statement.execute("Select account_no,pin from Customer where account_no=account,pin=password");
        this.ac_no=account;
         }
       else{
        validity=c1.statement.execute("Select ,id,password from Customer where id=account,password=password");
       this.ac_no=account;
       }
      }catch(Exception exception){
        exception.printStackTrace();
      }
      this.type=userType;
      return validity;
    }

      public DTOInterface login(){
         DTOInterface dto;
         dto=new DTOBank();
         try{
          ResultSet rs;
         Conn c1=new Conn();
       if(type.equalsIgnoreCase("customer")&& validity==true){
        rs=c1.statement.executeQuery("Select account_no,name,balance,mobile_no,address from Customer where account_no=ac_no");
        while(rs.next()){
          dto.setAccountNumber(rs.getString(0));
          dto.setName(rs.getString(1));
          dto.setBalance(rs.getString(2));
          dto.setMobileNumber(rs.getString(3));
          dto.setAddress(rs.getString(4));
        }
         }
       else if(validity==true){
         rs=c1.statement.executeQuery("Select id,designation,password from Customer where id=ac_no");
       while(rs.next()){
        dto.setId(rs.getString(0));
        dto.setDesignation(rs.getString(1));
       }
       }
      }catch(Exception exception){
        exception.printStackTrace();
      }
      return dto;
      }


     public void createAccount(DTOInterface dto)throws DAOException
     {
        try{
            Conn c1=new Conn();
            ResultSet rs=c1.statement.executeQuery("Select Account_no from Bank order by Account_no desc limit 1");
            String ac="";
            int ac1;
            while(rs.next()){
               ac=rs.getString(1);
            }
              ac1=Integer.parseInt(ac);
              ac1=ac1+1;
              ac=String.valueOf(ac1);
            ResultSet createAccount=c1.statement.executeQuery("INSERT INTO BANK(account_no,ifscCode,name,mobileNumber,address,pin,balance) values('"+ac+"','"+dto.getIfscCode()+"','"+dto.getName()+"','"+dto.getMobileNumber()+"','"+dto.getAddress()+"','"+dto.getPassword()+"','"+dto.getBalance()+"'");
             coustomerTableName=ac.concat(dto.getName());
            ResultSet cutomerAccount=c1.statement.executeQuery("create table coustomerTableName(account_no varchar(10),withdrawAmount varchar(10),depositeAmount varchar(10),date_time TimeStamp)");
            }
        catch(Exception e)
        {
            e.printStackTrace();
        }
     }

    public void update(DTOInterface dto)throws DAOException{
      if(type.equalsIgnoreCase("admin")&&validity==true)
      try{
        Conn c1=new Conn();
      // ResultSet rs=c1.statement.executeQuery("update Customer '"+dto.g+")
      }
      catch(Exception exception){
        exception.printStackTrace();
      }
    }

    public void withdraw(DTOInterface dto,String amount)throws DAOException{
      try{
        Conn c1=new Conn();
        ResultSet rs1=c1.statement.executeQuery("update customer set balance='"+dto.getBalance()+"' where account_no='"+dto.getAccountNumber()+"'");
        ResultSet customerInsert=c1.statement.executeQuery("Insert into '"+coustomerTableName+"' values(,'"+amount+"','"+date_time+"') ");
        }
        catch(Exception exception){
          exception.printStackTrace();
        }
    }

    public void deposite(DTOInterface dto,String amount)throws DAOException{
      try{
        Conn c1=new Conn();
        ResultSet rs1=c1.statement.executeQuery("update customer set balance='"+dto.getBalance()+"' where account_no='"+dto.getAccountNumber()+"'");
        ResultSet customerInsert=c1.statement.executeQuery("Insert into '"+coustomerTableName+(depositAmount,date_time)"' values('"+amount+"','"+date_time+"') ");
        }
        catch(Exception exception){
          exception.printStackTrace();
        }
    }

    public void accountChange(DTOInterface dto)throws DAOException{
        try{
        Conn c1=new Conn();
        ResultSet rs1=c1.statement.executeQuery("update customer set name='"+dto.getName()+"',mobileNumber='"+dto.getMobileNumber()+"',address='"+dto.getAddress()+"' where account_no='"+dto.getAccountNumber()+"'");
        }
        catch(Exception exception){
          exception.printStackTrace();
        }
    }

    public void checkStatus(DTOInterface dto)throws DAOException{}

    public void deleteAccount(DTOInterface dto)throws DAOException{
       try{
        Conn c1=new Conn();
        ResultSet rs1=c1.statement.executeQuery("delete from customer where account_no='"+dto.getAccountNumber()+"'");
        }
        catch(Exception exception){
          exception.printStackTrace();
        }
    }

}