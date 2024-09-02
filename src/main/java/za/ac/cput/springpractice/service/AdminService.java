package za.ac.cput.springpractice.service;

import za.ac.cput.springpractice.domain.Admin;
import za.ac.cput.springpractice.domain.UserType;

import java.util.List;

public interface AdminService extends Service <Admin,Long>{
    List<Admin> getAll();

    Admin validateAdmin(String firstName,String lastName, String password);
}
