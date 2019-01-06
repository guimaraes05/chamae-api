package br.com.chamae.gameEvent.models;

import java.util.List;

import javax.validation.constraints.Size;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class User {
  
  @Id
  private ObjectId _id;
  private String username;
  private String password;
  
  public ObjectId get_id() {
 	return _id;
  } 
  
  public void set_id(ObjectId _id) {
	this._id = _id;
  }
  
  public String getUsername() {
	return username;
  }
  
  public void setUsername(String username) {
	this.username = username;
  }
  
  public String getPassword() {
	return password;
  }
  
  public void setPassword(String password) {
	this.password = password;
  } 
  
  


}