package com.murderexpress;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.io.Serializable;


public class Board implements Serializable {
    public ArrayList<String> passedUserList = new ArrayList<>();
    public ArrayList<String> failedUserList = new ArrayList<>();

    public static Board getInstance() { //instantiates the board
        Board board = null;
        if (Files.exists(Path.of("data/board.dat"))) {
            //read saved Board object from file
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("data/board.dat"))) {
                board = (Board) in.readObject(); //downcast and read
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            board = new Board();
        }
        return board;
    }


    public void updatePassed(String userName) {
        passedUserList.add(userName);
        save();
    }

    public void updateFailed(String userName) {
        failedUserList.add(userName);
        save();
    }

    public void show() {
        System.out.println();
        if(passedUserList.size() > 0) {
                System.out.println("          =======================================");
                System.out.println("          Murder on the Feathered Express Winners");
                System.out.println("          =======================================");
                for (String player : passedUserList) {
                    System.out.println(player);
                }
        }
        if(failedUserList.size() > 0) {
                System.out.println();
                System.out.println("          =======================================");
                System.out.println("          Murder on the Feathered Express Losers");
                System.out.println("          =======================================");
                for (String player : failedUserList) {
                    System.out.println(player);
                }
        }
    }

    public void save() {

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data/board.dat"))) {
            out.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}