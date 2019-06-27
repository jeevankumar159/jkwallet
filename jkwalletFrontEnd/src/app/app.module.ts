import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateUserComponent } from './create-user/create-user.component';
import {FormsModule} from '@angular/forms';
import { LoginUserComponent } from './login-user/login-user.component';
import { MainpageComponent } from './mainpage/mainpage.component';
import { AddMoneyByCardComponent } from './add-money-by-card/add-money-by-card.component';
import { AddMoneyByMobileComponent } from './add-money-by-mobile/add-money-by-mobile.component';
import { PayMoneyUsingMobileComponent } from './pay-money-using-mobile/pay-money-using-mobile.component';
import { WithdrawMoneyComponent } from './withdraw-money/withdraw-money.component';
import { PayMoneyUsingAccountComponent } from './pay-money-using-account/pay-money-using-account.component';
import { HttpClientModule } from '@angular/common/http';
import { MenuComponent } from './menu/menu.component';
import { LoginStatus } from './service/LoginStatus';
import { RouteGuard } from './service/RouteGuard';


@NgModule({
  declarations: [
    AppComponent,
    CreateUserComponent,
    LoginUserComponent,
    MainpageComponent,
    AddMoneyByCardComponent,
    AddMoneyByMobileComponent,
    PayMoneyUsingMobileComponent,
    WithdrawMoneyComponent,
    PayMoneyUsingAccountComponent,
    MenuComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    
  ],
  providers: [LoginStatus,RouteGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
