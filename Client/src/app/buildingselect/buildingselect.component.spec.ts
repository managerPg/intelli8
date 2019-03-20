import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BuildingselectComponent } from './buildingselect.component';

describe('BuildingselectComponent', () => {
  let component: BuildingselectComponent;
  let fixture: ComponentFixture<BuildingselectComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BuildingselectComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BuildingselectComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
