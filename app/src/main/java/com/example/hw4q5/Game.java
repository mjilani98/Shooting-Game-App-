package com.example.hw4q5;

public class Game
{
    //scene coordinates
    private double sceneWidth ; //width of the screen
    private double sceneHeight; //Height of the scene

    private double ballX;   //x coordinate of the ball
    private double ballY;   //y coordinate of the ball
    private double ballSpeed; //speed of the ball

    private double radius;  //radius of the ball , bullet
    private boolean hit; //ball hit



    //public constructor
    public Game()
    {
        //create Initial game
        initializeGame();
    }


    //method moves the ball
    private void moveBall()
    {
        if(!hit)
        {
            //move bird down
            ballY = ballY - ballSpeed;

            //determine weather the ball is hit or not
            hit = decideHit();
        }
    }

    private boolean decideHit()
    {
        //find distance between bullet and ball

        return false;
    }



    //getters

    //get ball variables
    public double getBallX()  //get the ball x
    {
        return ballX;
    }
    public double getBallY() //get the ball y
    {
        return ballY;
    }
    public double getBallSpeed() //get the ball speed
    {
        return ballSpeed;
    }


    //get scene variables
    public double getSceneHeight() //get tha scene height
    {
        return sceneHeight;
    }
    public double getSceneWidth() //get the scene width
    {
        return sceneWidth;
    }

    //get radius
    public double getRadius()
    {
        return radius;
    }


    //method initialize coordinates for the game
    private void initializeGame()
    {
        //initialize the scene coordinates
        this.sceneHeight = 2400;
        this.sceneWidth = 1080;

        //initialize ball coordinates
        this.ballX = sceneWidth - 50;
        this.ballY = sceneHeight - 400 * Math.random() - 50;
        this.ballSpeed = 10 + 10 * Math.random();

        //initialize radius - size of the ball/bullet
        this.radius = 50;
    }

}
