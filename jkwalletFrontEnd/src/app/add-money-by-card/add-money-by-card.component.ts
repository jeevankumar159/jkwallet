import { Component, OnInit } from '@angular/core';
import { CardDetails } from '../model/cardDetails';
import { HttpClient,HttpParams } from '@angular/common/http';
import { LoginStatus } from '../service/LoginStatus';
import { Router } from '@angular/router';
import { AddMoneyService } from '../service/AddMoney.service';

@Component({
  selector: 'app-add-money-by-card',
  templateUrl: './add-money-by-card.component.html',
  styleUrls: ['./add-money-by-card.component.css']
})
export class AddMoneyByCardComponent implements OnInit {
  cardNumber:string;
  cvv:string;
  expiryMonth:string;
  expiryYear:string;
  addMoney:boolean;
  addCardDetails:boolean;
  amountToAdd:string;
  emailOfCurrentUser:string;
 
  cardDetails:CardDetails;
  constructor(private http:HttpClient,private router:Router,private addMoneyService:AddMoneyService) {
    this.cardDetails=new CardDetails(this.cardNumber,this.cvv,this.expiryMonth,this.expiryYear,this.amountToAdd);
    this.addMoney=false;
    this.addCardDetails=true;
    this.emailOfCurrentUser=LoginStatus.getCurrentUser();
  }

  ngOnInit() {
  }
  addMoneyByCard(){
    this.addMoneyService.addMoneyByCard(this.cardDetails)
    .subscribe(
      data=>{
        this.router.navigateByUrl('mainPage');
      },
      error=>{
        console.log(error.json);
      }
    )
  }

}
