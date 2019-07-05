package model;

public class PayUser {
String mobileNumber;
String amountToPay;
public PayUser(String mobileNumber, String amountToSend) {
	super();
	this.mobileNumber = mobileNumber;
	this.amountToPay = amountToSend;
}
public String getMobileNumber() {
	return mobileNumber;
}
public void setMobileNumber(String mobileNumber) {
	this.mobileNumber = mobileNumber;
}
public String getAmountToPay() {
	return amountToPay;
}
public void setAmountToPay(String amountToSend) {
	this.amountToPay = amountToSend;
}

}
