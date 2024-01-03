import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  baseurl = 'http://localhost:8080/register'
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

  
  

  //POST NEW PERSONAL USER
  RegisterPersonalUser(user: NewPersonalUser): Observable<HttpResponse<Object>> {
    return this.httpClient.post(this.baseurl, 
      JSON.stringify(user), 
      {
        observe: 'response',
        withCredentials: true,
        headers: new HttpHeaders({
          'Content-Type': 'application/json'
        })
      })
  }

  // // Error handling
  // errorHandl(error: any) {
  //   let errorMessage = '';
  //   if(error.error instanceof ErrorEvent) {
  //     // Get client-side error
  //     errorMessage = error.error.message;
  //   } else {
  //     // Get server-side error
  //     errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
  //   }
  //   console.log(errorMessage);
  //   return throwError(errorMessage);
  // }
}

export interface NewPersonalUser{
  username : string;
  password : string;
  email : string;
}
