package uk.co.lucyleach;

public class CardNameGenerator
{
  private int lastCardName;

  public CardNameGenerator()
  {
    this.lastCardName = 0;
  }

  public synchronized String getNextCardName() {
    lastCardName++;
    return Integer.toString(lastCardName);
  }
}
