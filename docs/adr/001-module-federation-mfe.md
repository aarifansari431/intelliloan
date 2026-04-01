# ADR-001: Micro Frontend Architecture using Module Federation

## Status
Accepted

## Context
IntelliLoan serves three distinct user personas: borrowers, loan officers, and admins.
Each persona has different release frequency requirements. The borrower portal receives
weekly UI updates driven by product feedback. The officer dashboard is updated monthly
with workflow changes. The admin panel is quarterly. A monolithic SPA would mean all
teams deploy together, creating a bottleneck.

## Decision
We will use Angular Module Federation (via @angular-architects/module-federation) to
decompose the frontend into independently deployable micro frontends. The shell app
acts as the host and loads remote MFEs at runtime via dynamic imports.

## Consequences
✅ Independent deployability per team
✅ Smaller bundle sizes per MFE (faster load per persona)
✅ Technology version flexibility (each MFE can upgrade Angular independently)
❌ Shared library versioning complexity (mitigated by shared singleton pattern)
❌ Initial setup overhead
❌ Cross-MFE communication requires discipline (we use NgRx and custom events)

## Alternatives Considered
- Single Angular SPA with feature modules: rejected due to deployment coupling
- iframes: rejected due to poor UX and communication complexity
- Web Components: considered for future phase but Module Federation gives us more
  Angular-native tooling today
```

---

## Your Deliverable for Today

By end of Day 1 you should be able to run `git log` and see these commits:
```
chore: initialize repository with .gitignore
docs: add high-level architecture documentation
chore: create project folder structure
feat(infra): add Docker Compose skeleton with Oracle, Redis, Kafka
feat(backend): add parent POM with dependency management
feat(frontend): bootstrap Angular workspace with shell and first MFE
docs: add ADR-001 for Module Federation decision