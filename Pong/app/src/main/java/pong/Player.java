// Copyright(C) 2024, Charles Theetten, <chalimede@proton.me>

package pong;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public final class Player extends Rectangle {

    private double vel;


    public Player(double x, double y, double w, double h) {
        super(x, y, w, h);
        setFill(Color.WHITE);
    }

    void move() {
        setY(getY() + vel);
    }

    void setVel(int vel) {
        this.vel = vel;
    }

}
