package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.Choice;

public class EasyLevel implements Level {

  private Strategy strategy;
  private ArrayList<Integer> playerInputList;
  private Choice choice;

  public EasyLevel(ArrayList<Integer> playerInputList, Choice choice) {
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
    return this.strategy.selectNum(this.playerInputList, this.choice);
  }

  @Override
  public Strategy getStrategy() {
    return this.strategy;
  }
}
