import { Component, OnInit } from '@angular/core';
import { LoginUser } from '../model/LoginUser';
import { HttpClient, HttpParams} from '@angular/common/http';
import { Router } from '@angular/router';
import { LoginService } from '../service/Login.service';

@Component({
  selector: 'app-login-user',
  templateUrl: './login-user.component.html',
  styleUrls: ['./login-user.component.css']
})
export class LoginUserComponent implements OnInit {
  user:LoginUser;
  email:string;
  password:string;
  
  constructor(private http:HttpClient,private router:Router,private loginService:LoginService) { 
    this.user=new LoginUser(this.email,this.password);
    
  }
  
  ngOnInit() {

  }
  onLogin(){
       this.loginService.basicLogin(this.user.email,this.user.password)
        .subscribe(
          data=>{
            this.router.navigateByUrl('mainPage');
          },
          error=>{
            console.log(error);
          }
        )


       
}


signup() {
  this.router.navigateByUrl('signup');
};
}
