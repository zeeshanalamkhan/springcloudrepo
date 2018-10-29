package com.nareshit.domain;

public class ReportTypes extends Patient{
private String cardiacReport;
private String nephrologyReport;
private String nuerologyReport;
private String OrthopedicReport;
public String getCardiacReport() {
	return cardiacReport;
}
public void setCardiacReport(String cardiacReport) {
	this.cardiacReport = cardiacReport;
}
public String getNephrologyReport() {
	return nephrologyReport;
}
public void setNephrologyReport(String nephrologyReport) {
	this.nephrologyReport = nephrologyReport;
}
public String getNuerologyReport() {
	return nuerologyReport;
}
public void setNuerologyReport(String nuerologyReport) {
	this.nuerologyReport = nuerologyReport;
}
public String getOrthopedicReport() {
	return OrthopedicReport;
}
public void setOrthopedicReport(String orthopedicReport) {
	OrthopedicReport = orthopedicReport;
}
}
