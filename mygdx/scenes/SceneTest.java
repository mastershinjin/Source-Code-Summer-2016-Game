package com.mygdx.scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;

public class SceneTest {

	public class MyActor extends Actor{
		Texture texture = new Texture("text.png");
		public boolean started = false;
		
		public MyActor(){
			setBounds(getX(), getY(), texture.getWidth(), texture.getHeight());
		}
		
		@Override
		public void draw(Batch batch, float alpha){
			batch.draw(texture, this.getX(), this.getY());
		}
	}
	
	private Stage stage;
	
	public SceneTest(){
		stage = new Stage();
		
		MyActor actor = new MyActor();
		
		MoveToAction moveAction = new MoveToAction();
		moveAction.setPosition(300f, 0f);
		moveAction.setDuration(10f);
		actor.addAction(moveAction);
		
		stage.addActor(actor);
		
	}

	public void render(float delta) {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
        stage.draw();
		
	}
	
}
