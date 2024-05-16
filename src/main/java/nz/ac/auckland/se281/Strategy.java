package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.Choice;

public interface Strategy {
  /**
   * Selects the bot's number that will be used for the round
   *
   * @param playerInputList the List of players' inputs
   * @param choice choice the user chose
   * @return the bot's number
   */
  int selectNum(ArrayList<Integer> playerInputList, Choice choice);
}
