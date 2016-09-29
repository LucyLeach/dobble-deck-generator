package uk.co.lucyleach;

import com.google.common.base.Strings;

import java.util.stream.Stream;

public enum GroupName
{
  alpha,
  beta,
  gamma,
  delta,
  epsilon,
  zeta,
  eta,
  theta;

  public String toPaddedString() {
    //noinspection OptionalGetWithoutIsPresent
    int maxLength = Stream.of(values()).mapToInt(name -> name.toString().length()).max().getAsInt();
    return Strings.padEnd(toString(), maxLength, ' ');
  }
}
