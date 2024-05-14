package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.Choice;

public class RandomStrategy implements Strategy {

  @Override
  public int selectNum(ArrayList<Integer> playerInputList, Choice choice) {
    return Utils.getRandomNumberRange(0, 5);
  }
}
