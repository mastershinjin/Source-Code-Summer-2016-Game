package com.mygdx.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.mygdx.gameworld.test.OverworldGameRenderer;
import com.mygdx.gameworld.test.OverworldGameWorld;
import com.mygdx.helpers.InputHandler;
import com.mygdx.scenes.SceneTest;

public class OverworldScreen implements Screen{
	
	OverworldGameRenderer renderer;
	OverworldGameWorld world;
	
	private SceneTest test;
	
	private OrthographicCamera camera;
	private TiledMap tiledMap;
	private TiledMapRenderer tiledMapRenderer;
	
	private int coolDown = 0;
	
	private Texture texture = new Texture("AppleKid.png");
	private TextureRegion appleBoyDown, appleBoyUp, appleBoyLeft, appleBoyRight;
	private TextureRegion[] appleBoys;
	private Animation appleBoyAnimation;
	TextureRegion textureToDraw;
	private SpriteBatch batcher;
	
	public OverworldScreen(InputHandler inp){
		
		Gdx.app.log("GameScreen", "attached");
		
		world = new OverworldGameWorld(inp);
		renderer = new OverworldGameRenderer(world);
		
		test = new SceneTest();
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Gdx.graphics.getWidth() / 3, Gdx.graphics.getHeight() / 3);
		camera.update();
		
		tiledMap = new TmxMapLoader().load("test_2.tmx");
		tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
		
		//appleboy
		appleBoyDown = new TextureRegion(texture, 0, 0, 16, 24);
		appleBoyUp = new TextureRegion(texture, 16, 0, 16, 24);
		appleBoyLeft = new TextureRegion(texture, 16, 24, 16, 24);
		appleBoyRight = new TextureRegion(texture, 16, 24, 16, 24);
		appleBoyRight.flip(true, false);
		
		textureToDraw = appleBoyUp;
		
		//sprite batcher
		batcher = new SpriteBatch();
		//Attach to camera
		batcher.setProjectionMatrix(camera.combined);
		
		
		
		Gdx.input.setInputProcessor(inp);
		
	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		
		//test.render(delta);
		
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		
		camera.update();
		tiledMapRenderer.setView(camera);
		tiledMapRenderer.render();
		
		//Inputs
		if(coolDown == 3){
			if(world.inp.getUpDown()){
				camera.translate(0, 16);
				textureToDraw = appleBoyUp;
			}
			if(world.inp.getRightDown()){
				camera.translate(16, 0);
				textureToDraw = appleBoyRight;
			}
			if(world.inp.getDownDown()){
				camera.translate(0, -16);
				textureToDraw = appleBoyDown;
			}
			if(world.inp.getLeftDown()){
				camera.translate(-16, 0);
				textureToDraw = appleBoyLeft;
			}
			
			coolDown = 0;
		}
		else{
			coolDown++;
		}
		
		batcher.begin();
		batcher.draw(textureToDraw, Gdx.graphics.getWidth() / 6 / 16 * 16, Gdx.graphics.getHeight() / 6 / 16 * 16, 16, 24);
		batcher.end();
		
	}

	@Override
	public void resize(int width, int height) {
		
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
	}

}
