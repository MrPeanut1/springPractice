package za.ac.cput.springpractice.config;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import za.ac.cput.springpractice.domain.Admin;
import za.ac.cput.springpractice.domain.Player;
import za.ac.cput.springpractice.repository.AdminRepository;
import za.ac.cput.springpractice.repository.PlayerRepository;


@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private PlayerRepository playerRepository; // Assuming you have a repository for Player

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // Try to find the user in the Admin repository first
        Admin admin = adminRepository.findByFirstName(username);
        if (admin != null) {
            return new UserPrincipal(admin); // Assuming UserPrincipal handles Admin
        }

        // If not found in Admin, try Player
        Player player = playerRepository.findByFirstName(username);
        if (player != null) {
            return new UserPrincipal(player); // Assuming UserPrincipal handles Player
        }

        // If neither admin nor player is found, throw exception
        throw new UsernameNotFoundException("User not found");
    }
}
