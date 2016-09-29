package uk.co.lucyleach;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.base.Preconditions.checkArgument;

public class DeckGenerator
{
  private final GroupGenerator groupGenerator = new GroupGenerator();

  public List<Card> generate(int numSymbolsOnCard) {
    return generateInGroups(numSymbolsOnCard).stream().flatMap(group -> group.getCards().stream()).collect(Collectors.toList());
  }

  public List<Group> generateInGroups(int numSymbolsOnCard) {
    checkNumberOfSymbols(numSymbolsOnCard);
    List<Group> groups = generateAllGroups(numSymbolsOnCard - 1);
    List<Group> augmentedGroups = new ArrayList<>();
    List<String> newSymbols = new ArrayList<>();
    for(int i = 0; i < groups.size(); i++) {
      String newSymbol = String.valueOf((char) ('A' + i));
      newSymbols.add(newSymbol);
      augmentedGroups.add(groups.get(i).replaceName(newSymbol).transformCards(card -> card.addSymbol(newSymbol)));
    }
    augmentedGroups.add(new Group("seed card", Lists.newArrayList(new Card("-", newSymbols))));
    return augmentedGroups;
  }

  private List<Group> generateAllGroups(int numSymbolsOnCard) {
    Group seedGroup = groupGenerator.createSeedGroup(numSymbolsOnCard);
    List<Group> groups = groupGenerator.generate(numSymbolsOnCard);
    List<Group> allGroups = new ArrayList<>();
    allGroups.add(seedGroup);
    allGroups.addAll(groups);
    return allGroups;
  }

  private void checkNumberOfSymbols(int numSymbolsOnCard) {
    String errorMsgStartTemplate = "Can't generate deck with " + numSymbolsOnCard + " symbols on card, ";
    checkArgument(numSymbolsOnCard > 1, errorMsgStartTemplate + "must have at least 2 symbols");
    checkArgument(numSymbolsOnCard < 10, errorMsgStartTemplate + "too big");
  }

  public static void main(String[] args) {
    List<Card> deck = new DeckGenerator().generate(8);
    deck.forEach(System.out::println);
    System.out.println("Number of cards: " + deck.size());
    System.out.print("Total number of symbols: " + deck.stream().flatMap(card -> card.getSymbols().stream()).distinct().count());
    System.out.println();

    DeckChecker checker = new DeckChecker();
    DeckCheckResult result = checker.checkDeck(deck);
    result.getErrorMessages().forEach(System.out::println);
  }
}
