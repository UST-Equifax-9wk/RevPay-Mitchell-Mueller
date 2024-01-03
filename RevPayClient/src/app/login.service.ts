import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  baseurl = 'http://localhost:8080/login'
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

  
  

  //LOGIN PERSONAL USER
  login(user: PersonalUser): Observable<HttpResponse<Object>> {
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

  checkUser(username: string): Observable<Object>{
    return this.httpClient.get('http://localhost:8080/personal_users/' + username)
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

export interface PersonalUser{
  username : string;
  password : string;

}

