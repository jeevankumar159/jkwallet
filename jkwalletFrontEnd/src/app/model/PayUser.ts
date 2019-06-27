

export class PayUser{
    mobileNumber:string;
    amountToPay:string;
    constructor(mobileNumber:string,amountToSend:string){
        this.amountToPay=amountToSend;
        this.mobileNumber=mobileNumber;
    }
}