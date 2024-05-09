package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {

  private Difficulty difficulty;
  private Choice choice;
  private int round;
  private String[] options;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    this.difficulty = difficulty;
    this.choice = choice;
    this.round = 1;
    this.options = options;

    // the first element of options[0]; is the name of the player
    MessageCli.WELCOME_PLAYER.printMessage(this.options[0]);
  }

  public void play() {
    // print the number of round
    MessageCli.START_ROUND.printMessage(Integer.toString(round));

    // Add 1 to the round for the next round
    round++;

    // scanning the input finger
    Boolean inputValid = false;
    String input = null;
    int inputNumber;

    while (inputValid == false) {
      // printing the input message
      MessageCli.ASK_INPUT.printMessage();

      // scanning the input
      input = Utils.scanner.nextLine();

      inputValid = true;
    }
  }

  public void endGame() {}

  public void showStats() {}
}
