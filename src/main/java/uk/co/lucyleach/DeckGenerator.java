package uk.co.lucyleach;

import com.google.common.collect.Lists;

import java.util.List;

public class DeckGenerator
{
  private final CardNameGenerator cardNameGenerator = new CardNameGenerator();
  private final SymbolNameGenerator symbolNameGenerator = new SymbolNameGenerator();

  public List<Card> generate(int deckSize) {
    System.out.println("Generating with " + deckSize + " cards");
    return Lists.newArrayList(
          Card.createCard(cardNameGenerator.getNextCardName(), symbolNameGenerator.getNextSymbolName(), symbolNameGenerator.getNextSymbolName()),
          Card.createCard(cardNameGenerator.getNextCardName(), symbolNameGenerator.getNextSymbolName(), symbolNameGenerator.getNextSymbolName()),
          Card.createCard(cardNameGenerator.getNextCardName(), symbolNameGenerator.getNextSymbolName(), symbolNameGenerator.getNextSymbolName())
        );
  }

  public static void main(String[] args) {
    List<Card> deck = new DeckGenerator().generate(3);
    deck.forEach(System.out::println);
  }
}
