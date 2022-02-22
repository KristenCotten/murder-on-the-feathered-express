package com.murderexpress;

import java.util.*;

import static com.murderexpress.Player.CHANCES;

public class StoryLine {
    // fields
    TriviaItem triviaItem;
    private Scanner scanner = new Scanner(System.in);
    private boolean isCorrect;
    private boolean canConclude;
    String scene1;
    String scene2;
    String scene3;
    String scene4;
    int clueIndex = 0;
    String[] clues = new String[]{"This is clue 1", "This is clue 2", "This is clue 3"};

    // ctor
    public StoryLine(String scene1, String scene2, String scene3, String scene4) {
        setScene1(scene1);
        setScene2(scene2);
        setScene3(scene3);
        setScene4(scene4);
    }

    // Business methods
    public TriviaItem getTrivia() { //retrieve a Trivia question from TriviaQ's
        QuestionBank triviaQ = new QuestionBank();
        int questionIndex = getRandomInt(0, 29);
        triviaItem = triviaQ.triviaData.get(questionIndex);
        return triviaItem;
    }

    public static int getRandomInt(int min, int max) {
        int result;
        double random = Math.random();
        int scaled = (int) (random * max);
        result = scaled + min;
        return result;
    }

    public void getQuestion() {
        if (CHANCES > 0) {
            String question = triviaItem.getQuestion();
            System.out.println("\nquestion: " + question);
            System.out.print("Please enter [T]rue or [F]alse: ");
        } else {
            getYouFailed();
        }
    }

    public boolean checkAnswer() {

        boolean result = false;

        String userAnswer = scanner.nextLine();

        if(CHANCES > 0) {
            String questionAnswer = triviaItem.getAnswer();

            if (userAnswer.equalsIgnoreCase(questionAnswer) && userAnswer.toUpperCase().matches("T|F")) {
                result = true;
                System.out.println();
                setCorrect(true);
                setCanConclude(true);
            } else {
                CHANCES--;
                setCorrect(false);
                System.out.println("\nincorrect answer, chances: " + CHANCES);
            }
        }
        return result;
    }

    public void getClue() {
        String clue = clues[clueIndex];
        setClueIndex(++clueIndex);
        if (isCorrect()) {
            System.out.print(clue + "\n");
        }
    }

    public void getConclusion() { //called when player wins the game
        System.out.println("Here is the conclusion");
    }

    private void getYouFailed() { //called when player uses up all 3 chances
        System.out.println("YOU were murdered before finding out who did it");
        System.out.println("\nPlease hit enter to see the score board");
    }

    // Accessory Methods
    public String getScene1() {
        return scene1;
    }

    public void setScene1(String scene1) {
        this.scene1 = scene1;
    }

    public String getScene2() {
        return scene2;
    }

    public void setScene2(String scene2) {
        this.scene2 = scene2;
    }

    public String getScene3() {
        return scene3;
    }

    public void setScene3(String scene3) {
        this.scene3 = scene3;
    }

    public String getScene4() {
        return scene4;
    }

    public void setScene4(String scene4) {
        this.scene4 = scene4;
    }

    public void setClueIndex(int clueIndex) {
        this.clueIndex = clueIndex;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public boolean canConclude() {
        return canConclude;
    }

    public void setCanConclude(boolean canConclude) {
        this.canConclude = canConclude;
    }
}
