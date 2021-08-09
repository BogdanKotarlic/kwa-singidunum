import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StudentNaGodiniComponent } from './student-na-godini.component';

describe('StudentNaGodiniComponent', () => {
  let component: StudentNaGodiniComponent;
  let fixture: ComponentFixture<StudentNaGodiniComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StudentNaGodiniComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StudentNaGodiniComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
