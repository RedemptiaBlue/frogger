package com.genspark2.frogger;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class LevelCompleteScreen implements Screen {
    final Frogger game;
    private Stage stage;

    public LevelCompleteScreen(final Frogger game){
        this.game = game;
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        Table table = new Table();
        table.setFillParent(true);
        stage.addActor(table);
        stage.addListener(new InputListener() {
            @Override
            public boolean keyDown(InputEvent event, int keycode) {
                if (keycode == Input.Keys.ENTER) {
                    game.level += 1;
                    game.setScreen(new GameScreen(game));
                    dispose();
                }
                if (keycode == Input.Keys.ESCAPE) {
                    game.level = 1;
                    game.setScreen(new Menu(game));
                }
                return super.keyDown(event, keycode);
            }
        });

        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        style.font = game.font;

        TextButton score = new TextButton(String.format("Level %d Complete!! Score: %d", game.level, game.score), style);
        score.setPosition(Frogger.gameWidth / 2 - score.getWidth() / 2, Frogger.gameHeight / 2);

        TextButton enterText = new TextButton("Press Enter to continue!", style);
        enterText.setPosition(Frogger.gameWidth / 2 - enterText.getWidth() / 2, Frogger.gameHeight / 2 - 50);

        TextButton exitText = new TextButton("Press Esc to return to Main Menu!", style);
        exitText.setPosition(Frogger.gameWidth / 2 - exitText.getWidth() / 2, Frogger.gameHeight / 2 - 50);

        table.add(score);
        table.row().padTop(30);
        table.add(enterText);
        table.row();
        table.add(exitText);
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(.1f, .2f, .3f, .5f);
        stage.draw();
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
