package com.piercebeckett.BrickBreaker;

import com.piercebeckett.BrickBreaker.model.Ball;
import com.piercebeckett.BrickBreaker.model.Paddle;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Main extends Application{

    private Paddle paddle = new Paddle();
    private Ball ball = new Ball();
    private double paddleDx = 0;

    public static final double WINDOW_WIDTH = 640;
    public static final double WINDOW_HEIGHT = 480;

    AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long currentNanoTime) {
            //double t = (currentNanoTime - startNanoTime) / 1000000000.0;
            //double x = ((640 - paddle.getWidth()) / 2) * Math.sin(t) + ((640- paddle.getWidth())    /2);
            //paddle.setX(x);

            paddle.setX(paddle.getX() + paddleDx);
            if(paddle.getX() < 0){
                paddle.setX(0);
            }
            else if(paddle.getX() > (WINDOW_WIDTH - paddle.getWidth())){
                paddle.setX(WINDOW_WIDTH - paddle.getWidth());
            }

            ball.setCenterX(ball.getCenterX() + ball.getxVelocity());
            ball.setCenterY(ball.getCenterY() + ball.getyVelocity());

            if((ball.getCenterX() - ball.getRadius()) < 0) {
                ball.setxVelocity(ball.getxVelocity() * -1);
                ball.setCenterX(ball.getRadius());
            }
            else if((ball.getCenterX() + ball.getRadius()) > WINDOW_WIDTH){
                ball.setxVelocity(ball.getxVelocity() * -1);
                ball.setCenterX(WINDOW_WIDTH - ball.getRadius());
            }

            if((ball.getCenterY() - ball.getRadius()) < 0) {
                ball.setyVelocity(ball.getyVelocity() * -1);
                ball.setCenterY(ball.getRadius());
            }
            else if((ball.getCenterY() + ball.getRadius()) > WINDOW_HEIGHT){
                ball.setyVelocity(ball.getyVelocity() * -1);
                ball.setCenterY(WINDOW_HEIGHT - ball.getRadius());
            }
        }
    };

    @Override
    public void start(Stage stage) {
        Group root = new Group();
        Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
        stage.setTitle("Brick Breaker");
        stage.setScene(scene);
        stage.setResizable(false);

        Canvas canvas = new Canvas(WINDOW_WIDTH, WINDOW_HEIGHT);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        canvas.setFocusTraversable(false);
        scene.setOnKeyPressed(keyPressed);
        scene.setOnKeyReleased(keyReleased);

        root.getChildren().addAll(paddle, ball);

        final long startNanoTime = System.nanoTime();

        timer.start();
        stage.show();
    }

    public static void main(String[] args){
        launch(args);
    }

    public EventHandler<KeyEvent> keyPressed = new EventHandler<KeyEvent>() {
        @Override
        public void handle(KeyEvent keyEvent) {

            switch(keyEvent.getCode()){
                case A:
                    paddleDx = -1 * paddle.getSpeed();
                    System.out.println("Key Press: A");
                    break;
                case D:
                    paddleDx = 1 * paddle.getSpeed();
                    System.out.println("Key Press: D");
                    break;
            }
        }
    };

    public EventHandler<KeyEvent> keyReleased = new EventHandler<KeyEvent>() {
        @Override
        public void handle(KeyEvent keyEvent) {

            switch(keyEvent.getCode()){
                case A:
                case D:
                    paddleDx = 0;
                    break;
            }
        }
    };

}
