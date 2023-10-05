package com.blogsite.exception;

public class ErrorResponse { 
	 private int code; 
	 private String msg; 
	  
	 public ErrorResponse(int code,String msg) 
	 { 
	  this.code=code; 
	  this.msg=msg; 
	 } 
	 public ErrorResponse() 
	 { 
	 } 
	     
	 public int getCode() { 
	  return code; 
	 } 
	 
	 public void setCode(int code) { 
	  this.code = code; 
	 } 
	 
	 public String getMsg() { 
	  return msg; 
	 } 
	 
	 public void setMsg(String msg) { 
	  this.msg = msg; 
	 } 
}
