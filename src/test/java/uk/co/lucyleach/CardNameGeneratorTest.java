package uk.co.lucyleach;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class CardNameGeneratorTest
{
  @Test
  public void testFirstCardName() {
    CardNameGenerator generator = new CardNameGenerator();
    String cardName = generator.getNextCardName();
    assertEquals("1", cardName);
  }

  @Test
  public void testNthCardName() {
    //NB random number is actually n - 1
    int randomNumber = (int) Math.floor(Math.random() * 50);
    CardNameGenerator generator = new CardNameGenerator();
    IntStream.range(0, randomNumber).forEach(i -> generator.getNextCardName());
    String nthCardName = generator.getNextCardName();
    assertEquals(Integer.toString(randomNumber + 1), nthCardName);
  }
}