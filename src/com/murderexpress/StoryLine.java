package com.murderexpress;

import java.io.IOException;
import java.util.*;

import static com.murderexpress.Player.CHANCES;

class StoryLine extends Thread {
    // fields
    TriviaItem triviaItem;
    private Scanner scanner = new Scanner(System.in);
    private boolean isCorrect;
    private boolean canConclude;
    private String scene1;
    private String scene2;
    private String scene3;
    private String scene4;
    private int clueIndex = 0;
    String[] clues = new String[]{"*** 🔍 CLUE: A single grey feather, once vibrant but now fading ***", "*** 🔍 CLUE: A pointed needle, grey, worn ***", "*** 🔍 CLUE: Butterscotch and peppermint wrappers, rolled in a dirty tissue ***", "*** 🔍 CLUE: A cookie tin filled with yarn ***"};

    // ctor
    StoryLine(String scene1, String scene2, String scene3, String scene4) {
        setScene1(scene1);
        setScene2(scene2);
        setScene3(scene3);
        setScene4(scene4);
    }

    // Business methods
    TriviaItem getTrivia() throws IOException {
        QuestionBank qLoader = new QuestionBank("data/questions.csv");
        List<TriviaItem> triviaQs = qLoader.load();
        int questionIndex = getRandomInt(0, 29);
        triviaItem = triviaQs.get(questionIndex);
        return triviaItem;
    }

    private static int getRandomInt(int min, int max) {
        int result;
        double random = Math.random();
        int scaled = (int) (random * max);
        result = scaled + min;
        return result;
    }

    public void getQuestion() {
        if (CHANCES > 0) {

                String question = triviaItem.getQuestion();
                System.out.println("-------------------------------");
                System.out.println("QUESTION: " + question);
                System.out.print("Please enter [T]rue or [F]alse: ");

        } else {
            getYouFailed();
        }
    }

    public boolean checkAnswer() {

        boolean result = false;

        String userAnswer = scanner.nextLine();

        if (CHANCES > 0) {
            String questionAnswer = triviaItem.getAnswer();

            if (userAnswer.equalsIgnoreCase(questionAnswer) && userAnswer.toUpperCase().matches("T|F")) { // user's answers match trivia answer then return true;
                result = true;
                System.out.println("\n ✔ CORRECT! You get a clue. \n");
                setCorrect(true);
                getClue();
                setCanConclude(true);
            } else {
                CHANCES--;
                setCorrect(false);
                    System.out.println("\n ❌ INCORRECT answer, chances: " + CHANCES);

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

    public void getConclusion(String userName) { //called when player wins the game
        System.out.println();
        System.out.println(

                "                   ( )\n" +
                        "               ( )\n" +
                        "           ( )\n" +
                        "           _||__ ____ ____ ____\n" +
                        "           (o)___)}___}}___}}___}\n" +
                        "           \'U\'\0 0  0 0  0 0  0 0");

        System.out.println();
        System.out.println(
                "The train slowly pulls into the station. You're reviewing race records and have\n" +
                        "uncovered a trend. One racer who's consistently finished second, never cracking\n" +
                        "that first place spot. A racer coming up on retirement with a big robin's egg for wins.\n" +
                        "You look at the clues, the handkerchief, the grey feathers, the knitting needle and it\n" +
                        "suddenly all makes sense.\n" +
                        "\n" +
                        "You dash out of the room - rushing to send a telegram to the London offices.\n" +
                        "As the train begins to clear, you smell the familiar scent of perfume, and see Granny,\n" +
                        "dashing at you with a sharpened knitting needle. Murder on her mind and blood on her feathers.\n" +
                        "You're able to successfully counter Granny's attack. Securing Granny, the wayward fowl at the wings.\n" +
                        "\n" +
                        "Cuffing Granny you say: \n" +
                        "\"You gave it up granny... all because you couldn't win. Now you won't deal with the line judge but the criminal judge. Lets go.\"\n" +
                        "You take a deep breath. The duckraces can continue. All in a days work as a top-tier investigator on the Feathered Express.\n" + "\n" +
                        "Congratulations on your win " + userName + "!");
        System.out.println();
        System.out.println();

    }

    private void getYouFailed() {
        System.out.println();
        System.out.println(

                "                   ( )\n" +
                        "               ( )\n" +
                        "           ( )\n" +
                        "           _||__ ____ ____ ____\n" +
                        "           (o)___)}___}}___}}___}\n" +
                        "           \'U\'\0 0  0 0  0 0  0 0");

        System.out.println();
        System.out.println(
                "The train slowly pulls into the station. You're reviewing race records and have uncovered a trend.\n" +
                        "One racer who's consistently finished second, never cracking that first place spot. A racer coming up...\n" + "\n" +
                        "You are caught off guard as a cloaked figure comes up to you and a sharp object meets your chest!\n" +
                        "You gasp for air as you fall on the ground\n" +"\n" +
                        "...just another victim on the Feathered Express.");


        System.out.println("\nPlease hit enter to see the score board");
        System.out.println();
        System.out.println();
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
