package com.murderexpress;

class Player {

    //fields
    private String userName;
    private int chances = 3; //player starts with 3 lives


    //Accessor Methods
    public String getUserName() {
        return userName;
    }

    private void setUserName(String userName) {
        this.userName = userName;
    }

    public int getChances() {
        return chances;
    }

    public void setChances(int chances) {
        this.chances = chances;
    }
}