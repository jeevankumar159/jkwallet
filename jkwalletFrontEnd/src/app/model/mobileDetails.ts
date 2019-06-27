export class MobileDetails{
    mobileNumber:string;
    pin:string;
    amount:string;
    bank:string;
    constructor(mobileNumber:string,pin:string,amount:string,bank:string){
        this.mobileNumber=mobileNumber;
        this.pin=pin;
        this.bank=bank;
        this.amount=amount;
    }
}