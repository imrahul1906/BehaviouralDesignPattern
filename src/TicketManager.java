package src;

import src.teams.*;

public class TicketManager {
    private int mId = 1;
    private final Team mChain;

    TicketManager() {
        mChain = setupChain();
    }

    private Team setupChain() {
        Team lowPriority = new LowPriorityTeam();
        Team midPriority = new MidPriorityTeam();
        Team highPriority = new HighPriorityTeam();
        Team criticalPriority = new CriticalPriorityTeam();

        lowPriority.setNext(midPriority);
        midPriority.setNext(highPriority);
        highPriority.setNext(criticalPriority);

        return lowPriority;
    }

    public static void main(String... args) {
        TicketManager manager = new TicketManager();

        // Create a Ticker
        Ticket ticket = manager.createTicket();

        // Assign priority
        ticket.setPriority(Priority.CRITICAL);

        // Route the ticket handling
        manager.handleTicket(ticket);
        ticket.setTicketState(TicketState.CLOSED);
    }

    private void handleTicket(Ticket ticket) {
        mChain.handleTicket(ticket);
    }

    private Ticket createTicket() {
        Ticket ticket = new Ticket(mId++);
        return ticket;
    }
}
