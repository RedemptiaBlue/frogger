package com.genspark2.frogger;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;
import com.genspark2.frogger.laneTypes.Lane;

import java.util.Arrays;

public class Frogger extends ApplicationAdapter {
	SpriteBatch batch;
	static ShapeRenderer shape;
	static Rectangle player;
	static Lane[] lanes;
	public static final int gameWidth = 1200;
	public static final int gameHeight = 800;
	public static final int laneWidth = 40;
	public static final int yMin = laneWidth/2;
	public static final int yMax = (int)(gameHeight - laneWidth * 1.5);
	public static final int xMin = 0;
	public static int xMax;

	static void renderPlayer() {
		shape.begin(ShapeRenderer.ShapeType.Filled);
		shape.setColor(0.9f, 0.3f, 1f, 1);
		shape.rect(player.x, player.y, player.width, player.height);
		shape.end();
	}

	static void movePlayer() {
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			player.x -= 160 * Gdx.graphics.getDeltaTime();
			if(player.x < xMin) player.x = xMin;
		}
		else if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			xMax = (int)(gameWidth - player.width);
			player.x += 160 * Gdx.graphics.getDeltaTime();
			if(player.x > xMax) player.x = xMax;
		}
		if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
			player.y += 60;
			if (player.y > yMax) player.y = yMax;
		}
		else if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
			player.y -= 60;
			if (player.y < yMin) player.y = yMin;
		}
	}
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		shape = new ShapeRenderer();
		player = new Rectangle().set(gameWidth /2f - player.width / 2f, player.height / 2f,40, laneWidth);
		lanes = (Lane[])Arrays.stream(new Lane[10]).map((lane -> Lane.setLaneType())).toArray();
		System.out.println(Arrays.toString(lanes));
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
