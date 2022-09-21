package com.piercebeckett.BrickBreaker.model;

import javafx.scene.shape.Circle;

import static com.piercebeckett.BrickBreaker.Main.WINDOW_HEIGHT;
import static com.piercebeckett.BrickBreaker.Main.WINDOW_WIDTH;

public class Ball extends Circle {
    static final double BASE_SPEED = 2;
    static final double STARTING_RADIUS = 10;
    static final double STARTING_X = WINDOW_WIDTH/2;
    static final double STARTING_Y = WINDOW_HEIGHT - 150;

    private double xVelocity;
    private double yVelocity;
    private double speed;

    public Ball(){
        super(
                STARTING_X,
                STARTING_Y,
                STARTING_RADIUS
        );
        xVelocity = 0;
        yVelocity = BASE_SPEED;
        speed = BASE_SPEED;
    }

    public double getxVelocity() {return xVelocity;}

    public void setxVelocity(double xVelocity) {this.xVelocity = xVelocity;}

    public double getyVelocity() {return yVelocity;}

    public void setyVelocity(double yVelocity) {this.yVelocity = yVelocity;}

    public double getSpeed(){return this.speed;}

}
