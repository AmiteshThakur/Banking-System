package com.ami.tech.dl.dao;
import com.ami.tech.dl.interfaces.dao.*;
import com.ami.tech.dl.exceptions.*;
import com.ami.tech.dl.interfaces.dto.*;
import com.ami.tech.dl.connection.*; 
import java.sql.*;
public class DAOBank implements DAOInterface{
     public void login(DTOInterface dto)throws DAOException{
     //iska return Dto ka object karna 
     
     
      Conn c1=new Conn();
       ResultSet rs=c1.Statement.executeQuery("");
     }


/*
 * public boolean loginValidity(String )
 */

     public void add(DTOInterface dto)throws DAOException
     {
        try{
            String url="jdbc:mysql://localhost/Bank";
            String userName="root";
            String password="Aadi1484";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn=DriverManager.getConnection(url, userName, password);
            String query1="Select Account_no from Bank order by Account_no desc limit 1";
            PreparedStatement pstm=conn.prepareStatement(query1);
            ResultSet rs=pstm.executeQuery(query1);
            String ac="";
            int ac1;
            while(rs.next()){
               ac=rs.getString(1);
            }
              ac1=Integer.parseInt(ac);
              ac1=ac1+1;
              ac=String.valueOf(ac1);
        
            String query="INSERT INTO BANK(account_no,name,mobile_number,pin,balance) values('"+ac+"',?,?,?,?)";
            pstm.setString(1,ac);
            pstm.setString(2,dto.getName());
            pstm.setString(3,dto.getPin());
            pstm.setString(4,dto.getMobileNumber());           
            pstm.setString(5,dto.getBalance());
            pstm.executeUpdate();
            conn.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
     }
    public void update(DTOInterface dto)throws DAOException{}
    public void withdraw(DTOInterface dto)throws DAOException{}
    public void deposite(DTOInterface dto)throws DAOException{}
    public void accountChange(DTOInterface dto)throws DAOException{}
    public void checkStatus(DTOInterface dto)throws DAOException{}
    public void deleteAccount(DTOInterface dto)throws DAOException{}

}