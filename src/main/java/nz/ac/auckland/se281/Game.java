package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {

  private Difficulty difficulty;
  private Choice choice;
  private int round;
  private String[] options;
  private ArrayList<Integer> playerInputList;
  private ArrayList<Boolean> playerWinStats;
  private ArrayList<Strategy> strategiesList;

  /**
   * Inserts the specified difficulty, choice, options from the user, and creates a new instance of
   * the Game class.
   *
   * @param difficulty difficulty that the user chose for the game
   * @param choice choice of the user for the game
   * @param options name of the user
   */
  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    this.difficulty = difficulty;
    this.choice = choice;
    this.round = 0;
    this.options = options;
    this.playerInputList = new ArrayList<Integer>();
    this.playerWinStats = new ArrayList<Boolean>();
    this.strategiesList = new ArrayList<Strategy>();

    // the first element of options[0]; is the name of the player
    MessageCli.WELCOME_PLAYER.printMessage(this.options[0]);
  }

  /**
   * This method does not insert anything but when it is called, it starts the round of the game
   * which will change some of the fields in the instance and print some messages about the game.
   */
  public void play() {
    // Check if there was a game created
    if (this.playerInputList == null) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    // Add 1 to the round for the next round
    round++;

    // print the number of round
    MessageCli.START_ROUND.printMessage(Integer.toString(round));

    // scanning the input finger
    Boolean inputValid = false;
    String input = null;
    int inputNumber = 0;

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

    // Add the input value to the playerInputList
    playerInputList.add(inputNumber);

    // Printing Player <name>: fingers: <a> After receiving the valid input
    MessageCli.PRINT_INFO_HAND.printMessage(this.options[0], input);

    // Create the level of this game with using the LevelFactory
    Level level =
        LevelFactory.createLevel(
            this.difficulty,
            this.playerInputList,
            this.choice,
            this.strategiesList,
            this.playerWinStats);

    // Get the number that the AI HAL-9000 will use
    int aiValue = level.getNum();
    String aiValueString = Integer.toString(aiValue);

    // Add the strategy to the strategy list
    Strategy roundStrategy = level.getStrategy();
    this.strategiesList.add(roundStrategy);

    // Printing Player <name>: fingers: <a> for the AI
    MessageCli.PRINT_INFO_HAND.printMessage("HAL-9000", aiValueString);

    // Determining the winner
    Boolean playerWins = true;
    int sumNumber = inputNumber + aiValue;

    switch (this.choice) {
      case ODD:
        if (Utils.isOdd(sumNumber)) {
          playerWins = true;
          break;
        } else {
          playerWins = false;
          break;
        }
      case EVEN:
        if (Utils.isEven(sumNumber)) {
          playerWins = true;
          break;
        } else {
          playerWins = false;
          break;
        }
      default:
        break;
    }

    // add to win list
    this.playerWinStats.add(playerWins);

    // print the outcome of this round
    String sumString = Integer.toString(sumNumber);
    String sumOddOrEven;

    if (Utils.isOdd(sumNumber)) {
      sumOddOrEven = "ODD";
    } else {
      sumOddOrEven = "EVEN";
    }

    if (playerWins) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage(sumString, sumOddOrEven, this.options[0]);
    } else {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage(sumString, sumOddOrEven, "HAL-9000");
    }
  }

  /**
   * This method does not insert anything but when it is called, it ends the round of the game which
   * will reset the fields in the instance and print some messages about the game.
   */
  public void endGame() {
    // Check if there was a game created
    if (this.playerInputList == null) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    // Count how many wins the player has
    int wins = 0;
    for (Boolean won : playerWinStats) {
      if (won) {
        wins++;
      }
    }

    // Get how many wins ai has
    int aiWins = this.round - wins;

    // Show the final stats by using showStats method
    this.showStats();

    // Print the winner
    if (wins > aiWins) {
      MessageCli.PRINT_END_GAME.printMessage(options[0]);
    } else if (wins < aiWins) {
      MessageCli.PRINT_END_GAME.printMessage("HAL-9000");
    } else {
      MessageCli.PRINT_END_GAME_TIE.printMessage();
    }

    // Setting to endGame (putting everything back to null)
    this.difficulty = null;
    this.choice = null;
    this.round = 0;
    this.options = null;
    this.playerInputList = null;
    this.playerWinStats = null;
    this.strategiesList = null;
  }

  /**
   * This method does not insert anything but when it is called, it shows the stats of the game
   * which will print some messages about the game by using the instance.
   */
  public void showStats() {
    // Check if there was a game created
    if (this.playerInputList == null) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    // Count how many wins the player has
    int wins = 0;
    for (Boolean won : playerWinStats) {
      if (won) {
        wins++;
      }
    }

    // Get how many wins ai has
    int aiWins = this.round - wins;

    // Print the stats
    String winsString = Integer.toString(wins);
    String aiWinsString = Integer.toString(aiWins);

    MessageCli.PRINT_PLAYER_WINS.printMessage(options[0], winsString, aiWinsString);
    MessageCli.PRINT_PLAYER_WINS.printMessage("HAL-9000", aiWinsString, winsString);
  }
}
