import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StudentNaGodiniFormComponent } from './student-na-godini-form.component';

describe('StudentNaGodiniFormComponent', () => {
  let component: StudentNaGodiniFormComponent;
  let fixture: ComponentFixture<StudentNaGodiniFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StudentNaGodiniFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StudentNaGodiniFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
