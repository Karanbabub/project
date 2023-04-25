import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CPaymentComponent } from './c-payment.component';

describe('CPaymentComponent', () => {
  let component: CPaymentComponent;
  let fixture: ComponentFixture<CPaymentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CPaymentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CPaymentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
