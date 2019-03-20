import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BuildingVacanciesComponent } from './building-vacancies.component';

describe('BuildingVacanciesComponent', () => {
  let component: BuildingVacanciesComponent;
  let fixture: ComponentFixture<BuildingVacanciesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BuildingVacanciesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BuildingVacanciesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
