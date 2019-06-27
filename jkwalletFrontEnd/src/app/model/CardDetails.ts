export class CardDetails{
    cardNumber:string;
    cvv:string;
    expiryMonth:string;
    expiryYear:string;
    amountToAdd:string
    constructor(cardNumber:string,cvv:string,expiryMonth:string,expiryYear:string,amountToAdd:string){
        this.cardNumber=cardNumber;
        this.cvv=cvv;
        this.expiryMonth=expiryMonth;
        this.expiryYear=expiryYear;
        this.amountToAdd=amountToAdd;
    }
}