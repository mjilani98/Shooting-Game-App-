package com.example.hw4q5;

import android.os.Bundle;

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
    }
}