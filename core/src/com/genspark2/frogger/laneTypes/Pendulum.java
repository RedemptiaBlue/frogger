package com.genspark2.frogger.laneTypes;

public class Pendulum extends Block{

    public Pendulum( int velocity, int frequency) {
        this.obstacleCount = frequency;
        this.obstacles = initObstacles();
    }
}
