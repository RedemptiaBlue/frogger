package com.genspark2.frogger;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.Timer;
import com.genspark2.frogger.laneTypes.Lane;

import java.util.Arrays;
import java.util.stream.Stream;

public class GameScreen implements Screen {
    final Frogger game;
    static ShapeRenderer shape;
    static Rectangle player;
    static Stream<Lane> lanes;

    public static int laneWidth = 40;public final int yMin = laneWidth/2;
    public final int yMax;
    public static final int xMin = 0;
    public static int xMax;

    public static Timer timer = new Timer();
    public static int timeLeft;
    public static Timer.Task decreaseTimeBy10 = new Timer.Task() {
        @Override
        public void run() {
            timeLeft -= 1;
        }
    };

    void renderPlayer() {
        shape.begin(ShapeRenderer.ShapeType.Filled);
        shape.setColor(0.9f, 0.3f, 1f, 1);
        shape.rect(player.x, player.y, player.width, player.height);
        shape.end();
    }

    void movePlayerOnKeyPress() {
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            player.x -= 160 * Gdx.graphics.getDeltaTime();
            if(player.x < xMin) player.x = xMin;
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            xMax = (int)(Frogger.gameWidth - player.width);
            player.x += 160 * Gdx.graphics.getDeltaTime();
            if(player.x > xMax) player.x = xMax;
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
            player.y += 60;
            if (player.y == yMax) {
                game.score += timeLeft * 10;
                game.setScreen(new LevelCompleteScreen(game));
                dispose();
            }
        }
        else if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
            player.y -= 60;
            if (player.y < yMin) player.y = yMin;
        }
    }

    public GameScreen(final Frogger game) {
        this.game = game;
        timeLeft = 100;
        timer.scheduleTask(decreaseTimeBy10, .7f, .7f);
        yMax = (int)(Frogger.gameHeight - laneWidth * 1.5);
        shape = new ShapeRenderer();
        player = new Rectangle().set(Frogger.gameWidth /2f - laneWidth / 2f, laneWidth / 2f,40, laneWidth);
        lanes = Arrays.stream(new Lane[10]).map((lane) -> Lane.setLaneType());
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(.1f, .2f, .3f, .5f);
        game.batch.begin();
        game.font.draw(game.batch, String.format("%d",timeLeft), Frogger.gameWidth - 100, Frogger.gameHeight - 50);
        game.batch.end();
        renderPlayer();
        movePlayerOnKeyPress();
        if (timeLeft < 1) {
            game.setScreen(new GameOverScreen(game));
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            pause();
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        timer.clear();
    }
}
