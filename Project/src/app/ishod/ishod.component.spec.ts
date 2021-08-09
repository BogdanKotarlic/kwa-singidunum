import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IshodComponent } from './ishod.component';

describe('IshodComponent', () => {
  let component: IshodComponent;
  let fixture: ComponentFixture<IshodComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ IshodComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(IshodComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
