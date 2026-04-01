const { withNativeFederation, shareAll } = require('@angular-architects/native-federation/config');

module.exports = withNativeFederation({

  remotes: {
    // Key   = name you use in loadRemoteModule()
    // Value = URL of the remote's remoteEntry.json
    // In development: remote dev server URL
    // In production: this becomes your CDN URL
    'loan-app-mfe': 'http://localhost:4201/remoteEntry.json',
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
