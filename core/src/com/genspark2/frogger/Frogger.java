package com.genspark2.frogger;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Frogger extends Game {
	public SpriteBatch batch;
	public BitmapFont font;
	public static final int gameWidth = 1200;
	public static final int gameHeight = 800;
	public int level;
	public int score;

	
	@Override
	public void create () {
		batch = new SpriteBatch();
		font = new BitmapFont();
		level = 1;
		this.setScreen(new Menu(this));
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		font.dispose();
	}
}
