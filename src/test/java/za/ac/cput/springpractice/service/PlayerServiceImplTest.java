package za.ac.cput.springpractice.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.springpractice.domain.Player;
import za.ac.cput.springpractice.domain.SupportedGames;
import za.ac.cput.springpractice.domain.User;
import za.ac.cput.springpractice.domain.UserType;
import za.ac.cput.springpractice.factory.PlayerFactory;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class PlayerServiceImplTest {

    private static Player player;
    private static Player player2;

    @Autowired
    private PlayerServiceImpl playerService;

    @BeforeAll
    static void setup() {
        player = PlayerFactory.createPlayer( "GamerTag", "GamerTagId", "John", "Doe", "password", UserType.PLAYER, SupportedGames.OVERWATCH);
        assertNotNull(player);
        player2 = PlayerFactory.createPlayer(2, "GamerTag2", "GamerTagId2", 2, "Jane", "Joe", "password", UserType.PLAYER, SupportedGames.FORTNITE);
        assertNotNull(player2);
    }




    @Test
    void a_create() {
        Player createdPlayer = playerService.create(player);
        assertNotNull(createdPlayer);
        System.out.println("Created Player: " + createdPlayer);

        Player createdPlayer2 = playerService.create(player2);
        assertNotNull(createdPlayer2);
        System.out.println("Created Player: " + createdPlayer2);
    }

    @Test
    void b_read() {
        Player readPlayer = playerService.read(player.getUserId());
        assertNotNull(readPlayer);
        System.out.println("Read Player: " + readPlayer);

        Player readPlayer2 = playerService.read(player2.getUserId());
        assertNotNull(readPlayer2);
        System.out.println("Read Player: " + readPlayer2);
    }

    @Test
    void c_update() {
        Player updatedPlayer = new Player.Builder().copy(player).setGamerTag("TeKrop").setGamerTagId("2217").build();
        playerService.update(updatedPlayer);
        assertNotNull(playerService.update(updatedPlayer));
        System.out.println("Updated Player: " + updatedPlayer.getPlayerTag());

        Player updatedPlayer2 = new Player.Builder().copy(player2).setFirstName("Janet").build();
        playerService.update(updatedPlayer2);
        assertNotNull(playerService.update(updatedPlayer2));
        System.out.println("Updated Player: " + updatedPlayer2);
    }

    @Test
    void d_getAll() {
        System.out.println("All Players: " + playerService.getAll());
    }


    @Test
    void e_getPlayerStats() {
        Player updatedPlayer = playerService.read(player.getUserId());
        assertNotNull(updatedPlayer);
        System.out.println(updatedPlayer.getPlayerTag());
        playerService.getPlayerStats(updatedPlayer.getPlayerTag());
    }
}