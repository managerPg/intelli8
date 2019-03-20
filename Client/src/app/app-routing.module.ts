import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BuildingComponent } from './building/building.component';
import { TestingComponent } from './testing/testing.component';
import { FirstchildComponent } from './firstchild/firstchild.component';
import { SecondchildComponent } from './secondchild/secondchild.component';
import { FirstchildsibilingComponent } from './firstchildsibiling/firstchildsibiling.component';
import { BuildingselectComponent } from './buildingselect/buildingselect.component';
import { BuildingVacanciesComponent } from './building-vacancies/building-vacancies.component';

const routes: Routes = [
 {
   path:'test',component:TestingComponent,
 children:[  
    {     path:'firstchild',
     component:FirstchildComponent,
    children:[      {
        path:'secondchild',
        component:SecondchildComponent
      }  ]
  },
  {
  path:'firstchildsibiling',
  component:FirstchildsibilingComponent
  }
]
},
{path:'NewBuilding', component:BuildingComponent},
{path:'building', component:BuildingselectComponent,
children:[
  {
    path:':buildingName',component:BuildingVacanciesComponent
  }
]
},
{path:'',redirectTo:'/building', pathMatch:'full'}

];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
