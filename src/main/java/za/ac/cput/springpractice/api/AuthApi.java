// File: src/main/java/za/ac/cput/springpractice/api/AuthApi.java
package za.ac.cput.springpractice.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.cput.springpractice.domain.Admin;
import za.ac.cput.springpractice.domain.Player;
import za.ac.cput.springpractice.domain.SupportedGames;
import za.ac.cput.springpractice.domain.UserType;
import za.ac.cput.springpractice.factory.AdminFactory;
import za.ac.cput.springpractice.factory.PlayerFactory;
import za.ac.cput.springpractice.service.AdminService;
import za.ac.cput.springpractice.service.PlayerServiceImpl;

@Component
public class AuthApi {

    private final PlayerServiceImpl playerService;
    private final AdminService adminService;

    @Autowired
    public AuthApi(PlayerServiceImpl playerService, AdminService adminService) {
        this.playerService = playerService;
        this.adminService = adminService;
    }

    public void loginUserByUserType(UserType userType, SupportedGames gameSelection, String gamerTag, String gamerTagId, String password, String firstName, String lastName) {
        if (userType == UserType.PLAYER) {
            playerService.validatePlayer(gamerTag, gamerTagId, gameSelection.toString(), password);
        } else {
            adminService.validateAdmin(firstName, lastName, password);
        }
    }

    public void createUserByUserType(UserType userType, SupportedGames gameSelection, String gamerTag, String gamerTagId, String password, String firstName, String lastName) {
        if (userType == UserType.PLAYER) {
            Player player = PlayerFactory.createPlayer(gamerTag, gamerTagId, firstName, lastName, password, userType, gameSelection);
            playerService.create(player);
        } else {
            Admin admin = AdminFactory.createAdmin(firstName, lastName, password, userType);
            adminService.create(admin);
        }
    }
}