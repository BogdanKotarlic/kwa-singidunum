import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IshodFormComponent } from './ishod-form.component';

describe('IshodFormComponent', () => {
  let component: IshodFormComponent;
  let fixture: ComponentFixture<IshodFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ IshodFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(IshodFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
