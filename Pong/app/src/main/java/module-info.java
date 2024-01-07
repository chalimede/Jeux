// Copyright(C) 2024, Charles Theetten, <chalimede@proton.me>

module pong {
    requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    exports pong;

    opens pong to javafx.fxml;
}