package com.murderexpress;

import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

public class Game {
    public Board board = Board.getInstance();
    private Scanner scanner = new Scanner(System.in);
    boolean isOver = false;
    private StoryLine storyLine;
    private Player player = new Player();
    private String userName;


    public void execute() throws IOException {
        while (!isOver) {
            welcome();
            chooseStoryId();// choose the story here
            playGame(storyLine);
            showBoard();
            end();
            isOver = true;
        }

    }

    private void welcome() {
        System.out.println("WELCOME to the app, please enter a user name");
        userName = scanner.nextLine();
        player.setUserName(userName);
    }

    private void playGame(StoryLine storyLine) throws IOException {
        System.out.println("Hello, " + player.getUserName());

        System.out.println(storyLine.getScene1());
        storyLine.getTrivia();
        storyLine.getQuestion();
        storyLine.checkAnswer();

        System.out.println(storyLine.getScene2());
        storyLine.getClue();
        storyLine.getTrivia();
        storyLine.getQuestion();
        storyLine.checkAnswer();

        System.out.println(storyLine.getScene3());
        storyLine.getClue();
        storyLine.getTrivia();
        storyLine.getQuestion();
        storyLine.checkAnswer();

        System.out.println(storyLine.getScene4());
        storyLine.getClue();
        storyLine.getTrivia();
        storyLine.getQuestion();
        storyLine.checkAnswer();
        if(storyLine.canConclude()){
            storyLine.getConclusion();
            board.update(userName);
        }
        else {
            board.updateFailed(userName);
        }

    }

    private StoryLine chooseStoryId() {
        int id = 0;
        boolean validInput = false;
        while (!validInput) {
            System.out.print("Choose story: 1, 2, or 3 ");
            String input = scanner.nextLine();
            if (input.matches("\\d")) {
                id = Integer.parseInt(input);
                if (id >= 1 && id <= 3) {
                    validInput = true;
                }
            }
        }
        if (id == 1) {
            storyLine = storyLineOne();
        }
        if (id == 2) {
            storyLine = storyLineTwo();
        }
        if (id == 3) {
            storyLine = storyLineThree();
        }
        return storyLine;
    }

    public void updateBoard(String userName){
        board.update(userName);
    }

    private void showBoard() {
        board.show();
    }

    private void end() {
        System.out.println("Thank you for playing!");
    }

    private StoryLine storyLineOne() {
        return new StoryLine("The beginning1", "the middle1", "middle end1", "end1");
    }

    private StoryLine storyLineTwo() {
        return new StoryLine("The beginning2", "the middle2", "middle end2", "end2");
    }

    private StoryLine storyLineThree() {
        return new StoryLine("The beginning3", "the middle3", "middle end3", "end3");
    }

}
