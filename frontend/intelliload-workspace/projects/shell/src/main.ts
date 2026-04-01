// projects/shell/src/main.ts
import { initFederation } from '@angular-architects/native-federation';

// initFederation loads the remoteEntry.json files from all remotes
// BEFORE bootstrapping the Angular app
// This ensures all remote modules are registered in the federation registry
// before any lazy route tries to load them
initFederation({
  'loan-app-mfe': 'http://localhost:4201/remoteEntry.json',
})
  .catch(err => console.error('Federation init error:', err))
  .then(() => import('./bootstrap'))
  .catch(err => console.error('Bootstrap error:', err));