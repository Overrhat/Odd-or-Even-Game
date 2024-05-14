package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class LevelFactory {

  public static Level createLevel(Difficulty difficulty, int round) {
    switch (difficulty) {
      case EASY:
        return new EasyLevel(round);
      case MEDIUM:
        return null;
      case HARD:
        return null;
      default:
        break;
    }
    return null;
  }
}
