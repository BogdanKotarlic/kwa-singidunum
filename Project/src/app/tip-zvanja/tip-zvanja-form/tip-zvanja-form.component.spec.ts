import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TipZvanjaFormComponent } from './tip-zvanja-form.component';

describe('TipZvanjaFormComponent', () => {
  let component: TipZvanjaFormComponent;
  let fixture: ComponentFixture<TipZvanjaFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TipZvanjaFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TipZvanjaFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
