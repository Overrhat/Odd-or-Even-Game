package nz.ac.auckland.se281;

public class MediumLevel implements Level {
  private Strategy strategy;

  public MediumLevel(int round) {
    this.strategy = new RandomStrategy();
  }

  @Override
  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  @Override
  public int getNum() {
    return this.strategy.selectNum();
  }
}
