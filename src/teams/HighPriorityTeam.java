package src.teams;

import src.Ticket;

public class HighPriorityTeam extends Team {

    @Override
    public void handleTicket(Ticket ticket) {
        System.out.println("The Ticket is being handled by HighPriority Team");
    }
}
