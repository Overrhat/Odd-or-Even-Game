package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.Choice;

public class HardLevel implements Level {
  private Strategy strategy;
  private ArrayList<Integer> playerInputList;
  private Choice choice;
  private ArrayList<Strategy> strategiesList;
  private ArrayList<Boolean> playerWinStats;

  public HardLevel(
      ArrayList<Integer> playerInputList,
      Choice choice,
      ArrayList<Strategy> strategiesList,
      ArrayList<Boolean> playerWinStats) {
    this.strategy = new RandomStrategy();
    this.playerInputList = playerInputList;
    this.choice = choice;
    this.strategiesList = strategiesList;
    this.playerWinStats = playerWinStats;
  }

  @Override
  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  @Override
  public int getNum() {
    // Find which round this is
    int numOfRound = this.playerInputList.size();

    // Set to the RandomStrategy if it's lower than 4th round
    if (numOfRound < 4) {
      return this.strategy.selectNum(this.playerInputList, this.choice);
    }

    // find the last strategy used
    int sizeOfList = this.strategiesList.size();
    Strategy lastStrategy = this.strategiesList.get(sizeOfList - 1);

    // Determine if the player won or not for the last round
    Boolean wonLast = this.playerWinStats.get((numOfRound - 2));

    // Use the HardLevel Technique
    if (!wonLast) {
      this.setStrategy(lastStrategy);
    } else {
      if (lastStrategy instanceof TopStrategy) {
        this.setStrategy(new RandomStrategy());
      } else {
        this.setStrategy(new TopStrategy());
      }
    }
    return this.strategy.selectNum(this.playerInputList, this.choice);
  }

  @Override
  public Strategy getStrategy() {
    return this.strategy;
  }
}
