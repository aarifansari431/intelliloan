// projects/loan-app-mfe/src/app/pages/loan-dashboard/loan-dashboard.component.ts
import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-loan-dashboard',
  standalone: true,
  imports: [CommonModule],
  template: `
    <div class="mfe-wrapper">
      <div class="mfe-badge">loan-app-mfe · port 4201</div>
      <h2>Loan Dashboard</h2>
      <p>
        This component was loaded by the shell at runtime using
        Native Federation. No page refresh occurred.
      </p>
      <p>
        Open DevTools → Network → filter by <code>remoteEntry</code>
        to see the federation handshake.
      </p>
    </div>
  `,
  styles: [`
    .mfe-wrapper {
      padding: 2rem;
      border: 2px dashed #534AB7;
      border-radius: 12px;
      margin: 1.5rem;
      background: #EEEDFE20;
    }
    .mfe-badge {
      display: inline-block;
      font-size: 11px;
      font-weight: 500;
      background: #EEEDFE;
      color: #3C3489;
      padding: 3px 10px;
      border-radius: 20px;
      margin-bottom: 1rem;
    }
    h2 { color: #534AB7; margin: 0 0 0.5rem; }
    code {
      font-family: monospace;
      background: #f0f0f0;
      padding: 1px 5px;
      border-radius: 3px;
    }
  `]
})
export class LoanDashboardComponent {}