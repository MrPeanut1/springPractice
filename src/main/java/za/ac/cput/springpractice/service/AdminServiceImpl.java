package za.ac.cput.springpractice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import za.ac.cput.springpractice.domain.Admin;
import za.ac.cput.springpractice.domain.UserType;
import za.ac.cput.springpractice.repository.AdminRepository;

import java.util.List;
@Service
public class AdminServiceImpl implements AdminService{

    private final AdminRepository repository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    AdminServiceImpl(AdminRepository repository) {
        this.repository = repository;
    }


    @Override
    public Admin create(Admin admin) {
        return repository.save(admin);
    }

    @Override
    public Admin read(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Admin update(Admin admin) {
        return repository.save(admin);
    }

    @Override
    public List<Admin> getAll() {
        return repository.findAll();
    }

    @Override
    public boolean validateAdmin(String firstName, String password, UserType userType) {
        Admin admin = repository.findByFirstNameAndUserType(firstName, userType);

        // If admin exists, compare the raw password with the encoded password
        if (admin != null && encoder.matches(password, admin.getPassword())) {
            return true;
        }

        // Return false if no match found
        return false;
    }
}
