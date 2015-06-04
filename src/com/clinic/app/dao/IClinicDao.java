package com.clinic.app.dao;

import java.util.List;

import com.clinic.app.entity.Login;
import com.clinic.app.entity.SearchForm;
import com.clinic.app.entity.User;

public interface IClinicDao {

	public User getdetails();

	public Login validateLogin(String username, String password);

	public boolean persistPatientDetails(User user);

	public List<User> findPatient(SearchForm search);

}
