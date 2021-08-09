import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TipNastaveComponent } from './tip-nastave.component';

describe('TipNastaveComponent', () => {
  let component: TipNastaveComponent;
  let fixture: ComponentFixture<TipNastaveComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TipNastaveComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TipNastaveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
