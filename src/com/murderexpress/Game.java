package com.murderexpress;

import java.util.Scanner;

public class Game {
    private Board board = Board.getInstance();
    private Scanner scanner = new Scanner(System.in);
    boolean isOver = false;
    private StoryLine storyLine;
    private Player player = new Player();


    public void execute() {
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
        String input = scanner.nextLine();
        player.setUserName(input);

    }

    private void playGame(StoryLine storyLine) {
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
        // will passing in a player obj and
    public void saveBoard(String input) {
        System.out.println(input);
        // save() from board?
//        board.save();
    }

    private void showBoard() {
        System.out.println("SHOWING BOARD");
//        board.show();
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
