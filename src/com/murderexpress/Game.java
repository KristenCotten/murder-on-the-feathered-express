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
//            updateBoard();
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
        System.out.println(storyLine.getScene1());        // trivia logic
        storyLine.getTrivia();
        storyLine.getQuestion();
        storyLine.checkAnswer();


        System.out.println(storyLine.getScene2());
        // trivia logic
        storyLine.getClue();
        storyLine.getTrivia();
        storyLine.getQuestion();
        storyLine.checkAnswer();


        System.out.println(storyLine.getScene3());
        // trivia logic
        storyLine.getClue();
        storyLine.getTrivia();
        storyLine.getQuestion();
        storyLine.checkAnswer();


        System.out.println(storyLine.getScene4());
        storyLine.getClue();
        storyLine.getTrivia();
        storyLine.getQuestion();
        storyLine.checkAnswer();
        // if passed to go
        if(storyLine.canConclude()){
            storyLine.getConclusion();
        }


    }

    private StoryLine chooseStoryId() {
        // story here

        int id = 0;
        boolean validInput = false;
        while (!validInput) {
            System.out.print("Choose story: 1, 2, or 3 ");
            String input = scanner.nextLine();
            if (input.matches("\\d{1}")) { // any digit, one or two times - now proceed
                id = Integer.parseInt(input); // will not blow up - you got digits
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
        // update pass
        System.out.println(input);
        // save() from board?
        // Player               // Result
        // BOB                      PASS
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
        StoryLine storyLine = new StoryLine("The beginning1", "the middle1", "middle end1", "end1");
        return storyLine;
    }

    private StoryLine storyLineTwo() {
        StoryLine storyLine = new StoryLine("The beginning2", "the middle2", "middle end2", "end2");
        return storyLine;
    }

    private StoryLine storyLineThree() {
        StoryLine storyLine = new StoryLine("The beginning3", "the middle3", "middle end3", "end3");
        return storyLine;
    }

}
