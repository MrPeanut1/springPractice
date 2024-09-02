package za.ac.cput.springpractice.factory;

import za.ac.cput.springpractice.domain.Player;
import za.ac.cput.springpractice.domain.SupportedGames;
import za.ac.cput.springpractice.domain.UserType;
import za.ac.cput.springpractice.util.Helper;

public class PlayerFactory {
    public static Player createPlayer(long id, String gamerTag, String gamerTagId, long userId, String firstName, String lastName, String password, UserType userType, SupportedGames supportedGames) {
        if(Helper.isNullOrEmpty(gamerTag) || Helper.isNullOrEmpty(gamerTagId) || Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName) || Helper.isNullOrEmpty(password) || Helper.isNullOrEmpty(supportedGames.toString())) {
            return null;
        } else {
            long playerId = Helper.generateId();
            return new Player.Builder().setId(playerId).setGamerTag(gamerTag).setGamerTagId(gamerTagId).setUserId(userId).setFirstName(firstName).setLastName(lastName).setPassword(password).setUserType(userType).setSupportedGames(supportedGames).build();
        }
    }

    public static Player createPlayer(String gamerTag, String gamerTagId, String firstName, String lastName, String password, UserType userType, SupportedGames supportedGames) {
        if(Helper.isNullOrEmpty(gamerTag) || Helper.isNullOrEmpty(gamerTagId) || Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName) || Helper.isNullOrEmpty(password) || Helper.isNullOrEmpty(supportedGames.toString())) {
            return null;
        } else {
            long playerId = Helper.generateId();
            return new Player.Builder().setId(playerId).setGamerTag(gamerTag).setGamerTagId(gamerTagId).setFirstName(firstName).setLastName(lastName).setPassword(password).setUserType(userType).setSupportedGames(supportedGames).build();
        }
    }
}
