package dao;

import java.sql.*;
public class DBConnect {

 public Connection cn;
 public DBConnect() throws Exception
 {
  Class.forName("com.mysql.cj.jdbc.Driver");
  cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javabatch"
    ,"root","root@123");
 }
 
 public void QueryExecuter(String sql) throws Exception//DML
 {
  Statement stmt = cn.createStatement();
  stmt.execute(sql);
  stmt.close();
  cn.close();
 }
 
 public ResultSet QueryReturner(String sql) throws Exception
 {
  Statement stmt = cn.createStatement();
  ResultSet rs = stmt.executeQuery(sql);
  return rs;
 }
 
}