package com.murderexpress;

import java.io.Serializable;
import java.util.Scanner;

public class Game {
    public Board board = Board.getInstance();
    private Scanner scanner = new Scanner(System.in);
    boolean isOver = false;
    private StoryLine storyLine;
    private Player player = new Player();
    private String userName;


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
        System.out.println("     ██████   ██████                          █████                   \n" +
                "   ░░██████ ██████                          ░░███                    \n" +
                "    ░███░█████░███  █████ ████ ████████   ███████   ██████  ████████ \n" +
                "    ░███░░███ ░███ ░░███ ░███ ░░███░░███ ███░░███  ███░░███░░███░░███\n" +
                "    ░███ ░░░  ░███  ░███ ░███  ░███ ░░░ ░███ ░███ ░███████  ░███ ░░░ \n" +
                "    ░███      ░███  ░███ ░███  ░███     ░███ ░███ ░███░░░   ░███     \n" +
                "    █████     █████ ░░████████ █████    ░░████████░░██████  █████    \n" +
                "   ░░░░░     ░░░░░   ░░░░░░░░ ░░░░░      ░░░░░░░░  ░░░░░░  ░░░░░     \n" +
                "                                                                  ");
        System.out.println("             ▄▀▀▀▀▄   ▄▀▀▄ ▀▄      ▄▀▀▀█▀▀▄  ▄▀▀▄ ▄▄   ▄▀▀█▄▄▄▄ \n" +
                "           █      █ █  █ █ █     █    █  ▐ █  █   ▄▀ ▐  ▄▀   ▐ \n" +
                "           █      █ ▐  █  ▀█     ▐   █     ▐  █▄▄▄█    █▄▄▄▄▄  \n" +
                "           ▀▄    ▄▀   █   █         █         █   █    █    ▌  \n" +
                "             ▀▀▀▀   ▄▀   █        ▄▀         ▄▀  ▄▀   ▄▀▄▄▄▄   \n" +
                "                    █    ▐       █          █   █     █    ▐   \n" +
                "                    ▐            ▐          ▐   ▐     ▐        ");

        System.out.println("  █████▒▓█████ ▄▄▄     ▄▄▄█████▓ ██░ ██  █    ██  ██▀███  ▓█████ ▓█████▄ \n" +
                "▓██   ▒ ▓█   ▀▒████▄   ▓  ██▒ ▓▒▓██░ ██▒ ██  ▓██▒▓██ ▒ ██▒▓█   ▀ ▒██▀ ██▌\n" +
                "▒████ ░ ▒███  ▒██  ▀█▄ ▒ ▓██░ ▒░▒██▀▀██░▓██  ▒██░▓██ ░▄█ ▒▒███   ░██   █▌\n" +
                "░▓█▒  ░ ▒▓█  ▄░██▄▄▄▄██░ ▓██▓ ░ ░▓█ ░██ ▓▓█  ░██░▒██▀▀█▄  ▒▓█  ▄ ░▓█▄   ▌\n" +
                "░▒█░    ░▒████▒▓█   ▓██▒ ▒██▒ ░ ░▓█▒░██▓▒▒█████▓ ░██▓ ▒██▒░▒████▒░▒████▓ \n" +
                " ▒ ░    ░░ ▒░ ░▒▒   ▓▒█░ ▒ ░░    ▒ ░░▒░▒░▒▓▒ ▒ ▒ ░ ▒▓ ░▒▓░░░ ▒░ ░ ▒▒▓  ▒ \n" +
                " ░       ░ ░  ░ ▒   ▒▒ ░   ░     ▒ ░▒░ ░░░▒░ ░ ░   ░▒ ░ ▒░ ░ ░  ░ ░ ▒  ▒ \n" +
                " ░ ░       ░    ░   ▒    ░       ░  ░░ ░ ░░░ ░ ░   ░░   ░    ░    ░ ░  ░ \n" +
                "           ░  ░     ░  ░         ░  ░  ░   ░        ░        ░  ░   ░    \n" +
                "                                                                  ░      ");
        System.out.println("     ██████████                                                         \n" +
                "   ░░███░░░░░█                                                         \n" +
                "    ░███  █ ░  █████ █████ ████████  ████████   ██████   █████   █████ \n" +
                "    ░██████   ░░███ ░░███ ░░███░░███░░███░░███ ███░░███ ███░░   ███░░  \n" +
                "    ░███░░█    ░░░█████░   ░███ ░███ ░███ ░░░ ░███████ ░░█████ ░░█████ \n" +
                "    ░███ ░   █  ███░░░███  ░███ ░███ ░███     ░███░░░   ░░░░███ ░░░░███\n" +
                "    ██████████ █████ █████ ░███████  █████    ░░██████  ██████  ██████ \n" +
                "   ░░░░░░░░░░ ░░░░░ ░░░░░  ░███░░░  ░░░░░      ░░░░░░  ░░░░░░  ░░░░░░  \n" +
                "                           ░███                                        \n" +
                "                           █████                                       \n" +
                "                          ░░░░░                                        ");

        System.out.println("                                                                       ");
        System.out.println("                                                                       ");
        System.out.print("Please enter your name: ");
        userName = scanner.nextLine();
        player.setUserName(userName);
        System.out.println();
        System.out.println("\nHello " + player.getUserName() + ", please read this letter to get started.");
        System.out.println();
        System.out.println("         __________________\n" +
                "        |\\                /|\n" +
                "        | \\              / |  \n" +
                "        | /\\____________/\\ |  \n" +
                "        |/                \\|  \n" +
                "        |__________________|  ");
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
            board.update(userName);
        } else {
            board.updateFailed(userName);
        }

    }

    private void openLetter() {
        boolean validInput = false;
        while (!validInput) {
            String input = scanner.nextLine();
            if (input.matches("o|O|open|Open")) {
                System.out.println("   ______________________________\n" +
                        " / \\                             \\.\n" +
                        "|   |  Your goal is to solve the |.\n" +
                        " \\_ |  murder before you run out |.\n" +
                        "    |  of chances.               |.\n" +
                        "    |                            |.\n" +
                        "    |  Please, be careful. The   |.\n" +
                        "    |  killer is out there.      |.\n" +
                        "    |                            |.\n" +
                        "    |  Good Luck!                |.\n" +
                        "    |   _________________________|___\n" +
                        "    |  /                            /.\n" +
                        "    \\_/____________________________/.");
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
            System.out.println("    *******************************");
            System.out.println("    *   Choose a story to begin   *");
            System.out.println("    *   [1]       [2]       [3]   *");
            System.out.println("    *    🦆        🦆        🦆    *");
            System.out.println("    *******************************");
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
        board.update(userName);
    }

    private void showBoard() {
        board.show();
    }

    private void end() {
        System.out.println("\nThank you for playing!");
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
