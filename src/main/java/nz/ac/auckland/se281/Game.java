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

      // Checking the length of the input
      if (input.length() != 1) {
        MessageCli.INVALID_INPUT.printMessage();
        continue;
      }

      // Checking the number is between 0 and 5 (inclusive)
      try {
        inputNumber = Integer.parseInt(input);
        if (inputNumber < 6 && inputNumber > -1) {
          inputValid = true;
          break;
        } else {
          MessageCli.INVALID_INPUT.printMessage();
          continue;
        }
      } catch (NumberFormatException e) {
        MessageCli.INVALID_INPUT.printMessage();
        continue;
      }
    }
  }

  public void endGame() {}

  public void showStats() {}
}
