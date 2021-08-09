import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdresaDetailsComponent } from './adresa-details.component';

describe('AdresaDetailsComponent', () => {
  let component: AdresaDetailsComponent;
  let fixture: ComponentFixture<AdresaDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdresaDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdresaDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
