package com.genspark2.frogger.laneTypes;

import java.awt.*;
import java.util.ArrayList;

import static com.genspark2.frogger.Frogger.laneWidth;

public class Block extends Lane{
    protected int obstacleCount;
    protected ArrayList<Rectangle> obstacles;
    protected int[] sizes = new int[]{laneWidth, laneWidth*2, laneWidth*4};
    protected int velocity;

    public ArrayList<Rectangle> initObstacles() {
        new ArrayList<Rectangle>() {{
            for (int i = 0; i < obstacleCount; i++) {
                Rectangle obstacle = new Rectangle();
                obstacle.setSize(sizes[(int)Math.floor(Math.random() * sizes.length)],laneWidth);
                add(new Rectangle());

            }
        }};
        return obstacles;
    }
}
