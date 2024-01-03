import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RegisterService, NewPersonalUser } from '../register.service';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {
  
  register: RegisterService;
  constructor(register: RegisterService){
    this.email = "";
    this.username = "";
    this.password = "";
    this.register = register;
  }

  email: string;
  username: string;
  password: string;
  

  submitRegistration() {
    console.log("submitting registration.")
    let newUser: NewPersonalUser = {
      username: this.username,
      password: this.password,
      email: this.email
    }
    this.register.RegisterPersonalUser(newUser).subscribe({
      next: (data) => {
        alert("User registered!")
        console.log(data)
      },
      error: (error: HttpErrorResponse) => {
        alert("Couldn't Register")
        console.log(error.error)
      }
    })
  }
}
