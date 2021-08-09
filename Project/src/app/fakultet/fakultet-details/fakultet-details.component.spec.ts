import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FakultetDetailsComponent } from './fakultet-details.component';

describe('FakultetDetailsComponent', () => {
  let component: FakultetDetailsComponent;
  let fixture: ComponentFixture<FakultetDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FakultetDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FakultetDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
