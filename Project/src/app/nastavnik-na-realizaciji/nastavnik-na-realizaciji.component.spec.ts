import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NastavnikNaRealizacijiComponent } from './nastavnik-na-realizaciji.component';

describe('NastavnikNaRealizacijiComponent', () => {
  let component: NastavnikNaRealizacijiComponent;
  let fixture: ComponentFixture<NastavnikNaRealizacijiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NastavnikNaRealizacijiComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NastavnikNaRealizacijiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
