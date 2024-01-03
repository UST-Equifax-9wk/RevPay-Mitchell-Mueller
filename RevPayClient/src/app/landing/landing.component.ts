import { Component } from '@angular/core';

@Component({
  selector: 'app-landing',
  standalone: true,
  imports: [],
  templateUrl: './landing.component.html',
  styleUrl: './landing.component.css'
})
export class LandingComponent {
  constructor(){
    let something = document.cookie.split(';')
   
    let somethingElse = something[0].split("=")
    console.log("On landing")
    console.log("Cookie?", somethingElse[1]);
    alert(somethingElse[1]);
  }
}
