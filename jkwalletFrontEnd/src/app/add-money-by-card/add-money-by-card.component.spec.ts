import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddMoneyByCardComponent } from './add-money-by-card.component';

describe('AddMoneyByCardComponent', () => {
  let component: AddMoneyByCardComponent;
  let fixture: ComponentFixture<AddMoneyByCardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddMoneyByCardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddMoneyByCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
