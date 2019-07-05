package model;

import javax.persistence.*;

@Entity
@Table(name="cardTable")
public class CardDetails {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
Long UID;
Long cardNumber;
int cvv;
int expiryMonth;
int expiryYear;
String bankName;
Long accountNumber;
int pin;

public CardDetails() {
	
}

public CardDetails(Long UID,Long cardNumber, int cvv, int expiryMonth, int expiryYear, String bankName, Long accountNumber,
		int pin) {
	super();
	this.UID=UID;
	this.cardNumber = cardNumber;
	this.cvv = cvv;
	this.expiryMonth = expiryMonth;
	this.expiryYear = expiryYear;
	this.bankName = bankName;
	this.accountNumber = accountNumber;
	this.pin = pin;
}

public Long getUID() {
	return UID;
}

public void setUID(Long uID) {
	UID = uID;
}
public Long getCardNumber() {
	return cardNumber;
}
public void setCardNumber(Long cardNumber) {
	this.cardNumber = cardNumber;
}
public int getCvv() {
	return cvv;
}
public void setCvv(int cvv) {
	this.cvv = cvv;
}
public int getExpiryMonth() {
	return expiryMonth;
}
public void setExpiryMonth(int expiryMonth) {
	this.expiryMonth = expiryMonth;
}
public int getExpiryYear() {
	return expiryYear;
}
public void setExpiryYear(int expiryYear) {
	this.expiryYear = expiryYear;
}
public String getBankName() {
	return bankName;
}
public void setBankName(String bankName) {
	this.bankName = bankName;
}
public Long getAccountNumber() {
	return accountNumber;
}
public void setAccountNumber(Long accountNumber) {
	this.accountNumber = accountNumber;
}
public int getPin() {
	return pin;
}
public void setPin(int pin) {
	this.pin = pin;
}



}
