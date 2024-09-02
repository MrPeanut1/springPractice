package za.ac.cput.springpractice.service;

import za.ac.cput.springpractice.domain.Player;
import za.ac.cput.springpractice.domain.UserType;

import java.util.List;

public interface PlayerService extends Service <Player,Long>{

    List<Player> getAll();

    Player validatePlayer(String gamerTag, String gamerTagId, String game, String password);
    Player getByPlayerTag(String playerTag);
}
