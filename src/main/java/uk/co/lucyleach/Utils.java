package uk.co.lucyleach;

public class Utils
{
  public static String getGroupName(int i) {
    return GroupName.values()[i].toPaddedString();
  }

  public static String getCardName(int i) {
    return String.valueOf((char)('a' + i));
  }

  public static String getSymbol(int group, int card, int position, int numSymbolsPerCard) {
    int p = ((group * position) + card) % numSymbolsPerCard;
    return getCardName(position).toUpperCase() + p;
  }
}
