import { Component } from '@angular/core';
import { LoginService } from '../login.service';
import { HttpErrorResponse } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule,
  CommonModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  username: string
  password: string
  loginService: LoginService

  constructor(loginService: LoginService) {
    this.username = ""
    this.password = ""
    this.loginService = loginService;
    let something = document.cookie.split(';')
   
    let somethingElse = something[0].split("=")
    console.log("Cookie?", somethingElse[1]);
    this.loginService.checkUser(somethingElse[1])
    .subscribe({
      next: (data) => {
        alert("User Exists")
        window.location.replace("landing")
        console.log(data)
      },
      error: (error:HttpErrorResponse) => {
        alert("Cookie Error")
        console.log(error.error)
      }
    })
    //window.location.replace("landing")
  


    
  
  }


  submitLogin() {
    this.loginService.login({username: this.username, password: this.password})
    .subscribe({
      next: (data) => {
        alert("Access Granted!")
        window.location.replace("landing")
        console.log(data)
      },
      error: (error:HttpErrorResponse) => {
        alert("Access Denied")
        console.log(error.error)
      }
    })
  }
}
