package model;

import javax.persistence.*;

import org.hibernate.validator.constraints.UniqueElements;

@Entity
@Table(name = "walletTable",uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
public class CreateUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long UID;
	String userName;
	String email;
	String mobileNumber;
	String password;
	Long walletBalance;
	



	public CreateUser(){
		
	}
	
	
	public CreateUser(String userName, String email, String mobileNumber, String password) {
		super();
		this.userName = userName;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.password = password;
	}



public Long getUID() {
	return UID;
}
public void setUID(Long uID) {
	UID = uID;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getMobileNumber() {
	return mobileNumber;
}
public void setMobileNumber(String mobileNumber) {
	this.mobileNumber = mobileNumber;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public Long getWalletBalance() {
	return walletBalance;
}
public void setWalletBalance(Long walletBalance) {
	this.walletBalance = walletBalance;
}

}
