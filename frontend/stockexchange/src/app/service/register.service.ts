import { Injectable } from '@angular/core';
import {User} from '../models/User';
import { Observable,throwError } from 'rxjs';
import {catchError} from "rxjs/operators"
import {HttpClient,HttpErrorResponse,HttpHeaders} from '@angular/common/http';

const httpOptions={
  headers: new HttpHeaders({'Content-Type': 'application/json'})
}
@Injectable({
  providedIn: 'root'
})
export class RegisterService {
  registerUrl:string="http://localhost:9197/user/";
 

  constructor(private http: HttpClient) {


   }
  getUsers():Observable<User[]>{
       return this.http.get<User[]>(this.registerUrl); 
   }
  registerUser(user:User) {  
  this.http.post<User>(this.registerUrl,JSON.stringify(user),httpOptions).subscribe(response=>console.log(response));
  }
  getUser(id:string):Observable<User>{
    return this.http.get<User>(this.registerUrl+id,httpOptions);
  }
  deletUser(id:string){
    this.http.delete(this.registerUrl+id,httpOptions);
  }
  updateUser(id:string,user:User){
    this.http.put(this.registerUrl+id,JSON.stringify(user),httpOptions);
  }
  // private handleError(error: HttpErrorResponse) {
  //   if (error.status === 0) {
  
  //     console.error('An error occurred:', error.error);
  //   } else {
  //     console.error(
  //       `Backend returned code ${error.status}, body was: `, error.error);
  //   }
  //   return throwError(
  //     'Something bad happened; please try again later.');
  // }
}
