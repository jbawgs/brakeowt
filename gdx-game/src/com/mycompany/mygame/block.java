package com.mycompany.mygame;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.math.*;


public class block extends Sprite
{
	public Rectangle rect;
	public Vector2 center;
	public Vector2 position = new Vector2(500,100);
	
	public block(Assets assets){
		super(assets.box);
		rect = new Rectangle(position.x, position.y, this.getWidth(), this.getHeight());
		center = new Vector2(position.x, position.y);
	}
	
	public Vector2 getPosition(){
		
		return new Vector2(this.getX() + this.getWidth()/2, this.getY() + this.getHeight()/2);
	}
	
	public void setPosition(Vector2 pos){
		position = pos;
		this.setPosition(pos.x - this.getWidth()/2, pos.y - this.getHeight()/2);
		rect.setPosition(pos.x - this.getWidth()/2, pos.y - this.getHeight()/2);
		center = new Vector2(this.getPosition().x, this.getPosition().y);
	}
	
	public void update(float dt){
		//this.setPosition(position.x, position.y);
	}
	public void positionToCamera(OrthographicCamera cam){
		this.setPosition(new Vector2(100, cam.viewportWidth/2));
	}
}
