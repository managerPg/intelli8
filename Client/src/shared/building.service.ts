import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs/observable';
import {catchError} from 'rxjs/operators';
import { Building } from './building';
import 'rxjs/Observable/throw';

const httpOptions={
  headers:new HttpHeaders({
                  'Content-Type':'application/json'
                        }) 
                      } 

@Injectable({
  providedIn: 'root'
})


export class BuildingService {

 private insertUrl = 'buildings';
                  
  constructor(private _http:HttpClient) { }

  insertBuilding(buildingInfo):Observable<Building>{
    console.log("In Insert Building Function");
   return  this._http.post(this.insertUrl,buildingInfo,httpOptions).
   pipe(
    catchError(this.errorHandler)
    );
  }

  
  errorHandler(error:HttpErrorResponse){
    console.log(error.error);
    return Observable.throw("Bad URL Request");
  }
}