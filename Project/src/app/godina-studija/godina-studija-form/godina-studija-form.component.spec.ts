import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GodinaStudijaFormComponent } from './godina-studija-form.component';

describe('GodinaStudijaFormComponent', () => {
  let component: GodinaStudijaFormComponent;
  let fixture: ComponentFixture<GodinaStudijaFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GodinaStudijaFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GodinaStudijaFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
