// Copyright(C) 2024, Charles Theetten, <chalimede@proton.me>

package pong;

import static java.lang.Math.PI;


 record Constants() {

    static final double C      = PI / 4.0;

    static final double TOP    = 15;
    static final double BOTTOM = 735;

    static final double VX     = 5.0;
    static final double VY     = 1.0;

    static final double MAG    = Math.sqrt(26);
    static final double SPEED  = 25;
    static final double ACC    = 1.1;

}
