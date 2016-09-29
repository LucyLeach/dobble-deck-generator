package uk.co.lucyleach;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GroupGenerator {
  public Group createSeedGroup(int n) {
    return new Group("seed   ", IntStream.range(0, n).mapToObj(cardIndex -> generateSeedCard(cardIndex, n)).collect(Collectors.toList()));
  }

  private Card generateSeedCard(int cardIndex, int n) {
    return new Card(getCardName(cardIndex), IntStream.range(0,n).mapToObj(position -> getSeedCardSymbolName(cardIndex, position)).collect(Collectors.toList()));
  }

  private String getSeedCardSymbolName(int cardIndex, int position) {
    return getCardName(cardIndex).toUpperCase() + position;
  }

  public List<Group> generate(int n) {
    return IntStream.range(0, n).mapToObj(groupIndex -> generateGroup(groupIndex, n)).collect(Collectors.toList());
  }

  private Group generateGroup(int groupIndex, int n) {
    return new Group(getGroupName(groupIndex), IntStream.range(0, n).mapToObj(cardIndex -> generateCard(groupIndex, cardIndex, n)).collect(Collectors.toList()));
  }

  private Card generateCard(int groupIndex, int cardIndex, int n) {
    return new Card(getCardName(cardIndex), IntStream.range(0, n).mapToObj(position -> getSymbol(groupIndex, cardIndex, position, n)).collect(Collectors.toList()));
  }

  private String getGroupName(int i) {
    return "group " + i;
  }

  private String getCardName(int i) {
    return String.valueOf((char) ('a' + i));
  }

  private String getSymbol(int group, int card, int position, int numSymbolsPerCard) {
    int p = ((group * position) + card) % numSymbolsPerCard;
    return getCardName(position).toUpperCase() + p;
  }

  public static void main(String[] args) {
    int n = 3;
    GroupGenerator groupGenerator = new GroupGenerator();
    System.out.println(groupGenerator.createSeedGroup(n));
    List<Group> groups = groupGenerator.generate(n);
    groups.forEach(System.out::println);
  }
}
