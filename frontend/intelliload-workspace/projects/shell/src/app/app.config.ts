import { ApplicationConfig } from '@angular/core';
import { provideRouter } from '@angular/router';
import { routes } from './app.routes';
import { initFederation } from '@angular-architects/native-federation';

export const appConfig: ApplicationConfig = {
  providers: [
    provideRouter(routes)
  ]
};