package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.Choice;

public interface Strategy {
  int selectNum(ArrayList<Integer> playerInputList, Choice choice);
}
