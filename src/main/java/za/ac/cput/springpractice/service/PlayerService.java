package za.ac.cput.springpractice.service;

import za.ac.cput.springpractice.domain.Player;
import za.ac.cput.springpractice.domain.UserType;

import java.util.List;

public interface PlayerService extends Service <Player,Long>{

    List<Player> getAll();

    boolean validatePlayer(String firstName, String password, UserType userType);
    Player getByPlayerTag(String playerTag);
}
