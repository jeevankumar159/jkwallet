import { Component, OnInit } from '@angular/core';
import { LoginStatus } from '../service/LoginStatus';



@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {
  userLoggedInBoolean:boolean;
  constructor(private loginStatus:LoginStatus) { 
    
  }

  ngOnInit() {
    this.userLoggedInBoolean=this.loginStatus.isUserLoggedIn();
  }

  onLogout(){
    sessionStorage.removeItem("email");
    this.userLoggedInBoolean=false;
  }

}
