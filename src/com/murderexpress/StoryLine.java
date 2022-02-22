package com.murderexpress;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class StoryLine {

    // fields
    //public Collection<String> scenes = new ArrayList<>();
    TriviaItem triviaItem;
    Player player = new Player();
    int chances = player.getChances();
    int questionIndex = 0;
    private Scanner scanner = new Scanner(System.in);
    String scene1;
    String scene2;
    String scene3;
    String scene4;

    // Constructor
    public StoryLine(String scene1, String scene2, String scene3, String scene4) {
        setScene1(scene1);
        setScene2(scene2);
        setScene3(scene3);
        setScene4(scene4);
    }

    // Business methods
    public TriviaItem getTrivia() { //retrieve a TriviaItem from QuestionBank
        QuestionBank triviaQ = new QuestionBank();
        int questionIndex = getRandomInt(0, 29);
        triviaItem = triviaQ.triviaData.get(questionIndex);
        return triviaItem;
    }
    public static int getRandomInt(int min, int max) {
        int result = 0;
        double random = Math.random();
        int scaled = (int) (random * max);
        result = scaled + min;
        return result;
    }

    public void getQuestion() {
        String question = triviaItem.getQuestion();
        System.out.println("question: " + question);
    }

    public boolean checkAnswer() {  //wrong answer->decrease chances
                                    // correct answer-> player can move forward
        boolean result;
        System.out.print("Please enter [T]rue or [F]alse: ");
        String userAnswer = scanner.nextLine();
        String questionAnswer = triviaItem.getAnswer();
        if (userAnswer.equalsIgnoreCase(questionAnswer) && userAnswer.toUpperCase().matches("T|F")) { // user's answers match trivia answer then return true;
            result = true;
            System.out.println("correct");
        } else {
            player.setChances(chances--);
            result = false;
            if(chances == 0){
                getYouFailed();
            }
            System.out.println("false, chances: " + chances);
        }
        return result;
    }

    public void getConclusion() { //called when player wins the game
        System.out.println("Congrats you found out who did it");
    }

    private void getYouFailed() { //called when player uses up all 3 chances
        System.out.println("YOU were murdered before finding out who did it");
        // exit the program and display score
    }

    // Accessor methods
//    public Collection<String> getScenes() {
//        return scenes;
//    }
//
//    public void setScenes(Collection<String> scenes) {
//        this.scenes = scenes;
//    }

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

    public int getQuestionIndex() {
        return questionIndex;
    }

    public void setQuestionIndex(int questionIndex) {
        this.questionIndex = questionIndex;
    }
}
