package com.clinic.app;

public interface IClinicService {

	public User getdetails();

	public Login validateLogin(Login login);

	public boolean persistPatientDetails(User user);

}
