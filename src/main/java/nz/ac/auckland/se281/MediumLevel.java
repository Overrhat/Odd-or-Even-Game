package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.Choice;

public class MediumLevel implements Level {
  private Strategy strategy;
  private ArrayList<Integer> playerInputList;
  private Choice choice;

  /**
   * Constructor for MediumLevel
   *
   * @param playerInputList the List of players' inputs
   * @param choice choice the user chose
   */
  public MediumLevel(ArrayList<Integer> playerInputList, Choice choice) {
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
   * Gets the number that the bot will use by using RandomStrategy for the first 3 rounds of the
   * game and using TopStrategy for rest of the game
   *
   * @return the number created with the level's strategy
   */
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
