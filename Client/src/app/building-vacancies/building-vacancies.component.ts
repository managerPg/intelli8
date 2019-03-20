import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { VacancyService } from 'src/shared/vacancy.service';
import { Vacancies } from 'src/shared/vacancies';



@Component({
  selector: 'app-building-vacancies',
  templateUrl: './building-vacancies.component.html',
  styleUrls: ['./building-vacancies.component.css']
})
export class BuildingVacanciesComponent implements OnInit {

  private buildingName:string;
  private vacancies : Vacancies[];
  private errorMessage:String;
  constructor(private _route:ActivatedRoute,private _vacancyserv:VacancyService) { }

 ngOnInit(){

   console.log("Activated ROute Building Name :" + this._route.snapshot.paramMap.get('buildingName'));
   this.buildingName=this._route.snapshot.paramMap.get('buildingName');

 this._vacancyserv.getVacancyRooms(this.buildingName).subscribe(
   (vacancyObj)=>this.vacancies=vacancyObj,
   (error)=> this.errorMessage=error
   );
 }

}
