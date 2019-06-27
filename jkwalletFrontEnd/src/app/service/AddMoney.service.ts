import { CardDetails } from '../model/cardDetails';
import { HttpClient,HttpParams, HttpErrorResponse } from '@angular/common/http';
import { LoginStatus } from './LoginStatus';
import { Injectable } from '@angular/core';
import { map, catchError } from 'rxjs/operators';
import { MobileDetails } from '../model/mobileDetails';
import { Observable } from 'rxjs';



@Injectable({
    providedIn:'root'
})
export class AddMoneyService{
emailOfCurrentUser:string;
errorMessage:string;
constructor(private http:HttpClient,){
this.emailOfCurrentUser=LoginStatus.getCurrentUser();
}

addMoneyByCard(cardDetails:CardDetails){

    let params=new HttpParams()
    .set('email',this.emailOfCurrentUser)
    return this.http.post("http://localhost:8080/addMoneyByCard",cardDetails,{params}).pipe(map(
      data=>{
            return data;
      },
      error =>{
          console.log(error.error);
      }));
}


addMoneyByMobile(mobileDetails:MobileDetails){
    return this.http.post("http://localhost:8080/addMoneyByMobile",mobileDetails).pipe(map(
      data=>{
           return data;
      },
      error=>{
          console.log(error.message);
      }
));
}
errorHandler(error:HttpErrorResponse){
this.errorMessage=error.message;
}

}