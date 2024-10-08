package za.ac.cput.springpractice.service;

import za.ac.cput.springpractice.domain.Admin;
import za.ac.cput.springpractice.domain.UserType;

import java.util.List;

public interface AdminService extends Service <Admin,Long>{
    List<Admin> getAll();

    boolean validateAdmin(String firstName, String password, UserType userType);
}
