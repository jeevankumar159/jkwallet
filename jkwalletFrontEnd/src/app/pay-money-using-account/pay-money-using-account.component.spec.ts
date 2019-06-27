import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PayMoneyUsingAccountComponent } from './pay-money-using-account.component';

describe('PayMoneyUsingAccountComponent', () => {
  let component: PayMoneyUsingAccountComponent;
  let fixture: ComponentFixture<PayMoneyUsingAccountComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PayMoneyUsingAccountComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PayMoneyUsingAccountComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
