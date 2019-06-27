import { Injectable } from '@angular/core';
import { HttpClient,HttpParams } from '@angular/common/http';
import { Withdraw } from '../model/Withdraw';
import { map } from 'rxjs/operators';
import { LoginStatus } from './LoginStatus';

@Injectable({
    providedIn:'root'
})


export class WithdrawService{
    emailOfCurrentUser:string;
constructor(private http:HttpClient){
    this.emailOfCurrentUser=LoginStatus.getCurrentUser();
}


withdrawMoney(withdraw:Withdraw){
    let params=new HttpParams()
    .set('email',this.emailOfCurrentUser)
    .set('bankName',withdraw.bankName)
    .set('amountTowithdraw',withdraw.amountToWithdraw);
return this.http.post("http://localhost:8080/withdraw",null,{params}).pipe(map(
  data=>{
            return data;
      },
  error =>{
          console.log(error.error);
      }));
}
}
