import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PredmetDetailsComponent } from './predmet-details.component';

describe('PredmetDetailsComponent', () => {
  let component: PredmetDetailsComponent;
  let fixture: ComponentFixture<PredmetDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PredmetDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PredmetDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
