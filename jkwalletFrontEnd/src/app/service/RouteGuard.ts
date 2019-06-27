import { CanActivate,ActivatedRouteSnapshot,RouterStateSnapshot, Router} from '@angular/router';
import { LoginStatus } from './LoginStatus';
import { Injectable } from '@angular/core';


@Injectable({
    providedIn:'root'
})
export class RouteGuard implements CanActivate{

    constructor(private loginStatus:LoginStatus,private router:Router){

    }

    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot){
        if(this.loginStatus.isUserLoggedIn()) return true;
        this.router.navigate(['login']);
        return false;
    }
}
