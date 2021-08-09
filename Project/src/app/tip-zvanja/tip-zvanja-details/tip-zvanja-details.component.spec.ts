import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TipZvanjaDetailsComponent } from './tip-zvanja-details.component';

describe('TipZvanjaDetailsComponent', () => {
  let component: TipZvanjaDetailsComponent;
  let fixture: ComponentFixture<TipZvanjaDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TipZvanjaDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TipZvanjaDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
