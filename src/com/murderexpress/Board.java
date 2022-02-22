package com.murderexpress;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.io.Serializable;


class Board implements Serializable {
    public ArrayList<String> playerList = new ArrayList<>();

    public boolean isEmpty;

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
    };

    public boolean isEmpty() {
        return playerList.isEmpty();
    }

    public void update(String userName) {
        playerList.add(userName);
        save();
    }

    public void show() {
        System.out.println();
        System.out.println("=======================================");
        System.out.println("Murder on the Feathered Express Winners");
        System.out.println("=======================================");
        for (String player : playerList) {
            System.out.println(player);
        }
    }

    public void save() {
        //use a new  FileOutputStream and write to object
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data/board.dat"))) {
            out.writeObject(this); //please write "me" (a Board object) to the file
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}