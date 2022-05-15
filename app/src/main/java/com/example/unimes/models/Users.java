package com.example.unimes.models;

public class Users {

    String ProfilePic, UserName, Email, Password, UserId, LastMessage, Status;


    public Users(String profilePic, String userName, String email, String password, String userId, String lastMessage, String status) {
        this.ProfilePic = profilePic;
        this.UserName = userName;
        this.Email = email;
        this.Password = password;
        this.UserId = userId;
        this.LastMessage = lastMessage;
        this.Status = status;
    }

    public Users() {

    }

    // SignUp Constructor

    public Users(String userName, String email, String password) {
        this.UserName = userName;
        this.Email = email;
        this.Password = password;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getProfilePic() {
        return ProfilePic;
    }

    public void setProfilePic(String profilePic) {
        ProfilePic = profilePic;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }



    public String getLastMessage() {
        return LastMessage;
    }

    public void setLastMessage(String lastMessage) {
        LastMessage = lastMessage;
    }
}
