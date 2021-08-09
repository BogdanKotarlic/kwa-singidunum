import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ZvanjeDetailsComponent } from './zvanje-details.component';

describe('ZvanjeDetailsComponent', () => {
  let component: ZvanjeDetailsComponent;
  let fixture: ComponentFixture<ZvanjeDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ZvanjeDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ZvanjeDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
