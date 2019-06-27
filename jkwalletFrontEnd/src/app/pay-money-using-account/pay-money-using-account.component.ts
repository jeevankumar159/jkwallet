import { Component, OnInit } from '@angular/core';
import { AccountDetails } from '../model/AccountDetails';
import { HttpClient,HttpParams} from '@angular/common/http';
import { LoginStatus } from '../service/LoginStatus';
import { Router } from '@angular/router';
import { PayMoneyService } from '../service/PayMoney.service';

@Component({
  selector: 'app-pay-money-using-account',
  templateUrl: './pay-money-using-account.component.html',
  styleUrls: ['./pay-money-using-account.component.css']
})
export class PayMoneyUsingAccountComponent implements OnInit {
  accountDetails:AccountDetails;
  accountNumber:string;
  bankName:string;
  bankList:string[];
  amountToPay:string;
  emailOfCurrentUser:string;
  constructor(private http:HttpClient,private router:Router,private payMoneyService:PayMoneyService) {
    this.accountDetails=new AccountDetails(this.accountNumber,this.bankName,this.amountToPay);
    this.bankList=["ABC","XYZ"];
    this.emailOfCurrentUser=LoginStatus.getCurrentUser();
   }
  

  ngOnInit() {
  }


  payUsingAccountNumber(){
    this.payMoneyService.payMoneyUsingAccount(this.accountDetails)
    .subscribe(
      data=>{
        this.router.navigateByUrl('mainPage');
      },
      error=>{
        console.log(error);
      }
    )
  }
}
