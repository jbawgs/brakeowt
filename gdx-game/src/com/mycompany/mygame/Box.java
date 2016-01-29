package com.mycompany.mygame;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.math.*;
import java.util.*;
public class Box extends Sprite
{
	public Rectangle rect;
	public Vector2 center;
	public Vector2 position = Vector2.Zero;
	public boolean exists = true;
	public Texture tex;
	public float strength=1;
	public float maxStr;
	Assets assets;
	GameWorld world;

	public Box(Assets assets, GameWorld world){
		super(assets.red);
		this.setTexture(pickTexture(assets));
		rect = new Rectangle(position.x, position.y, this.getWidth(), this.getHeight());
		center = new Vector2(position.x, position.y);
		this.world = world;
		
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
		this.setAlpha(strength/maxStr);
	}
	Texture pickTexture(Assets assets){
		Random r = new Random();
		int i = r.nextInt(3);
		if(i==0){
			strength = maxStr =1;
			return assets.green;
		} else if(i==1) {
			strength = maxStr = 2;
			return assets.blue;
		} else if(i==2){
			strength = maxStr = 3;
			return assets.red;
		} else {
			strength = maxStr = 4;
		    return assets.orange;
		}
	}
}
