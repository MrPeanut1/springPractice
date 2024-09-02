package za.ac.cput.springpractice.domain;

import jakarta.persistence.ManyToOne;

public class Team {

    @ManyToOne
    private Player player;
}
