package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.Choice;

public class MediumLevel implements Level {
  private Strategy strategy;
  private ArrayList<Integer> playerInputList;
  private Choice choice;

  public MediumLevel(ArrayList<Integer> playerInputList, Choice choice) {
    this.strategy = new RandomStrategy();
    this.playerInputList = playerInputList;
    this.choice = choice;
  }

  @Override
  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  @Override
  public int getNum() {
    // Find which round this is
    int numOfRound = this.playerInputList.size();

    // Set to the TopStrategy if it's 4th or higher round
    if (numOfRound >= 4) {
      this.setStrategy(new TopStrategy());
    }

    return this.strategy.selectNum(this.playerInputList, this.choice);
  }

  @Override
  public Strategy getStrategy() {
    return this.strategy;
  }
}
