# IntelliLoan — Intelligent Loan Lifecycle Management Platform

## Architecture
- **Frontend**: Angular 21 Micro Frontend architecture using Native Federation
- **Backend**: Spring Boot 3.3 multi-module Maven project (in progress)
- **Database**: Oracle 23c + Redis cache
- **Messaging**: Apache Kafka
- **AI**: RAG-based document intelligence (coming soon)

## Frontend Structure
| App | Port | Type | Description |
|-----|------|------|-------------|
| shell | 4200 | Host | Main application shell |
| loan-app-mfe | 4201 | Remote | Loan application and dashboard |
| officer-mfe | 4202 | Remote | Officer review dashboard (coming soon) |
| admin-mfe | 4203 | Remote | Admin panel (coming soon) |

## Running Locally

### Infrastructure
```bash
docker-compose up oracle-db redis kafka zookeeper -d
```

### Frontend
```bash
cd frontend/intelliload-workspace
ng serve loan-app-mfe --port 4201   # Terminal 1
ng serve shell --port 4200           # Terminal 2
```

## Phase Progress
- [x] Phase 1 — Foundation, monorepo setup, Docker infrastructure
- [x] Phase 2 — Native Federation MFE architecture
- [ ] Phase 3 — Spring Boot backend + JWT auth
- [ ] Phase 4 — Core loan domain
- [ ] Phase 5 — AI/RAG integration
- [ ] Phase 6 — DevOps, CI/CD, Docker
- [ ] Phase 7 — Multirepo migration