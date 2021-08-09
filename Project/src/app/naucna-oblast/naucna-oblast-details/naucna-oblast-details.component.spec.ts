import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NaucnaOblastDetailsComponent } from './naucna-oblast-details.component';

describe('NaucnaOblastDetailsComponent', () => {
  let component: NaucnaOblastDetailsComponent;
  let fixture: ComponentFixture<NaucnaOblastDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NaucnaOblastDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NaucnaOblastDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
