package nz.ac.auckland.se281;

public class TopStrategy implements Strategy {

  @Override
  public int selectNum() {
    return Utils.getRandomNumberRange(0, 5);
  }
}
