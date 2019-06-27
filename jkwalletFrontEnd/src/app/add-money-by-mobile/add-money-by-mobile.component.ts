import { Component, OnInit } from '@angular/core';
import { MobileDetails } from '../model/mobileDetails';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';
import { AddMoneyService } from '../service/AddMoney.service';

@Component({
  selector: 'app-add-money-by-mobile',
  templateUrl: './add-money-by-mobile.component.html',
  styleUrls: ['./add-money-by-mobile.component.css']
})
export class AddMoneyByMobileComponent implements OnInit {
  mobileDetails:MobileDetails;
  mobileNumber:string;
  pin:string;
  selectedBank:string;
  bankList:string[];
  amount:string;


  constructor(private http:HttpClient,private router:Router,private addMoneyService:AddMoneyService) { 
    this.mobileDetails=new MobileDetails(this.mobileNumber,this.pin,this.amount,this.selectedBank);
    this.bankList=["ABC","XYZ"];
  }

  ngOnInit() {
  }
 onAddMoneyByMobile(){
   this.addMoneyService.addMoneyByMobile(this.mobileDetails)
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
