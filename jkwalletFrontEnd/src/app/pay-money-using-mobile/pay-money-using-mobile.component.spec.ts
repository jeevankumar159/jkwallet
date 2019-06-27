import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PayMoneyUsingMobileComponent } from './pay-money-using-mobile.component';

describe('PayMoneyUsingMobileComponent', () => {
  let component: PayMoneyUsingMobileComponent;
  let fixture: ComponentFixture<PayMoneyUsingMobileComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PayMoneyUsingMobileComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PayMoneyUsingMobileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
