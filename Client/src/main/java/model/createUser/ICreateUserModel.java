package model.createUser;

import shared.User;

public interface ICreateUserModel {

    void createUser(String username, String password, String fname, String lname, String email, String status, String accesslevel);
    String createUserResponse();
    User getUserInfo();
}
