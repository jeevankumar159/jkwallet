export class Withdraw{
    amountToWithdraw:string;
    bankName:string;
    
    constructor(amountToWithdraw:string,bankName:string){
        this.amountToWithdraw=amountToWithdraw;
        this.bankName=bankName;
    }
}