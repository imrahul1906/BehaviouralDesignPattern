package src;

import src.teams.*;

public class TicketManager {
    private int mId = 1;
    public static void main(String... args) {
        TicketManager manager = new TicketManager();

        // Create a Ticker
        Ticket ticket = manager.createTicket();

        // Assign priority
        ticket.setPriority(Priority.CRITICAL);

        // Route the ticket handling
        Team team = manager.getTeam(ticket.getPriority());
        team.handleTicket(ticket);
        ticket.setTicketState(TicketState.CLOSED);
    }

    private Ticket createTicket() {
        Ticket ticket = new Ticket(mId++);
        return ticket;
    }

    private Team getTeam(Priority priority) {
        Team team = null;
        if (priority == Priority.LOW) {
            team = new LowPriorityTeam();
        } else if (priority == Priority.MID) {
            team = new MidPriorityTeam();
        } else if(priority == Priority.HIGH) {
            team = new HighPriorityTeam();
        } else {
            team = new CriticalPriorityTeam();
        }
        return team;
    }
}
