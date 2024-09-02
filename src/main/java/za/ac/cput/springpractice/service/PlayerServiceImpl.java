package za.ac.cput.springpractice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.springpractice.overwatch.OverwatchApi;
import za.ac.cput.springpractice.domain.Player;
import za.ac.cput.springpractice.repository.PlayerRepository;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository repository;
    private final OverwatchApi overwatchApi;

    @Autowired
    PlayerServiceImpl(PlayerRepository repository, OverwatchApi overwatchApi) {
        this.repository = repository;
        this.overwatchApi = overwatchApi;
    }

    @Override
    public List<Player> getAll() {
        return repository.findAll();
    }



    @Override
    public Player create(Player player) {
        return repository.save(player);
    }

    @Override
    public Player read(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Player update(Player player) {
        return repository.save(player);
    }


    public String getPlayerStats(String playerTag) {
        String stats = overwatchApi.getPlayerSummary(playerTag);
        System.out.println("Player Stats: " + stats);
        return stats;
    }

    @Override
    public Player validatePlayer(String gamerTag, String gamerTagId, String game, String password) {
        return repository.findByGamerTagAndGamerTagIdAndGameAndPassword(gamerTag, gamerTagId,game, password);
    }



    @Override
    public Player getByPlayerTag(String playerTag) {
        String[] parts = playerTag.split("-");
        String gamerTag = parts[0];
        String gamerTagId = parts[1];
        return repository.findByGamerTagAndGamerTagId(gamerTag, gamerTagId);
    }
}
