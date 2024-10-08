package za.ac.cput.springpractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.springpractice.domain.Admin;
import za.ac.cput.springpractice.domain.UserType;
@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByFirstName(String firstName);
    Admin findByLastName(String lastName);
    Admin findByFirstNameAndLastName(String firstName, String lastName);
    Admin findByUserType(UserType userType);
    Admin findByFirstNameAndUserType(String firstName, UserType userType);
    Admin findByLastNameAndUserType(String lastName, UserType userType);
    Admin findByFirstNameAndLastNameAndUserType(String firstName, String lastName, UserType userType);
    boolean existsByFirstNameAndPasswordAndUserType(String firstName, String lastName, UserType userType);
}
