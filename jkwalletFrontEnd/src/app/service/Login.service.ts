import { Injectable } from '@angular/core';
import { HttpClient,HttpParams} from '@angular/common/http';
import { Router } from '@angular/router';
import { map } from 'rxjs/operators';

@Injectable({
    providedIn: 'root'
  })
export class LoginService{
    constructor(private http:HttpClient,private router:Router){}


    basicLogin(email,password){
        let params=new HttpParams()
          .set('email',email)
          .set('password',password);
          return this.http.get("http://localhost:8080/login",{params}).pipe(map(
                data => {
                  sessionStorage.setItem('email',email); 
                  return data;
               
            }));
    }


}