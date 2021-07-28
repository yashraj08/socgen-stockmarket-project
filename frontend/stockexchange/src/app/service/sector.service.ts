import { Injectable } from '@angular/core';
import { Observable,throwError } from 'rxjs';
import {catchError} from "rxjs/operators"
import {HttpClient,HttpErrorResponse,HttpHeaders} from '@angular/common/http';
import { Sector } from '../models/Sector';
import { TimeSearch } from '../models/TimeSearch'; 

const httpOptions={
  headers: new HttpHeaders({'Content-Type': 'application/json'})
}

@Injectable({
  providedIn: 'root'
})
export class SectorService {
  url:string="http://localhost:9193/sector/"
  constructor(private http:HttpClient) { }
  getSectors():Observable<Sector[]>{
    return this.http.get<Sector[]>(this.url,httpOptions);
  }
  getSector(id:String):Observable<Sector>{
    return this.http.get<Sector>(this.url+id,httpOptions);
  }
  addSector(sector:Sector){
    return this.http.post<Sector>(this.url,JSON.stringify(sector),httpOptions);
  }
  getSectorPrice(id:string,timeSearch:TimeSearch){
    return this.http.post<Sector>(this.url+id+"/price/",JSON.stringify(timeSearch),httpOptions);
  }
}
