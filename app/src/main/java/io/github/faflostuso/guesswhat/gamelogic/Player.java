package io.github.faflostuso.guesswhat.gamelogic;


/**
 * Created by Fabian on 03.07.2017.
 */

public class Player {

    private String name;
    private int points = 0;

    public String getName(){
        return name;
    }

    public int getPoints(){
        return points;
    }

    /**
     *
     * @param points
     * @throws IllegalArgumentException if value of points is negative
     */
    public void addPoints(int points)throws IllegalArgumentException{
        checkPointsValue(points);
        this.points += points;
    }

    public void removePoints(int points){
        checkPointsValue(points);
        this.points -= points;

    }

    private void checkPointsValue(int points)throws IllegalArgumentException{
        if(points < 0){
            throw new IllegalArgumentException("Number of Points must be positive!");
        }
    }
}
