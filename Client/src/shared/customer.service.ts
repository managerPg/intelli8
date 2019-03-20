import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs/observable';
import {catchError} from 'rxjs/operators';
import { Vacancies } from './vacancies';


@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private _http:HttpClient) { }


  getVacancyRooms(buildingName:string):Observable<Vacancies[]>{
    return this._http.get<Vacancies[]>("/buildings/"+buildingName+"/rooms")
    .pipe(
      catchError(this.errorHandler)
    );
   }

   errorHandler(error: HttpErrorResponse) {
    console.log(error.status)
    return Observable.throw(error.statusText);
  }
}
