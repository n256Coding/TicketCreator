package com.csse.ticketcreator.Controllers;

import com.csse.ticketcreator.Dummies.NationalSystem;
import com.csse.ticketcreator.Dummies.NationalSystemImpl;
import com.csse.ticketcreator.Models.User;

/**
 * This class manages information regarding to users.
 *
 * @author Nishan
 * @version 1.2
 */

public class UserController {
    private User user = new User();
    private static volatile UserController userController = new UserController();

    private UserController() {
    }

    public static UserController getInstance() {
        return userController;
    }

    /**
     * This will check validity of user given information
     * in {@link com.csse.ticketcreator.Fragments.PersonalInfoFragment}. Information are send to
     * national system to validate.
     *
     * @param user user object which contains information of user
     * @return true is user information found in national system, Else false
     */
    public boolean checkUserValidity(User user) {
        NationalSystem nationalSystem = new NationalSystemImpl();
        return nationalSystem.validateUser(user.getFirstName(), user.getLastName(), user.getNicNo());
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return this.user;
    }
}