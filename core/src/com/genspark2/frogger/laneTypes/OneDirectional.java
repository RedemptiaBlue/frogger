package com.genspark2.frogger.laneTypes;

public class OneDirectional extends Block{

    public OneDirectional( int velocity, int frequency){
        this.obstacleCount = frequency;
        this.obstacles = initObstacles();
        this.velocity = velocity;
    }
}
