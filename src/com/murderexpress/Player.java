package com.murderexpress;

class Player {

    //fields
    private String userName;
    static int CHANCES = 3; //player starts with 3 lives


    //Accessor Methods
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getChances() {
        return CHANCES;
    }

    public void setChances(int chances) {
        this.CHANCES = chances;
    }
}