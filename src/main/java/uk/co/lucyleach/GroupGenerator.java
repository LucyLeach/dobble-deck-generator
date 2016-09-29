package uk.co.lucyleach;

import com.google.common.base.Joiner;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GroupGenerator
{
  public List<String> groupOutputs(int n) {
    return IntStream.range(0,n).mapToObj(group -> generateGroup(group,n)).collect(Collectors.toList());
  }

  private String generateGroup(int group, int n) {
    return Utils.getGroupName(group) + ": " + Joiner.on(", ").join(IntStream.range(0,n).mapToObj(card -> generateCard(group,card,n)).collect(Collectors.toList()));
  }

  private String generateCard(int group, int card, int n) {
    return Utils.getCardName(card) + ":{" + Joiner.on(",").join(IntStream.range(0,n).mapToObj(position -> Utils.getSymbol(group,card,position,n)).collect(Collectors.toList())) + "}";
  }

  public static void main(String[] args) {
    new GroupGenerator().groupOutputs(5).forEach(System.out::println);
  }
}
