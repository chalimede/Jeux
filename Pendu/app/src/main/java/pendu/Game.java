// Copyright(C) 2024, Charles Theetten, <chalimede@proton.me>

package pendu;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static pendu.Constants.*;


public final class Game {

  private List<String>  dico;
  private String        word;

  public Game(String file) {
    var path = Paths.get(file);

    try {
      dico = Files.readAllLines(path);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void run() {
    var trials = 0;
    var str = buildStr();
    char c = 0;

    display(str + "\n");
    while (trials < 7 && !str.equals(word)) {
      System.out.print("Choose a letter: ");
      c = EScanner.get().charAt(0);
      if (word.contains(Character.toString(c))) {
        str = checkWord(c, str);
      } else {
        System.out.println(MAN[trials++] + "\n");
      }
      display(str + "\n");
    }
    System.out.println(trials < 7 ? "You win :-)" : "You loose, the word was: " + word);
  }

  private String checkWord(char c, String str) {
    var sb = new StringBuilder(str);

    if (str.contains(Character.toString(c))) {
      System.out.println("Already chosen");
    } else {
      IntStream.range(0, word.length()).filter(i -> word.charAt(i) == c).forEach(i -> sb.setCharAt(i, c));
    }
    return sb.toString();
  }

  private String buildStr() {
    var sb = new StringBuilder();

    IntStream.range(0, word.length()).forEach(e -> sb.append("_"));
    return sb.toString();
  }

  private void display(String str) {
    str.chars().forEach(c -> System.out.print((char) c + " "));
    System.out.println();
  }

  void setWord() {
    word = dico.get(new Random().nextInt(dico.size()));
  }

}
