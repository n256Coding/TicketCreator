package com.csse.ticketcreator.Controllers;

import com.csse.ticketcreator.Dummies.NationalSystemImpl;
import com.csse.ticketcreator.Interfaces.NationalSystem;
import com.csse.ticketcreator.Models.User;

/**
 * @author Nishan
 * @version 1.2
 */

public class UserController {
    private User user;
    private static volatile UserController userController = new UserController();

    private UserController(){
    }

    public static UserController getInstance(){
        return userController;
    }

    public boolean checkUserValidity(User user){
        NationalSystem nationalSystem = new NationalSystemImpl();
        return nationalSystem.validateUser(user.firstName, user.lastName, user.nicNo);
    }

    public void setUser(User user){
        this.user = user;
    }

    public User getUser(){
        return this.user;
    }
}