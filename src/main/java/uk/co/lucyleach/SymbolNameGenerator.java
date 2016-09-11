package uk.co.lucyleach;

public class SymbolNameGenerator
{
  private int roundNumber;
  private char letter;

  public SymbolNameGenerator()
  {
    roundNumber = -1;
    letter = 'Z';
  }

  public synchronized String getNextSymbolName() {
    if ('Z' == letter) {
      roundNumber++;
      letter = 'A';
    } else {
      letter++;
    }

    if(roundNumber == 0) {
      return Character.toString(letter);
    } else {
      return Character.toString(letter) + roundNumber;
    }
  }
}
