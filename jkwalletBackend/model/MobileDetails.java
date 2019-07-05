package model;

public class MobileDetails {
	String mobileNumber;
	String pin;
	String amount;
	String bank;
	public MobileDetails(String mobileNumber, String pin, String amount, String bank) {
		super();
		this.mobileNumber = mobileNumber;
		this.pin = pin;
		this.amount = amount;
		this.bank = bank;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	
	
}
