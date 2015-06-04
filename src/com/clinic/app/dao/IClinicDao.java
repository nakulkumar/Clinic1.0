package com.clinic.app.dao;

import java.util.List;

import com.clinic.app.Login;
import com.clinic.app.SearchForm;
import com.clinic.app.User;

public interface IClinicDao {

	public User getdetails();

	public Login validateLogin(String username, String password);

	public boolean persistPatientDetails(User user);

	public List<User> findPatient(SearchForm search);

}
