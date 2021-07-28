import { Injectable } from '@angular/core';
import { Observable,throwError } from 'rxjs';
import {catchError} from "rxjs/operators"
import {HttpClient,HttpErrorResponse,HttpHeaders} from '@angular/common/http';
import { Login } from '../models/Login';
import {Router} from '@angular/router';


const httpOptions={
  headers: new HttpHeaders({'Content-Type': 'application/json'})
}
@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private currentUser:Login;
  url:string="http://localhost:9196/auth/login";
  constructor(private http:HttpClient,private route:Router ) {
    this.currentUser={
      username:"",
      password:"",
      role:"unauthorised"

    }
   }
  loginUser(login:Login){
      this.currentUser=login;
      this.currentUser.role="User";
  return this.http.post<Login>(this.url,JSON.stringify(login),httpOptions).subscribe(response=>{this.route.navigate(['/company'])});
  }
}
