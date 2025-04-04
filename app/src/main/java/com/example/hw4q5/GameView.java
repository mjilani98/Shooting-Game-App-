package com.example.hw4q5;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class GameView extends View
{
    private Game game;  //game model


    //public constructor
    public GameView(Context context, Game game)
    {
        super(context);

        //set game model
        this.game = game;
    }

    //method draws scene
    public void onDraw(Canvas canvas)
    {
        //get scene dimensions
        double sceneHeight = game.getSceneHeight();
        double sceneWidth = game.getSceneWidth();

        //get location of the ball
        double ballX = game.getBallX();
        double ballY = game.getBallY();


        //get radius of ball/bullet
        double radius = game.getRadius();


        //create a paint object
        Paint paint = new Paint();

        //draw background
        paint.setColor(Color.parseColor("#AAAAAA"));
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(0, 0, (float)sceneWidth, (float)sceneHeight, paint);
    }
}
