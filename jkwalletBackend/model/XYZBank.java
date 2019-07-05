package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "XYZTable")
@SequenceGenerator(name = "seq",initialValue = 1000000000, allocationSize = 1000000000)
public class XYZBank {
@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq")
@Id
Long accountNumber;
@Column(unique = true)
String mobileNumber;
Long balance;
int pin;
public XYZBank() {
	
}
public XYZBank(Long accountNumber, String mobileNumber, Long balance, int pin) {
	super();
	this.accountNumber = accountNumber;
	this.mobileNumber = mobileNumber;
	this.balance = balance;
	this.pin = pin;
}
public Long getAccountNumber() {
	return accountNumber;
}
public void setAccountNumber(Long accountNumber) {
	this.accountNumber = accountNumber;
}
public String getMobileNumber() {
	return mobileNumber;
}
public void setMobileNumber(String mobileNumber) {
	this.mobileNumber = mobileNumber;
}
public Long getBalance() {
	return balance;
}
public void setBalance(Long balance) {
	this.balance = balance;
}
public int getPin() {
	return pin;
}
public void setPin(int pin) {
	this.pin = pin;
}



}
