package src.teams;

import src.Ticket;

public class MidPriorityTeam extends Team {
    @Override
    public void handleTicket(Ticket ticket) {
        System.out.println("The Ticket is being handled by MidPriority Team");
    }
}
