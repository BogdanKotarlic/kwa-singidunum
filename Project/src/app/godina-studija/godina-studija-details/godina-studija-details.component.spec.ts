import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GodinaStudijaDetailsComponent } from './godina-studija-details.component';

describe('GodinaStudijaDetailsComponent', () => {
  let component: GodinaStudijaDetailsComponent;
  let fixture: ComponentFixture<GodinaStudijaDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GodinaStudijaDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GodinaStudijaDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
