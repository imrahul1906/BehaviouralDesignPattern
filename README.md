# Why Chain of Responsibility
- when you need to delegate a request to one of many classes
- when you have to process a request in a predefined sequence
 
# Chain of Responsibility – Design Problems and Solutions

This project demonstrates how the **Chain of Responsibility** pattern improves the design of a ticket handling system in Java. Below, each original design problem is described along with how the pattern resolves it in your refactored implementation.

---

## ✅ 1. Tight Coupling Between `TicketManager` and Team Classes

**Original Problem:**  
Hardcoded `if-else` statements in `getTeam()` tightly coupled `TicketManager` with all specific team classes.

**Current Solution:**  
You moved the routing logic to `setupChain()`, where the chain of responsibility is wired up once. Now, `TicketManager` only holds a reference to the head of the chain (`mChain`).

**Is it resolved?**  
✔️ **Partially resolved.**

- `TicketManager` no longer decides which team handles which priority.
- The logic-based coupling (`if-else`) is removed, but class references remain inside `setupChain()`.

**Further Decoupling (optional):**
- Move `setupChain()` to a separate `TeamChainFactory`, or
- Load the chain from configuration or a service registry.

For most use cases, this level of decoupling is sufficient and idiomatic.

---

## ✅ 2. No Flexibility or Extensibility

**Original Problem:**  
Routing logic was hardcoded based only on priority. If you wanted to route tickets based on SLA, tags, or content, you’d have to rewrite `getTeam()`.

**Current Solution:**  
Each `Team` (handler) now checks `ticket.getPriority()` in its own `canHandle()` or `handleTicket()` method.

**Is it resolved?**  
✔️ **Yes, and extensible.**

- You can easily add richer routing logic inside each `Team`, such as:
    ```java
    if (ticket.getTags().contains("urgent")) { ... }
    ```
- Introducing new handlers with custom logic is now possible without changing `TicketManager`.
- The routing decision is encapsulated within the team classes, not centralized.

---

## ✅ 3. No Abstraction Over Handling Process

**Original Problem:**  
Every team was assumed to be able to handle every ticket, and there was no delegation or abstraction for filtering.

**Current Solution:**  
You now use the **Chain of Responsibility** pattern:

- Each `Team` has a `setNext()` method and holds a reference to the next handler.
- Each team decides if it can handle the ticket, or passes it on to the next handler.

**Is it resolved?**  
✔️ **Fully resolved.**

Now you have:
- **Abstraction:** A `Team` interface.
- **Responsibility Delegation:** Each handler decides if it will process or delegate.
- **Handling Encapsulation:** Each handler encapsulates its own logic.
- **Extensible Pipeline:** Easily introduce additional behaviors (like logging or auditing) in the chain.

---

This refactoring transforms the system into a flexible, extensible, and maintainable solution using the **Chain of Responsibility** pattern.
