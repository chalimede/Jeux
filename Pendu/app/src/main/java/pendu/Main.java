// Copyright(C) 2024, Charles Theetten, <chalimede@proton.me>

package pendu;


public class Main {

  public static void main(String[] args) {
    var resp = 0;
    var game = new Game(args[0]);

    do {
      game.setWord();
      game.run();
      System.out.println("Another game? y / n");
      resp = EScanner.get().charAt(0);
    } while (resp == 'y');
  }

}
