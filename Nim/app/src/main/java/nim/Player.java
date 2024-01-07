// Copyright(C) 2024, Charles Theetten, <chalimede@proton.me>

package nim;


record Player() {

  int getMatches(int[] packets, int indice, int matches) {
    packets[indice] -= matches;
    return matches;
  }

}
