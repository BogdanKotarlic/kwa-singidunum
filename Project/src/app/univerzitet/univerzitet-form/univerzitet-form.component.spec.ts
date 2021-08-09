import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UniverzitetFormComponent } from './univerzitet-form.component';

describe('UniverzitetFormComponent', () => {
  let component: UniverzitetFormComponent;
  let fixture: ComponentFixture<UniverzitetFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UniverzitetFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UniverzitetFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
