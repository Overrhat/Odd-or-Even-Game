package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

public class LevelFactory {

  public static Level createLevel(
      Difficulty difficulty,
      ArrayList<Integer> playerInputList,
      Choice choice,
      ArrayList<Strategy> strategiesList,
      ArrayList<Boolean> playerWinStats) {
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
