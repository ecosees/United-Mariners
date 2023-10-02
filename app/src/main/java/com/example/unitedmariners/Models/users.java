package com.example.unitedmariners.Models;

public class users {

    String UserId;
    String UserName;

    public users(String userId, String userName, String profilePic) {
        UserId = userId;
        UserName = userName;
        ProfilePic = profilePic;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getProfilePic() {
        return ProfilePic;
    }

    public void setProfilePic(String profilePic) {
        ProfilePic = profilePic;
    }
    public users(){}

    String ProfilePic;
}
