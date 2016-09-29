package uk.co.lucyleach;

import org.junit.Test;

import static com.google.common.collect.Lists.newArrayList;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DeckCheckerTest {
  private static final DeckChecker UNDER_TEST = new DeckChecker();

  @Test
  public void testNoCards() {
    DeckCheckResult result = UNDER_TEST.checkDeck(newArrayList());
    assertFalse(result.hasErrors());
  }

  @Test
  public void testOneCard() {
    DeckCheckResult result = UNDER_TEST.checkDeck(newArrayList(card("A", "B")));
    assertFalse(result.hasErrors());
  }

  @Test
  public void testDistinctCards() {
    DeckCheckResult result = UNDER_TEST.checkDeck(newArrayList(
        card("A", "B"),
        card("C", "D")
    ));
    assertTrue(result.hasErrors());
    assertFalse(result.getPairsWithoutOverlap().isEmpty());
    assertTrue(result.getPairsWithTooMuchOverlap().isEmpty());
  }

  @Test
  public void testTwoMatchingSymbols() {
    DeckCheckResult result = UNDER_TEST.checkDeck(newArrayList(
        card("A", "B", "C"),
        card("A", "B", "D")
    ));
    assertTrue(result.hasErrors());
    assertTrue(result.getPairsWithoutOverlap().isEmpty());
    assertFalse(result.getPairsWithTooMuchOverlap().isEmpty());
  }

  @Test
  public void testErrorCombo() {
    DeckCheckResult result = UNDER_TEST.checkDeck(newArrayList(
        card("A", "B", "C"),
        card("A", "B", "D"),
        card("E", "F", "G")
    ));
    assertTrue(result.hasErrors());
    assertFalse(result.getPairsWithoutOverlap().isEmpty());
    assertFalse(result.getPairsWithTooMuchOverlap().isEmpty());
  }

  @Test
  public void testAllGood() {
    DeckCheckResult result = UNDER_TEST.checkDeck(newArrayList(
        card("A", "B"),
        card("A", "C"),
        card("B", "C")
    ));
    assertFalse(result.hasErrors());
  }

  private static Card card(String... symbols) {
    return new Card("card", newArrayList(symbols));
  }
}