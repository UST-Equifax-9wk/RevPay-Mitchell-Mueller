import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AccountService } from '../account.service';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-account',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './account.component.html',
  styleUrl: './account.component.css'
})
export class AccountComponent {
  accountNumber: string
  type: string
  balance: number
  accountService: AccountService
  username: string

  constructor(accountService: AccountService){
    this.accountNumber = ""
    this.type = ""
    this.balance = 0
    this.accountService = accountService;
    let something = document.cookie.split(';')
   
    let somethingElse = something[0].split("=")
    console.log("Cookie?", somethingElse[1]);
    this.username = somethingElse[1];
  }

  submitAccount(){
    this.accountService.addAccount({accountNumber: this.accountNumber, type: this.type, balance: this.balance}, this.username)
    .subscribe({
      next: (data) => {
        alert("Account Added!")
        console.log(data)
      },
      error: (error:HttpErrorResponse) => {
        alert("Account not Added.")
        console.log(error.error)
      }
    })
  }
}
