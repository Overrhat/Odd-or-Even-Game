package nz.ac.auckland.se281;

import java.util.ArrayList;

public class RandomStrategy implements Strategy {

  @Override
  public int selectNum(ArrayList<Integer> playerInputList) {
    return Utils.getRandomNumberRange(0, 5);
  }
}
