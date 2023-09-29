package com.ami.tech.dl.connection;
//this package will use to establish the connection and to retreive the data from the database

import java.sql.*;

public class Conn {

  Connection connection;
  Statement statement;

  public Conn() {
    try {
        Class.forName("com.mysql.jdbc.Driver");
        connection=DriverManager.getConnection("jdbc:mysql:///ebs", "root","Ram9691@mitesh");
        statement=connection.createStatement();
    } catch (Exception exception) {
      System.out.println(exception.getMessage());
    }
  }
}
