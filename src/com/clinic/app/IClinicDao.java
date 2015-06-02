package com.clinic.app;

import java.util.List;

public interface IClinicDao {

	public User getdetails();

	public Login validateLogin(String username, String password);

	public boolean persistPatientDetails(User user);

	public List<User> findPatient(SearchForm search);

}
