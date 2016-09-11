package uk.co.lucyleach;

import java.util.Set;

public class DeckGenerator
{
  private final CardNameGenerator cardNameGenerator = new CardNameGenerator();
  private final SymbolNameGenerator symbolNameGenerator = new SymbolNameGenerator();

  public Set<Card> generate(int deckSize) {
    System.out.println("Generating with " + deckSize + " cards");
    return null;
  }

  public static void main(String[] args) {
    new DeckGenerator().generate(3);
  }
}
