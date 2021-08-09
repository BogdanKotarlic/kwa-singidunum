import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NastavnikNaRealizacijiDetailsComponent } from './nastavnik-na-realizaciji-details.component';

describe('NastavnikNaRealizacijiDetailsComponent', () => {
  let component: NastavnikNaRealizacijiDetailsComponent;
  let fixture: ComponentFixture<NastavnikNaRealizacijiDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NastavnikNaRealizacijiDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NastavnikNaRealizacijiDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
