import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PohadjanjePredmetaDetailsComponent } from './pohadjanje-predmeta-details.component';

describe('PohadjanjePredmetaDetailsComponent', () => {
  let component: PohadjanjePredmetaDetailsComponent;
  let fixture: ComponentFixture<PohadjanjePredmetaDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PohadjanjePredmetaDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PohadjanjePredmetaDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
