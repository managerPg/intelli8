import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FirstchildsibilingComponent } from './firstchildsibiling.component';

describe('FirstchildsibilingComponent', () => {
  let component: FirstchildsibilingComponent;
  let fixture: ComponentFixture<FirstchildsibilingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FirstchildsibilingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FirstchildsibilingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
