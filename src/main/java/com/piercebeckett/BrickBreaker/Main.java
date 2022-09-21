package com.piercebeckett.BrickBreaker;

import com.piercebeckett.BrickBreaker.model.Paddle;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

public class Main extends Application{

    @Override
    public void start(Stage stage) {
        Group root = new Group();
        Scene scene = new Scene(root, 640, 480);
        stage.setTitle("Brick Breaker");
        stage.setScene(scene);
        stage.setResizable(false);

        Canvas canvas = new Canvas(640, 480);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        Paddle paddle = new Paddle();
        root.getChildren().add(paddle);

        final long startNanoTime = System.nanoTime();

        new AnimationTimer() {
            @Override
            public void handle(long currentNanoTime) {
                double t = (currentNanoTime - startNanoTime) / 1000000000.0;

                double x = ((640 - paddle.getWidth()) / 2) * Math.sin(t) + ((640- paddle.getWidth())/2);

                paddle.setX(x);
            }
        }.start();

        //new Gameplay(gc);
        stage.show();
    }

    public static void main(String[] args){
        launch(args);
    }

}
