// Copyright(C) 2024, Charles Theetten, <chalimede@proton.me>

package jeuvingtetun;

import java.util.Scanner;


public class Main {

  public static void main(String[] args) {
    var sc    = new Scanner(System.in);
    var resp  = 0;

    do {
      System.out.println("Give a name for player 1:");
      var p1 = new Player(sc.nextLine());
      System.out.println("Give a name for player 2:");
      var p2   = new Player(sc.nextLine());
      var game = new Game(p1, p2);
      game.run();
      System.out.println("Another game? y / n");
      resp = sc.nextLine().charAt(0);
    } while (resp == 'y');
    sc.close();
  }

}
