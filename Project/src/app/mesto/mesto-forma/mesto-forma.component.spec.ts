import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MestoFormaComponent } from './mesto-forma.component';

describe('MestoFormaComponent', () => {
  let component: MestoFormaComponent;
  let fixture: ComponentFixture<MestoFormaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MestoFormaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MestoFormaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
