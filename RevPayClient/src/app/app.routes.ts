import { Routes } from '@angular/router';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { LandingComponent } from './landing/landing.component';
import { AccountComponent } from './account/account.component';
import { SendComponent } from './send/send.component';

export const routes: Routes = [
    {path: "register", component: RegisterComponent},
    {path: "login", component: LoginComponent},
    {path: "landing", component: LandingComponent},
    {path: "account", component: AccountComponent},
    {path: "send", component: SendComponent}
];
