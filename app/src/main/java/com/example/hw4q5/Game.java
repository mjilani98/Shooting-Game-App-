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
    private double distanceThreshold;        //closeness threshold of bird/bullet

    private boolean hit; //ball hit
    private boolean fired; //gun fired



    //public constructor
    public Game()
    {
        //create Initial game
        initializeGame();
    }

    //method update game model
    public void update()
    {
        //at start move ball
        moveBall();

        //if gun is fired , move the bullet
        if(fired)
            moveBullet();

        //if scene is clear create initial game again
        if (sceneClear())
            initializeGame();

    }

    private boolean sceneClear()
    {
        //check ball has gone past bottom boundaries of scene
        //and check bullet has gone past top boundary of scene
        return (ballX < 0 || ballY < 0) && bulletX > sceneWidth;
    }

    //method fires the fun
    public void fire()
    {
        //set fired to true
        fired = true;
    }

    //method moves the bullet
    private void moveBullet()
    {
        //change x, y coordinates of bullet, using its speed and angle
        bulletX = bulletX + bulletSpeed*Math.cos(gunAngle*Math.PI/180);
        bulletY = bulletY + bulletSpeed*Math.sin(gunAngle*Math.PI/180);
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
        else
        {
            //if the ball has been hit , move it off the screen
            ballY = -100;
            ballX = -100;
        }
    }
    private boolean decideHit()
    {
        //find distance between bullet and ball
        //find distance between bird and bullet
        double distance = Math.sqrt((ballX - bulletX)*(ballX - bulletX) +
                (ballY - bulletY)*(ballY - bulletY));

        //check distance is within the closeness threshold
        return distance <= distanceThreshold;
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
        this.gunLength = 150;
        this.gunAngle = 0 ;

        //initialize bullet coordinates
        this.bulletX = gunX;
        this.bulletY = gunY;
        this.bulletSpeed = 20;

        //turn off the gun
        fired = false;

        //set hit to false
        hit = false;

        //initialize radius - size of the ball/bullet
        this.radius = 50;
        this.distanceThreshold = 50;
    }

}