import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NastavnikNaRealizacijiFormComponent } from './nastavnik-na-realizaciji-form.component';

describe('NastavnikNaRealizacijiFormComponent', () => {
  let component: NastavnikNaRealizacijiFormComponent;
  let fixture: ComponentFixture<NastavnikNaRealizacijiFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NastavnikNaRealizacijiFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NastavnikNaRealizacijiFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
