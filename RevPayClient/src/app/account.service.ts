import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AccountService {
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

   //add account
  addAccount(account: PersonalFinancialAccount, username: string): Observable<HttpResponse<Object>> {
  return this.httpClient.post(this.baseurl + username + '/account', 
    JSON.stringify(account), 
    {
      observe: 'response',
      withCredentials: true,
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    })
}
}

export interface PersonalFinancialAccount{
  accountNumber: string
  type: string
  balance: number
}
