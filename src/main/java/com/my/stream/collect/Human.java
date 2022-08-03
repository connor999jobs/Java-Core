package com.my.stream.collect;

public class Human {
    private   String name, surname;
    private   int friendsAmount;

    public Human(String name, String surname, int friendsAmount) {
        this.name = name;
        this.surname = surname;
        this.friendsAmount = friendsAmount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getFriendsAmount() {
        return friendsAmount;
    }

    public void setFriendsAmount(int friendsAmount) {
        this.friendsAmount = friendsAmount;
    }
}
