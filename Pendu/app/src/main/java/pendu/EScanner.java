// Copyright(C) 2024, Charles Theetten, <chalimede@proton.me>

package pendu;

import java.util.Scanner;


public enum EScanner {
  ;

  private static final Scanner sc = new Scanner(System.in);

  public static String get() {
    return sc.nextLine();
  }

}
