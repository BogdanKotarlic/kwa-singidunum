import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UniverzitetDetailsComponent } from './univerzitet-details.component';

describe('UniverzitetDetailsComponent', () => {
  let component: UniverzitetDetailsComponent;
  let fixture: ComponentFixture<UniverzitetDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UniverzitetDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UniverzitetDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
