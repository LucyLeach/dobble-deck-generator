package uk.co.lucyleach;

import com.google.common.collect.Sets;

import java.util.List;

public class DeckChecker {
  public DeckCheckResult checkDeck(List<Card> deck) {
    DeckCheckResult.Builder bob = new DeckCheckResult.Builder();
    for(int i = 0; i < deck.size() - 1; i++) {
      for(int j = i + 1; j < deck.size(); j++) {
        Card card1 = deck.get(i);
        Card card2 = deck.get(j);
        int numOverlappingSymbols = Sets.intersection(card1.getSymbolSet(), card2.getSymbolSet()).size();
        if(numOverlappingSymbols == 0) {
          bob.addCardsWithoutOverlap(card1, card2);
        } else if (numOverlappingSymbols > 1) {
          bob.addCardsWithTooMuchOverlap(card1, card2);
        }
      }
    }
    return bob.build();
  }
}
