import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StudijskiProgramDetailsComponent } from './studijski-program-details.component';

describe('StudijskiProgramDetailsComponent', () => {
  let component: StudijskiProgramDetailsComponent;
  let fixture: ComponentFixture<StudijskiProgramDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StudijskiProgramDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StudijskiProgramDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
