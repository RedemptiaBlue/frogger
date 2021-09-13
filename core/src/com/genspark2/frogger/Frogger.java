package com.genspark2.frogger;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;

public class Frogger extends ApplicationAdapter {
	SpriteBatch batch;
	static ShapeRenderer shape;
	static Rectangle player;
	public static final int gameWidth = 1200;
	public static final int gameHeight = 800;

	static void renderPlayer() {
		shape.begin(ShapeRenderer.ShapeType.Filled);
		shape.setColor(0.9f, 0.3f, 1f, 1);
		shape.rect(player.x, player.y, player.width, player.height);
		shape.end();
	}

	static void movePlayer() {
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			player.x -= 160 * Gdx.graphics.getDeltaTime();
			if(player.x < 0) player.x = 0;
		}
		else if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			player.x += 160 * Gdx.graphics.getDeltaTime();
			if(player.x > gameWidth - player.width) player.x = gameWidth - player.width;
		}
		if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
			player.y += 60;
			if (player.y > gameHeight - player.height) player.y = gameHeight - player.height * 1.5f;
		}
		else if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
			player.y -= 60;
			if (player.y < 0) player.y = player.width / 2;
		}
	}
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		shape = new ShapeRenderer();
		player = new Rectangle();
		player.setSize(40, 40);
		player.setPosition(gameWidth /2 - player.width / 2, player.height / 2);
	}

	@Override
	public void render () {
		ScreenUtils.clear(0f,0.1f,0.2f, 0.1f);
		renderPlayer();
		movePlayer();
	}
	
	@Override
	public void dispose () {
		shape.dispose();
	}
}
