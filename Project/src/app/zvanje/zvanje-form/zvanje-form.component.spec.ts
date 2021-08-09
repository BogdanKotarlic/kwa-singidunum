import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ZvanjeFormComponent } from './zvanje-form.component';

describe('ZvanjeFormComponent', () => {
  let component: ZvanjeFormComponent;
  let fixture: ComponentFixture<ZvanjeFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ZvanjeFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ZvanjeFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
