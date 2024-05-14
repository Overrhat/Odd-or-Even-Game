package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

public class LevelFactory {

  public static Level createLevel(
      Difficulty difficulty, ArrayList<Integer> playerInputList, Choice choice) {
    switch (difficulty) {
      case EASY:
        return new EasyLevel(playerInputList, choice);
      case MEDIUM:
        return new MediumLevel(playerInputList, choice);
      case HARD:
        return null;
      default:
        break;
    }
    return null;
  }
}
