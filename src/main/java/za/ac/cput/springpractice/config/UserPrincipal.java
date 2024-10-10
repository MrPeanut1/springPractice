package za.ac.cput.springpractice.config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import za.ac.cput.springpractice.domain.Admin;
import za.ac.cput.springpractice.domain.Player;

import java.util.Collection;
import java.util.List;

public class UserPrincipal implements UserDetails {

    private final String username; // Changed to username for clarity
    private final String password;
    private final Collection<? extends GrantedAuthority> authorities;

    public UserPrincipal(Admin admin) {
        this.username = admin.getFirstName(); // or admin.getUsername() if you have a specific field
        this.password = admin.getPassword();
        this.authorities = List.of(new SimpleGrantedAuthority("ROLE_" + admin.getUserType().toString().toUpperCase()));
    }

    public UserPrincipal(Player player) {
        this.username = player.getFirstName(); // or player.getUsername() if applicable
        this.password = player.getPassword();
        this.authorities = List.of(new SimpleGrantedAuthority("ROLE_" + player.getUserType().toString().toUpperCase()));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username; // Changed to username
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
