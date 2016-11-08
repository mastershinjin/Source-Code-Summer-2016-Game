package com.mygdx.gameworld.test;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.MyGdxGame;

public class OverworldGameRenderer {

	private OverworldGameWorld world;
	
	private OrthographicCamera mainCam;
	private Texture pic;
	private SpriteBatch batch;
	private TextureRegion sprite;
	private ShapeRenderer shapeRenderer;
	
	private float currentX = 0;
	private float currentY = 0;
	
	public OverworldGameRenderer(OverworldGameWorld world){
		
		this.world = world;
		
		mainCam = new OrthographicCamera();
		mainCam.setToOrtho(true, 136, 200);
		
		batch = new SpriteBatch();
		//batch.setProjectionMatrix(mainCam.combined);
		
		pic = new Texture("toronto.jpg");
		pic.setFilter(TextureFilter.Linear, TextureFilter.Linear);
	}
	
	public void render(float delta){
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		//Stuff
		if(world.inp.getUpDown() && currentY > -pic.getHeight()/2){
			currentY -= 6;
		}
		if(world.inp.getRightDown() && currentX > -pic.getWidth()/2){
			currentX -= 6;
		}
		if(world.inp.getDownDown() && currentY < 0){
			currentY += 6;
		}
		if(world.inp.getLeftDown() && currentX < 0){
			currentX += 6;
		}
		
		batch.begin();
		batch.draw(pic, currentX, currentY);
		batch.end();
	}
	
}
