// projects/shell/src/app/app.routes.ts
import { Routes } from '@angular/router';
import { loadRemoteModule } from '@angular-architects/native-federation';

export const routes: Routes = [
  {
    path: '',
    redirectTo: 'home',
    pathMatch: 'full'
  },
  {
    path: 'home',
    loadComponent: () =>
      import('./pages/home/home.component')
        .then(m => m.HomeComponent)
  },
  {
    path: 'loans',
    loadChildren: () =>
      loadRemoteModule('loan-app-mfe', './Routes')
        .then(m => m.routes)
  },
  {
    path: '**',
    redirectTo: 'home'
  }
];