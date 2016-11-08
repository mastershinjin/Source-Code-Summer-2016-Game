package com.mygdx.helpers;

import com.badlogic.gdx.InputProcessor;

public class InputHandler implements InputProcessor{

	private boolean upDown = false;
	private boolean rightDown = false;
	private boolean downDown = false;
	private boolean leftDown = false;
	
	public int key;
	
	public InputHandler(){
		
	}
	
	public boolean getUpDown(){
		return upDown;
	}
	public boolean getRightDown(){
		return rightDown;
	}
	public boolean getDownDown(){
		return downDown;
	}
	public boolean getLeftDown(){
		return leftDown;
	}
	
	@Override
	public boolean keyDown(int keycode) {
		
		key = keycode;
		
		if(keycode == 19){
			upDown = true;
		}
		if(keycode == 22){
			rightDown = true;
		}
		if(keycode == 20){
			downDown = true;
		}
		if(keycode == 21){
			leftDown = true;
		}
		
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		
		key = keycode;
		
		if(keycode == 19){
			upDown = false;
		}
		if(keycode == 22){
			rightDown = false;
		}
		if(keycode == 20){
			downDown = false;
		}
		if(keycode == 21){
			leftDown = false;
		}
		
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
