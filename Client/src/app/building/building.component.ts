import { Component, OnInit } from '@angular/core';
import {FormBuilder, Validators, FormArray, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-building',
  templateUrl: './building.component.html',
  styleUrls: ['./building.component.css']
})
export class BuildingComponent implements OnInit
 {

  constructor(private fb:FormBuilder) { }

  ngOnInit() {
  }

  pushFloorGroup(){
    (<FormArray>this.newBuildingForm.get('floors')).push(this.addFloorGroup());
  }
  pushRoomGroup(floorindex){
    (<FormArray>(<FormArray>this.newBuildingForm.get('floors')).at(floorindex).get('rooms')).push(this.addRoomGroup());
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
    floor:['',Validators.required],
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

showForm(){
  console.log(JSON.stringify(this.newBuildingForm.value));
}


}
