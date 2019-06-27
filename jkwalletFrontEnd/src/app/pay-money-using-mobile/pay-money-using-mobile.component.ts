import { Component, OnInit } from '@angular/core';
import { PayUser } from '../model/PayUser';
import { LoginStatus } from '../service/LoginStatus';
import { HttpClient,HttpParams } from '@angular/common/http';
import { Router } from '@angular/router';
import { PayMoneyService } from '../service/PayMoney.service';

@Component({
  selector: 'app-pay-money-using-mobile',
  templateUrl: './pay-money-using-mobile.component.html',
  styleUrls: ['./pay-money-using-mobile.component.css']
})
export class PayMoneyUsingMobileComponent implements OnInit {
  payUser:PayUser;
  mobileNumber:string;
  amountToPay:string;
  emailOfCurrentUser:string;
  constructor(private http:HttpClient,private router:Router,private payMoneyService:PayMoneyService) {
    this.payUser=new PayUser(this.mobileNumber,this.amountToPay);
    this.emailOfCurrentUser=LoginStatus.getCurrentUser();
   }

  ngOnInit() {
  }

  payUsingMobile(){
    this.payMoneyService.payMoneyUsingMobile(this.payUser)
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
