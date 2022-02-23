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
                Thread.sleep(20000);
                chooseStoryId();// choose the story here
                playGame(storyLine);
                showBoard();
                Thread.sleep(5000);
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
            System.out.println("                                             Created By                                 ");
            System.out.println("                                              Kristen                                   ");
            System.out.println("                                               Jilly                                    ");
            System.out.println("                                                Dev                                     ");
            System.out.println("                                                 🩸                                         ");
            System.out.println();

            boolean validInput = false;
            System.out.print("Please enter your name: ");
            while (!validInput) {
                userName = scanner.nextLine();
                if (userName.matches("[a-zA-Z]{2,15}")) {
                    player.setUserName(userName);
                    validInput = true;
                } else {
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
            try {
                Thread.sleep(30000);
                board.updatePassed(userName);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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
                        "            |  feathered fowl and fans.    |.\n" +
                        "            |  Racers have taken to the    |.\n" +
                        "            |  railway to celebrate their  |.\n" +
                        "            |  wins on the daily races.    |.\n" +
                        "            |  But as the wins ticked up,  |.\n" +
                        "            |  the competition pool ticked |.\n" +
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
            System.out.println("         **********************************************");
            System.out.println("         *    Where does your investigation begin?    *");
            System.out.println("         *                                            *");
            System.out.println("         *    [1] The Turkish Ducklight to Istanbul   *");
            System.out.println("         *    [2] The Golden Gander to Geneva         *");
            System.out.println("         *    [3] The Pleasant Pheasant to Paris      *");
            System.out.println("         *                                            *");
            System.out.println("         **********************************************");
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
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }

    private StoryLine storyLineOne() {
        return new StoryLine(
                //Scene One
                "\n" + "\n" + "====================================================================================================\n" +
                        "In the midst of a blizzard at night on the Turkish Ducklight to Istanbul.\n" +
                        "Your contact Private Hercule Quacker, has received an urgent telegram instructing him to return to London.\n" +
                        "Naturally, given your prestigious reputation, Hercule Quacker extends the invitation to you, " +
                        player.getUserName() + "\n" +
                        "\nYou accept and jump trains to the Lavish Loon. Upon boarding you try to not be disarmed by the luxury,\n" +
                        "ever vigilant and on your feathers. Upon unpacking your wares in your stateroom, there's a knock on the door.\n" +
                        "Who else would it be but DuckRacer #13, Leo Quackett, the 6 time race champion.\n" + "\n" +
                        player.getUserName() + ", \"We have an issue, a shadowy quacker has been looming near my stateroom. I do fear the worst.\" \n" +
                        "You hastily set a time to meet, over an unassuming cup of coffee the next morning, attempting to keep a low profile.\n" +
                        "All the while, completely unaware of the shadow that was moving, in the next stateroom.\n \n",

                //Scene Two
                "\n" + "\n" + "====================================================================================================\n" +
                        "In the early dawn of the morning, as the Lavish Loon inched closer to London, the blizzard began.\n" +
                        "As the train passed through the Alps, the squalls overwhelmed the train and it lurched to a stop.\n" +
                        "The Lavish Loon, was victim of an insurmountable snowdrift.\n\n" +
                        "You hear the other passengers, startled by the early morning upset, milling about.\n" +
                        "Suddenly, a piercing scream arises from a few staterooms down. It is too late.\n" +
                        "A murder has occurred. 6-time champion, Leo Quackett, is dead.\n\n" +
                        "Who could possibly be responsible for such a heinous act? What could drive a duck to this?\n" +
                        "... an act of passion? Possible jealousy? \n\n" +
                        "You send telegram to London, and head to the room to investigate.\n",

                //Scene Three
                "\n" + "\n" + "====================================================================================================\n" +
                        "Quackett's room is mostly undisturbed aside from an open window, and a handkerchief\n" +
                        "with an embroidered \"G\" lying on the floor.\n" + "\n" +
                        "Interviews with passengers proved useless. No solid leads. Only the mention of a strange shawled dame...  \n" +
                        player.getUserName() + ", it was in fact an act of passion.\n" + "\n" +
                        "All that remained when they took Leo Quackett away was lingering smell of perfume.\n\n",


                //Scene Four
                "\n" + "\n" + "====================================================================================================\n" +
                        "You have heard more alibis than you have leads.\n" +
                        "Every duck has a story, but stories don't catch criminals.\n\n" +
                        "The conductor and crew were able to clear the tracks as the Lavish Loon speeds forward. \n" +
                        "The clock is ticking and a murderer is still on the loose.\n\n" +
                        "Who could it be, " + player.getUserName() + "?");
    }

    private StoryLine storyLineTwo() {
        return new StoryLine(

                //Scene One
                "\n" + "\n" + "====================================================================================================\n" +
                        "You step onto the Golden Gander. The train is full so you'll be spending your night, shoulder-to-shoulder in the dining car.\n" +
                        "Ever since the duck races got hot, these trains seemed to find capacity to pack in the fowl..\n" +
                        "safety regulations or not. You meet with your contact Private Quack Hercule Quacker. \n\n" +

                        "\"I've heard good things about you " + player.getUserName() + ", I hope you've got a strong" + "\n" +
                        "stomach because this ain't for the faint of heart. \n" +
                        "This quacker has passion, passion and nothing to lose.\"\n" + "\n" +
                        "You begin reviewing the briefings but are caught off guard by the faint smell of perfume.\n" +
                        "Out of the side of your eye you think you see a shawled silhouette of a dame but you readjust and return to reading\n",

                //Scene Two
                "\n" + "\n" + "====================================================================================================\n" +
                        "The train is abuzz, famed duck racer, Dina Honks was aboard.\n" +
                        "It was hard to catch sight of this racer with the crowding of fans, feather-to-feather.\n\n" +
                        "She slid through the dining car, fans trailing but the look on her face\n" +
                        "was anything but light. You could see there was worry.\n" +
                        "She kept looking over her shoulder, sweat beading on her beak. \n" +
                        "All of the sudden, from the back of the train there was a POW!! \n\n" +
                        "Panic ensues as fearful fowl scramble to escape. \n" +
                        "Dina Honks lay on the ground, yet another victim of this gruesome game.\n" +
                        "I head out of the dining car and to Hercule's room to advise him of the grim development.\n",

                //Scene Three
                "\n" + "\n" + "====================================================================================================\n" +
                        player.getUserName() + " the number two racer in the world is dead... do we even have a lead?\n" +
                        "You continue to search around the scene. \n" + "\n" +
                        "Hard to discern whats a clue and what may have been lost in the rush to leave the dining car. \n" +
                        "A knitting needle, grey and white feathers, a misplaced \"G\" embroidered handkerchief - all that can be found. \n" + "\n" +
                        "But that familiar smell of perfume still remained, even with the smell of gun-smoke hanging in the air.\n",

                //Scene Four
                "\n" + "\n" + "====================================================================================================\n" +
                        "You have heard more alibis than you have leads.\n" +
                        "Every duck has a story, but stories don't catch criminals.\n" + "\n" +
                        "The Golden Gander remains abuzz as no murderer has been caught.\n" +
                        "The train drives forward, full speed towards Geneva.\n" +
                        "The clock is ticking and a murderer is still on the loose.\n\n" +
                        "Who could it be, " + player.getUserName() + "?\n");
    }

    private StoryLine storyLineThree() {
        return new StoryLine(
                //Scene One
                "\n" + "\n" + "====================================================================================================\n" +
                        "You board the Pleasant Pheasant and are caught off guard." + "\n" + "You knew Chuckle McQuackins was on board (famed racer and comedic entertainer)" +
                        "\n" + "but were still surprised to see the famed clown racer.\n" +
                        "He turned the train into a literal car clown. Clown dressed ducks everywhere.\n" +
                        "The only non-costumed quacker was Hercule Quacker, your contact. \n" + "\n" +
                        "He looked equally as fuzzy feathered as you, " + player.getUserName() + ".\n" +
                        "All that can be heard were honks and chuckles as you walked to your stateroom,\n" +
                        "You are already agitated by the circus that's become your investigation.\n",
                //Scene Two
                "\n" + "\n" + "====================================================================================================\n" +
                        "You notice another non-costumed quack on board. You haven't been able to see a face" + "\n" +
                        "but you've seen the silhouette of a duck, wrapped in a shawl and obviously interested" + "\n" +
                        "in keeping clear of the clowning. They moved like a phantom, hard to track but unassuming" + "\n" +
                        "enough and always leaving the faint smell of perfume.\n" + "\n" +
                        "Chuckle was in the dining car, surrounded by acolytes.\n" + "\n" +
                        "You sat with your back to the caboose, watching the clown. He was gleeful, but an undercurrent\n" +
                        "of concern rest on his face. All of a sudden, Chuckle began to grab his neck. His feathers\n" +
                        "greying and the sweat beading on his bill. He fell forward into his caraft of soup.\n\n" +
                        "The clowns around him honked in panic as they attempted to wake him up. It looked like \n" +
                        "poison. Another racer gone. Killed by an act of passion.\n",
                //Scene Three
                "\n" + "\n" + "====================================================================================================\n" +
                        "You know that you need to find the shawled duck but they are nowhere to be found.\n" +
                        "You searched the scene and find an empty bottle of rat poison, it'd fallen in the hall.\n\n" +
                        "It'd fallen with butterscotch wrappers, an old tissue, and about $0.64 in a change purse.\n" +
                        "Related? Unsure. But the duck eluded you and you continue to search.\n",
                //Scene Four
                "\n" + "\n" + "====================================================================================================\n" +
                        "The Pleasant Pheasant trip was no clowning around\n" +
                        "No alibis, but a potential suspect who couldn't be found.\n" +
                        "\n" + "The train continued forward, full speed towards Paris. \n" +
                        "The clock is ticking and a murderer is still on the loose.\n\n" +
                        "Who could it be, " + player.getUserName() + "?\n");
    }
}

