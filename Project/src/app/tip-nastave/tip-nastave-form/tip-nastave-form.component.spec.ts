import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TipNastaveFormComponent } from './tip-nastave-form.component';

describe('TipNastaveFormComponent', () => {
  let component: TipNastaveFormComponent;
  let fixture: ComponentFixture<TipNastaveFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TipNastaveFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TipNastaveFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
