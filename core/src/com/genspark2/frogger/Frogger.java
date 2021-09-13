package com.genspark2.frogger;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;

public class Frogger extends ApplicationAdapter {
	SpriteBatch batch;
	ShapeRenderer shape;
	Rectangle player;
	public static final int width = 1200;
	public static final int height = 800;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		shape = new ShapeRenderer();
		player = new Rectangle();
		player.setSize(40, 40);
		player.setPosition(width/2 - player.width / 2, player.height / 2);
	}

	@Override
	public void render () {
		ScreenUtils.clear(0.5f,0.85f,1f, 0.1f);
		shape.begin(ShapeRenderer.ShapeType.Filled);
		shape.setColor(0.9f, 0.4f, 1f, 1);
		shape.rect(player.x, player.y, player.width, player.height);
		shape.end();
	}
	
	@Override
	public void dispose () {
		shape.dispose();
	}
}
