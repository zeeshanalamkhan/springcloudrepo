package novelhealthcare;

import java.io.Serializable;

public class InValidPatient extends RuntimeException implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7440473943770586579L;

	public InValidPatient(String message){
		super(message);
	}
	
}
