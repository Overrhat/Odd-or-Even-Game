package nz.ac.auckland.se281;

import java.util.ArrayList;

public class MediumLevel implements Level {
  private Strategy strategy;
  private ArrayList<Integer> playerInputList;

  public MediumLevel(ArrayList<Integer> playerInputList) {
    this.strategy = new RandomStrategy();
    this.playerInputList = playerInputList;
  }

  @Override
  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  @Override
  public int getNum() {
    return this.strategy.selectNum(playerInputList);
  }
}
