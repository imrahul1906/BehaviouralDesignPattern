## Why State pattern ?
- When you have to show the life cycle of the object
- 
## State Pattern: Ticket System Improvements

This repository demonstrates the application of the State Design Pattern to fix common issues in a ticket management system. Below is a summary of the original problems and their solutions as implemented in this codebase.

---

### ✅ Problem 1: Anyone could set any state manually

**Before:**
```java
ticket.setTicketState(TicketState.CLOSED); // ❌ previously allowed from anywhere
```

**Now:**
- Only `TicketState` subclasses (e.g., `ResolvedState`, `InProgressState`) can change the ticket's internal state.
- External classes (like `TicketManager`) can only trigger transitions via `updateState()` or `closeTicket()`—not by setting the state directly.

**🔒 Encapsulation enforced**  
**Status:** ✅ Solved

---

### ❌ Problem 2: No Enforcement of Valid State Transitions

**Before:**
- Any code could force transitions like `OPEN → CLOSED` by calling `ticket.setTicketState(...)`, even if the transition was invalid.

**Now:**
- `OpenState`, `InProgressState`, `ResolvedState`, and `ClosedState` each define which transitions are valid.
- For example:
    - `ResolvedState.close()` → Allowed
    - `OpenState.close()` → Can log or throw exception (customizable)
    - `ClosedState.updateState()` → Blocked

**🧠 Transition logic is centralized in state classes**  
**Status:** ✅ Solved

---

### ✅ Problem 3: Transition Logic Was Duplicated

**Before:**
```java
ticket.setTicketState(IN_PROGRESS);
ticket.setTicketState(RESOLVED);
// Every team duplicated these lines.
```

**Now:**
- Teams call `ticket.updateState()`, and the current state class decides the next valid state.
- No repetition across clients; transition logic lives in one place.

**🪄 No repetition across clients**  
**Status:** ✅ Solved

---

### ✅ Problem 4: `TicketManager` Assigned State Directly

**Before:**
```java
ticket.setTicketState(TicketState.CLOSED); // ❌ Manager assigned directly
```

**Now:**
- `TicketManager` and other classes only interact via public API:
    ```java
    team.handleTicket(ticket);
    ticket.closeTicket();
    ```
- All state transitions are triggered through `Ticket` methods, not by setting the state directly.

**🧼 Clean separation of concerns**  
**Status:** ✅ Solved
