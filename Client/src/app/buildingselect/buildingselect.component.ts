import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-buildingselect',
  templateUrl: './buildingselect.component.html',
  styleUrls: ['./buildingselect.component.css']
})
export class BuildingselectComponent implements OnInit {

  public buildings:string[] =['sapthagiri Avani', 'sapthagiri samrudi', 'samyathi Heights', 'Brigade Apartments']; 
  public buildingName:string;
  constructor(private _router:Router) { }

  
  ngOnInit() {
    
  }

  showBuildingDetails(building){
    console.log("The Name of the building is : "+building.value);
    this._router.navigate(['/building',building.value])
    this.buildingName=building.value;
  }

}
