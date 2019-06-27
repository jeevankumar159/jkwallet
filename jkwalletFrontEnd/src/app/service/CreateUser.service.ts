import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { CreateUser } from '../model/CreateUser';



const httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json'
    })
  };

  @Injectable({
    providedIn:'root'
})
export class CreateUserService{
    constructor(private http:HttpClient){}

    CreateUser(createUser:CreateUser){
        return this.http.post<any>("http://localhost:8080/createUser",createUser,httpOptions)
        .pipe(map(
          data => {
            console.log(data);
            sessionStorage.setItem('email',createUser.email);
             return data;
          },
          error => {
            console.log(error)
          }
        ))
    }
}