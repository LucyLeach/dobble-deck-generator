package uk.co.lucyleach;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DeckCheckResult {
  private final ImmutableList<CardPair> pairsWithoutOverlap;
  private final ImmutableList<CardPair> pairsWithTooMuchOverlap;

  public DeckCheckResult(List<CardPair> pairsWithoutOverlap, List<CardPair> pairsWithTooMuchOverlap) {
    this.pairsWithoutOverlap = ImmutableList.copyOf(pairsWithoutOverlap);
    this.pairsWithTooMuchOverlap = ImmutableList.copyOf(pairsWithTooMuchOverlap);
  }

  public boolean hasErrors() {
    return !pairsWithoutOverlap.isEmpty() || !pairsWithTooMuchOverlap.isEmpty();
  }

  public ImmutableList<CardPair> getPairsWithoutOverlap() {
    return pairsWithoutOverlap;
  }

  public ImmutableList<CardPair> getPairsWithTooMuchOverlap() {
    return pairsWithTooMuchOverlap;
  }

  public List<String> getErrorMessages() {
    List<String> messages = new ArrayList<>();
    if(!pairsWithoutOverlap.isEmpty()) {
      messages.add("Pairs without overlap: ");
      messages.addAll(pairsWithoutOverlap.stream().map(pair -> pair.card1.toString() + ", " + pair.card2.toString()).collect(Collectors.toList()));
    }
    if(!pairsWithTooMuchOverlap.isEmpty()) {
      messages.add("Pairs too much overlap: ");
      messages.addAll(pairsWithTooMuchOverlap.stream().map(pair -> pair.card1.toString() + ", " + pair.card2.toString()).collect(Collectors.toList()));
    }
    return messages;
  }

  public static final class Builder {
    private final List<CardPair> pairsWithoutOverlap = new ArrayList<>();
    private final List<CardPair> pairsWithTooMuchOverlap = new ArrayList<>();

    public void addCardsWithoutOverlap(Card card1, Card card2) {
      pairsWithoutOverlap.add(new CardPair(card1, card2));
    }

    public void addCardsWithTooMuchOverlap(Card card1, Card card2) {
      pairsWithTooMuchOverlap.add(new CardPair(card1, card2));
    }

    public DeckCheckResult build() {
      return new DeckCheckResult(pairsWithoutOverlap, pairsWithTooMuchOverlap);
    }
  }

  private static final class CardPair {
    private final Card card1;
    private final Card card2;

    public CardPair(Card card1, Card card2) {
      this.card1 = card1;
      this.card2 = card2;
    }
  }
}
