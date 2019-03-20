import { BrowserModule } from '@angular/platform-browser';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule} from '@angular/forms'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BuildingComponent } from './building/building.component';
import { TestingComponent } from './testing/testing.component';
import { FirstchildComponent } from './firstchild/firstchild.component';
import { SecondchildComponent } from './secondchild/secondchild.component';
import { FirstchildsibilingComponent } from './firstchildsibiling/firstchildsibiling.component';
import { BuildingService } from 'src/shared/building.service';
import {FormsModule} from '@angular/forms'
import { HttpClientModule } from '@angular/common/http';
import { BuildingselectComponent } from './buildingselect/buildingselect.component';
import { BuildingVacanciesComponent } from './building-vacancies/building-vacancies.component';

@NgModule({
  declarations: [
    AppComponent,
    BuildingComponent,
    TestingComponent,
    FirstchildComponent,
    SecondchildComponent,
    FirstchildsibilingComponent,
    BuildingselectComponent,
    BuildingVacanciesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    NgbModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
