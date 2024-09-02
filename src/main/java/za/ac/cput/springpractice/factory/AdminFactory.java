package za.ac.cput.springpractice.factory;

import za.ac.cput.springpractice.domain.Admin;
import za.ac.cput.springpractice.domain.UserType;
import za.ac.cput.springpractice.util.Helper;

public class AdminFactory {
    public static Admin createAdmin(long id, String firstName, String lastName, String password, UserType userType, long userId) {
        if(Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName) || Helper.isNullOrEmpty(password)) {
            return null;
        } else {
            long adminId = Helper.generateId();
            return new Admin.Builder().setUserId(userId).setId(adminId).setFirstName(firstName).setLastName(lastName).setPassword(password).setUserType(userType).build();
        }
    }

    public static Admin createAdmin(String firstName, String lastName, String password, UserType userType) {
        if(Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName) || Helper.isNullOrEmpty(password)) {
            return null;
        } else {
            long adminId = Helper.generateId();
            return new Admin.Builder().setId(adminId).setFirstName(firstName).setLastName(lastName).setPassword(password).setUserType(userType).build();
        }
    }
}
