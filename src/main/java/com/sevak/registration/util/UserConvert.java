package com.sevak.registration.util;


import com.sevak.registration.model.User;

public class UserConvert {
    public static User createUser(String userParameters){
        String[] split = userParameters.split(", ");
        return new User(split[0], split[1], split[2], Integer.parseInt(split[3]), split[4]);
    }
}
