package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.AudioDevice;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.helpers.InputHandler;
import com.mygdx.scenes.SceneTest;
import com.mygdx.screens.OverworldScreen;

public class MyGdxGame extends Game {
	
	private OverworldScreen mainScreen;
	private InputHandler inp = new InputHandler();
	
	private SceneTest test;
	
	
	@Override
	public void create () {
		mainScreen = new OverworldScreen(inp);
	
		test = new SceneTest();
		
		this.setScreen(mainScreen);
	}
	
	@Override
	public void dispose(){
		super.dispose();
		
	}

}
