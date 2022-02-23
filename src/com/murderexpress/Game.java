package com.murderexpress;

import java.io.IOException;
import java.util.Scanner;


public class Game extends Thread {
    public Board board = Board.getInstance();
    private Scanner scanner = new Scanner(System.in);
    boolean isOver = false;
    private StoryLine storyLine;
    private Player player = new Player();
    private String userName;


    public void execute() {
        while (!isOver) {
            try {
                welcome();
                Thread.sleep(2000); //TODO-make longer
                chooseStoryId();// choose the story here
                playGame(storyLine);
                showBoard();
                Thread.sleep(3000);
                end();
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
            isOver = true;
        }

    }

    private void welcome() {
        try {
            System.out.println("                  ██████ ██████                           █████                   \n" +
                    "                ░░██████ ██████                          ░░███                    \n" +
                    "                 ░███░█████░███  █████ ████ ████████   ███████   ██████  ████████ \n" +
                    "                 ░███░░███ ░███ ░░███ ░███ ░░███░░███ ███░░███  ███░░███░░███░░███\n" +
                    "                 ░███ ░░░  ░███  ░███ ░███  ░███ ░░░ ░███ ░███ ░███████  ░███ ░░░ \n" +
                    "                 ░███      ░███  ░███ ░███  ░███     ░███ ░███ ░███░░░   ░███     \n" +
                    "                 █████     █████ ░░████████ █████    ░░████████░░██████  █████    \n" +
                    "                ░░░░░     ░░░░░   ░░░░░░░░ ░░░░░      ░░░░░░░░  ░░░░░░  ░░░░░     \n" +
                    "                                                                            ");
            Thread.sleep(1000);
            System.out.println("                       ▄▀▀▀▀▄   ▄▀▀▄ ▀▄      ▄▀▀▀█▀▀▄  ▄▀▀▄ ▄▄   ▄▀▀█▄▄▄▄ \n" +
                    "                      █      █ █  █ █ █     █    █  ▐ █  █   ▄▀ ▐  ▄▀   ▐ \n" +
                    "                      █      █ ▐  █  ▀█     ▐   █     ▐  █▄▄▄█    █▄▄▄▄▄  \n" +
                    "                      ▀▄    ▄▀   █   █         █         █   █    █    ▌  \n" +
                    "                        ▀▀▀▀   ▄▀   █        ▄▀         ▄▀  ▄▀   ▄▀▄▄▄▄   \n" +
                    "                               █    ▐       █          █   █     █    ▐   \n" +
                    "                               ▐            ▐          ▐   ▐     ▐        ");
            Thread.sleep(1500);
            System.out.println("  █████▒   ▓█████     ▄▄▄         ▄▄▄█████▓    ██░ ██    ▓█████     ██▀███     ▓█████    ▓█████▄ \n" +
                    "▓██   ▒    ▓█   ▀    ▒████▄       ▓  ██▒ ▓▒   ▓██░ ██▒   ▓█   ▀    ▓██ ▒ ██▒   ▓█   ▀    ▒██▀ ██▌\n" +
                    "▒████ ░    ▒███      ▒██  ▀█▄     ▒ ▓██░ ▒░   ▒██▀▀██░   ▒███      ▓██ ░▄█ ▒   ▒███      ░██   █▌\n" +
                    "░▓█▒  ░    ▒▓█  ▄    ░██▄▄▄▄██    ░ ▓██▓ ░    ░▓█ ░██    ▒▓█  ▄    ▒██▀▀█▄     ▒▓█  ▄    ░▓█▄   ▌\n" +
                    "░▒█░       ░▒████▒    ▓█   ▓██▒     ▒██▒ ░    ░▓█▒░██▓   ░▒████▒   ░██▓ ▒██▒   ░▒████▒   ░▒████▓ \n" +
                    " ▒ ░       ░░ ▒░ ░    ▒▒   ▓▒█░     ▒ ░░       ▒ ░░▒░▒   ░░ ▒░ ░   ░ ▒▓ ░▒▓░   ░░ ▒░ ░    ▒▒▓  ▒ \n" +
                    " ░          ░ ░  ░     ▒   ▒▒ ░       ░        ▒ ░▒░ ░    ░ ░  ░     ░▒ ░ ▒░    ░ ░  ░    ░ ▒  ▒ \n" +
                    " ░ ░          ░        ░   ▒        ░          ░  ░░ ░      ░        ░░   ░       ░       ░ ░  ░ \n" +
                    "              ░  ░         ░  ░                ░  ░  ░      ░  ░      ░           ░  ░      ░    \n" +
                    "                                                                                          ░      ");
            Thread.sleep(1500);
            System.out.println("                 ██████████                                                         \n" +
                    "                ░░███░░░░░█                                                         \n" +
                    "                 ░███  █ ░  █████ █████ ████████  ████████   ██████   █████   █████ \n" +
                    "                 ░██████   ░░███ ░░███ ░░███░░███░░███░░███ ███░░███ ███░░   ███░░  \n" +
                    "                 ░███░░█    ░░░█████░   ░███ ░███ ░███ ░░░ ░███████ ░░█████ ░░█████ \n" +
                    "                 ░███ ░   █  ███░░░███  ░███ ░███ ░███     ░███░░░   ░░░░███ ░░░░███\n" +
                    "                 ██████████ █████ █████ ░███████  █████    ░░██████  ██████  ██████ \n" +
                    "                ░░░░░░░░░░ ░░░░░ ░░░░░  ░███░░░  ░░░░░      ░░░░░░  ░░░░░░  ░░░░░░  \n" +
                    "                                        ░███                                        \n" +
                    "                                        █████                                       \n" +
                    "                                       ░░░░░                                        ");
            Thread.sleep(1500);
            System.out.println("                                               Created By                                 ");
            System.out.println("                                                Kristen                                   ");
            System.out.println("                                                 Jilly                                    ");
            System.out.println("                                                  Dev                                     ");
            System.out.println("                                                   🩸                                         ");
            System.out.println();

            boolean validInput = false;
            System.out.print("Please enter your name: ");
            while (!validInput){
                userName = scanner.nextLine();
                if(userName.matches("[a-zA-Z]{2,15}")) {
                    player.setUserName(userName);
                    validInput = true;
                }
                else {
                    System.out.println("Please enter a valid user name between 2 and 15 characters (numbers not allowed)");
                }
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println("\nHello " + player.getUserName() + ", please open and read this letter to get started.");
        System.out.println();
        System.out.println("                __________________\n" +
                "               |\\                /|\n" +
                "               | \\              / |  \n" +
                "               | /\\____________/\\ |  \n" +
                "               |/                \\|  \n" +
                "               |__________________|  ");
        System.out.println();
        System.out.print("[O]pen: ");
        openLetter();

    }

    private void playGame(StoryLine storyLine) throws IOException {
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
        if (storyLine.canConclude()) {
            storyLine.getConclusion(userName);
            board.updatePassed(userName);
        } else {
            board.updateFailed(userName);
        }

    }

    private void openLetter() {
        boolean validInput = false;
        while (!validInput) {
            String input = scanner.nextLine();
            if (input.matches("o|O|open|Open")) {
                System.out.println("         ________________________________\n" +
                        "        /  \\                              \\.\n" +
                        "       |    |  Something foul is afoot on  |.\n" +
                        "        \\__ |  the Feathered Express! The  |.\n" +
                        "            |  destination for famed       |.\n" +
                        "            |  feathered foal and fans     |.\n" +
                        "            |  Racers have taken to the    |.\n" +
                        "            |  railway to celebrate their  |.\n" +
                        "            |  wins on the daily races.    |.\n" +
                        "            |  But as the wins ticked up?  |.\n" +
                        "            |  The competition pool ticked |.\n" +
                        "            |  down.                       |.\n" +
                        "            |                              |.\n" +
                        "            |  We have to find the killer! |.\n" +
                        "            |  Answer questions correctly  |.\n" +
                        "            |  & you may solve the mystery |.\n" +
                        "            |  & survive the Feathered     |.\n" +
                        "            |  Express!                    |.\n" +
                        "            |                              |.\n" +
                        "            |  Good luck!                  |.\n" +
                        "            |    __________________________|__\n" +
                        "            |   /                            /.\n" +
                        "            \\__/____________________________/.");
                validInput = true;
            }
        }
    }

    private StoryLine chooseStoryId() {
        int id = 0;
        boolean validInput = false;
        while (!validInput) {
            System.out.println();
            System.out.println();
            System.out.println("             **********************************************");
            System.out.println("             *    Where does your investigation begin?    *");
            System.out.println("             *                                            *");
            System.out.println("             *    [1] The Turkish Ducklight to Istanbul   *");
            System.out.println("             *    [2] The Golden Gander to Geneva         *");
            System.out.println("             *    [3] The Pleasant Pheasant to Paris      *");
            System.out.println("             *                                            *");
            System.out.println("             **********************************************");
            System.out.println();
            System.out.print("Which one will it be? ");
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

    public void updateBoard(String userName) {
        board.updatePassed(userName);
    }

    private void showBoard() {
        board.show();
    }

    private void end() {
        System.out.println("                      .---.\n" +
                "                      |---|\n" +
                "                      |---|\n" +
                "                      |---|\n" +
                "                  .---^ - ^---.\n" +
                "                  :___________:\n" +
                "                     |  |//|\n" +
                "                     |  |//|\n" +
                "                     |  |//|\n" +
                "                     |  |//|\n" +
                "                     |  |//|\n" +
                "                     |  |//|\n" +
                "                     |  |.-|\n" +
                "                     |.-'**|\n" +
                "                      \\***/\n" +
                "                       \\*/\n" +
                "                        V\n" +
                "                   \n" +
                "                       '\n" +
                "                        ^'\n" +
                "                       (_)\n" +
                "               \n" +
                "                   -.   ^   .-\n" +
                "_____________________\\'.|.'/_____________________");
        System.out.println("              Thank you for playing!");
    }

    private StoryLine storyLineOne() {
        return new StoryLine("\nThe beginning1", "\nthe middle1", "\nmiddle end1", "\nend1");
    }

    private StoryLine storyLineTwo() {
        return new StoryLine("\nThe beginning2", "\nthe middle2", "\nmiddle end2", "\nend2");
    }

    private StoryLine storyLineThree() {
        return new StoryLine("\nThe beginning3", "\nthe middle3", "\nmiddle end3", "\nend3");
    }

}
