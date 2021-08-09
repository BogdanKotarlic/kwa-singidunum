import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PohadjanjePredmetaFormComponent } from './pohadjanje-predmeta-form.component';

describe('PohadjanjePredmetaFormComponent', () => {
  let component: PohadjanjePredmetaFormComponent;
  let fixture: ComponentFixture<PohadjanjePredmetaFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PohadjanjePredmetaFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PohadjanjePredmetaFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
