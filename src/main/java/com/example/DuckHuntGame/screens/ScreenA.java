package com.example.DuckHuntGame.screens;

import com.example.DuckHuntGame.model.Avatar;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Random;


public class ScreenA {

    private Canvas canvas;
    private GraphicsContext graphicsContext;
    private ArrayList<Avatar> avatars;
    private Random rand;

    public ScreenA(Canvas canvas) {
        this.canvas = canvas;
        this.graphicsContext = this.canvas.getGraphicsContext2D();
        this.avatars = new ArrayList<>();
        this.rand = new Random();
    }

    public void paint() {
        graphicsContext.setFill(Color.BLACK);
        Image backgroundImage = new Image((getClass().getResourceAsStream("/backgrounds/Space2d.jpg")));
        graphicsContext.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        graphicsContext.drawImage(backgroundImage,0,0,600,600);
        createAvatars();

    }

    public void onKeyPressed(KeyEvent event){
        //this.avatar.onKeyPressed(event);
    }

    public void createAvatars(){
        int numAleatorio = rand.nextInt(5);
        if(numAleatorio == 0){
            numAleatorio = 1;
        }
        for(int i = 0; i < numAleatorio; i++){
            this.avatars.add(i,new Avatar(this.canvas));
            avatars.get(i).paint();
        }


    }
}
