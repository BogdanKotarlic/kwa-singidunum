import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MestoDetailsComponent } from './mesto-details.component';

describe('MestoDetailsComponent', () => {
  let component: MestoDetailsComponent;
  let fixture: ComponentFixture<MestoDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MestoDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MestoDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
