import { Injectable } from '@angular/core';
import { Observable,throwError } from 'rxjs';
import {catchError} from "rxjs/operators"
import {HttpClient,HttpErrorResponse,HttpHeaders} from '@angular/common/http';
import { Company } from '../models/Company';
import { Ipo } from '../models/Ipo';
import { Stock } from '../models/Stock';
import {TimeSearch} from '../models/TimeSearch'

const httpOptions={
  headers: new HttpHeaders({'Content-Type': 'application/json'})
}
@Injectable({
  providedIn: 'root'
})
export class CompanyService {
  url:string="http://localhost:9192/company/"
  url2:string="http://localhost:9192/company/ipo/"
  constructor(private http:HttpClient) { }
  getCompanies():Observable<Company[]>{
    return this.http.get<Company[]>(this.url,httpOptions);
  }
  getCompany(id:string):Observable<Company>{
    return this.http.get<Company>(this.url+id,httpOptions);
  }
  addCompany(company:Company){
    return this.http.post<Company>(this.url,JSON.stringify(company),httpOptions);
  }
  deleteCompany(id:string){
    this.http.delete(this.url+id,httpOptions);
  }
  searchCompany(key:string){
    this.http.get(this.url+"search/"+key,httpOptions);
  }
  getCompanyprice(id:string,time:TimeSearch):Observable<Stock[]>{
    return this.http.post<Stock[]>(this.url+id+"/price",JSON.stringify(time),httpOptions);
  }
  getIpos():Observable<Ipo[]>{
    return this.http.get<Ipo[]>(this.url2,httpOptions);
  }
  getIpo(id:string):Observable<Ipo>{
    return this.http.get<Ipo>(this.url2+id,httpOptions);
  }
  addIpo(ipo:Ipo){
    this.http.post<Ipo>(this.url2,JSON.stringify(ipo),httpOptions);
  }
 deleteIpo(id:string){
    this.http.delete(this.url2+id,httpOptions);
 }
  getByCompanyId(companyId:string):Observable<Ipo>{
      return this.http.get<Ipo>(this.url2+"company/"+companyId,httpOptions);
  }
}
