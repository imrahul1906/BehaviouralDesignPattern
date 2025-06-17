package src;

import src.teams.HighPriorityTeam;
import src.teams.LowPriorityTeam;
import src.teams.MidPriorityTeam;
import src.teams.Team;

public class TicketManager {
    public static void main(String... args) {
        TicketManager manager = new TicketManager();

        // Create a Ticker
        Ticket ticket = manager.createTicket();

        // Assign priority
        ticket.setPriority(Priority.LOW);

        // Route the ticket handling
        Team team = manager.getTeam(ticket.getPriority());
        team.handleTicket(ticket);
    }

    private Ticket createTicket() {
        Ticket ticket = new Ticket(1);
        return ticket;
    }

    private Team getTeam(Priority priority) {
        Team team = null;
        if (priority == Priority.LOW) {
            team = new LowPriorityTeam();
        } else if (priority == Priority.MID) {
            team = new MidPriorityTeam();
        } else {
            team = new HighPriorityTeam();
        }
        return team;
    }
}
