// File: src/main/java/za/ac/cput/springpractice/api/AuthApi.java
package za.ac.cput.springpractice.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);


    @Autowired
    public AuthApi(PlayerServiceImpl playerService, AdminService adminService) {
        this.playerService = playerService;
        this.adminService = adminService;
    }

    public boolean loginUserByUserType(String firstName, String password, UserType userType) {
        boolean isValidPlayer = playerService.validatePlayer(firstName, password, userType);
        boolean isValidAdmin = adminService.validateAdmin(firstName, password, userType);

        return isValidPlayer || isValidAdmin;


    }

    public void createUserByUserType(UserType userType, SupportedGames gameSelection, String gamerTag, String gamerTagId, String password, String firstName, String lastName) {
        String encodedPassword = encoder.encode(password);
        if (userType == UserType.PLAYER) {
            Player player = PlayerFactory.createPlayer(gamerTag, gamerTagId, firstName, lastName, encodedPassword, userType, gameSelection);
            playerService.create(player);
        } else {
            Admin admin = AdminFactory.createAdmin(firstName, lastName,encodedPassword , userType);
            adminService.create(admin);
        }
    }
}