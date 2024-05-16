package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.Choice;

public class TopStrategy implements Strategy {

  /**
   * Selects the bot's number that will be used for the round by following the TopStrategy which is
   * assuming the user to input with the predominantly selected choice so wining with that.
   */
  @Override
  public int selectNum(ArrayList<Integer> playerInputList, Choice choice) {
    // check if the playerInputList is empty
    if (playerInputList == null || playerInputList.isEmpty()) {
      return Utils.getRandomNumberRange(0, 5);
    }

    // get the amount of odd and even numbers in the list
    int sizeList = playerInputList.size() - 1;
    int oddNum = 0;
    int evenNum = 0;

    for (int i = 0; i < sizeList; i++) {
      if (Utils.isOdd(playerInputList.get(i))) {
        oddNum++;
      } else {
        evenNum++;
      }
    }

    switch (choice) {
      case ODD:
        if (oddNum > evenNum) {
          return Utils.getRandomOddNumber();
        } else if (oddNum < evenNum) {
          return Utils.getRandomEvenNumber();
        } else {
          return Utils.getRandomNumberRange(0, 5);
        }
      case EVEN:
        if (oddNum > evenNum) {
          return Utils.getRandomEvenNumber();
        } else if (oddNum < evenNum) {
          return Utils.getRandomOddNumber();
        } else {
          return Utils.getRandomNumberRange(0, 5);
        }
      default:
        return Utils.getRandomNumberRange(0, 5);
    }
  }
}
