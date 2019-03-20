import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/observable';
import {catchError} from 'rxjs/operators';
import { Vacancies } from './vacancies';
import { HttpErrorResponse, HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class VacancyService {

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
