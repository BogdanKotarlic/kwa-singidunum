import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StudentNaGodiniDetailsComponent } from './student-na-godini-details.component';

describe('StudentNaGodiniDetailsComponent', () => {
  let component: StudentNaGodiniDetailsComponent;
  let fixture: ComponentFixture<StudentNaGodiniDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StudentNaGodiniDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StudentNaGodiniDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
