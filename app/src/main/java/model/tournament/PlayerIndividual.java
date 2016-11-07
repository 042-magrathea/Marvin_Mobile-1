/*
 * MAGRATHEA - DAM
 */
package model.tournament;

import model.user.User;

/**
 * Stores an individual player, inherits from TournamentPlayer
 * @author Klaussius
 */
public class PlayerIndividual extends TournamentPlayer{
    private User player;

    /**
     * Constructor with parameters
     * @param player individual player
     * @param rank final ranking
     */
    public PlayerIndividual(User player, int rank) {
        super(rank);
        this.player = player;
    }

    /**
     * Constructor simple
     */
    public PlayerIndividual() {
    }

    // GETTERS AND SETTERS

    /**
     * Get player
     * @return player
     */
    public User getPlayer() {
        return player;
    }

    /**
     * Set player
     * @param player player
     */
    public void setPlayer(User player) {
        this.player = player;
    }
    
}
