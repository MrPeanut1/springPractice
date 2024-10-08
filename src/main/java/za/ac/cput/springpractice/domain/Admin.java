package za.ac.cput.springpractice.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.util.Objects;

@Entity
public class Admin extends User {
    private long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "user_type")
    protected UserType userType;

    public Admin(){
    }

    private Admin(Builder builder) {
        this.id = builder.id;
        this.userId = builder.userId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.password = builder.password;
        this.userType = builder.userType;
    }

    public long getId() {
        return id;
    }

    public UserType getUserType() {
        return userType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Admin admin = (Admin) o;
        return id == admin.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", userType=" + userType +
                "} " + super.toString();
    }

    public static class Builder {
        private long id;
        private long userId;
        private String firstName;
        private String lastName;
        private String password;
        private UserType userType;

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

        public Admin build() {
            return new Admin(this);
        }

        public Builder copy(Admin admin) {
            this.id = admin.id;
            this.userId = admin.userId;
            this.firstName = admin.firstName;
            this.lastName = admin.lastName;
            this.password = admin.password;
            this.userType = admin.userType;
            return this;
        }
    }
}
