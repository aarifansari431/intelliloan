const { withNativeFederation, shareAll } = require('@angular-architects/native-federation/config');

module.exports = withNativeFederation({
  name: 'loan-app-mfe',

  exposes: {
    // Key   = the import path the shell will use
    // Value = the actual file to expose
    // We expose routes, not a component — cleaner and more flexible
    './Routes': './projects/loan-app-mfe/src/app/app.routes.ts',
  },

  shared: {
    ...shareAll({ singleton: true, strictVersion: false, requiredVersion: 'auto' }),
  },

  skip: [
    'rxjs/ajax',
    'rxjs/fetch',
    'rxjs/testing',
    'rxjs/webSocket',
    // Add further packages you don't need at runtime
    'auth-lib',
    'models',
    'ui-components',
    '@angular/animations/browser',
    '@angular/animations',
    '@angular/platform-browser/animations',
    '@angular/platform-browser/animations/async',
  ],

  // Please read our FAQ about sharing libs:
  // https://shorturl.at/jmzH0
});
