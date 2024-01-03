import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { SendService } from '../send.service';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-send',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './send.component.html',
  styleUrl: './send.component.css'
})
export class SendComponent {
  sendService: SendService
  target: string
  amount: number
  username: string

  constructor(sendService: SendService){
    this.target = ""
    this.amount = 0
    this.sendService = sendService;
    let something = document.cookie.split(';')
   
    let somethingElse = something[0].split("=")
    console.log("Cookie?", somethingElse[1]);
    this.username = somethingElse[1];
  }

  submitSend(){
    this.sendService.sendMoney(this.target, this.amount, this.username)
    .subscribe({
      next: (data) => {
        alert("Money Sent!")
        console.log(data)
      },
      error: (error:HttpErrorResponse) => {
        alert("Money not Sent.")
        console.log(error.error)
      }
    })
  }
}
