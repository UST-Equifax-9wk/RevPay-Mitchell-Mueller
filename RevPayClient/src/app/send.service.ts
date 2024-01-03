import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SendService {
  baseurl = 'http://localhost:8080/personal_users/'
  httpClient: HttpClient;
  httpOptions = {
    observe: 'response',
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }
  constructor(httpClient: HttpClient) {
    alert("working")
    this.httpClient = httpClient;
   }

   //send money
  sendMoney(target: String, amount: number, username: string): Observable<HttpResponse<Object>> {
  return this.httpClient.post(this.baseurl + username + '/send' +'/'+target+'/'+amount, 
    JSON.stringify(target), 
    {
      observe: 'response',
      withCredentials: true,
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    })
}

}
export interface Target{
  username : string;
  amount : number;

}
