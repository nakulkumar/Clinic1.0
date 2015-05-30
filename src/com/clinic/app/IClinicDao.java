package com.clinic.app;


public interface IClinicDao {

	public User getdetails();

	public Login validateLogin(String username,String password);
	
}
