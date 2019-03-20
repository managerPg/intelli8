import { Component, OnInit } from '@angular/core';
import { NgbDateStruct } from '@ng-bootstrap/ng-bootstrap';
import {FormBuilder, Validators, FormArray, FormGroup} from '@angular/forms';
import { BuildingService } from 'src/shared/building.service';

@Component({
  selector: 'app-building',
  templateUrl: './building.component.html',
  styleUrls: ['./building.component.css']
})
export class BuildingComponent implements OnInit
 {
  model: NgbDateStruct;

  constructor(private fb:FormBuilder, private _buildingService:BuildingService) { }

  ngOnInit() {
  }

  get buildingName(){
    return this.newBuildingForm.get('buildingName');
  }
  
  get buildingAdress(){
    return this.newBuildingForm.get('buildingAdress');
  }
  
  get buildingOwner(){
    return this.newBuildingForm.get('buildingOwner');
  }
 
newBuildingForm = this.fb.group({
  buildingName:['',Validators.required],
  buildingAdress:['',Validators.required],
  buildingOwner:['',Validators.required],
  floors:this.fb.array([
    this.addFloorGroup()
  ])
});

addFloorGroup():FormGroup{
  return this.fb.group({
    floorNumber:['',Validators.required],
    rooms:this.fb.array([
      this.addRoomGroup()
    ])
  })
}

addRoomGroup():FormGroup{
 return this.fb.group({
    roomNumber:['',Validators.required],
    roomCapacity:['',Validators.required],
    vacancies:['',Validators.required]
  })
}

get floors(){
  return <FormArray>this.newBuildingForm.get('floors');
}
get rooms(){
return (<FormArray>this.newBuildingForm.get('rooms'));
}

 
pushFloorGroup(){
  (<FormArray>this.newBuildingForm.get('floors')).push(this.addFloorGroup());
}
pushRoomGroup(floorIndex){
  (<FormArray>(<FormArray>this.newBuildingForm.get('floors')).at(floorIndex).get('rooms')).push(this.addRoomGroup());
}
popFloorGroup(floorIndex){
  (<FormArray>this.newBuildingForm.get('floors')).removeAt(floorIndex);
}

popRoomGroup(floorIndex,roomIndex){
  console.log("Room Index is"+roomIndex);
 (<FormArray>(<FormArray>this.newBuildingForm.get('floors')).at(floorIndex).get('rooms')).removeAt(roomIndex);
}

submitForm(){
  console.log(JSON.stringify(this.newBuildingForm.value));
  this._buildingService.insertBuilding(JSON.stringify(this.newBuildingForm.value)).subscribe(
    (error)=> console.log("Please check the URL")
  );

}


}
