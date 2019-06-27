import { Component, OnInit } from '@angular/core';
import { HttpClient,HttpParams } from '@angular/common/http';
import { WalletDetails } from '../model/WalletDetails';
import {map} from 'rxjs/operators';
import { Router } from '@angular/router';

@Component({
  selector: 'app-mainpage',
  templateUrl: './mainpage.component.html',
  styleUrls: ['./mainpage.component.css']
})
export class MainpageComponent implements OnInit {
  walletBalance:String;
  addMoney:boolean;
  withdrawMoney:boolean;
  walletDetails:WalletDetails;
  email:string;
  payMoney:boolean;
  addUsingCreditCardBoolean:boolean;
  addUsingMobileNumberBoolean:boolean;
  payUsingAccountNumberBoolean:boolean;
  payUsingMobileNumberBoolean:boolean;

  constructor(private http:HttpClient,private router:Router) {
    this.email=sessionStorage.getItem('email');
  
    
    this.addMoney=this.payMoney=this.withdrawMoney=false;
    this.addUsingCreditCardBoolean=this.addUsingMobileNumberBoolean=false;
    this.payUsingAccountNumberBoolean=this.payUsingMobileNumberBoolean=false;
   }

  ngOnInit() {
    this.loadWalletBalance();
  }
  onAddMoney():void{
    this.addMoney=true;
    this.withdrawMoney=false;
    this.payMoney=false;
  }

  onWithdrawMoney():void{
    this.withdrawMoney=true;
    this.payMoney=false;
    this.addMoney=false;
  }


  onPayMoney():void{
    this.payMoney=true;
    this.withdrawMoney=false;
    this.addMoney=false;
  }
  addMoneyUsingCreditCard():void{
    this.router.navigateByUrl('addMoneyByCard');
  }
  addMoneyUsingMobileNumber():void{
    this.router.navigateByUrl('addMoneyByMobile');
  }
  payUsingMobileNumber():void{
    this.router.navigateByUrl('payMoneyByMobile')
  }
  payUsingAccountNumber():void{
    this.router.navigateByUrl('payMoneyByAccount')
  }
  withdrawMoneyMethod():void{
    this.router.navigateByUrl('withdraw')
  }

  loadWalletBalance(){
    let params=new HttpParams()
    .set('email',this.email);
    
    return this.http.get<WalletDetails>("http://localhost:8080/walletDetails",{params}).subscribe(
      response=>{
        this.walletDetails=response;
        this.walletBalance=this.walletDetails.walletBalance;
        
      }
    )
   
  }
}
