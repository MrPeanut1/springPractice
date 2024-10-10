package za.ac.cput.springpractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.springpractice.domain.Player;
import za.ac.cput.springpractice.domain.UserType;

@Repository
public interface PlayerRepository extends JpaRepository<Player,Long> {
    Player findByGamerTagAndGamerTagId(String gamerTag, String gamerTagId);
    Player findByFirstName(String firstName);
    Player findByFirstNameAndUserType(String firstName, UserType userType);

}
