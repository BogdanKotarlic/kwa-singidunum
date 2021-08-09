import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IshodDetailsComponent } from './ishod-details.component';

describe('IshodDetailsComponent', () => {
  let component: IshodDetailsComponent;
  let fixture: ComponentFixture<IshodDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ IshodDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(IshodDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
