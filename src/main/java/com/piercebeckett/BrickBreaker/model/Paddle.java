package com.piercebeckett.BrickBreaker.model;

import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import static com.piercebeckett.BrickBreaker.Main.WINDOW_HEIGHT;
import static com.piercebeckett.BrickBreaker.Main.WINDOW_WIDTH;

public class Paddle extends Rectangle {
    static final double BASE_SPEED = 3;
    static final double BASE_WIDTH= 80;
    static final double HEIGHT = 20;
    static final double Y_OFFSET = 20;
    static final double STARTING_X = (WINDOW_WIDTH/2) - (BASE_WIDTH / 2);
    static final double STARTING_Y = WINDOW_HEIGHT - HEIGHT - Y_OFFSET;

    private double speed;

    public Paddle(){

        super(
                STARTING_X,
                STARTING_Y,
                BASE_WIDTH,
                HEIGHT
        );
        resetSpeed();
    }

    public void increaseSpeed(){this.speed += 10;}

    public void decreaseSpeed(){this.speed -= 10;}

    public void resetSpeed(){this.speed = BASE_SPEED;}

    public void increaseWidth(){setWidth(getWidth() + 10);}

    public void decreaseWidth(){setWidth(getWidth() - 10);}

    public void resetWidth(){setWidth(BASE_WIDTH);}

    public void resetPosition(){setX(STARTING_X);}

    public double getSpeed() {return this.speed;}

    public void setSpeed(double speed) {this.speed = speed;}

}
