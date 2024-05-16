package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.Choice;

public class EasyLevel implements Level {

  private Strategy strategy;
  private ArrayList<Integer> playerInputList;
  private Choice choice;

  /**
   * Constructor for EasyLevel
   *
   * @param playerInputList the List of players' inputs
   * @param choice choice the user chose
   */
  public EasyLevel(ArrayList<Integer> playerInputList, Choice choice) {
    this.strategy = new RandomStrategy();
    this.playerInputList = playerInputList;
    this.choice = choice;
  }

  /**
   * Inserts the strategy to set the strategy of the instance
   *
   * @param strategy strategy to set into
   */
  @Override
  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  /**
   * Gets the number that the bot will use by using RandomStrategy
   *
   * @return the number created with the level's strategy
   */
  @Override
  public int getNum() {
    return this.strategy.selectNum(this.playerInputList, this.choice);
  }

  /**
   * gets the strategy of the instance
   *
   * @return the strategy of the instance
   */
  @Override
  public Strategy getStrategy() {
    return this.strategy;
  }
}
