package org.example.mockito.stub;

public class UserGreeting {
    private final UserProfiles profiles;

    public UserGreeting(UserProfiles profiles) {

        this.profiles = profiles;
    }

    public String formatGreeting(UserId userId) {
        return String.format("Hello and welcome, %s", profiles.fetchNicknameFor(userId));
    }
}
