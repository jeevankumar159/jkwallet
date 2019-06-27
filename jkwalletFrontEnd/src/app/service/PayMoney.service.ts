import { Injectable } from '@angular/core';
import { HttpClient,HttpParams } from '@angular/common/http';
import { LoginStatus } from './LoginStatus';
import { AccountDetails } from '../model/AccountDetails';
import { map } from 'rxjs/operators';
import { PayUser } from '../model/PayUser';

@Injectable({
    providedIn:'root'
})
export class PayMoneyService{
    emailOfCurrentUser:string;
    constructor(private http:HttpClient){
        this.emailOfCurrentUser=LoginStatus.getCurrentUser();
    }


    payMoneyUsingAccount(accountDetails:AccountDetails){
        let params=new HttpParams()
        .set('email',this.emailOfCurrentUser)
        .set('bankName',accountDetails.bankName)
        .set('accountNumber',accountDetails.accountNumber)
        .set('balanceToTransfer',accountDetails.amountToPay);
        return this.http.post("http://localhost:8080/payUsingAccountNumber",null,{params}).pipe(map(
          data=>{
                return data;
          },
          error =>{
              console.log(error.error);
          }));
    }



    payMoneyUsingMobile(payUser:PayUser){
        let params=new HttpParams()
          .set('email',this.emailOfCurrentUser);
    return this.http.post("http://localhost:8080/payUsingMobile",payUser,{params}).pipe(map(
      data=>{
           return data; 
      },
      error =>{
          console.log(error.error);
      }));
    }
}