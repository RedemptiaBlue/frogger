package com.genspark2.frogger.laneTypes;

public class Lane {
    public static Lane setLaneType() {
        Lane randomLaneType = null;
        switch ((int)Math.floor(Math.random() * 5)) {
            case 0:
                randomLaneType = new Full();
                break;
            case 1:
                randomLaneType = new OneDirectional(160, 2);
                break;
            case 2:
                randomLaneType = new Pendulum(160, 1);
                break;
            case 3:
                randomLaneType = new Beam();
                break;
            case 4:
                randomLaneType = new LilyPad();
                break;
            case 5:
                randomLaneType = new Logs();
                break;
        }
        return randomLaneType;
    }
}
