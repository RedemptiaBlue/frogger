package com.genspark2.frogger;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.ScreenUtils;

public class LevelCompleteScreen implements Screen {
    final Frogger game;

    public LevelCompleteScreen(final Frogger game){
        this.game = game;
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(.1f, .2f, .3f, .5f);
        game.batch.begin();
        game.font.draw(game.batch, String.format("Level %d Complete!! Score: %d", game.level, game.score), Frogger.gameWidth / 2 - 100, Frogger.gameHeight / 2 + 50);
        game.font.draw(game.batch, "Press Enter to continue!", Frogger.gameWidth / 2 - 100, Frogger.gameHeight / 2);
        game.font.draw(game.batch, "Press Esc to return to Main Menu!", Frogger.gameWidth / 2 - 100, Frogger.gameHeight / 2 - 50);
        game.batch.end();
        if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
            game.level += 1;
            game.setScreen(new GameScreen(game));
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            game.level = 1;
            game.setScreen(new Menu(game));
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

    }
}
