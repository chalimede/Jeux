// Copyright(C) 2024, Charles Theetten, <chalimede@proton.me>

package pong;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public final class Computer extends Rectangle {

    public Computer(double x, double y, double w, double h) {
        super(x, y, w, h);
        setFill(Color.WHITE);
    }

}
