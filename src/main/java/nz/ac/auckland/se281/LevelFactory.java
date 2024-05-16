package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/**
 * A class follows the Factory Design pattern which will create a new constructor with a given
 * parameters.
 */
public class LevelFactory {

  /**
   * Inserts difficulty, playerInputList, choice, strategiesList, and playerWinStats to create a new
   * level.
   *
   * @param difficulty difficulty the user chose
   * @param playerInputList the List of players' inputs
   * @param choice choice the user chose
   * @param strategiesList the List of the strategies used
   * @param playerWinStats the List of the players' win stats
   * @return new EasyLevel, MediumLevel or HardLevel instance created
   */
  public static Level createLevel(
      Difficulty difficulty,
      ArrayList<Integer> playerInputList,
      Choice choice,
      ArrayList<Strategy> strategiesList,
      ArrayList<Boolean> playerWinStats) {

    // Create a constructor with the inputed difficulty
    switch (difficulty) {
      case EASY:
        return new EasyLevel(playerInputList, choice);
      case MEDIUM:
        return new MediumLevel(playerInputList, choice);
      case HARD:
        return new HardLevel(playerInputList, choice, strategiesList, playerWinStats);
      default:
        break;
    }
    return null;
  }
}
