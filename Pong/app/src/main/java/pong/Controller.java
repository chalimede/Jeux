// Copyright(C) 2024, Charles Theetten, <chalimede@proton.me>

package pong;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public final class Controller {

    @FXML
    private Pane        board;
    @FXML
    private Label       score;

    private Player      player;
    private Computer    cpu;
    private Circle      ball;
    private Game        game;


    public Controller() {
        this.cpu    = new Computer(1169, 450, 30, 150);
        this.ball   = new Circle(450, 350, 15, Color.WHITE);
        this.player = new Player(1, 150, 30, 150);
        this.game   = new Game(player, cpu, ball);
    }

    @FXML
    private void initialize() {
        score.textProperty().bind(Bindings.convert(game.score));
        board.getChildren().add(player);
        board.getChildren().add(cpu);
        board.getChildren().add(ball);

        board.setOnKeyPressed(this::onKeyPressed);
        board.setOnKeyReleased(this::onKeyReleased);
    }

    @FXML
    private void run() {
        board.requestFocus();
        game.start();
    }

    @FXML
    private void reset() {
        game.stop();
        game.reset();
    }

    void onKeyPressed(KeyEvent e) {
        switch(e.getCode()) {
            case J:
                if (player.getY() >= 10) {
                    player.setVel(-10);
                    player.move();
                }
                break;
            case N:
                if (player.getY() <= 600) {
                    player.setVel(10);
                    player.move();
                }
                break;
            default:
                break;
        }
    }

    void onKeyReleased(KeyEvent e) {
        player.setVel(0);
    }

}
