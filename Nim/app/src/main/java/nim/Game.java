// Copyright(C) 2024, Charles Theetten, <chalimede@proton.me>

package nim;

import java.util.Arrays;
import java.util.Random;

import static nim.Colors.*;


public final class Game {

  private Player  player  = new Player();
  private Hal     hal     = new Hal();
  private Random  rand    = new Random();
  private int[]   packets = { };
  private int     matches = 0;

  public Game(int nbPackets) {
    this.packets  = new int[nbPackets];
    this.fillPackets();
  }

  public void run() {
    displayPackets();
    var move = Arrays.stream(packets).reduce((x, y) -> x ^ y).getAsInt() != 0 ? 0 : 1;

    do {
      if (move == 1) {
        System.out.print(CYAN + "\nChoose your packet                     : " + RESET);
        var indice = Integer.parseInt(EScanner.get());
        System.out.print(CYAN + "Choose the number of matches to remove : " + RESET);
        var remove = Integer.parseInt(EScanner.get());
        System.out.println();
        matches -= player.getMatches(packets, indice, remove);
      } else {
        matches -= hal.getMatches(packets);
      }
      displayPackets();
      move ^= 1;
    } while (matches >= 1);
    System.out.println(RED + (move == 1 ? "Hal won." : "Hal lost.") + RESET);
  }

  private void fillPackets() {
    for (var i = 0; i < packets.length; i++) {
      packets[i] = rand.nextInt(5) + 1;
      matches += packets[i];
    }
  }

  private void displayPackets() {
    displayIndices();
    displayLine();

    for (var elem : packets) {
      if (elem != 0) {
        System.out.print("|");
        for (var i = 0; i < elem; i++) {
          System.out.print(GREEN + "|");
        }
        System.out.print(RESET + "|     ");
      } else {
        System.out.print("EMPTY     ");
      }
    }
    System.out.println();
    displayLine();
    System.out.println();
  }

  private void displayIndices() {
    for (var i = 0; i < packets.length; i++) {
      if (packets[i] != 0) {
        System.out.print(i);
        for (var j = 0; j < packets[i]; j++) {
          System.out.print(" ");
        }
        System.out.print("      ");
      } else {
        System.out.print("          ");
      }
    }
    System.out.println();
  }

  private void displayLine() {
    for (var elem : packets) {
      if (elem != 0) {
        System.out.print("-");
        for (var i = 0; i < elem; i++) {
          System.out.print("-");
        }
        System.out.print("-     ");
      } else {
        System.out.print("-----     ");
      }
    }
    System.out.println();
  }

}
