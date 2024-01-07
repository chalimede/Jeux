// Copyright(C) 2024, Charles Theetten, <chalimede@proton.me>

package pong;

import static java.lang.Math.abs;
import static java.lang.Math.atan2;
import static java.lang.Math.cos;
import static java.lang.Math.sin;

import static pong.Constants.*;

import javafx.animation.AnimationTimer;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.shape.Circle;


public final class Game extends AnimationTimer {

    final IntegerProperty score = new SimpleIntegerProperty(0);

    final Player            player;
    final Computer          cpu;
    final Circle            ball;

    double                  a   = atan2(VY, VX);
    double                  mag = MAG;
    double                  dX  = mag * cos(a);
    double                  dY  = mag * sin(a);

    boolean                 end = false;


    public Game(Player player, Computer cpu, Circle ball) {
        this.player = player;
        this.cpu    = cpu;
        this.ball   = ball;
    }

    @Override
    public void handle(long now) {
        if (!end) {
            handlePlayer();
            updateGame();
            checkGameOver();
        }
    }

    void checkGameOver() {
        end = (ball.getCenterX() <= 0);
    }

    void handlePlayer() {
        if (player.getY() >=10 && player.getY() <= 600) {
            player.move();
        }
    }

    void reset() {
        end = false;
        a   = atan2(VY, VX);
        mag = MAG;
        dX  = mag * cos(a);
        dY  = mag * sin(a);

        ball.setCenterX(450);
        ball.setCenterY(350);
        player.setY(150);
        score.set(0);
    }

    void updateGame() {
        ball.setCenterX(ball.getCenterX() + dX);
        ball.setCenterY(ball.getCenterY() + dY);
        cpu.setY(ball.getCenterY() - 75);

        if (player.getBoundsInParent().intersects(ball.getBoundsInParent())) {
            mag *= (mag < SPEED) ? ACC : 1;
            a   = abs(C * (player.getY() + 75 - ball.getCenterY() - 15) / 75);
            dX  = mag * cos(a);
            dY  = dY < 0 ? -mag * sin(a) : mag * sin(a);
            score.set(score.get() + 1);
        } else if (cpu.getBoundsInParent().intersects(ball.getBoundsInParent())) {
            dX = -dX;
            ball.setCenterX(1153);
        } else if (ball.getCenterY() > BOTTOM) {
            dY = -dY;
            ball.setCenterY(719);
        } else if (ball.getCenterY() < TOP) {
            dY = -dY;
            ball.setCenterY(16);
        }
    }

}
