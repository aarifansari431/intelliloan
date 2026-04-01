// projects/shell/src/app/pages/home/home.component.ts
import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [RouterLink],
  template: `
    <div class="home-wrapper">
      <div class="brand">
        <h1>IntelliLoan</h1>
        <span class="tagline">Intelligent Loan Lifecycle Management</span>
      </div>
      <nav class="nav-links">
        <a routerLink="/home" class="nav-item active">Home</a>
        <a routerLink="/loans" class="nav-item">
          Loan Application
          <span class="mfe-tag">MFE</span>
        </a>
      </nav>
      <p class="hint">
        Click "Loan Application" — watch the Network tab in DevTools.
        You will see the shell fetch remoteEntry.json from port 4201.
      </p>
    </div>
  `,
  styles: [`
    .home-wrapper { padding: 2rem; max-width: 600px; }
    .brand h1 { font-size: 2rem; color: #534AB7; margin: 0; }
    .tagline { color: #888; font-size: 0.9rem; }
    .nav-links { display: flex; gap: 1rem; margin-top: 2rem; }
    .nav-item {
      padding: 0.5rem 1.2rem;
      border-radius: 8px;
      text-decoration: none;
      background: #EEEDFE;
      color: #3C3489;
      font-weight: 500;
      display: flex;
      align-items: center;
      gap: 6px;
    }
    .nav-item:hover { background: #CECBF6; }
    .mfe-tag {
      font-size: 10px;
      background: #534AB7;
      color: white;
      padding: 1px 6px;
      border-radius: 4px;
    }
    .hint { margin-top: 1.5rem; font-size: 0.85rem; color: #888; }
  `]
})
export class HomeComponent {}