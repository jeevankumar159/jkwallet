import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginUserComponent } from './login-user/login-user.component';
import { CreateUserComponent } from './create-user/create-user.component';
import { AddMoneyByCardComponent } from './add-money-by-card/add-money-by-card.component';
import { AddMoneyByMobileComponent } from './add-money-by-mobile/add-money-by-mobile.component';
import { MainpageComponent } from './mainpage/mainpage.component';
import { PayMoneyUsingMobileComponent } from './pay-money-using-mobile/pay-money-using-mobile.component';
import { PayMoneyUsingAccountComponent } from './pay-money-using-account/pay-money-using-account.component';
import { WithdrawMoneyComponent } from './withdraw-money/withdraw-money.component';
import { RouteGuard } from './service/RouteGuard';

const routes: Routes = [
  {path:"",component:LoginUserComponent},
  {path:"login",component:LoginUserComponent},
  {path:"signup",component:CreateUserComponent},
  {path:"addMoneyByCard",component:AddMoneyByCardComponent,canActivate:[RouteGuard]},
  {path:"addMoneyByMobile",component:AddMoneyByMobileComponent,canActivate:[RouteGuard]},
  {path:"mainPage",component:MainpageComponent,canActivate:[RouteGuard]},
  {path:"payMoneyByMobile",component:PayMoneyUsingMobileComponent,canActivate:[RouteGuard]},
  {path:"payMoneyByAccount",component:PayMoneyUsingAccountComponent,canActivate:[RouteGuard]},
  {path:"withdraw",component:WithdrawMoneyComponent,canActivate:[RouteGuard]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
