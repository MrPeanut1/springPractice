package za.ac.cput.springpractice.config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;
import za.ac.cput.springpractice.domain.Admin;
import za.ac.cput.springpractice.domain.UserType;

import java.util.Collection;
import java.util.Collections;



public class UserPrincipal implements UserDetails {

    private final Admin admin;

    public UserPrincipal(Admin admin) {
        this.admin = admin;

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(UserType.ADMIN.toString()));
    }




    @Override
    public String getPassword() {
        System.out.println(admin.getPassword());
        return admin.getPassword();
    }

    @Override
    public String getUsername() {
        System.out.println(admin.getFirstName());
        return admin.getFirstName();
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
