package uk.co.lucyleach;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Group
{
  private final String groupName;
  private final ImmutableList<Card> cards;

  public Group(String groupName, List<Card> cards)
  {
    this.groupName = groupName;
    this.cards = ImmutableList.copyOf(cards);
  }

  public Group replaceName(String newName) {
    return new Group(newName, cards);
  }

  public Group transformCards(Function<Card, Card> transformer) {
    return new Group(groupName, cards.stream().map(transformer).collect(Collectors.toList()));
  }

  public ImmutableList<Card> getCards() {
    return cards;
  }

  @Override
  public String toString()
  {
    return groupName + ": " + Joiner.on(", ").join(cards.stream().map(Card::toStringWithName).collect(Collectors.toList()));
  }
}
