package com.piercebeckett.BrickBreaker.model;

import javafx.scene.shape.Rectangle;

public class Brick extends Rectangle {
    public static final double BASE_WIDTH = 22;
    public static final double BASE_HEIGHT = 22;

    private int health;

    public Brick(double x, double y){
        super(
                x,
                y,
                BASE_WIDTH,
                BASE_HEIGHT
        );
        this.health = 1;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
