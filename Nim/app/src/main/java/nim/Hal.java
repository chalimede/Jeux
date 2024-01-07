// Copyright(C) 2024, Charles Theetten, <chalimede@proton.me>

package nim;

import java.util.Arrays;

import static nim.Colors.*;


record Hal() {

  int getMatches(int[] packets) {
    for (var i = 0; i < packets.length; i++) {
      for (var j = 1; j <= packets[i]; j++) {
        packets[i] -= j;
        if (Arrays.stream(packets).filter(e -> e >= 0).reduce((x, y) -> x ^ y).getAsInt() == 0) {
          System.out.println(RED + "HAL takes " + j + " matches(s) in packet number " + i + "\n" + RESET);
          return j;
        }
        packets[i] += j;
      }
    }
    return 0;
  }

}
