import { Component, OnInit } from '@angular/core';
import { CreateUser } from '../model/CreateUser';
import { HttpClient } from '@angular/common/http';
import { CreateUserService } from '../service/CreateUser.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-user',
  templateUrl: './create-user.component.html',
  styleUrls: ['./create-user.component.css']
})
export class CreateUserComponent implements OnInit {
  user:CreateUser;
  userName:string;
  email:string;
  mobileNumber:string;
  password:string;
  rePassword:string;
  passwordMatch:boolean;
  constructor(private http:HttpClient,private createUserService:CreateUserService,private router:Router) { 
    this.user=new CreateUser(this.userName,this.email,this.mobileNumber,this.password);
    this.passwordMatch=true;
  }

  ngOnInit() {
  }
  createUserLogin(){
      this.createUserService.CreateUser(this.user)
        .subscribe(
            data=>{
                this.router.navigateByUrl("mainPage");
                  }     
    )
  }


  getUser(){
    this.http.get("http://localhost:8080/getUser")
    .subscribe(
      data => {
        console.log(data)     
      },
      error => {
        console.log(error)
      }
    )
  }
}
