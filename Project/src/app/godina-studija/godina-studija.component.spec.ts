import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GodinaStudijaComponent } from './godina-studija.component';

describe('GodinaStudijaComponent', () => {
  let component: GodinaStudijaComponent;
  let fixture: ComponentFixture<GodinaStudijaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GodinaStudijaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GodinaStudijaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
