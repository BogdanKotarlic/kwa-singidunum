import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdresaFormComponent } from './adresa-form.component';

describe('AdresaFormComponent', () => {
  let component: AdresaFormComponent;
  let fixture: ComponentFixture<AdresaFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdresaFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdresaFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
