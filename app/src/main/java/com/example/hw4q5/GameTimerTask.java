package com.example.hw4q5;

import java.util.TimerTask;

public class GameTimerTask extends TimerTask
{
    private Game game;              //game model
    private GameView gameView;      //game view

    //constructor of game timer task class
    public GameTimerTask(Game game,GameView gameView)
    {
        this.game = game;            //set game model
        this.gameView = gameView;    //set game view
    }

    //run method of game timer task class
    public void run()
    {
        game.update(); 

        gameView.postInvalidate();      //redraw game view
    }
}
