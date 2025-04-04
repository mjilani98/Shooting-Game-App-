package com.example.hw4q5;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Timer;

public class MainActivity extends AppCompatActivity
{
    //Game model
    private Game game;

    //Game view
    private GameView gameView;

    //gesture detector
    private GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        //create game model
        game = new Game();

        //create game view
        gameView = new GameView(this,game);

        //display screen
        setContentView(gameView);

        //schedule animation
        Timer timer = new Timer();
        GameTimerTask task = new GameTimerTask(game , gameView);
        timer.schedule(task , 5000 , 20);

        //create gesture detector and attach event handler to it
        TouchHandler temp = new TouchHandler();
        gestureDetector = new GestureDetector(this, temp);
    }

    //Event handler of touch event
    public boolean onTouchEvent(MotionEvent event)
    {
        //pass touch event to gesture detector
        gestureDetector.onTouchEvent(event);

        return true;
    }
    //Gesture detector class
    private class TouchHandler extends GestureDetector.SimpleOnGestureListener
    {
        //Event handler of double tap
        public boolean onDoubleTap(MotionEvent event)
        {
            //fire gun
            game.fire();

            return true;
        }
    }
}