package model;

public class Regmodel {
 private String name;
 private String email;
 private String password;
 private String gender;
 
 public Regmodel(String name,String email,String password,String gender)
 {
  this.name = name;
  this.email = email;
  this.password = password;
  this.gender = gender;
    
 }
 
 String getName() {
  return name;
 }
 void setName(String name) {
  this.name = name;
 }
 String getEmail() {
  return email;
 }
 void setEmail(String email) {
  this.email = email;
 }
 String getPassword() {
  return password;
 }
 void setPassword(String password) {
  this.password = password;
 }
 String getGender() {
  return gender;
 }
 void setGender(String gender) {
  this.gender = gender;
 }
 
 
 
 
}