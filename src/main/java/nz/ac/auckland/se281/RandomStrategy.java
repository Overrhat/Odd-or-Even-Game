package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.Choice;

public class RandomStrategy implements Strategy {

  /**
   * Selects the bot's number that will be used for the round by getting the random number between 0
   * to 5 by using getRandomNumberRange in Utils
   */
  @Override
  public int selectNum(ArrayList<Integer> playerInputList, Choice choice) {
    return Utils.getRandomNumberRange(0, 5);
  }
}
