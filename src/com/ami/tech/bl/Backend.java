package com.ami.tech.bl;

import com.ami.tech.dl.dao.*;
import com.ami.tech.dl.dto.*;
import com.ami.tech.dl.exceptions.*;
import com.ami.tech.dl.interfaces.dao.*;
import com.ami.tech.dl.interfaces.dto.*;

public class Backend {

  int check = 0;
  String type = "";
  String accountNo = "";
  String name = "";
  String ifscCode = "";
  String aadharNumber = "";
  String balance = "";
  String id = "";
  String designation = "";
  String address = "";
  String password = "";
  DTOInterface user = new DTOBank();
  boolean validation = false;
  DAOInterface dao = new DAOBank();

  public int backendLogin(String id, String password) {
    if (
      id.length() < 4 ||
      id.length() > 10 ||
      password.length() == 0 ||
      password.length() > 10
    ) {
      return -1;
    }
    String ad = id.substring(id.length() - 2, id.length());
    if (ad.equals("AD")) {
      String remString = id.substring(0, id.length() - 2);
      if (remString.length() < 4 || remString.length() > 4) return -1;
      try {
        int idval = Integer.parseInt(remString);
        if (dao.loginValidation(String.valueOf(idval), password, "admin")) {
          this.accountNo = id;
          this.type = "admin";
          this.password = password;
          login();
          return 0;
        } else return -2;
      } catch (Exception exception) {
        return -1;
      }
    } else {
      try {
        check = Integer.parseInt(id);
        if (dao.loginValidation(id, password, "customer")) {
          this.accountNo = id;
          this.password = password;
          this.type = "customer";
          login();
          return 1;
        } else return -2;
      } catch (Exception user) {
        return -1;
      }
    }
  }

  public void login() {
    user = dao.login();
    if (type.equalsIgnoreCase("customer")) {
      this.name = user.getName();

      this.aadharNumber = user.getAadharNumber();
      this.balance = user.getBalance();
      this.address = user.getAddress();
      this.ifscCode = user.getIfscCode();
    } else {
      this.designation = user.getDesignation();
    }
  }

  public String getAccountNumber() {
    return this.accountNo;
  }

  public String getName() {
    return this.name;
  }

  public String getIfscCode() {
    return this.ifscCode;
  }

  public String getmobileNmber() {
    return this.mobileNumber;
  }

  public String getBalance() {
    return this.balance;
  }

  public String getId() {
    return this.id;
  }

  public String getDesignation() {
    return this.designation;
  }

  public String getAddress() {
    return this.address;
  }

  public void createAccount(
    String name,
    String mobileNumber,
    String address,
    String pin,
    String balance
  ) {
    this.name = name;
    user.setName(this.name);
    this.mobileNumber = mobileNumber;
    user.setMobileNumber(this.mobileNumber);
    this.address = address;
    user.setAddress(this.address);
    this.pin = pin;
    user.setPassword(this.pin);
    this.balance = balance;
    user.setBalance(this.balance);
    DAOInterface dao;
    dao.createAccount(user);
  }

  public void withdraw(String amount, String password) {
    DAOInterface dao;
    dao = new DAOBank();
    int availAmount = Integer.parseInt(this.balance);
    int withdrawAmount = Integer.parseInt(amount);
    withdrawAmount = withdrawAmount - availAmount;
    this.balance = String.valueOf(withdrawAmount);
    user.setBalance(this.balance);
    if (this.validation == true) dao.withdraw(user);
  }

  public void deposit(String amount) {
    DAOInterface dao;
    dao = new DAOBank();
    int availAmount = Integer.parseInt(this.balance);
    int depositeAmount = Integer.parseInt(amount);
    depositeAmount = depositeAmount + availAmount;
    this.balance = String.valueOf(depositeAmount);
    user.setBalance(this.balance);
    if (this.validation == true) dao.deposite(user);
  }

  public void accountChange(String name, String mobileNumber, String address) {
    this.name = name;
    user.setName(this.name);
    this.mobileNumber = mobileNumber;
    user.setMobileNumber(this.mobileNumber);
    this.address = address;
    user.setAddress(this.address);
    DAOInterface dao;
    dao.accountChange(user);
  }

  public void deleteAccount(String account, String password) {
    this.account_no = account;
    user.setAccountNumber(this.name);
    DAOInterface dao;
    dao.deleteAccount(user);
  }
}
