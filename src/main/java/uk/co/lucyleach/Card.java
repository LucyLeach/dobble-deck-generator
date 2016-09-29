package uk.co.lucyleach;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Card
{
  private final String name;
  private final ImmutableList<String> symbols;

  public Card(String name, List<String> symbols)
  {
    this.name = name;
    this.symbols = ImmutableList.copyOf(symbols);
  }

  public Card addSymbol(String symbol) {
    List<String> newSymbols = new ArrayList<>();
    newSymbols.addAll(symbols);
    newSymbols.add(symbol);
    return new Card(name, newSymbols);
  }

  public ImmutableList<String> getSymbols() {
    return symbols;
  }

  public Set<String> getSymbolSet() {
    return ImmutableSet.copyOf(symbols);
  }

  public String toStringWithName() {
    return name + ":" + toString();
  }

  @Override
  public String toString()
  {
    return "{" + Joiner.on(",").join(symbols) + "}";
  }
}
