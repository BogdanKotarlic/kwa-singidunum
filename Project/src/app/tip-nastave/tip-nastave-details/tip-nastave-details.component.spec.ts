import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TipNastaveDetailsComponent } from './tip-nastave-details.component';

describe('TipNastaveDetailsComponent', () => {
  let component: TipNastaveDetailsComponent;
  let fixture: ComponentFixture<TipNastaveDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TipNastaveDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TipNastaveDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
