package com.murderexpress;

import java.util.Arrays;

public interface Path {
  //  public String pathName;


    private TriviaItem getTrivia(){ //retrieve a Trivia question from TriviaQ's
        TriviaQs triviaQ = new TriviaQs();
     //   triviaQ1 = triviaData.question[0];

        return null;
    };


    //Business Methods
    private boolean checkAnswer() {  //wrong answer->decrease chances
                                    // correct answer-> player can move forward

        return false;
    };

    private boolean moveForward() { //checkAnswer must be true to call this method
        return true; //TODO
    };

    private void getConclusion() { //called when player wins the game

    };

    private void getYouFailed() { //called when player uses up all 3 chances

    };


}
