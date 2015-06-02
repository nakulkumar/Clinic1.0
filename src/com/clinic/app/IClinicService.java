package com.clinic.app;

import java.util.List;

public interface IClinicService {

	public User getdetails();

	public Login validateLogin(Login login);

	public boolean persistPatientDetails(User user);

	public List<User> findPatient(SearchForm search);

}
