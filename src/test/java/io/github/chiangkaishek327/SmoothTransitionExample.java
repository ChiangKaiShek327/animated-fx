package io.github.chiangkaishek327;

import io.github.chiangkaishek327.animated.control.pane.AnimatedPane;
import io.github.chiangkaishek327.animated.control.tabpane.AnimatedTab;
import io.github.chiangkaishek327.animated.control.tabpane.AnimatedTabPane;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SmoothTransitionExample extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        AnimatedTabPane atp = new AnimatedTabPane();
        atp.setPrefHeight(300);
        atp.setPrefWidth(400);
        AnimatedTab at = new AnimatedTab("red", new Rectangle(100, 100, Paint.valueOf("#ff0000")));
        AnimatedTab at2 = new AnimatedTab("blue", new Rectangle(100, 100, Paint.valueOf("#0000ff")));

        AnimatedTab at3 = new AnimatedTab("green", new Rectangle(100, 100, Paint.valueOf("#00ff00")));

        AnimatedTab at4 = new AnimatedTab("yellow", new Rectangle(100, 100, Paint.valueOf("#ffff00")));
        AnchorPane ape = new AnchorPane();
        ape.widthProperty().addListener((ob, o, n) -> {
        });
        AnimatedTab at5 = new AnimatedTab("debug", ape);
        AnimatedPane ap = new AnimatedPane();
        ape.setBackground(
                new Background(new BackgroundFill(Paint.valueOf("#abc"), null, null)));
        ap.show(atp);
        FXMLLoader fxl = new FXMLLoader(App.class.getResource("test.fxml"));
        fxl.setBuilderFactory(new JavaFXBuilderFactory());
        fxl.load();
        BorderPane bpw = fxl.getRoot();
        AnimatedTab at6 = new AnimatedTab("FXML test", bpw);
        atp.getTabs().addAll(at6, at5, at2, at3, at4, at);
        atp.setDuration(Duration.millis(100));
        primaryStage.setScene(new Scene(ap));

        primaryStage.show();
    }

    public static void a_() {
        launch("");
    }
}