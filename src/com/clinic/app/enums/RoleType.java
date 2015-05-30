package com.clinic.app.enums;

public enum RoleType {

	RECEPTIONIST("REC");
	
	private String code;
	
	private RoleType(String code){
		this.code=code;
	}
	
	public String code() {
        return this.code;
    }
	
	public static RoleType getValueof(String str) {
		System.out.println("HERE");
        if (str.equalsIgnoreCase(RoleType.RECEPTIONIST.code())) {
            return RoleType.RECEPTIONIST;
        } 
        else
        	return null;
    }
}
