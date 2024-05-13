package nz.ac.auckland.se281;

public class EasyLevel implements Level {

  private Strategy strategy;

  public EasyLevel() {
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
