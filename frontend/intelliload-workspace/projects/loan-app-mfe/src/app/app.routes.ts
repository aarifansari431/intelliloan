import { Routes } from '@angular/router';

export const routes: Routes = [
  {
    path: '',
    loadComponent: () =>
      import('./pages/loan-dashboard/loan-dashboard.component')
        .then(m => m.LoanDashboardComponent)
  }
];