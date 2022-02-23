package com.murderexpress;

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
                Thread.sleep(7000);
                chooseStoryId();// choose the story here
                playGame(storyLine);
                showBoard();
                Thread.sleep(3000);
                end();
            } catch (InterruptedException e) {
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
            System.out.print("Please enter your name: ");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        userName = scanner.nextLine();
        player.setUserName(userName);
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

    private void playGame(StoryLine storyLine) {
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
            storyLine.getConclusion();
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
                System.out.println("         ______________________________\n" +
                        "        /  \\                            \\.\n" +
                        "       |    |  Your goal is to solve the |.\n" +
                        "        \\__ |  murder before you run out |.\n" +
                        "            |  of chances.               |.\n" +
                        "            |                            |.\n" +
                        "            |  Please, be careful. The   |.\n" +
                        "            |  killer is out there.      |.\n" +
                        "            |                            |.\n" +
                        "            |  Good Luck!                |.\n" +
                        "            |    ________________________|____\n" +
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
            System.out.println("             *********************************");
            System.out.println("             *    Choose a story to begin    *");
            System.out.println("             *                               *");
            System.out.println("             *    [1]       [2]       [3]    *");
            System.out.println("             *                               *");
            System.out.println("             *********************************");
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
