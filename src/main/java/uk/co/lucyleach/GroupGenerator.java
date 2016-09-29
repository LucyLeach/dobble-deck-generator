package uk.co.lucyleach;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GroupGenerator
{
  public List<Group> groupOutputs(int n) {
    return IntStream.range(0,n).mapToObj(groupIndex -> generateGroup(groupIndex,n)).collect(Collectors.toList());
  }

  private Group generateGroup(int groupIndex, int n) {
    return new Group(getGroupName(groupIndex), IntStream.range(0,n).mapToObj(cardIndex -> generateCard(groupIndex,cardIndex,n)).collect(Collectors.toList()));
  }

  private Card generateCard(int groupIndex, int cardIndex, int n) {
    return new Card(getCardName(cardIndex), IntStream.range(0,n).mapToObj(position -> getSymbol(groupIndex,cardIndex,position,n)).collect(Collectors.toList()));
  }

  private String getGroupName(int i) {
    return "group " + i;
  }

  private String getCardName(int i) {
    return String.valueOf((char)('a' + i));
  }

  private String getSymbol(int group, int card, int position, int numSymbolsPerCard) {
    int p = ((group * position) + card) % numSymbolsPerCard;
    return getCardName(position).toUpperCase() + p;
  }

  public static void main(String[] args) {
    List<Group> groups = new GroupGenerator().groupOutputs(3);
    groups.forEach(System.out::println);
  }
}
