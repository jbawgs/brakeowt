package com.mycompany.mygame;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.math.*;

public class BallActor extends Actor
{
	private Texture tex;
	
	public Circle circ;
	public Vector2 direction = Vector2.Zero;
	public boolean dead = false;
	public BallActor(Texture tex, float x, float y){
		super();
		
	}
}
