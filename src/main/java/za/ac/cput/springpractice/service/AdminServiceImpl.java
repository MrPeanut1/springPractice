package za.ac.cput.springpractice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.springpractice.domain.Admin;
import za.ac.cput.springpractice.repository.AdminRepository;

import java.util.List;
@Service
public class AdminServiceImpl implements AdminService{

    private final AdminRepository repository;

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
    public Admin validateAdmin(String firstName, String lastName, String password) {
        return repository.findByFirstNameAndLastNameAndPassword(firstName, lastName, password);
    }
}
