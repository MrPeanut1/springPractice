package za.ac.cput.springpractice.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import za.ac.cput.springpractice.domain.Admin;
import za.ac.cput.springpractice.domain.UserType;
import za.ac.cput.springpractice.factory.AdminFactory;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class AdminServiceImplTest {
    @Autowired
    private AdminServiceImpl adminService;

    private static Admin admin;

    private static Admin admin2;

    @BeforeAll
    static void setup() {
        admin = AdminFactory.createAdmin(1, "John", "Doe", "password", UserType.ADMIN,1);
        assertNotNull(admin);
        admin2 = AdminFactory.createAdmin("Jane", "Doe", "password", UserType.ADMIN);
        assertNotNull(admin2);

    }

    @Test
    void a_create() {
        Admin createdAdmin = adminService.create(admin);
        assertNotNull(createdAdmin);
        System.out.println("Created Admin: " + createdAdmin);

        Admin createdAdmin2 = adminService.create(admin2);
        assertNotNull(createdAdmin2);
        System.out.println("Created Admin: " + createdAdmin2);
    }

    @Test
    void b_read() {
        Admin readAdmin = adminService.read(admin.getUserId());
        assertNotNull(readAdmin);
        System.out.println("Read Admin: " + readAdmin);

        Admin readAdmin2 = adminService.read(admin2.getUserId());
        assertNotNull(readAdmin2);
        System.out.println("Read Admin: " + readAdmin2);
    }

    @Test
    void c_update() {
        Admin updatedAdmin = new Admin.Builder().copy(admin).setFirstName("Johnny").build();
        assertNotNull(adminService.update(updatedAdmin));
        System.out.println("Updated Admin: " + updatedAdmin);
    }

    @Test
    void d_getAll() {
        System.out.println(adminService.getAll());
    }

    @Test
    void e_validateAdmin(){
        boolean validAdmin = adminService.validateAdmin(admin2.getFirstName(), admin2.getPassword(), admin2.getUserType());
        assertTrue(validAdmin);
        System.out.println("Valid Admin: " + validAdmin);
    }
}