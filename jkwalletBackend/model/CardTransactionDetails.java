package model;

public class CardTransactionDetails {
	Long cardNumber;
	int cvv;
	int expiryMonth;
	int expiryYear;
	Long amountToAdd;
	public CardTransactionDetails(Long cardNumber, int cvv, int expiryMonth, int expiryYear, Long amountToAdd) {
		super();
		this.cardNumber = cardNumber;
		this.cvv = cvv;
		this.expiryMonth = expiryMonth;
		this.expiryYear = expiryYear;
		this.amountToAdd = amountToAdd;
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
	public Long getAmountToAdd() {
		return amountToAdd;
	}
	public void setAmountToAdd(Long amountToAdd) {
		this.amountToAdd = amountToAdd;
	}


	
	
}
