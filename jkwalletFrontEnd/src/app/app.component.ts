import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'jkwallet';
  loggedIn:boolean;
  createUser:boolean;
  constructor(){
    this.loggedIn=true;
    this.createUser=false;
  }

  onCreateUserClick():void{
    this.createUser=true;
  }
}
