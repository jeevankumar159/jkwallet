export class AccountDetails{
    accountNumber:string;
    bankName:string;
    amountToPay:string;
    constructor(accountNumber:string,bankName:string,amountToPay:string){
        this.accountNumber=accountNumber;
        this.bankName=bankName;
        this.amountToPay=amountToPay;
    }
}