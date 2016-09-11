package uk.co.lucyleach;

import com.google.common.base.Joiner;
import com.google.common.collect.Sets;

import java.util.HashSet;
import java.util.Set;

public class Card
{
  private final String name;
  private final Set<String> symbols;

  public Card(String name)
  {
    this.name = name;
    symbols = new HashSet<>();
  }

  private Card(String name, Set<String> symbols)
  {
    this.name = name;
    this.symbols = symbols;
  }

  public Card addSymbol(String symbol) {
    if(symbols.contains(symbol))
      throw new IllegalArgumentException("Already contains symbol " + symbol);

    Set<String> newSymbols = new HashSet<>(symbols);
    newSymbols.add(symbol);
    return new Card(name, newSymbols);
  }

  public static Card createCard(String name, String... symbols) {
    return new Card(name, Sets.newHashSet(symbols));
  }

  public int howManyMatchingSymbols(Card otherCard) {
    return Sets.intersection(this.symbols, otherCard.symbols).size();
  }

  public int numberOfSymbols() {
    return symbols.size();
  }

  @Override
  public String toString()
  {
    return name + ": " + Joiner.on(", ").join(symbols);
  }
}
