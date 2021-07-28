import { Injectable } from '@angular/core';
import { Observable,throwError } from 'rxjs';
import {catchError} from "rxjs/operators"
import {HttpClient,HttpErrorResponse,HttpHeaders} from '@angular/common/http';
import { Exchange } from '../models/Exchange';
import { Company } from '../models/Company';

const httpOptions={
  headers: new HttpHeaders({'Content-Type': 'application/json'})
}

@Injectable({
  providedIn: 'root'
})
export class ExchangeService {
  url:string="http://localhost:9191/stockexchange/";
  constructor(private http:HttpClient) {

   }
  getExchanges():Observable<Exchange[]>{
    return this.http.get<Exchange[]>(this.url,httpOptions);
  }
  getExchange(id:string):Observable<Exchange>{
    return this.http.get<Exchange>(this.url,httpOptions);
  }
  addexchange(exchange:Exchange){
    this.http.post(this.url,JSON.stringify(exchange),httpOptions);
  }
  getCompany(id:string):Observable<Company>{
    return this.http.get<Company>(this.url+id+"/company",httpOptions);
  }
  

  
}
