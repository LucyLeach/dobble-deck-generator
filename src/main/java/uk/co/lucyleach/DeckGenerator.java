package uk.co.lucyleach;

import com.google.common.collect.Lists;

import java.util.List;

public class DeckGenerator
{
  public List<Card> generate(int deckSize) {
    System.out.println("I do nothing");
    return Lists.newArrayList();
  }

  public static void main(String[] args) {
    List<Card> deck = new DeckGenerator().generate(3);
    deck.forEach(System.out::println);
  }
}
