package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.Choice;

/**
 * The class for the hard level that the user chose for the game which implements the Level
 * interface.
 */
public class HardLevel implements Level {
  private Strategy strategy;
  private ArrayList<Integer> playerInputList;
  private Choice choice;
  private ArrayList<Strategy> strategiesList;
  private ArrayList<Boolean> playerWinStats;

  /**
   * Constructor for HardLevel class.
   *
   * @param playerInputList the List of players' inputs
   * @param choice choice the user chose
   * @param strategiesList the List of the strategies used
   * @param playerWinStats the List of the players' win stats
   */
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

  /**
   * Inserts the strategy to set the strategy of the instance.
   *
   * @param strategy strategy to set into
   */
  @Override
  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  /**
   * Gets the number that the bot will use by using RandomStrategy for the first 3 rounds and from
   * the 4th round, use the strategy from the round before if the bot won the round before. Use
   * another if not.
   *
   * @return the number created with the level's strategy
   */
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

  /**
   * gets the strategy of the instance.
   *
   * @return the strategy of the instance
   */
  @Override
  public Strategy getStrategy() {
    return this.strategy;
  }
}
