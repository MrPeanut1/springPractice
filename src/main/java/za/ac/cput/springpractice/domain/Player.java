package za.ac.cput.springpractice.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Player extends User {
    //TODO:ADD FIELD FOR PHOTO
    private long id;
    private String gamerTag;
    private String gamerTagId;
    @Enumerated(EnumType.STRING)
    @Column(name = "user_type")
    private UserType userType;
    @Enumerated(EnumType.STRING)
    @Column(name = "player_game")
    private SupportedGames game;


    public Player() {
    }

    private Player(Builder builder) {
        this.id = builder.id;
        this.gamerTag = builder.gamerTag;
        this.gamerTagId = builder.gamerTagId;
        this.userId = builder.userId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.password = builder.password;
        this.userType = builder.userType;
        this.game = builder.supportedGames;
    }


    public long getId() {
        return id;
    }

    public String getGamerTag() {
        return gamerTag;
    }

    public String getGamerTagId() {
        return gamerTagId;
    }

    public String getPlayerTag(){
        return gamerTag + "-" + gamerTagId;
    }

    public UserType getUserType() {
        return userType;
    }

    public SupportedGames getGame() {
        return game;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", gamerTag='" + gamerTag + '\'' +
                ", gamerTagId='" + gamerTagId + '\'' +
                ", userType=" + userType +
                ", supportedGames=" + game +
                ", userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Player player = (Player) o;
        return id == player.id && Objects.equals(gamerTag, player.gamerTag) && Objects.equals(gamerTagId, player.gamerTagId) && userType == player.userType && game == player.game;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, gamerTag, gamerTagId, userType, game);
    }


    public static class Builder {
        private long id;
        private String gamerTag;
        private String gamerTagId;
        private long userId;
        private String firstName;
        private String lastName;
        private String password;
        private UserType userType;
        private SupportedGames supportedGames;

        public Builder setId(long id) {
            this.id = id;
            return this;
        }

        public Builder setUserId(long userId) {
            this.userId = userId;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setUserType(UserType userType) {
            this.userType = userType;
            return this;
        }

        public Builder setGamerTag(String gamerTag) {
            this.gamerTag = gamerTag;
            return this;
        }

        public Builder setGamerTagId(String gamerTagId) {
            this.gamerTagId = gamerTagId;
            return this;
        }

        public Builder setSupportedGames(SupportedGames supportedGames) {
            this.supportedGames = supportedGames;
            return this;
        }

        public Builder copy(Player player) {
            this.id = player.id;
            this.gamerTag = player.gamerTag;
            this.gamerTagId = player.gamerTagId;
            this.userId = player.userId;
            this.firstName = player.firstName;
            this.lastName = player.lastName;
            this.password = player.password;
            this.userType = player.userType;
            this.supportedGames = player.game;
            return this;
        }

        public Player build() {
            return new Player(this);
        }
    }
}
