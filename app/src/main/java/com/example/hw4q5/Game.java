package com.example.hw4q5;

public class Game
{
    //scene coordinates
    private double sceneWidth ; //width of the screen
    private double sceneHeight; //Height of the scene

    //ball coordinates
    private double ballX;   //x coordinate of the ball
    private double ballY;   //y coordinate of the ball
    private double ballSpeed; //speed of the ball

    //gun coordinates
    private double gunX ;  //x coordinates of the gun
    private double gunY;   //y coordinates of the gun
    private double gunAngle; //angle of the gun
    private double gunLength; //length of the gun

    //bullet coordinates
    private double bulletX;          //x coordinate of bullet
    private double bulletY;          //y coordinate of bullet
    private double bulletSpeed;      //speed of bullet

    private double radius;  //radius of the ball , bullet
    private boolean hit; //ball hit



    //public constructor
    public Game()
    {
        //create Initial game
        initializeGame();
    }

    //method update game model
    public void update()
    {
        //move ball
        moveBall();
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

    //get gun variables
    public double getGunX() //get gun x
    {
        return gunX;
    }
    public double getGunY() //get gun y
    {
        return gunY;
    }
    public double getGunAngle() //get gun angle
    {
        return gunAngle;
    }
    public double getGunLength() //get gun length
    {
        return gunLength;
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

    //get bullet variables
    public double getBulletX() //get the bullet x
    {
        return bulletX;
    }
    public double getBulletY() //get the bullet y
    {
        return bulletY;
    }
    public double getBulletSpeed() //get bullet speed
    {
        return bulletSpeed;
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
        this.ballX = sceneWidth  * Math.random()-80;
        this.ballY = sceneHeight - 55;
        this.ballSpeed = 10 + 15 * Math.random();

        //initialize gun coordinates
        int min = 540; // minimum gun location on the screen
        int max = 1070;// maximum gun location on the screen
        this.gunY =  min + (int)(Math.random() * ((max - min + 1))); //generate a random location
        this.gunX = 0;
        this.gunLength = 200;
        this.gunAngle = 0 ;

        //initialize bullet coordinates
        this.bulletX = gunX;
        this.bulletY = gunY;
        this.bulletSpeed = 20;



        //initialize radius - size of the ball/bullet
        this.radius = 50;
    }

}