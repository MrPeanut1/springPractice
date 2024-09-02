package za.ac.cput.springpractice.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ManyToOne;

public class School {

    @ManyToOne(cascade = CascadeType.ALL)
    private Team team;
}
