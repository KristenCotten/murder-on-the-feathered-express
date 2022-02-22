package com.murderexpress;

import java.util.*;
//Done format so that updateBoard is not called twice at end.
public class StoryLine {
    // fields
    TriviaItem triviaItem;
    Player player = new Player();
    int chances = player.getChances();
    private Scanner scanner = new Scanner(System.in);
    private boolean isCorrect;
    private boolean canConclude;
    Game game = new Game();
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
        int questionIndex = getRandomInt(0, 3);
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
        if (chances > 0) {
            String question = triviaItem.getQuestion();
            System.out.println("question: " + question);
        } else {
            getYouFailed();
        }
    }

    public boolean checkAnswer() {  //wrong answer->decrease chances
        // correct answer-> player can move forward

        boolean result = false;
        System.out.print("Please enter [T]rue or [F]alse: ");
        String userAnswer = scanner.nextLine();
        if(chances > 0) {

            String questionAnswer = triviaItem.getAnswer();

            if (userAnswer.equalsIgnoreCase(questionAnswer) && userAnswer.toUpperCase().matches("T|F")) { // user's answers match trivia answer then return true;
                result = true;
                System.out.println("");
                setCorrect(true);
                setCanConclude(true);
            } else {
                player.setChances(chances--);
                setCorrect(false);
                System.out.println("incorrect answer, chances: " + chances);
            }
        }
        return result;
    }

    public void getClue() {
        // iterate a list of clues
        String clue = clues[clueIndex];
        setClueIndex(++clueIndex);
        if (isCorrect()) {
            System.out.print(clue + "\n");
        }
    }

    public void getConclusion() { //called when player wins the game
        System.out.println("Here is the conclusion");
        // update pass to the file
        game.saveBoard("Board update: pass");
    }

    private void getYouFailed() { //called when player uses up all 3 chances
        System.out.println("YOU were murdered before finding out who did it");
        // update fail to the file
        game.saveBoard("Board update: fail");
        // exit the program and display score
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
