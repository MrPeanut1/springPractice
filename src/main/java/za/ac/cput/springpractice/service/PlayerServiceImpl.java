package za.ac.cput.springpractice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import za.ac.cput.springpractice.domain.UserType;
import za.ac.cput.springpractice.overwatch.OverwatchApi;
import za.ac.cput.springpractice.domain.Player;
import za.ac.cput.springpractice.repository.PlayerRepository;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository repository;
    private final OverwatchApi overwatchApi;

    @Autowired
    private BCryptPasswordEncoder encoder;


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


    public void getPlayerStats(String playerTag) {
        String stats = overwatchApi.getPlayerSummary(playerTag);
        System.out.println("Player Stats: " + stats);
    }

    @Override
    public boolean validatePlayer(String firstName, String password, UserType userType) {
        Player player = repository.findByFirstNameAndUserType(firstName, userType);

        // If player exists, compare the raw password with the encoded password
        if (player != null && encoder.matches(password, player.getPassword())) {
            return true;
        }

        // Return false if no match found
        return false;
    }



    @Override
    public Player getByPlayerTag(String playerTag) {
        String[] parts = playerTag.split("-");
        String gamerTag = parts[0];
        String gamerTagId = parts[1];
        return repository.findByGamerTagAndGamerTagId(gamerTag, gamerTagId);
    }
}
