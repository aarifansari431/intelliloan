import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoanDashboardComponent } from './loan-dashboard.component';

describe('LoanDashboardComponent', () => {
  let component: LoanDashboardComponent;
  let fixture: ComponentFixture<LoanDashboardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [LoanDashboardComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(LoanDashboardComponent);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
