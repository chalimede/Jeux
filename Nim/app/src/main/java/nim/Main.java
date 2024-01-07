// Copyright(C) 2024, Charles Theetten, <chalimede@proton.me>

package nim;


public class Main {

  public static void main(String[] args) {
    System.out.print("Give the number of packets : ");
    var nbPackets = Integer.parseInt(EScanner.get());
    System.out.println();
    var game = new Game(nbPackets);
    game.run();
  }

}
