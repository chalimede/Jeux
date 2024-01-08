// Copyright(C) 2024, Charles Theetten, <chalimede@proton.me>

package jeuvingtetun;

import java.util.Random;


public final class Player {

     private static final Random rand = new Random();

     private String name;


     public Player(String name) {
        this.name = name;
     }

     int throwDice() {
        return rand.nextInt(6) + 1;
     }

     @Override
     public String toString() {
        return name;
     }

}
