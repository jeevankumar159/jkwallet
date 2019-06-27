import { Injectable } from '@angular/core';
@Injectable({
  providedIn:'root'
})
export class LoginStatus{
    constructor(){

    }

   
  isUserLoggedIn():boolean{
    if(sessionStorage.getItem("email")==null)
    {
      return false;
      
    }
    else
    {
      return true;
    }
  }

  static getCurrentUser():string{
    return sessionStorage.getItem("email");
  }
}