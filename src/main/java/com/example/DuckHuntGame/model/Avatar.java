package com.example.DuckHuntGame.model;

import javafx.animation.TranslateTransition;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Random;

public class Avatar {

    // elementos graficos
    private Canvas canvas;
    private GraphicsContext graphicsContext;
    private ArrayList<Image> idles;
    private ArrayList<Image> runs;
    private int frame;
    private Random rand;
    // elemntos espaciales
    private Position position;
    private int state;

    private boolean rightPressed;

    public Avatar(Canvas canvas){
        this.canvas = canvas;
        this.graphicsContext = this.canvas.getGraphicsContext2D();
        // 0 is idle | 1 izquierda | 2 derecha
        this.state = 1;
        this.frame = 0;

        this.idles = new ArrayList<>();
        this.runs = new ArrayList<>();
        rand = new Random();
        this.position = new Position(300,250);

        for (int i = 0; i <= 3; i++) {
            Image image = new Image(getClass().getResourceAsStream("/animations/hero/idle/adventurer-idle-2-0"+i+".png"), 50, 50, false, false);
            this.idles.add(image);
        }

        for (int i = 0; i <=5 ; i++) {
            Image image = new Image(getClass().getResourceAsStream("/animations/hero/run/adventurer-run-0"+i+".png"));
            this.runs.add(image);
        }
    }

    public void paint(){
        onMove();

        if(state == 0){
            graphicsContext.drawImage(idles.get(frame%3), position.getX(), position.getY(),100,100);
            frame++;
        } else if (state == 1) {
            graphicsContext.drawImage(runs.get(frame%5), position.getX(), position.getY(),100,100);
            position.setX(position.getX()+10);
            frame++;
        } else if (state == 2) {
            graphicsContext.drawImage(runs.get(frame%5), position.getX(), position.getY(),100,100);
            frame++;
        }
    }

    public void onMove(){
        if (rightPressed){
            position.setX(position.getX() + 10);
        }
    }
    public void onKeyPressed(KeyEvent event){ // convertir a click con mouse para que se quede quieto
        switch (event.getCode()){
            case RIGHT : {
                state = 1;
                rightPressed = true;
            }
        }
    }



}
