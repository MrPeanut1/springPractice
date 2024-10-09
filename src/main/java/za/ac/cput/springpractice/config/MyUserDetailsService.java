package za.ac.cput.springpractice.config;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import za.ac.cput.springpractice.domain.Admin;
import za.ac.cput.springpractice.repository.AdminRepository;


@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private AdminRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Admin admin= repo.findByFirstName(username);

        if (admin==null) {
            System.out.println("User 404");
            throw new UsernameNotFoundException("User 404");
        }
        return new UserPrincipal(admin);
    }

}