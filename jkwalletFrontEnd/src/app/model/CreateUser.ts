export class CreateUser{
    userName:string;
    email:string;
    mobileNumber:string;
    password:string;
    

    constructor(userName:string,email:string,mobileNumber:string,password:string){
        this.userName=userName;
        this.email=email;
        this.password=password;
        this.mobileNumber=mobileNumber;
    }
}