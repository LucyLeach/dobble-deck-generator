package uk.co.lucyleach;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class SymbolNameGeneratorTest
{
  @Test
  public void testFirstSymbol() {
    SymbolNameGenerator generator = new SymbolNameGenerator();
    String firstSymbol = generator.getNextSymbolName();
    assertEquals("A", firstSymbol);
  }

  @Test
  public void testSecondSymbol() {
    SymbolNameGenerator generator = new SymbolNameGenerator();
    generator.getNextSymbolName();
    String secondSymbol = generator.getNextSymbolName();
    assertEquals("B", secondSymbol);
  }

  @Test
  public void testLooping() {
    SymbolNameGenerator generator = new SymbolNameGenerator();
    IntStream.range(0, 26).forEach(i -> generator.getNextSymbolName());
    String twentySeventhSymbol = generator.getNextSymbolName();
    assertEquals("A1", twentySeventhSymbol);
  }

  @Test
  public void testNumberLooping() {
    SymbolNameGenerator generator = new SymbolNameGenerator();
    IntStream.range(0, 52).forEach(i -> generator.getNextSymbolName());
    String fiftyThirdSymbol = generator.getNextSymbolName();
    assertEquals("A2", fiftyThirdSymbol);
  }
}