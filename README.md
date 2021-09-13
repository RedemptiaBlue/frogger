frogger

Score: Each level starts at 100, score decreases per second until player makes it to the other side or dies.
Final score is the sum of all the scores of each level * 10. Game Over if score reaches 0

Player is a box.

Obstacles to dodge: one-direction, pendulum, beam
one-direction{
direction, speed, frequency, size(choice of 3, can be random)
    types: 
        -dodge
        -platform {has coins that increase time left}
}
pendulum {
speed, size(choice of 3, can be random)
}
beams {frequency, indicator}

lilypad {random static platforms}

wasd controls

Savestate json {PlayerName:Score} put onto save file. If Player already on json, checks if new score is High Score.


