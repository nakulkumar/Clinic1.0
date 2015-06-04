package com.clinic.app.service;

import java.util.List;

import com.clinic.app.Login;
import com.clinic.app.SearchForm;
import com.clinic.app.User;

public interface IClinicService {

	public User getdetails();

	public Login validateLogin(Login login);

	public boolean persistPatientDetails(User user);

	public List<User> findPatient(SearchForm search);

}
