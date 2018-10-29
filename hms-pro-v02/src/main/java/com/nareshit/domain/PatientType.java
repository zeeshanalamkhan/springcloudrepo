package com.nareshit.domain;

public class PatientType extends Patient {
 private boolean inPatient;
 private boolean outPatient;
public boolean isInPatient() {
	return inPatient;
}
public void setInPatient(boolean inPatient) {
	this.inPatient = inPatient;
}
public boolean isOutPatient() {
	return outPatient;
}
public void setOutPatient(boolean outPatient) {
	this.outPatient = outPatient;
}
}
