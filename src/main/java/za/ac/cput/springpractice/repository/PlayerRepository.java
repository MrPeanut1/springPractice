package za.ac.cput.springpractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.springpractice.domain.Player;
import za.ac.cput.springpractice.domain.UserType;

@Repository
public interface PlayerRepository extends JpaRepository<Player,Long> {
    Player findByGamerTag(String gamerTag);
    Player findByGamerTagAndGamerTagId(String gamerTag, String gamerTagId);
    Player findByGamerTagAndGamerTagIdAndUserId(String gamerTag, String gamerTagId, long userId);
    Player findByUserId(long userId);
    Player findByGamerTagAndPasswordAndUserType(String gamerTag, String password, UserType userType);
    Player findByGamerTagAndGamerTagIdAndGameAndPassword(String gamerTag, String gamerTagId, String game, String password);

}
