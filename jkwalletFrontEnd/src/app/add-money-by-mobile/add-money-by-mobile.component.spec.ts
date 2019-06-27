import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddMoneyByMobileComponent } from './add-money-by-mobile.component';

describe('AddMoneyByMobileComponent', () => {
  let component: AddMoneyByMobileComponent;
  let fixture: ComponentFixture<AddMoneyByMobileComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddMoneyByMobileComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddMoneyByMobileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
