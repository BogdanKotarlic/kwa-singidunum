import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NastavnikDetailsComponent } from './nastavnik-details.component';

describe('NastavnikDetailsComponent', () => {
  let component: NastavnikDetailsComponent;
  let fixture: ComponentFixture<NastavnikDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NastavnikDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NastavnikDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
