package uk.co.lucyleach;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;

import java.util.List;

public class Group
{
  private final String groupName;
  private final ImmutableList<Card> cards;

  public Group(String groupName, List<Card> cards)
  {
    this.groupName = groupName;
    this.cards = ImmutableList.copyOf(cards);
  }

  @Override
  public String toString()
  {
    return groupName + ": " + Joiner.on(", ").join(cards);
  }
}
