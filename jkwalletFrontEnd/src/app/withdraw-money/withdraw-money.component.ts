import { Component, OnInit, Input } from '@angular/core';
import { PayUser } from '../model/PayUser';
import { Withdraw } from '../model/Withdraw';
import { LoginStatus } from '../service/LoginStatus';
import { HttpClient,HttpParams } from '@angular/common/http';
import { WithdrawService } from '../service/Withdraw.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-withdraw-money',
  templateUrl: './withdraw-money.component.html',
  styleUrls: ['./withdraw-money.component.css']
})
export class WithdrawMoneyComponent implements OnInit {
  bankList:string[];
  amountToWithdraw:string;
  bankName:string;
  withdraw:Withdraw;
  emailOfCurrentUser:string;
  constructor(private http:HttpClient,private withdrawServcie:WithdrawService,private router:Router) {
    this.bankList=["ABC","XYZ"];
    this.withdraw=new Withdraw(this.amountToWithdraw,this.bankName);
    this.emailOfCurrentUser=LoginStatus.getCurrentUser();
   }

  ngOnInit() {
  }
  withdrawOnClick(){
this.withdrawServcie.withdrawMoney(this.withdraw)
.subscribe(
  data=>{
    this.router.navigateByUrl('mainPage');
  }
)
}
}