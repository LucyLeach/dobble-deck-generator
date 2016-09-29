package uk.co.lucyleach;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;

import java.util.List;

public class Card
{
  private final String name;
  private final ImmutableList<String> symbols;

  public Card(String name, List<String> symbols)
  {
    this.name = name;
    this.symbols = ImmutableList.copyOf(symbols);
  }

  @Override
  public String toString()
  {
    return name + ":{" + Joiner.on(",").join(symbols) + "}";
  }
}
