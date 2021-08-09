import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NaucnaOblastFormComponent } from './naucna-oblast-form.component';

describe('NaucnaOblastFormComponent', () => {
  let component: NaucnaOblastFormComponent;
  let fixture: ComponentFixture<NaucnaOblastFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NaucnaOblastFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NaucnaOblastFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
