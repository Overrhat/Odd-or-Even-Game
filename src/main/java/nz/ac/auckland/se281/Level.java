package nz.ac.auckland.se281;

public interface Level {
  /**
   * Inserts the strategy to set the strategy of the instance
   *
   * @param strategy strategy to set into
   */
  void setStrategy(Strategy strategy);

  /**
   * Gets the number that the bot will use for the round in this instance
   *
   * @return the number created with the level's strategy
   */
  int getNum();

  /**
   * gets the strategy of the instance
   *
   * @return the strategy of the instance
   */
  Strategy getStrategy();
}
